package com.kediumm.kednasdake.controller.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ErrorMessage {
	
	public ErrorMessage() {}
	
	public static void addErrorMessage(Exception exc) {
		
		FacesMessage error_message = new FacesMessage("Error: " + exc.getMessage());
		
		FacesContext.getCurrentInstance().addMessage(null, error_message);
		
	}

}
