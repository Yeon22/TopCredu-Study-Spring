package com.devglan.userportal;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(int id) {
        super(id + " not found!");
    }

}
