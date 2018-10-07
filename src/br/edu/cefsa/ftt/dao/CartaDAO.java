package br.edu.cefsa.ftt.dao;

import java.sql.Connection;

import br.edu.cefsa.ftt.util.DbUtil;

public class CartaDAO {
	
	private Connection connection;
	
	public CartaDAO() {
		connection = DbUtil.getConnection();
	}

}
