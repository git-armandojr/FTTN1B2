package br.edu.cefsa.ftt.test;

import java.sql.Connection;
import java.util.Date;

import br.com.cefsa.ftt.util.DbUtil;

public class ConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DbUtil.getConnection();
			
			if (connection != null) {
				System.out.println("Connected! " + String.valueOf(new Date()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
