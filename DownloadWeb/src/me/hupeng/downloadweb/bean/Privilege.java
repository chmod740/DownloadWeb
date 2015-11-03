package me.hupeng.downloadweb.bean;

/**
 * Privilege entity. @author MyEclipse Persistence Tools
 */

public class Privilege implements java.io.Serializable {

	// Fields

	private Integer privilegeId;
	private Integer userId;
	private String rightstr;

	// Constructors

	/** default constructor */
	public Privilege() {
	}

	/** full constructor */
	public Privilege(Integer userId, String rightstr) {
		this.userId = userId;
		this.rightstr = rightstr;
	}

	// Property accessors

	public Integer getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRightstr() {
		return this.rightstr;
	}

	public void setRightstr(String rightstr) {
		this.rightstr = rightstr;
	}

}