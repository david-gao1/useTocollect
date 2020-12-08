package com.practise.useException;

import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ResponseStatus(value= HttpStatus.OK, reason="Server Internal Exception")
public class DeployPortalException extends RuntimeException {

	private static String mergeString(Object... message) {
		String msg = "";
		for (Object m : message) {
            if (m instanceof Throwable) {
                Throwable e = (Throwable) m;
                msg += ExceptionUtils.getStackTrace(e) + "\n";
            } else {
                msg += m.toString() + " ";
            }
		}
		msg = msg.trim();
		return msg;
	}

	public DeployPortalException() {
		super();
	}

	public DeployPortalException(Object... message) {
		super(mergeString(message));
	}
}
