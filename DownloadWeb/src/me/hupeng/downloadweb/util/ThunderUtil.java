package me.hupeng.downloadweb.util;



import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.WString;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.NativeLongByReference;
public class ThunderUtil {
    
    static {
        // ע��dll
        Native.register("D:\\util\\xl\\XLDownload.dll");
    }
    
    // --------XLError.h�е�״̬--------------
    public static final int XL_ERROR_FAIL = 268435456;
    public static final int XL_SUCCESS = 0;
    public static final int XL_ERROR_FILE_NAME_INVALID = XL_ERROR_FAIL + 12;
    public static final int XL_ERROR_ADD_TASK_TRAY_ICON_FAIL = XL_ERROR_FAIL + 4;
    public static final int XL_ERROR_FILE_ALREADY_EXIST = XL_ERROR_FAIL + 16;
    public static final int XL_ERROR_INVALID_TASK_TYPE = XL_ERROR_FAIL + 15;
    public static final int XL_ERROR_BUFFER_TOO_SMALL = XL_ERROR_FAIL + 22;
    public static final int XL_ERROR_CANNOT_CONTINUE_TASK = XL_ERROR_FAIL + 20;
    public static final int XL_ERROR_INIT_TASK_TRAY_ICON_FAIL = XL_ERROR_FAIL + 3;
    public static final int XL_ERROR_INVALID_ARG = XL_ERROR_FAIL + 10;
    public static final int XL_ERROR_CREATE_DIRECTORY_FAIL = XL_ERROR_FAIL + 8;
    public static final int XL_ERROR_STRING_IS_EMPTY = XL_ERROR_FAIL + 6;
    public static final int XL_ERROR_TASK_DONT_EXIST = XL_ERROR_FAIL + 11;
    public static final int XL_ERROR_UNINITAILIZE = XL_ERROR_FAIL + 1;
    public static final int XL_ERROR_POINTER_IS_NULL = XL_ERROR_FAIL + 5;
    public static final int XL_ERROR_CANNOT_PAUSE_TASK = XL_ERROR_FAIL + 21;
    public static final int XL_ERROR_PATH_DONT_INCLUDE_FILENAME = XL_ERROR_FAIL + 7;
    public static final int XL_ERROR_WRITE_CFG_FILE_FAIL = XL_ERROR_FAIL + 19;
    public static final int XL_ERROR_INIT_THREAD_EXIT_TOO_EARLY = XL_ERROR_FAIL + 23;
    public static final int XL_ERROR_READ_CFG_FILE_FAIL = XL_ERROR_FAIL + 18;
    public static final int XL_ERROR_NOTIMPL = XL_ERROR_FAIL + 13;
    public static final int XL_ERROR_MEMORY_ISNT_ENOUGH = XL_ERROR_FAIL + 9;
    public static final int XL_ERROR_FILE_DONT_EXIST = XL_ERROR_FAIL + 17;
    public static final int XL_ERROR_UNSPORTED_PROTOCOL = XL_ERROR_FAIL + 2;
    public static final int XL_ERROR_TASKNUM_EXCEED_MAXNUM = XL_ERROR_FAIL + 14;
    
    // -------XLDownload��Task��״̬------------
    /**
     * ��ʼ��������
     */
    public static final int XL_STATUS_CONNECT = 0;
    
    /**
     * ��ʼ���� 
     */
    public static final int XL_STATUS_DOWNLOAD = 2;
    
    /**
     * ��ͣ
     */
    public static final int XL_STATUS_PAUSE = 10;
    
    /**
     * ���سɹ�
     */
    public static final int XL_STATUS_SUCESS = 11;
    
    /**
     * ����ʧ��
     */
    public static final int XL_STATUS_FAIL = 12;
    
    // ------XLDownload�еķ���ǩ��---------------------
    
    /**
     * ��ʼ������
     * @return TRUE����ʾ�ɹ���FALSE����ʾʧ�ܡ� 
     */
    public static native boolean XLInitDownloadEngine();
    
    /**
     * ����ָ������Դ�������浽�����ļ���ֻ֧��HTTP����֧�ֶ�̬��
     * @param pszFileName ������Դ�ı����ļ���
     * @param pszUrl ��Դ��URL������ΪNULL
     * @param pszRefUrl ��Դ������ҳ������ΪNULL
     * @param lTaskId ������������Ψһ��ʶ���洴�������񣬸ò���������ΪXLQueryTaskInfo��XLStopTask�ĵ�һ������������ò���ֵΪ0����ʾ���洴������ʧ��
     * @return XL_SUCCESS����ʾ�ɹ�������ֵ����ʾʧ��
     */
    public static native int XLURLDownloadToFile(WString pszFileName, WString pszUrl, WString pszRefUrl, NativeLongByReference lTaskId);
    
    /**
     * ��ѯָ������ĵ�ǰ״̬
     * @param lTaskId ָ����Ҫ��ѯ������ͨ������XLURLDownloadToFile���Ի�ȡһ������ID
     * @param plStatus ��������������������ĵ�ǰ״̬�����ܵ�ȡֵ���μ�XLDownload.h
     * @param pullFileSize �������������ļ���С����λ���ֽ�
     * @param pullRecvSize �������������Ѿ����ص������ݣ���λ���ֽ�
     * @return
     */
    public static native int XLQueryTaskInfo(NativeLong lTaskId, NativeLongByReference plStatus, LongByReference pullFileSize, LongByReference pullRecvSize);
    
