package br.edu.cefsa.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.cefsa.ftt.bean.CartaBEAN;
import br.edu.cefsa.ftt.ec.model.Model;
import br.edu.cefsa.ftt.util.DbUtil;

public class CartaDAO {
	
	private Connection connection;
	
	public CartaDAO() {
		connection = DbUtil.getConnection();
	}

	public void addCarta(CartaBEAN carta) {
        
    	try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO carta (nome, ataque, defesa, foto, tipo, atributo) VALUES (?, ?, ?, ?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, carta.getNome());
            preparedStatement.setInt(2, carta.getAtaque());
            preparedStatement.setInt(3, carta.getDefesa());
            preparedStatement.setBinaryStream(4, carta.getFoto());
            
            
            preparedStatement.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
            
            throw new ArithmeticException("ModelDao: addModel: " + e.getMessage()); 
        }
    } //addModel
}
