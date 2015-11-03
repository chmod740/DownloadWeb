package me.hupeng.downloadweb.bean;

/**
 * Loginlog entity. @author MyEclipse Persistence Tools
 */

public class Loginlog implements java.io.Serializable {

	// Fields

	private Integer loginlogId;
	private Integer userId;
	private String loginTime;
	private String ipAddr;

	// Constructors

	/** default constructor */
	public Loginlog() {
	}

	/** full constructor */
	public Loginlog(Integer userId, String loginTime, String ipAddr) {
		this.userId = userId;
		this.loginTime = loginTime;
		this.ipAddr = ipAddr;
	}

	// Property accessors

	public Integer getLoginlogId() {
		return this.loginlogId;
	}

	public void setLoginlogId(Integer loginlogId) {
		this.loginlogId = loginlogId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getIpAddr() {
		return this.ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

}