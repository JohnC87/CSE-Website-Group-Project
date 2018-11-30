package com.ait.cse;

public class SiteOwner {

	private String siteName, username, siteOwnerPassword, siteOwnerEmail, siteOwnerName;
	private String feeStatus;
	private String feeCommand;

	public SiteOwner(String siteName, String username, String siteOwnerPassword, String siteOwnerEmail,
			String siteOwnerName) {
		this.siteName = siteName;
		this.username = username;
		this.siteOwnerPassword = siteOwnerPassword;
		this.siteOwnerEmail = siteOwnerEmail;
		this.siteOwnerName = siteOwnerName;
		this.feeStatus = "Not Paid";
		setFeeCommand(feeStatus);
	}

	public String getSiteOwnerName() {
		return siteOwnerName;
	}

	public void setSiteOwnerName(String siteOwnerName) {
		this.siteOwnerName = siteOwnerName;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSiteOwnerEmail() {
		return siteOwnerEmail;
	}

	public void setSiteOwnerEmail(String siteOwnerEmail) {
		this.siteOwnerEmail = siteOwnerEmail;
	}

	public String getSiteOwnerPassword() {
		return siteOwnerPassword;
	}
	
	public void setSiteOwnerPassword(String siteOwnerPassword) {
		this.siteOwnerPassword = siteOwnerPassword;
	}
	
	public boolean changePassword(String oldPassword, String newPassword) {
		if (oldPassword.equals(siteOwnerPassword)) {
			siteOwnerPassword = newPassword;
			return true;
		} else {
			return false;
		}
	}
	
	public String getFeeStatus() {
		return feeStatus;
	}

	public void setFeeStatus(String galwayFeeStatus) {
		this.feeStatus = galwayFeeStatus;
	}

	public String getFeeCommand() {
		return feeCommand;
	}

	public void setFeeCommand(String feeStatus) {
		if (feeStatus.equals("Paid")) {
			this.feeCommand = "Mark Not Paid";
		} else {
			this.feeCommand = "Mark Paid";
		}
	}

	@Override
	public String toString() {
		return "SiteOwner [siteName=" + siteName + ", username=" + username + ", siteOwnerPassword=" + siteOwnerPassword
				+ ", siteOwnerEmail=" + siteOwnerEmail + ", siteOwnerName=" + siteOwnerName + "]";
	}

}