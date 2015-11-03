package me.hupeng.downloadweb.service;

import me.hupeng.downloadweb.DAO.UserDAO;
import me.hupeng.downloadweb.bean.User;

public class UserService {
	private UserDAO userDAO;
	private User user;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