    /**
     * ��ָͣ�����񣬲������µ�����ID
     * @param lTaskId ����ID��ͨ������XLURLDownloadToFile���Ի�ȡһ������ID
     * @param lNewTaskId ������������������ֵ����XL_SUCCESSʱ�������µ�����ID������ֵδ����
     * @return XL_SUCCESS����ʾ�ɹ�������ֵ����ʾʧ�ܡ�
     */
    public static native int XLPauseTask(NativeLong lTaskId, NativeLongByReference lNewTaskId);
    
    /**
     * �ָ�����ͣ������
     * @param lTaskId ����ID
     * @return XL_SUCCESS����ʾ�ɹ�������ֵ����ʾʧ�ܡ� 
     */
    public static native int XLContinueTask(NativeLong lTaskId);
    
    /**
     * ��ָ����TD�ļ���ʼ������
     * @param pszTdFileFullPath TD�ļ�������·�����ļ���
     * @param lTaskId ���������������óɹ�ʱ�������½������ID
     * @return XL_SUCCESS����ʾ�ɹ�����������ʾʧ�ܡ����XLError.h
     */
    public static native int XLContinueTaskFromTdFile(String pszTdFileFullPath, NativeLongByReference lTaskId);
    
    /**
     * ָֹͣ������ 
     * ��ע�⡿ÿ�������������سɹ���ʧ�ܣ���󶼱������һ��XLStopTask�����򣬻ᵼ����Դй©��
     * @param lTaskId Ҫֹͣ������ID
     */
    public static native void XLStopTask(NativeLong lTaskId);
    
    /**
     * ����һЩ��Դ���ղ���
     * ��ע�⡿������ʹ������ʱ��������øú���������ᵼ����Դй©��
     * @return TRUE����ʾ�ɹ���FALSE����ʾʧ�ܡ� 
     */
    public static native boolean XLUninitDownloadEngine();
    
    /**
     * ���������Ӧ�Ĵ�����Ϣ������ָ���Ļ�������
     * @param dwErrorId �����������涨��Ĵ����룬���XLError.h
     * @param pszBuffer �������׵�ַ
     * @param dwSize ����������������ʱ��ָ�����������ȣ���������ʱ��������������Ȳ��㣬�ò��������ó�����Ļ��������ȡ��ò����ĵ�λ���ַ����������ֽ����� 
     * @return
     */
    public static native int XLGetErrorMsg(int dwErrorId, String pszBuffer, IntByReference dwSize);
    
    
    //-------------------���ߺ���----------------
    
    /**
     * longתNativeLongByReference
     * @param value
     * @return
     */
    public static NativeLongByReference makeNativeRefLong(long value) {
        NativeLongByReference ullFileSize = new NativeLongByReference();
        ullFileSize.setValue(new NativeLong(value));
        return ullFileSize;
    }
    
    /**
     * NativeLongByReferenceתlong
     * @param longRef
     * @return
     */
    public static long getLongValue(NativeLongByReference longRef) {
        return longRef.getValue().longValue();
    }
//
//    
//    // ���Դ��룺  http://xldoc.xl7.xunlei.com/0000000026/index.html��C���Ե�Java����
//    public static void main( String[] args) throws InterruptedException {
//        int result;
//        
//        try {
//            if (!XLInitDownloadEngine()) {
//                System.out.println("Initialize download engine failed.");
//                return;
//            }
//            
//            NativeLongByReference lTaskId = makeNativeRefLong(0);
//            result = XLURLDownloadToFile(
//                    new WString("d:\\xxx.flv"), 
//                    new WString("http://f6.r.56.com/f6.c95.56.com/flvdownload/5/4/135175960260hd.flv?v=1&t=clnCNmA07nD3NWUGnVwBQQ&r=36978&e=1351849624"), 
//                    new WString(""), 
//                    lTaskId);
//            System.out.println("result code: " + result);
//            System.out.println("task id: " + getLongValue(lTaskId));
//        if (XL_SUCCESS != result) {
//                XLUninitDownloadEngine();
//                System.out.println("Create new task failed, error code: " + ( result - XL_ERROR_FAIL) );
//                return;
//            }
//        System.out.println("Begin download file.");
//        
//        do {
//                Thread.sleep(1000);
//
//                LongByReference ullFileSize = new LongByReference(0);
//                LongByReference ullRecvSize = new LongByReference(0);
//                NativeLongByReference lStatus = makeNativeRefLong(-1);
//                NativeLong nativeLong = new NativeLong();
//                nativeLong.setValue(getLongValue(lTaskId));
//                
//                result = XLQueryTaskInfo(nativeLong, lStatus, ullFileSize, ullRecvSize);
//                if (XL_SUCCESS == result) {
//                    // ���������Ϣ
//                    if (0 != ullFileSize.getValue()) {
//                        double douProgress = (double) ullRecvSize.getValue() / (double) ullFileSize.getValue();
//                        douProgress *= 100.0;
//                        System.out.println("Download progress:" + douProgress);
//                    } else {
//                        System.out.println("File size is zero.");
//                    }
//
//                    if (XL_STATUS_SUCESS == getLongValue(lStatus)) {
//                        System.out.println("Download successfully.\n");
//                        break;
//                    }
//
//                    if (XL_STATUS_FAIL == getLongValue(lStatus)) {
//                        System.out.println("Download failed.");
//                        break;
//                    }
//                }
//            } while (XL_SUCCESS == result);
//        XLStopTask(lTaskId.getValue());
//        } finally {
//            XLUninitDownloadEngine();
//        }
//        
//    }
}