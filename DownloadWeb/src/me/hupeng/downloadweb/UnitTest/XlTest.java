package me.hupeng.downloadweb.UnitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.sun.jna.NativeLong;
import com.sun.jna.WString;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.NativeLongByReference;

import me.hupeng.downloadweb.util.ThunderUtil;

@RunWith(JUnit4.class)
public class XlTest {
	private ThunderUtil thunderUtil;
	@Test
	public void test() {
		int result;
		try {
			// 判断初始化是否成功
			if (!thunderUtil.XLInitDownloadEngine()) {
				System.out.println("迅雷下载引擎初始化失败！");
				return;
			}

			NativeLongByReference lTaskId = thunderUtil.makeNativeRefLong(0);

			result = thunderUtil.XLURLDownloadToFile(new WString(
					"d:\\wmp9c.exe"), new WString(
					"http://219.150.251.69/mvbar_v2/soft/wmp9cn.exe"),
					new WString(""), lTaskId);
			System.out.println("result code:" + result);
			if (thunderUtil.XL_SUCCESS != result) {
				System.out.println("下载任务创建失败！");
				return;
			}
			System.out.println("开始下载文件。。。");
			do {
				Thread.sleep(1000);

				LongByReference ullFileSize = new LongByReference(0);
				LongByReference ullRecvSize = new LongByReference(0);
				NativeLongByReference lStatus = thunderUtil.makeNativeRefLong(-1);
				NativeLong nativeLong = new NativeLong();
				nativeLong.setValue(thunderUtil.getLongValue(lTaskId));

				result = thunderUtil.XLQueryTaskInfo(nativeLong, lStatus, ullFileSize,
						ullRecvSize);
				if (thunderUtil.XL_SUCCESS == result) {
					// 输出进度信息
					if (0 != ullFileSize.getValue()) {
						double douProgress = (double) ullRecvSize.getValue()
								/ (double) ullFileSize.getValue();
						douProgress *= 100.0;
						System.out.println("Download progress:" + douProgress);
					} else {
						System.out.println("File size is zero.");
					}

					if (thunderUtil.XL_STATUS_SUCESS == thunderUtil.getLongValue(lStatus)) {
						System.out.println("Download successfully.\n");
						break;
					}

					if (thunderUtil.XL_STATUS_FAIL == thunderUtil.getLongValue(lStatus)) {
						System.out.println("Download failed.");
						break;
					}
				}
			} while (thunderUtil.XL_SUCCESS == result);
			thunderUtil.XLStopTask(lTaskId.getValue());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
