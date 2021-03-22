package com.nagarro.vaccnow.exception;


public class SlotNotAvailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String slotNotAvailable;

	public String getSlotNotAvailable() {
		return slotNotAvailable;
	}

	public void setSlotNotAvailable(String slotNotAvailable) {
		this.slotNotAvailable = slotNotAvailable;
	}

	
}
