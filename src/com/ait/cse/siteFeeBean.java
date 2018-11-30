package com.ait.cse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class siteFeeBean {
	private ArrayList<SiteFees> fees;
	
	@PostConstruct
	public void init() {
	ArrayList<SiteFees> fees = new ArrayList<SiteFees>();
	SiteFees sitefees = new SiteFees("January", true);
	fees.add(sitefees);
	}
	
	public siteFeeBean() {
		
	}

	public ArrayList<SiteFees> getFees() {
		return fees;
	}
}
