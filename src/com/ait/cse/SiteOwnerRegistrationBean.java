package com.ait.cse;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SiteOwnerRegistrationBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String siteOwnerName, siteName, username, siteOwnerEmail, siteOwnerPassword;

	private SiteOwner siteOwner;
	
	public SiteOwnerRegistrationBean() {
	}
	
	public SiteOwner getSiteOwner() {
		return siteOwner;
	}

	public void setSiteOwner(SiteOwner siteOwner) {
		this.siteOwner = siteOwner;
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
	
}
