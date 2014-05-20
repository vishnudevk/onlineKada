package com.onlinekada.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="indexBean")
@ViewScoped
public class IndexBean extends MasterBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init(){
		super.init();
	}

	String pageHeader ="Test Welcome";

	public String getPageHeader() {
		return pageHeader;
	}

	public void setPageHeader(String pageHeader) {
		this.pageHeader = pageHeader;
	}
	
	
	
}
