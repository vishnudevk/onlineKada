package com.onlinekada.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.icefaces.util.JavaScriptRunner;

import com.onlinekada.bo.UserLoginBo;
import com.onlinekada.model.KadaUser;

@ManagedBean(name="userLoginBean")
@ViewScoped
public class UserLoginBean extends MasterBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@PostConstruct
	public void init(){
		//overrride the method from the masterbean
	}
	
	@ManagedProperty(value = "#{userLoginBo}")
	private UserLoginBo userLoginBo;
	
	
	private KadaUser user = new KadaUser();

	
	/**This method is getting called on the sign in button
	 */
	public void login(){
		logger.debug("1.login");
		user = userLoginBo.login(user);
		if(user==null){
			JavaScriptRunner.runScript(FacesContext.getCurrentInstance(), "alert('user login failed');");
		}else{
			JavaScriptRunner.runScript(FacesContext.getCurrentInstance(), "alert('sucessfully loged in as "+user.getName()+"');");
		}
		logger.debug("2.login");
	}
	
	/****************************Getter Setter******************************/
	
	public KadaUser getUser() {
		return user;
	}

	public void setUser(KadaUser user) {
		this.user = user;
	}

	public UserLoginBo getUserLoginBo() {
		return userLoginBo;
	}

	public void setUserLoginBo(UserLoginBo userLoginBo) {
		this.userLoginBo = userLoginBo;
	}
}
