package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimeZone=UTC";
		String user = "hbstudent";
		String pwd = "hbstudent";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, pwd);
			
			System.out.println("Connection successful -->" + myConnection);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
