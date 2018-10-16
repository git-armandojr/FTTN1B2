package br.edu.cefsa.ftt.dao;



import java.sql.Connection;

import br.edu.cefsa.ftt.util.DbUtil;
	
	

public class JogadorDAO {
	
	private Connection connection;
	
	public JogadorDAO() {
		connection = DbUtil.getConnection();	
	}
	
	
}
