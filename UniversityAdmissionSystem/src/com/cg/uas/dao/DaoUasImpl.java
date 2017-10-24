package com.cg.uas.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cg.uas.dto.Application;
import com.cg.uas.dto.Programs_Offered;
import com.cg.uas.dto.Programs_Scheduled;
import com.cg.uas.exception.UasException;
import com.cg.uas.util.ConnectionProvider;

public class DaoUasImpl implements IDaoUas {

	private Logger classLogger;
	private ConnectionProvider conPro;

	public DaoUasImpl() throws UasException {
		classLogger = Logger.getLogger(DaoUasImpl.class);
		try {
			conPro = ConnectionProvider
					.getInstance("resources/dbconfig.properties");

		} catch (ClassNotFoundException | IOException exp) {
			classLogger.error(exp);
			throw new UasException("Data Acces Initialization failed");
		}
	}

	public Programs_Scheduled mapProgram(ResultSet row) throws UasException {
		Programs_Scheduled program = new Programs_Scheduled();
		try {

			program.setScheduled_Program_Id(row
					.getString("Scheduled_Program_Id"));
			program.setProgramName(row.getString("programName"));
			program.setCity(row.getString("city"));
			program.setPincode(row.getInt("pincode"));
			program.setStart_Date(row.getDate("start_Date"));
			program.setEnd_Date(row.getDate("end_Date"));
			program.setSessions_Per_Week(row.getInt("sessions_Per_Week"));

		} catch (SQLException exp) {
			classLogger.error(exp);
			throw new UasException("Failed to retrieve Program Scheduled Data");
		}

		return program;
	}

	@Override
	public List<Programs_Scheduled> allPrograms() throws UasException {

		List<Programs_Scheduled> programsList = new ArrayList<>();
		try (Connection con = conPro.getConnection();
				PreparedStatement pstSelectAll = con
						.prepareStatement(IQueryMapper.VIEW_ALL_PROGS)) {
			System.out.println("function enter");
			ResultSet results = pstSelectAll.executeQuery();
			/*
			 * results.next(); System.out.println(results.getInt("pincode"));
			 */
			System.out.println("query executed");
			while (results.next()) {
				System.out.println("query while enter");
				programsList.add(mapProgram(results));
			}
		} catch (SQLException exp) {
			classLogger.error(exp);
			throw new UasException("Failed to get Programs Schedule!");
		}

		return programsList;

	}

	@Override
	public int apply(Application application) throws UasException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String status(int application_Id) throws UasException {

		try (Connection con = conPro.getConnection();
				PreparedStatement pstStatus = con
						.prepareStatement(IQueryMapper.VIEW_STATUS)) {

			pstStatus.setInt(1, application_Id);
			ResultSet results = pstStatus.executeQuery();
		} catch (SQLException exp) {
			classLogger.error(exp);
			throw new UasException("Failed to get Application status");
		}

		return null;
	}

	@Override
	public boolean macLogin(String userName, String Password)
			throws UasException {
		// TODO Auto-generated method stub
		boolean valid = false;

		try (Connection con = conPro.getConnection();
				PreparedStatement pst = con
						.prepareStatement(IQueryMapper.LOGIN_VERIFY_MAC)) {

			pst.setString(1, userName);
			pst.setString(2, Password);
			ResultSet result = pst.executeQuery();

			if (result.next()) {
				valid = true;
			}

		} catch (SQLException exp) {
			classLogger.error(exp);
			throw new UasException("Failed to authenticate ");
		}
		return valid;
	}

	@Override
	public boolean adminLogin(String userName, String Password)
			throws UasException {
		boolean valid = false;

		try (Connection con = conPro.getConnection();
				PreparedStatement pst = con
						.prepareStatement(IQueryMapper.LOGIN_VERIFY_ADMIN)) {

			pst.setString(1, userName);
			pst.setString(2, Password);
			ResultSet result = pst.executeQuery();
			if (result.next()) {
				valid = true;
			}
		} catch (SQLException exp) {
			classLogger.error(exp);
			throw new UasException("Failed to authenticate ");
		}
		return valid;
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
		boolean valid = false;

		try (Connection con = conPro.getConnection();
				PreparedStatement pst = con
						.prepareStatement(IQueryMapper.ACCEPT_APPLICANT)) {

			pst.setString(1, interviewDate);
			pst.setInt(2, application_Id);
			
			ResultSet result = pst.executeQuery();
			if (result.next()) {
				valid = true;
			}
		} catch (SQLException exp) {
			classLogger.error(exp);
			throw new UasException("Failed to update accept status ");
		}
		return valid;
	}

	@Override
	public boolean rejectApplication(int application_Id)
			throws UasException {
		boolean valid = false;

		try (Connection con = conPro.getConnection();
				PreparedStatement pst = con
						.prepareStatement(IQueryMapper.REJECT_APPLICANT)) {

			pst.setInt(1, application_Id);
			
			ResultSet result = pst.executeQuery();
			if (result.next()) {
				valid = true;
			}
		} catch (SQLException exp) {
			classLogger.error(exp);
			throw new UasException("Failed to update accept status ");
		}
		return valid;
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

}
