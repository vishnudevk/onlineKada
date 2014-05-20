package com.onlinekada.bo.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.onlinekada.bo.MasterBo;
import com.onlinekada.bo.UserLoginBo;
import com.onlinekada.dao.impl.UserDaoImpl;
import com.onlinekada.model.User;

public class UserLoginBoImpl extends MasterBo implements UserLoginBo{

	private UserDaoImpl userDaoImpl;
	
	private static Logger logger = Logger.getLogger(UserLoginBoImpl.class);
	
	@Override
	public User login(User user) {
		logger.debug("1.login");
		List<User> logins = userDaoImpl.findByExample(user);
		if(logins.isEmpty()){
			return null;
		}else{
			user = logins.get(0);
			logger.info("Login succes for user "+ user.getUserName());
		}
		logger.debug("2.login");
		return user;
	}


	public UserDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}


	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

}
