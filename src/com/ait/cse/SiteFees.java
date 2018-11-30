package com.ait.cse;

public class SiteFees {
	private String month;
	private boolean payment;

	
	public SiteFees() {
		
	}

public SiteFees(String month, boolean payment) {
	this.month=month;
	this.payment=payment;

}

public String getMonth() {
	return month;
}

public void setMonth(String month) {
	this.month = month;
}

public boolean isPayment() {
	return payment;
}

public void setPayment(boolean payment) {
	this.payment = payment;
}


}
