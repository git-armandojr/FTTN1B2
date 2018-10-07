package br.edu.cefsa.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.cefsa.ftt.bean.TipoBEAN;
import br.edu.cefsa.ftt.util.DbUtil;

public class TipoDAO {
	public static void Inserir(TipoBEAN tipo) {
	try{
		String insert = "insert into tipos values (?,?)";
		Connection connection = DbUtil.getConnection();
		PreparedStatement sql = connection.prepareStatement(insert);
		sql.executeUpdate();
		
	} catch (SQLException erro) {
		
	}
		
	}
}
