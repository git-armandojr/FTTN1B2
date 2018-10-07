package br.edu.cefsa.ftt.teste;

import java.sql.Connection;
import java.util.Date;

import br.edu.cefsa.ftt.util.DbUtil;

public class TesteConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DbUtil.getConnection();
			
			if (connection != null) {
				System.out.println("Conectado! " + String.valueOf(new Date()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
