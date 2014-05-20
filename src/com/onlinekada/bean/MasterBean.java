package com.onlinekada.bean;

import java.io.IOException;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

public class MasterBean {

	Logger logger = Logger.getLogger(MasterBean.class);
	
	public void init(){
		logger.debug("1.init");
		UserLogin userLogin = (UserLogin) FacesContext.getCurrentInstance().
				getExternalContext().getSessionMap().get("userLogin");
		if(userLogin==null){
		    try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("userLogin.jsf");
			} catch (IOException e) {
				e.printStackTrace();
			}     
		}
		logger.debug("2.init");
	}
	
}
