package com.onlinekada.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.onlinekada.bo.UserLoginBo;
import com.onlinekada.model.User;

@ManagedBean(name="userLogin")
@ViewScoped
public class UserLogin extends MasterBean {

	@PostConstruct
	public void init(){
		//overrride the method from the masterbean
	}
	
	@ManagedProperty(name="userLoginBo", value = "#{userLoginBo}")
	private UserLoginBo userLoginBo;
	
	
	private User user = new User();

	
	/**This method is getting called on the sign in button
	 */
	public void login(){
		logger.debug("1.login");
		logger.debug(userLoginBo);
		logger.debug("2.login");
	}
	
	
	
	
	
	
	
	/****************************Getter Setter******************************/
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}







	public UserLoginBo getUserLoginBo() {
		return userLoginBo;
	}







	public void setUserLoginBo(UserLoginBo userLoginBo) {
		this.userLoginBo = userLoginBo;
	}
}
