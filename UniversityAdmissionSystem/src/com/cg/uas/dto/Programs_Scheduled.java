package com.cg.uas.dto;

import java.util.Date;

public class Programs_Scheduled

{

	private String scheduled_Program_Id ;
	private String programName ;
	private String city  ;
	private int pincode	 ;
	private Date start_Date  ;
	private Date end_Date  ;
	private int sessions_Per_Week ;
	
	
	@Override
	public String toString() {
		return "Programs_Scheduled [scheduled_Program_Id="
				+ scheduled_Program_Id + ", programName=" + programName
				+ ", city=" + city + ", pincode=" + pincode + ", start_Date="
				+ start_Date + ", end_Date=" + end_Date
				+ ", sessions_Per_Week=" + sessions_Per_Week + "]";
	}


	public String getScheduled_Program_Id() {
		return scheduled_Program_Id;
	}


	public void setScheduled_Program_Id(String scheduled_Program_Id) {
		this.scheduled_Program_Id = scheduled_Program_Id;
	}


	public String getProgramName() {
		return programName;
	}


	public void setProgramName(String programName) {
		this.programName = programName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public Date getStart_Date() {
		return start_Date;
	}


	public void setStart_Date(Date start_Date) {
		this.start_Date = start_Date;
	}


	public Date getEnd_Date() {
		return end_Date;
	}


	public void setEnd_Date(Date end_Date) {
		this.end_Date = end_Date;
	}


	public int getSessions_Per_Week() {
		return sessions_Per_Week;
	}


	public void setSessions_Per_Week(int sessions_Per_Week) {
		this.sessions_Per_Week = sessions_Per_Week;
	}
	
	
	
}
