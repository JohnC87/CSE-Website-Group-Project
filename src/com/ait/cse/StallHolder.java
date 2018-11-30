package com.ait.cse;

public class StallHolder {

	private String name, stallName, username, email, description, location, websiteLink, typeOfProduce;
	private String password;
	private int clicks;
	private String activationStatus, externalLinkStatus;
	private String activationCommand, externalLinkCommand;
	private String websiteLinkForProfile;

	public StallHolder(String sHName, String sName, String sUsername, String sHEmail, String sHPassword,
			String sHDescription, String typeOfProd, String websiteLink, String loc, boolean isAct) {
		this.name = sHName;
		this.stallName = sName;
		this.username = sUsername;
		this.email = sHEmail;
		this.password = sHPassword;
		this.description = sHDescription;
		this.typeOfProduce = typeOfProd;
		this.websiteLink = websiteLink;
		this.websiteLinkForProfile = websiteLink;
		this.location = loc;
		this.activationStatus = handleActivationStatus(isAct);
		this.externalLinkStatus = handleExternalLinkShown(false);
		setClicks(0);
	}

	private String handleActivationStatus(boolean status) {
		if (status == true) {
			this.activationCommand = "Deactivate";
			return "Activated";
		} else {
			this.activationCommand = "Activate";
			return "Not Activated";
		}
	}

	private String handleExternalLinkShown(boolean externalLink) {
		if (externalLink == true) {
			externalLinkCommand = "Hide";
			return "Displayed";
		} else {
			externalLinkCommand = "Display";
			return "Not Displayed";
		}
	}

	public String getWebsiteLinkForProfile() {
		if (this.externalLinkStatus.equals("Displayed")) {
			return websiteLinkForProfile;
		}
		return ""; // return nothing if status set to not displayed
	}

	public void setWebsiteLinkForProfile(String websiteLinkForProfile) {
		this.websiteLinkForProfile = websiteLinkForProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStallName() {
		return stallName;
	}

	public void setStallName(String stallName) {
		this.stallName = stallName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWebsiteLink() { 
			return websiteLink; 
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public String getTypeOfProduce() {
		return typeOfProduce;
	}

	public void setTypeOfProduce(String typeOfProduce) {
		this.typeOfProduce = typeOfProduce;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Gets and Sets for statuses ----------------------------------------------

	public String getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(boolean isActivated) {
		this.activationStatus = handleActivationStatus(isActivated);
	}

	public String getExternalLinkStatus() {
		return externalLinkStatus;
	}

	public void setExternalLinkStatus(boolean status) {
		this.externalLinkStatus = handleExternalLinkShown(status);
	}

	// Button Commands -----------------------------------------------------------
	public String getActivationCommand() {
		return activationCommand;
	}

	public void setActivationCommand(String activationCommand) {
		if (getActivationStatus().equals("Not Activated")) {
			this.activationCommand = "Activate";
		} else {
			this.activationCommand = "Deactivate";
		}
	}

	public String getExternalLinkCommand() {
		return externalLinkCommand;
	}

	public void setExternalLinkCommand(String externalLinkCommand) {
		if (getActivationStatus().equals("Not Displayed")) {
			this.externalLinkCommand = "Display";
		} else {
			this.externalLinkCommand = "Hide";
		}
	}

	@Override
	public String toString() {
		return "Name:" + name + "\nStallName: " + getStallName() + "\nUsername: " + getUsername() + "\nEmail: " + email
				+ "\nDescription: " + getDescription() + "\nLocation: " + getLocation() + "\nWebsiteLink: "
				+ websiteLink + "\nType of Produce: " + typeOfProduce + "\nPassword: " + getPassword()
				+ "\nActivation Status: " + getActivationStatus();
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public void addClick() {
		setClicks(clicks + 1);
	}

}