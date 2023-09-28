package com.pedrogomesdev.crud.services.expections;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException{

	public NotFoundException (String msg) {
		super(msg);
	}
}
