package com.core.app;

@SuppressWarnings("serial")
public class BuddyCustomExcption extends Exception {
	public BuddyCustomExcption(String errorMesg) {
		super(errorMesg);
	}
}
