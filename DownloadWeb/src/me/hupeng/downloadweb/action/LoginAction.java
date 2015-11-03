package me.hupeng.downloadweb.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		this.addFieldError("errorInfo", "用户名或者密码错误");
		Map<String, Object> map = ActionContext.getContext().getSession();
		for (String key : map.keySet()) {
			System.out.println("key= "+ key + " and value= " + map.get(key));
		}
		return super.execute();
	}
}
