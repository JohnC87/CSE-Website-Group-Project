package com.ait.cse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Users> userList;
	private String password, newPassword;
	private String oldPassword;
	private String username;

	private ArrayList<StallHolder> stallHolderList;
	private ArrayList<StallHolder> galwayList;
	private ArrayList<StallHolder> sligoList;
	private ArrayList<SiteOwner> siteOwnerList;
	private ArrayList<Manager> managerList;
	
	private ArrayList<String> loggedInSHBookingsString;
	
	private LinkedList<String> siteOwnerGalwayPastFees = new LinkedList<String>();
	// Sligo past fees
	private LinkedList<String> siteOwnerSligoPastFees = new LinkedList<String>();
	private String currentMonth;
	private String previousFeesString[] = new String[12];

	private StallHolder loggedInSh;
	private SiteOwner loggedInSo;
	private Users loggedUser;

	private String updateName, updateStallName, updateUsername, updateEmail, updateDescription, updateProduce,
			updateLocation, updateWebsiteLink;

	private StallHolder viewing, managing;
	private boolean activationStatus, externalLinkStatus; // ignore warning, this is used in the changeActivationStatus() function!

	private boolean log;
	private boolean confirmSligoFeePaid;
	private boolean confirmGalwayFeePaid;
	private boolean galwayFeePaid;
	private boolean sligoFeePaid;
	private boolean loginFailed;
	
	SiteOwner galwayFees;
	SiteOwner sligoFees;

	FarmersMarketUserDatabase db;

	@PostConstruct
	public void init() {
		db = new FarmersMarketUserDatabase();
		log = false;
		setLoginFailed(false);

		userList = new ArrayList<Users>();
		galwayList = new ArrayList<StallHolder>();
		sligoList = new ArrayList<StallHolder>();
		stallHolderList = new ArrayList<StallHolder>();

		siteOwnerGalwayPastFees = new LinkedList<String>();
		siteOwnerGalwayPastFees.add("Paid");
		siteOwnerGalwayPastFees.add("Paid");
		siteOwnerGalwayPastFees.add("Paid");
		siteOwnerGalwayPastFees.add("Paid");
		siteOwnerGalwayPastFees.add("Paid");
		siteOwnerGalwayPastFees.add("Paid");
		siteOwnerGalwayPastFees.add("Paid");
		/*siteOwnerGalwayPastFees.add("Not Paid");
		siteOwnerGalwayPastFees.add("Not Paid");
		siteOwnerGalwayPastFees.add("Not Paid");
		siteOwnerGalwayPastFees.add("Not Paid");
		siteOwnerGalwayPastFees.add("Not Paid");*/

		for (int i = 0; i < siteOwnerGalwayPastFees.size(); i++) {
			System.out.println(i + ": " + siteOwnerGalwayPastFees.get(i));
		}

		db.setSiteOwnerGalwayPastFees(siteOwnerGalwayPastFees);

		// Sligo Fees
		siteOwnerSligoPastFees = new LinkedList<String>();
		siteOwnerSligoPastFees.add("Paid");
		siteOwnerSligoPastFees.add("Paid");
		siteOwnerSligoPastFees.add("Paid");
		siteOwnerSligoPastFees.add("Paid");
		siteOwnerSligoPastFees.add("Paid");
		siteOwnerSligoPastFees.add("Paid");
		siteOwnerSligoPastFees.add("Paid");
		/*siteOwnerSligoPastFees.add("Not Paid");*/
		/*siteOwnerSligoPastFees.add("Not Paid");
		siteOwnerSligoPastFees.add("Not Paid");
		siteOwnerSligoPastFees.add("Not Paid");
		siteOwnerSligoPastFees.add("Not Paid");*/

		for (int i = 0; i < siteOwnerSligoPastFees.size(); i++) {
			System.out.println(i + ": " + siteOwnerSligoPastFees.get(i));
		}

		db.setSiteOwnerGalwayPastFees(siteOwnerSligoPastFees);

		StallHolder stall1 = new StallHolder("John Apple", "John's Fruit", "johnsfruit01", "john@google.com", "password01", "Fresh fruit from John's garden.", "Fruit", "https://www.johnsfruit.ie/", "Galway",true);
		sortLists(stall1);
		db.addNewStallHolder(stall1);
		StallHolder stall2 = new StallHolder("Pat Smith", "Pat's Peaches", "peaches01", "pat@google.com", "password01", "Lovely Peaches", "Fruit", "https://www.peaches.ie/", "Galway", false);
		sortLists(stall2);
		db.addNewStallHolder(stall2);
		StallHolder stall3 = new StallHolder("Mary Smith", "Mary's Bread", "bread", "mary@google.com", "password01", "Freshly Baked Bread", "Baked Goods", "https://www.bread.ie/", "Sligo", true);
		sortLists(stall3);
		db.addNewStallHolder(stall3);
		StallHolder stall4 = new StallHolder("Anne Joyce", "Anne's Pastries", "pastries", "anne@google.com", "password01", "Freshly Baked Pastries", "Baked Goods", "https://www.pastries.ie/", "Sligo", true);
		sortLists(stall4);
		db.addNewStallHolder(stall4);
		Users u1 = new Users(stall1.getPassword(), stall1.getUsername(), "stallholder");
		add(u1);
		Users u2 = new Users(stall2.getPassword(), stall2.getUsername(), "stallholder");
		add(u2);
		Users mary = new Users(stall3.getPassword(), stall3.getUsername(), "stallholder");
		add(mary);
		Users anne = new Users(stall4.getPassword(), stall4.getUsername(), "stallholder");
		add(anne);
		stallHolderList.add(stall1);
		stallHolderList.add(stall2);
		stallHolderList.add(stall3);
		stallHolderList.add(stall4);

		siteOwnerList = new ArrayList<SiteOwner>();
		SiteOwner galway = new SiteOwner("Galway", "galwaysite", "pass01", "john@galway.ie", "John Smith");
		siteOwnerList.add(galway);
		setGalwayFees(galway);
		db.addNewSiteOwner(galway);
		Users u3 = new Users(galway.getSiteOwnerPassword(), galway.getUsername(), "siteowner");
		add(u3);

		// Added for Sligo Site
		SiteOwner sligo = new SiteOwner("Sligo", "sligosite", "pass02", "john@sligo.ie", "Jane Smith");
		siteOwnerList.add(sligo);
		setSligoFees(sligo);
		db.addNewSiteOwner(sligo);
		Users u5 = new Users(sligo.getSiteOwnerPassword(), sligo.getUsername(), "siteowner");
		add(u5);

		managerList = new ArrayList<Manager>();
		Manager sabrina = new Manager("Sabrina1", "FarmersM");
		managerList.add(sabrina);
		Users u4 = new Users("FarmersM", sabrina.getUsername(), "manager");
		add(u4);
	}

	// Log In / Log Out / Register Functionality
	// ------------------------------------------------------------------------------------------------
	public String login() {
		for (Users u : getUserList()) {
			if (u.getPassword().equals(password) && u.getUsername().equals(username)) {
				if (u.getType().equalsIgnoreCase("stallholder")) {
					for (StallHolder sh : stallHolderList) {
						if (u.getPassword().equals(sh.getPassword()) && u.getUsername().equals(sh.getUsername()))
							setLoggedInSh(sh);
						setLoggedUser(u);
						log = true;
						setLoginFailed(false);
					}
					return "StallOwner";
				} else if (u.getType().equalsIgnoreCase("siteowner")) {
					for (SiteOwner so : siteOwnerList) {
						if (u.getPassword().equals(so.getSiteOwnerPassword())
								&& u.getUsername().equals(so.getUsername()))
							setLoggedInSo(so);
						setLoggedUser(u);
						log = true;
						setLoginFailed(false);
					}
					for (SiteOwner so : siteOwnerList) {
						if (so.getSiteName().equalsIgnoreCase("Galway")) {
							return "SiteOwnerGalway";
						} else if (so.getSiteName().equalsIgnoreCase("Sligo")) {
							return "SiteOwnerSligo";
						}
					}
				}
				if (u.getType().equalsIgnoreCase("manager")) {
					log = true;
					setLoginFailed(false);
					return "Manager";
				}
			}
		}
		setLoginFailed(true);
		return "SingleLogin";
	}

	public String Logout() {
		setUsername(null);
		setPassword(null);
		log = false;
		return "Home";
	}

	public String registerStallHolder(String sHName, String sName, String sUsername, String sHEmail, String sHPassword,
			String sHDescription, String typeOfProd, String loc, String webLink, boolean isAct) {
		StallHolder stallHolder = new StallHolder(sHName, sName, sUsername, sHEmail, sHPassword, sHDescription,
				typeOfProd, webLink, loc, isAct);
		System.out.println("Registered stallHolder: " + stallHolder.toString());
		db.addNewStallHolder(stallHolder);
		stallHolderList = db.getStallHolderList();
		Users u = new Users(stallHolder.getPassword(), stallHolder.getUsername(), "stallholder");
		add(u);
		sortLists(stallHolder);
		for (StallHolder s : stallHolderList) {
			System.out.println("DB Contains:\n" + s.getName());
		}
		return "Manager";
	}

	public String registerSiteOwner(String siteName, String username, String siteOwnerPassword, String siteOwnerEmail,
			String siteOwnerName) {
		SiteOwner siteOwner = new SiteOwner(siteName, username, siteOwnerPassword, siteOwnerEmail, siteOwnerName);
		// System.out.println("Registered SiteOwner: " + siteOwner.toString());
		Users u = new Users(siteOwnerPassword, username, "siteowner");
		userList.add(u);
		db.addNewSiteOwner(siteOwner);
		siteOwnerList = db.getSiteOwnerList();
		for (SiteOwner s : siteOwnerList) {
			System.out.println("DB Contains:\n" + s.toString());
		}
		return "Manager.xhtml";
	}

	// Change Password / Update Info Functionality
	// -------------------------------------------------------------------------------------------------
	public String changePasswordSo() {
		if (loggedInSo.getSiteOwnerPassword().equals(oldPassword)
				&& loggedInSo.getSiteName().equalsIgnoreCase("galway")) {
			loggedInSo.setSiteOwnerPassword(newPassword);
			loggedUser.setPassword(newPassword);
			return "SiteOwnerGalway";
		} else if (loggedInSo.getSiteOwnerPassword().equals(oldPassword)
				&& loggedInSo.getSiteName().equalsIgnoreCase("sligo")) {
			loggedInSo.setSiteOwnerPassword(newPassword);
			loggedUser.setPassword(newPassword);
			return "SiteOwnerSligo";
		} else {
			return "Error";
		}
	}

	public String changePasswordSh() {
		if (loggedInSh.getPassword().equals(oldPassword)) {
			loggedInSh.setPassword(newPassword);
			loggedUser.setPassword(newPassword);
			return "StallOwner";
		} else {
			return "Error";
		}
	}

	// Update Stall Holder Info
	// ------------------------------------------------------------------------------------------------------
	public String updateData() {
		loggedInSh.setName(updateName);
		loggedInSh.setStallName(updateStallName);
		loggedInSh.setUsername(updateUsername);
		loggedUser.setUsername(updateUsername);
		loggedInSh.setEmail(updateEmail);
		loggedInSh.setDescription(updateDescription);
		loggedInSh.setTypeOfProduce(updateProduce);
		loggedInSh.setLocation(updateLocation);
		loggedInSh.setWebsiteLink(updateWebsiteLink);
		return "StallOwner";
	}

	// Stall Holder currently being viewed
	// -------------------------------------------------------------------------------------------
	public String view(String stallName) {
		for (StallHolder s : stallHolderList) {
			if (s.getStallName().equals(stallName))
				setViewing(s);
		}
		if (getViewing().getLocation().equals("Galway")) {
			return "GalwaySite#stallHolderProfileSection";
		} else if (getViewing().getLocation().equals("Sligo")) {
			return "SligoSite";
		}
		return "Home";
	}

	// Manage Stall Holder Functionality
	public String manageStallHolder(StallHolder stall) {
		setManaging(stall);
		return "ManageSelectedStallHolder";
	}

	public String changeActivationStatus() {
		for (StallHolder s : stallHolderList) {
			if (s.getStallName().equals(getManaging().getStallName())) {
				if (getManaging().getActivationStatus().equals("Not Activated")) {
					System.out.println("changing status from " + getManaging().getActivationStatus() + " to true");
					getManaging().setActivationStatus(true);
					setActivationStatus(true);
					s.setActivationStatus(true);
				} else {
					System.out.println("changing status from " + getManaging().getActivationStatus() + " to false");
					getManaging().setActivationStatus(false);
					setActivationStatus(false);
					s.setActivationStatus(false);
				}
			}
		}
		return "ManageSelectedStallHolder";
	}

	public String changeExternalLinkStatus() {
		for (StallHolder s : stallHolderList) {
			if (s.getStallName().equals(getManaging().getStallName())) {
				if (getManaging().getExternalLinkStatus().equals("Not Displayed")) {
					System.out.println("changing status from " + getManaging().getExternalLinkStatus() + " to true");
					getManaging().setExternalLinkStatus(true);
					setExternalLinkStatus(true);
					s.setExternalLinkStatus(true);
				} else {
					System.out.println("changing status from " + getManaging().getExternalLinkStatus() + " to false");
					getManaging().setExternalLinkStatus(false);
					setExternalLinkStatus(false);
					s.setExternalLinkStatus(false);
				}
			}
		}
		return "ManageSelectedStallHolder";
	}

	// Sort SH List
	// ------------------------------------------------------------------------------------------------------------------
	public void sortLists(StallHolder s) {
		if (s.getLocation().equalsIgnoreCase("galway"))
			galwayList.add(s);
		else if (s.getLocation().equalsIgnoreCase("sligo"))
			sligoList.add(s);
	}

	// Add User
	// ----------------------------------------------------------------------------------------------------------------------
	public void add(Users u) {
		userList.add(u);
	}

	// Update Management Fee to SO
	// ---------------------------------------------------------------------------------------------------
	public String changeFeeStatus(SiteOwner s) {
		if (s.getFeeStatus().equals("Not Paid")) {
			System.out.println("changing " + s.getSiteName() + "status from " + s.getFeeStatus() + " to paid");
			s.setFeeStatus("Paid");
		} else {
			System.out.println("changing " + s.getSiteName() + "status from " + s.getFeeStatus() + " to not paid");
			s.setFeeStatus("Not Paid");
		}
		return "Manager";
	}
	
	public SiteOwner getGalwayFees() {
		return galwayFees;
	}

	public void setGalwayFees(SiteOwner galwayFees) {
		this.galwayFees = galwayFees;
	}

	public SiteOwner getSligoFees() {
		return sligoFees;
	}

	public void setSligoFees(SiteOwner sligoFees) {
		this.sligoFees = sligoFees;
	}
	
	public String getConfirmSligoFeePaid() {
		if (confirmSligoFeePaid == true) {
			return "Payment Confirmed by Site Owner";
		} else {
			return "Payment Not Yet Confirmed";
		}
	}

	public void setConfirmSligoFeePaid(boolean confirmSligoFeePaid) {
		this.confirmSligoFeePaid = confirmSligoFeePaid;
	}

	public String getConfirmGalwayFeePaid() {
		if (confirmGalwayFeePaid == true) {
			return "Payment Confirmed by Site Owner";
		} else {
			return "Payment Not Yet Confirmed";
		}
	}

	public void setConfirmGalwayFeePaid(boolean confirmGalwayFeePaid) {
		this.confirmGalwayFeePaid = confirmGalwayFeePaid;
	}

	// Gets and Sets
	// -----------------------------------------------------------------------------------------------------------------
	public ArrayList<Users> getUserList() {
		return userList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<StallHolder> getStallHolderList() {
		return stallHolderList;
	}

	public void setStallHolderList(ArrayList<StallHolder> stallHolderList) {
		this.stallHolderList = stallHolderList;
	}

	public ArrayList<StallHolder> getGalwayList() {
		return galwayList;
	}

	public ArrayList<StallHolder> getSligoList() {
		return sligoList;
	}

	public ArrayList<SiteOwner> getSiteOwnerList() {
		return siteOwnerList;
	}

	public void setSiteOwnerList(ArrayList<SiteOwner> siteOwnerList) {
		this.siteOwnerList = siteOwnerList;
	}

	public StallHolder getLoggedInSh() {
		return loggedInSh;
	}

	public void setLoggedInSh(StallHolder loggedInSh) {
		this.loggedInSh = loggedInSh;
	}

	public StallHolder getViewing() {
		return viewing;
	}

	public void setViewing(StallHolder viewing) {
		this.viewing = viewing;
	}

	public SiteOwner getLoggedInSo() {
		return loggedInSo;
	}

	public void setLoggedInSo(SiteOwner loggedInSo) {
		this.loggedInSo = loggedInSo;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public boolean isLog() {
		return log;
	}

	public void setLog(boolean log) {
		this.log = log;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getUpdateStallName() {
		return updateStallName;
	}

	public void setUpdateStallName(String updateStallName) {
		this.updateStallName = updateStallName;
	}

	public String getUpdateUsername() {
		return updateUsername;
	}

	public void setUpdateUsername(String updateUsername) {
		this.updateUsername = updateUsername;
	}

	public String getUpdateEmail() {
		return updateEmail;
	}

	public void setUpdateEmail(String updateEmail) {
		this.updateEmail = updateEmail;
	}

	public String getUpdateDescription() {
		return updateDescription;
	}

	public void setUpdateDescription(String updateDescription) {
		this.updateDescription = updateDescription;
	}

	public String getUpdateProduce() {
		return updateProduce;
	}

	public void setUpdateProduce(String updateProduce) {
		this.updateProduce = updateProduce;
	}

	public String getUpdateLocation() {
		return updateLocation;
	}

	public void setUpdateLocation(String updateLocation) {
		this.updateLocation = updateLocation;
	}

	public String getUpdateWebsiteLink() {
		return updateWebsiteLink;
	}

	public void setUpdateWebsiteLink(String updateWebsiteLink) {
		this.updateWebsiteLink = updateWebsiteLink;
	}

	public Users getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(Users loggedUser) {
		this.loggedUser = loggedUser;
	}

	public String getSligoFeePaid() {
		if (sligoFeePaid == true) {
			return "Fee Paid-In-Full";
		} else {
			return "Fee Not Paid";
		}
	}

	public void setSligoFeePaid(boolean sligoFee) {
		this.sligoFeePaid = sligoFee;
	}

	public String getGalwayFeePaid() {
		if (galwayFeePaid == true) {
			return "Paid-In-Full";
		} else {
			return "Fee Not Paid";
		}
	}

	public void setGalwayFeePaid(boolean galwayFee) {
		this.galwayFeePaid = galwayFee;
	}

	public StallHolder getManaging() {
		return managing;
	}

	public void setManaging(StallHolder managing) {
		this.managing = managing;
	}

	public boolean isActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public boolean isExternalLinkStatus() {
		return externalLinkStatus;
	}

	public void setExternalLinkStatus(boolean externalLinkStatus) {
		this.externalLinkStatus = externalLinkStatus;
	}

	public LinkedList<String> getSiteOwnerGalwayPastFees() {
		return siteOwnerGalwayPastFees;
	}

	public void setSiteOwnerGalwayPastFees(LinkedList<String> siteOwnerGalwayPastFees) {
		this.siteOwnerGalwayPastFees = siteOwnerGalwayPastFees;
	}

	public String getCurrentMonth() {
		String monthStr = "";
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int month = cal.get(Calendar.MONTH);
		switch (month) {
		case 0:
			monthStr = "January";
			break;
		case 1:
			monthStr = "February";
			break;
		case 2:
			monthStr = "March";
			break;
		case 3:
			monthStr = "April";
			break;
		case 4:
			monthStr = "May";
			break;
		case 5:
			monthStr = "June";
			break;
		case 6:
			monthStr = "July";
			break;
		case 7:
			monthStr = "August";
			break;
		case 8:
			monthStr = "September";
			break;
		case 9:
			monthStr = "October";
			break;
		case 10:
			monthStr = "November";
			break;
		case 11:
			monthStr = "December";
			break;
		default:
			break;
		}
		return monthStr;
	}

	public void setCurrentMonth(String currentMonth) {
		this.currentMonth = currentMonth;
	}

	public String[] getPreviousFeesString() {

		String monthStr = "";
		for (int i = 0; i < this.siteOwnerGalwayPastFees.size(); i++) {
			switch (i) {
			case 0:
				monthStr = "January";
				break;
			case 1:
				monthStr = "February";
				break;
			case 2:
				monthStr = "March";
				break;
			case 3:
				monthStr = "April";
				break;
			case 4:
				monthStr = "May";
				break;
			case 5:
				monthStr = "June";
				break;
			case 6:
				monthStr = "July";
				break;
			case 7:
				monthStr = "August";
				break;
			case 8:
				monthStr = "September";
				break;
			case 9:
				monthStr = "October";
				break;
			case 10:
				monthStr = "November";
				break;
			case 11:
				monthStr = "December";
				break;
			default:
				break;
			}

			previousFeesString[i] = monthStr + ": " + this.siteOwnerGalwayPastFees.get(i);
		}
		return previousFeesString;
	}

	public boolean isLoginFailed() {
		return loginFailed;
	}

	public void setLoginFailed(boolean loginFailed) {
		this.loginFailed = loginFailed;
	}

}