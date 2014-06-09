package com.onlinekada.jsf.components;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.icefaces.util.JavaScriptRunner;


/**This is the class used for msgbox which is showed in tha pages
 * (only ok button will be there in this type of dialoges)
 * @author Vishnudev.K
 *
 */
public class MsgBox {
		
		private static final Logger logger = Logger.getLogger(MsgBox.class);
	
		private boolean msgBoxVisible;
		private String msgBoxHdr;
		private String msgBoxText;
		private String confirmOKInvokeMethod;

		private Object instance ;//this is the instance in which the ok method will be executed 
		
		/**
		 * @param instance		-current instance on which msg is poped up
		 * @param msgBoxVisible -visibility of msg box
		 * @param msgBoxHdr		-header text of message box
		 * @param msgBoxText 	-message box content
		 */
		public MsgBox(Object instance , boolean msgBoxVisible, String msgBoxHdr, String msgBoxText ) {
			if(msgBoxHdr!=null){
				logger.debug("creating a new messge box "
						+ msgBoxHdr + " : " + msgBoxText);
			}
			this.instance		= instance;
			this.msgBoxVisible 	= msgBoxVisible;
			this.msgBoxHdr 		= msgBoxHdr;
			this.msgBoxText 	= msgBoxText;
			if (msgBoxVisible) {
				JavaScriptRunner.runScript(FacesContext.getCurrentInstance(),
						"if(typeof(msgBoxOKDialog) !== 'undefined')msgBoxOKDialog.show();");
			} else {
				JavaScriptRunner.runScript(FacesContext.getCurrentInstance(),
						"if(typeof(msgBoxOKDialog) !== 'undefined')msgBoxOKDialog.hide();");
			}
		}

		/**
		 * @param msgBoxVisible
		 *            visibility of msg box
		 * @param msgBoxHdr
		 *            header text of message box
		 * @param msgBoxText
		 *            message box content
		 */
		public MsgBox(Object instance ,boolean msgBoxVisible, String msgBoxHdr, String msgBoxText,String confirmOKInvokeMethod) {
			this(instance, msgBoxVisible,msgBoxHdr,msgBoxText);
			this.confirmOKInvokeMethod = confirmOKInvokeMethod;
		}
		

		/**
		 * method used to show the message box
		 * 
		 * @return
		 */
		public String showMsgbox() {
			// setting visibility of the msgbox into true
			JavaScriptRunner.runScript(FacesContext.getCurrentInstance(),
					"if(typeof(msgBoxOKDialog) !== 'undefined')msgBoxOKDialog.show();");
			this.msgBoxVisible = true;
			return null;
		}

		/**
		 * Method used for hide message box
		 * 
		 * @return
		 */
		public String closeMsgBox() {
			// setting visibility of the msgbox into false
			JavaScriptRunner.runScript(FacesContext.getCurrentInstance(),
					"if(typeof(msgBoxOKDialog) !== 'undefined')msgBoxOKDialog.hide();");
			this.msgBoxVisible = false;
			return null;
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
		public String confirmOK() throws NoSuchMethodException,
				SecurityException, IllegalAccessException,
				IllegalArgumentException, InvocationTargetException {
			msgBoxVisible = false;
			JavaScriptRunner.runScript(FacesContext.getCurrentInstance(),"msgBoxOKDialog.hide();");
			if (confirmOKInvokeMethod != null &&!"".equals(confirmOKInvokeMethod.trim())) {
				logger.info("calling method " + confirmOKInvokeMethod
						+ " using reflection");
				Method method = instance.getClass().getMethod(
						confirmOKInvokeMethod);
				method.invoke(instance);
			}
			return null;
		}

		
		/*********************************************** getter setters ******************************************************************/
		
		/**
		 * @return the msgBoxVisible
		 */
		public boolean isMsgBoxVisible() {
			return msgBoxVisible;
		}

		/**
		 * @param msgBoxVisible
		 *            the msgBoxVisible to set
		 */
		public void setMsgBoxVisible(boolean msgBoxVisible) {
			this.msgBoxVisible = msgBoxVisible;
		}

		/**
		 * @return the msgBoxHdr
		 */
		public String getMsgBoxHdr() {
			return msgBoxHdr;
		}

		/**
		 * @param msgBoxHdr
		 *            the msgBoxHdr to set
		 */
		public void setMsgBoxHdr(String msgBoxHdr) {
			this.msgBoxHdr = msgBoxHdr;
		}

		/**
		 * @return the msgBoxText
		 */
		public String getMsgBoxText() {
			return msgBoxText;
		}

		/**
		 * @param msgBoxText
		 *            the msgBoxText to set
		 */
		public void setMsgBoxText(String msgBoxText) {
			this.msgBoxText = msgBoxText;
		}

		public Object getInstance() {
			return instance;
		}

		public void setInstance(Object instance) {
			this.instance = instance;
		}

		public String getConfirmOKInvokeMethod() {
			return confirmOKInvokeMethod;
		}

		public void setConfirmOKInvokeMethod(String confirmOKInvokeMethod) {
			this.confirmOKInvokeMethod = confirmOKInvokeMethod;
		}

}
