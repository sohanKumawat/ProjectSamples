package ai.msg.training.portal.common.beans;

import java.util.HashMap;

public class ErrorMessage {
	
	public static HashMap<Integer,String> errorMessageCode=new HashMap<Integer,String>();
	public static final String ADDING_MESSAGE_ERROR="Something Went Wrong while adding messages"; 
	public static final String ASSIGN_ERROR_MESSAGE="Unable to assign to you";
	public static final String NULL_CHATTING_MODE="Chatting mode is null";
	public static final String INVALID_CHATTING_MODE="Chatting mode is invalid";
	public static final int NULL_CHATTING_MODE_CODE=3;
	public static final int INVALID_CHATTING_MODE_CODE=4;
	 static{ 
		 errorMessageCode.put(1,ADDING_MESSAGE_ERROR);
		 errorMessageCode.put(2,ASSIGN_ERROR_MESSAGE);
		 errorMessageCode.put(NULL_CHATTING_MODE_CODE,NULL_CHATTING_MODE);
		 errorMessageCode.put(INVALID_CHATTING_MODE_CODE, INVALID_CHATTING_MODE);
	 }
	boolean errorExist;
	String errorMessage;
	int ErrorType;
	public ErrorMessage(){
		this.errorExist=false;
	}
	public ErrorMessage(int errorCode,String errorMessage){
		this.errorExist=true;
		this.ErrorType=errorCode;
		this.errorMessage=errorMessage;
	}
	public int getErrorType() {
		return ErrorType;
	}
	public void setErrorType(int errorType) {
		ErrorType = errorType;
	}
	public boolean isErrorExist() {
		return errorExist;
	}
	public void setErrorExist(boolean errorExist) {
		this.errorExist = errorExist;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
