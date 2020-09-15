package com.gura.spring05.exception;

import org.springframework.dao.DataAccessException;

public class NoDeliveryException extends DataAccessException {

	public NoDeliveryException(String msg) {
		super(msg);
	}

}
