package com.cg.uas.service;

import java.util.List;

import com.cg.uas.dao.DaoUasImpl;
import com.cg.uas.dao.IDaoUas;
import com.cg.uas.dto.Application;
import com.cg.uas.dto.Programs_Offered;
import com.cg.uas.dto.Programs_Scheduled;
import com.cg.uas.exception.UasException;




public class ServiceUasImpl implements IServiceUas {

private IDaoUas dao =null;

	
	
	
	public ServiceUasImpl() throws UasException {
		dao = new DaoUasImpl();
	}

	@Override
	public List<Programs_Scheduled> allPrograms() throws UasException {
		// TODO Auto-generated method stub
		return dao.allPrograms();
	}

	@Override
	public int apply(Application application) throws UasException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String status(int application_Id) throws UasException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean macLogin(String userName, String Password)
			throws UasException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean adminLogin(String userName, String Password)
			throws UasException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Application> allApplications(String programName)
			throws UasException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptApplication(int application_Id, String interviewDate)
			throws UasException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean confirmApplication(int application_Id) throws UasException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updProgramOffered(Programs_Offered program_offered)
			throws UasException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addProgramOffered(Programs_Offered program_offered)
			throws UasException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delProgramOffered(String ProgramName) throws UasException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updProgramScheduled(Programs_Scheduled program_Scheduled)
			throws UasException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addProgramScheduled(Programs_Scheduled program_Scheduled)
			throws UasException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delProgramScheduled(String scheduled_Program_Id)
			throws UasException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Application> viewApplicants() throws UasException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Programs_Scheduled> viewPrograms(String startDate,
			String endDate) throws UasException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean rejectApplication(int application_Id) throws UasException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	

}
