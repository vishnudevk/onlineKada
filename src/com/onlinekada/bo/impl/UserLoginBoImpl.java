package com.onlinekada.bo.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinekada.bo.MasterBo;
import com.onlinekada.bo.UserLoginBo;
import com.onlinekada.dao.impl.UserDaoImpl;
import com.onlinekada.model.KadaUser;

@Service("userLoginBo")
@Transactional(readOnly = true)
public class UserLoginBoImpl extends MasterBo implements UserLoginBo , Serializable{

	private UserDaoImpl userDaoImpl;
	
	private static Logger logger = Logger.getLogger(UserLoginBoImpl.class);
	
	@Override
	public KadaUser login(KadaUser user) {
		logger.debug("1.login");
		List<KadaUser> users = userDaoImpl.findByExample(user);
		if(users.size()==1){
			user = users.get(0);
			logger.info("Login is success full");
			return user;
		}
		return null;
	}


	public UserDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}


	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

}
