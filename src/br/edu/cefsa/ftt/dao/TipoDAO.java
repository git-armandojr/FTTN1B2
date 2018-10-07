package br.edu.cefsa.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.cefsa.ftt.bean.TipoBEAN;
import br.edu.cefsa.ftt.util.DbUtil;
import br.edu.cefsa.ftt.util.MyException;

	public class TipoDAO {
	
	private Connection connection;

	public TipoDAO() {
		connection = DbUtil.getConnection();
	}
	
	public TipoBEAN getTipoById(int id) throws MyException {
		
		TipoBEAN tipo = new TipoBEAN();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM tipo WHERE codigo=?");
            
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.next()) {
            	String message = "Código do tipo " + id + " não encontrado!";
            	
            	throw new MyException(message);
            } 
            else {
            	tipo.setCodigo(rs.getInt("codigo"));
                tipo.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipo;
	}

}
