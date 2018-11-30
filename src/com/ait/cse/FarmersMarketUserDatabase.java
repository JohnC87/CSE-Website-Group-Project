package com.ait.cse;

import java.util.ArrayList;
import java.util.LinkedList;

public class FarmersMarketUserDatabase {
	
	private ArrayList<StallHolder> stallHolderList;
	private ArrayList<SiteOwner> siteOwnerList;
	private ArrayList<Manager> managerList;
	private boolean galwayFeePaid;
	private boolean sligoFeePaid;
	private LinkedList<String> siteOwnerGalwayPastFees;
	
	public FarmersMarketUserDatabase() {
		stallHolderList = new ArrayList<StallHolder>();
		siteOwnerList = new ArrayList<SiteOwner>();
		managerList = new ArrayList<Manager>();
		siteOwnerGalwayPastFees = new LinkedList<String>();
	}
	
	public void addNewStallHolder(StallHolder stallHolder) {
		stallHolderList.add(stallHolder);
	}
	
	public void addNewSiteOwner(SiteOwner siteOwner) {
		siteOwnerList.add(siteOwner);
	}
	
	/*public void addNewManagementStaff(Manager manager) {
		managerList.add(manager);
	}*/

	public ArrayList<StallHolder> getStallHolderList() {
		return stallHolderList;
	}

	public ArrayList<SiteOwner> getSiteOwnerList() {
		return siteOwnerList;
	}

	/*public ArrayList<Manager> getManagerList() {
		return managerList;
	}*/

	public boolean isGalwayFeePaid() {
		return galwayFeePaid;
	}

	public void setGalwayFee(boolean galwayFeePaid) {
		this.galwayFeePaid = galwayFeePaid;
	}

	public boolean isSligoFeePaid() {
		return sligoFeePaid;
	}

	public void setSligoFeePaid(boolean sligoFeePaid) {
		this.sligoFeePaid = sligoFeePaid;
	}
	public LinkedList<String> getSiteOwnerGalwayPastFees() {
		return siteOwnerGalwayPastFees;
	}

	public void setSiteOwnerGalwayPastFees(LinkedList<String> siteOwnerGalwayPastFees2) {
		this.siteOwnerGalwayPastFees = siteOwnerGalwayPastFees2;
	}
}
