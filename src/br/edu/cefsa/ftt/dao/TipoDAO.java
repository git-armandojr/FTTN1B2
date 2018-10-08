package br.edu.cefsa.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.cefsa.ftt.bean.TipoBEAN;
import br.edu.cefsa.ftt.util.DbUtil;
import br.edu.cefsa.ftt.util.MyException;

	public class TipoDAO {
	
	private Connection connection;

	public TipoDAO() {
		connection = DbUtil.getConnection();
	}
	
	public void addTipo(TipoBEAN tipo) {
        
    	try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO tipo (descricao) VALUES (?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, tipo.getDescricao());            
            
            preparedStatement.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
            
            throw new ArithmeticException("TipoDAO: addTipo: " + e.getMessage()); 
        }
    } //addTipo
	
	public void deleteTipo(TipoBEAN tipo) throws MyException {
        try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM tipo WHERE codigo=?");
            
            // Parameters start with 1
            preparedStatement.setInt(1, tipo.getCodigo());

            int updates = preparedStatement.executeUpdate();
            
            if(updates == 0) {
            	String message = "Código do tipo " + tipo.getCodigo() + " não encontrado!";
            	
            	throw new MyException(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //deleteTipo
	
	public void updateTipo(TipoBEAN tipo) throws MyException {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE tipo SET descricao=?" 
                                               + "WHERE codigo=?");
            
            // Parameters start with 1
            preparedStatement.setString(1, tipo.getDescricao());
            preparedStatement.setInt(2, tipo.getCodigo());
            
            int updates = preparedStatement.executeUpdate();
            
            if(updates == 0) {
            	String message = "Código do tipo " + tipo.getCodigo() + " não encontrado!";
            	
            	throw new MyException(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //updateTipo
	
	public List<TipoBEAN> getAllTipos() throws MyException {
        
    	List<TipoBEAN> tipos = new ArrayList<TipoBEAN>();
        
        try {
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM tipo");
            
            boolean found = false;
            
            while (rs.next()) {
            	
            	found = true;
                
            	TipoBEAN tipo = new TipoBEAN();
                
            	tipo.setCodigo(rs.getInt("codigo"));
            	tipo.setDescricao(rs.getString("descricao"));

                tipos.add(tipo);
            }
            
            if (!found) {
            	String message = "Nenhum tipo disponível!";
            	
            	throw new MyException(message);
			}
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipos;
    } //getAllTipos
	
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
