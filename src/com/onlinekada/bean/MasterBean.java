package com.onlinekada.bean;

import java.io.IOException;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.onlinekada.jsf.components.ConfirmBox;
import com.onlinekada.jsf.components.MsgBox;
import com.onlinekada.model.KadaUser;

public class MasterBean {

	private static final Logger logger = Logger.getLogger(MasterBean.class);
	
	protected MsgBox msgBox;
	protected ConfirmBox confirmBox;
	protected KadaUser kadaUser;
	
	
	
	
	
	
	
	/*********************************************** code related to message and confirm boxes ******************************************************************/
	
	
	/**Init method should contain the security validations for the page 
	 * it will check weather user is logged in or not will set the kadaUser variable 
	 * which can be further used for privilege checks
	 */
	public void init(){
		logger.debug("1.init");
		UserLoginBean userLogin = (UserLoginBean) FacesContext.getCurrentInstance().
				getExternalContext().getSessionMap().get("userLoginBean");
		if(userLogin==null){
		    try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("userLogin.jsf");
			} catch (IOException e) {
				e.printStackTrace();
			}     
		}else{
			kadaUser = userLogin.getKadaUser();
		}
		logger.debug("2.init");
	}
	
	/**The method to show the message box
	 * @param msgBoxHdr
	 * @param msgBoxText
	 */
	public void openMsgBox(String msgBoxHdr,String msgBoxText) {
		if(msgBoxHdr!=null && msgBoxText !=null){
			logger.debug("creating a message box "+msgBoxHdr+" : "+ msgBoxText);
		}
		if(msgBox==null) msgBox = new MsgBox(null, false, null, null);
		msgBox.setInstance(this);
		msgBox.setMsgBoxVisible(true);
		msgBox.setMsgBoxHdr(msgBoxHdr);
		msgBox.setMsgBoxText(msgBoxText);
		msgBox.showMsgbox();
	}
	
	/**Method to show message box with a function on ok button
	 * @param msgBoxHdr
	 * @param msgBoxText
	 * @param confirmOKInvokeMethod
	 */
	public void openMsgBox(String msgBoxHdr,String msgBoxText,String confirmOKInvokeMethod) {
		msgBox.setConfirmOKInvokeMethod(confirmOKInvokeMethod);
		this.openMsgBox(msgBoxHdr, msgBoxText);
	}
	
	/**Method to hide the messge box
	 */
	public void hideMsgBox(){
		if(msgBox!=null && msgBox.getMsgBoxHdr()!=null && msgBox.getMsgBoxText() !=null){
			logger.debug("hiding the message box "+msgBox.getMsgBoxHdr()+" : "+ msgBox.getMsgBoxText());
		}
		msgBox.closeMsgBox();
	}
	
	/**This is the method used for showing confirmation box
	 * message box
	 * @author vishnudev.k
	 */
	public void openConfirmation(String confirmHdr,
			String confirmText, String confirmYesInvokeMethod,
			String confirmNoInvokeMethod) {
		if(confirmHdr!=null && confirmText !=null && confirmYesInvokeMethod !=null && confirmNoInvokeMethod !=null){
			logger.debug("creating a new confirm box  " + confirmHdr + " : " + confirmText + " : "
				+ confirmYesInvokeMethod + " : " + confirmNoInvokeMethod);
		}
		if(confirmBox==null)confirmBox = new ConfirmBox(null, false, null, null, null, null);
		confirmBox.setInstance(this);
		confirmBox.setConfirmVisible(true);
		confirmBox.setConfirmHdr(confirmHdr);
		confirmBox.setConfirmText(confirmText);
		confirmBox.setConfirmYesInvokeMethod(confirmYesInvokeMethod);
		confirmBox.setConfirmNoInvokeMethod(confirmNoInvokeMethod);
		confirmBox.showConfirmation();
	}
	
	/**Method used to hide the confirmation message box
	 */
	public void hideConfirmation(){
		if(confirmBox!=null && confirmBox.getConfirmHdr()!=null && confirmBox.getConfirmText() !=null && confirmBox.getConfirmYesInvokeMethod() !=null && confirmBox.getConfirmNoInvokeMethod() !=null){
			logger.debug("creating a new confirm box  " + confirmBox.getConfirmHdr() + " : " + confirmBox.getConfirmText() + " : "
				+ confirmBox.getConfirmYesInvokeMethod() + " : " + confirmBox.getConfirmNoInvokeMethod());
		}
		confirmBox.hideConfirmation();
	}
	
	
	/*************************************************************** getter setters ******************************************************************************/
	
	public MsgBox getMsgBox() {
		return msgBox;
	}

	public void setMsgBox(MsgBox msgBox) {
		this.msgBox = msgBox;
	}

	public KadaUser getKadaUser() {
		return kadaUser;
	}

	public void setKadaUser(KadaUser kadaUser) {
		this.kadaUser = kadaUser;
	}


	public ConfirmBox getConfirmBox() {
		return confirmBox;
	}


	public void setConfirmBox(ConfirmBox confirmBox) {
		this.confirmBox = confirmBox;
	}
}
