package com.onlinekada.jsf.components;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.icefaces.util.JavaScriptRunner;


/**
 * This is the class used as confirm boxes (yes/No) msg box
 * @author vishnudev.k
 * 
 */
public class ConfirmBox {
	
	private static final Logger logger = Logger.getLogger(ConfirmBox.class);
	
	// for setting properties of confirmation box
	private boolean confirmVisible;
	private String confirmHdr;
	private String confirmText;
	// this variable is the name of method which is getting called on Yes button
	private String confirmYesInvokeMethod;
	// this variable is the name of method which is getting called on No button
	private String confirmNoInvokeMethod;
	
	private Object instance ;//this is the instance in which the ok method will be executed 
	

	/**
	 * @param confirmVisible
	 *            confirm box visibility
	 * @param confirmHdr
	 *            confirm box header
	 * @param confirmText
	 *            confirm box message
	 * @param confirmYesInvokeMethod
	 *            the method name to be run on click of ok/yes button
	 * @param confirmNoInvokeMethod
	 *            the method name to be run on click of ok/no button
	 */
	public ConfirmBox(Object instance , boolean confirmVisible, String confirmHdr,
			String confirmText, String confirmYesInvokeMethod,
			String confirmNoInvokeMethod) {
		if(confirmHdr!=null){
			logger.debug("creating a new confirm box  " + confirmHdr + " : " + confirmText + " : "
				+ confirmYesInvokeMethod + " : " + confirmNoInvokeMethod);
		}
		this.instance 				= instance;
		this.confirmVisible 		= confirmVisible;
		this.confirmHdr 			= confirmHdr;
		this.confirmText 			= confirmText;
		this.confirmYesInvokeMethod = confirmYesInvokeMethod;
		this.confirmNoInvokeMethod 	= confirmNoInvokeMethod;
		if (confirmVisible) {
			showConfirmation();
		}

	}


	/**
	 * This method shows the popup
	 */
	public void showConfirmation() {
		confirmVisible = true;
		JavaScriptRunner.runScript(FacesContext.getCurrentInstance(),
				"if(typeof(confirmation) !== 'undefined')confirmation.show();");
	}

	/**
	 * This method shows the popup
	 */
	public void hideConfirmation() {
		confirmVisible = false;
		JavaScriptRunner.runScript(FacesContext.getCurrentInstance(),
				"if(typeof(confirmation) !== 'undefined')confirmation.hide();");
	}

	
	/**
	 * This method is getting called on user clicking Yes button of the
	 * message box This method check if there is any method to be called on
	 * no click and call the method after that hide the confirm box
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public String confirmYes() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		confirmVisible = false;
		JavaScriptRunner.runScript(FacesContext.getCurrentInstance(),"if(typeof(confirmation) !== 'undefined')confirmation.hide();");
		//JavaScriptRunner.runScript(FacesContext.getCurrentInstance(), "$('.ui-widget-overlay').remove();$('.ui-widget-overlay').hide();");
		if (confirmYesInvokeMethod != null&&!"".equals(confirmYesInvokeMethod.trim())) {
			logger.info("calling method " + confirmYesInvokeMethod
					+ " using reflection");
			Method method = instance.getClass().getMethod(
					confirmYesInvokeMethod);
			method.invoke(instance);
		}
		return null;
	}

	/**
	 * This method is getting called on user clicking No button of the
	 * message box This method check if there is any method to be called on
	 * no click and call the method after it this will hide the msg box
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public String confirmNo() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		confirmVisible = false;
		JavaScriptRunner.runScript(FacesContext.getCurrentInstance(),"confirmation.hide();");
		//JavaScriptRunner.runScript(FacesContext.getCurrentInstance(), "$('.ui-widget-overlay').remove();$('.ui-widget-overlay').hide();");
		if (confirmNoInvokeMethod != null &&!"".equals(confirmNoInvokeMethod.trim())) {
			logger.info("calling method " + confirmYesInvokeMethod
					+ " using reflection");
			Method method = instance.getClass().getMethod(
					confirmNoInvokeMethod);
			method.invoke(instance);
		}
		return null;
	}

	
	/*********************************************** getter setters ******************************************************************/
	
	/**
	 * @return the confirmVisible
	 */
	public boolean isConfirmVisible() {
		return confirmVisible;
	}

	/**
	 * @param confirmVisible
	 *            the confirmVisible to set
	 */
	public void setConfirmVisible(boolean confirmVisible) {
		this.confirmVisible = confirmVisible;
	}

	/**
	 * @return the confirmHdr
	 */
	public String getConfirmHdr() {
		return confirmHdr;
	}

	/**
	 * @param confirmHdr
	 *            the confirmHdr to set
	 */
	public void setConfirmHdr(String confirmHdr) {
		this.confirmHdr = confirmHdr;
	}

	/**
	 * @return the confirmText
	 */
	public String getConfirmText() {
		return confirmText;
	}

	/**
	 * @param confirmText
	 *            the confirmText to set
	 */
	public void setConfirmText(String confirmText) {
		this.confirmText = confirmText;
	}

	/**
	 * @return the confirmYesInvokeMethod
	 */
	public String getConfirmYesInvokeMethod() {
		return confirmYesInvokeMethod;
	}

	/**
	 * @param confirmYesInvokeMethod
	 *            the confirmYesInvokeMethod to set
	 */
	public void setConfirmYesInvokeMethod(String confirmYesInvokeMethod) {
		this.confirmYesInvokeMethod = confirmYesInvokeMethod;
	}

	/**
	 * @return the confirmNoInvokeMethod
	 */
	public String getConfirmNoInvokeMethod() {
		return confirmNoInvokeMethod;
	}

	/**
	 * @param confirmNoInvokeMethod
	 *            the confirmNoInvokeMethod to set
	 */
	public void setConfirmNoInvokeMethod(String confirmNoInvokeMethod) {
		this.confirmNoInvokeMethod = confirmNoInvokeMethod;
	}


	public Object getInstance() {
		return instance;
	}


	public void setInstance(Object instance) {
		this.instance = instance;
	}

}