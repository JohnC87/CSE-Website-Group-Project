package com.ait.cse;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StallHolderRegistrationBean implements Serializable  {
	private static final long serialVersionUID = 1L;
	private String stallHolderName, stallName, username, stallHolderEmail, stallHolderDescription, typeOfProduce, location, websiteLink;
	private String stallHolderPassword;
	private boolean isActivated;
	private StallHolder stallHolder;

	public StallHolderRegistrationBean() {
	}

	public String getStallName() {
		return stallName;
	}

	public void setStallName(String stallName) {
		this.stallName = stallName;
	}

	public String getStallHolderName() {
		return stallHolderName;
	}

	public void setStallHolderName(String stallHolderName) {
		this.stallHolderName = stallHolderName;
	}

	public String getStallHolderEmail() {
		return stallHolderEmail;
	}

	public void setStallHolderEmail(String stallHolderEmail) {
		this.stallHolderEmail = stallHolderEmail;
	}

	public String getStallHolderDescription() {
		return stallHolderDescription;
	}

	public void setStallHolderDescription(String stallHolderDescription) {
		this.stallHolderDescription = stallHolderDescription;
	}

	public String getStallHolderPassword() {
		return stallHolderPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTypeOfProduce() {
		return typeOfProduce;
	}

	public void setTypeOfProduce(String typeOfProduce) {
		this.typeOfProduce = typeOfProduce;
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

	public StallHolder getStallHolder() {
		return stallHolder;
	}

	public void setStallHolder(StallHolder stallHolder) {
		this.stallHolder = stallHolder;
	}

	public void setStallHolderPassword(String password) {
		this.stallHolderPassword = password;
	}

	public boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	
}
