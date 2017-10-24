package com.cg.uas.ui;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import com.cg.uas.dto.Programs_Scheduled;
import com.cg.uas.exception.UasException;
import com.cg.uas.service.IServiceUas;
import com.cg.uas.service.ServiceUasImpl;

public class UasClient {

	static IServiceUas service;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
				service = new ServiceUasImpl();
			System.out.println("Service started! ");
		} catch (UasException exp) {
			System.err.println(exp.getMessage());
			System.exit(0);
		}
		PropertyConfigurator.configure("resources/log4j.properties");

		List<Programs_Scheduled> programsList;
		
		
		try {
			programsList =service.allPrograms();
			System.out.println("try enter");
			for(Programs_Scheduled program: programsList)
			{	System.out.println("for enter");
				System.out.println(program.toString());
			}
		} catch (UasException exp) {
			System.err.println(exp.getMessage());
		}
		
		
		
		
	}

}
