package br.edu.cefsa.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.cefsa.ftt.bean.CartaBEAN;
import br.edu.cefsa.ftt.bean.TipoBEAN;
import br.edu.cefsa.ftt.types.AtributoENUM;
import br.edu.cefsa.ftt.util.DbUtil;
import br.edu.cefsa.ftt.util.MyException;

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
            preparedStatement.setBlob(4, carta.getFoto());
            preparedStatement.setInt(5, carta.getTipo().getCodigo());
            preparedStatement.setString(6, carta.getAtributo().toString());            
            
            preparedStatement.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
            
            throw new ArithmeticException("CartaDao: addCarta: " + e.getMessage()); 
        }
    } //addCarta
	
	public void deleteCarta(CartaBEAN carta) throws MyException {
        try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM carta WHERE codigo=?");
            
            // Parameters start with 1
            preparedStatement.setInt(1, carta.getCodigo());

            int updates = preparedStatement.executeUpdate();
            
            if(updates == 0) {
            	String message = "Código da carta " + carta.getCodigo() + " não encontrado!";
            	
            	throw new MyException(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //deleteCarta
	
	public void updateCarta(CartaBEAN carta) throws MyException {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE carta SET nome=?, " 
                    		                          + "ataque=?, " 
                    		                          + "defesa=?, " 
                    		                          + "foto=?, " 
                    		                          + "tipo=?, " 
                    		                          + "atributo=?" 
                                               + "WHERE codigo=?");
            
            // Parameters start with 1
            preparedStatement.setString(1, carta.getNome());
            preparedStatement.setInt(2, carta.getAtaque());
            preparedStatement.setInt(3, carta.getDefesa());
            preparedStatement.setBlob(4, carta.getFoto());
            preparedStatement.setInt(5, carta.getTipo().getCodigo());
            preparedStatement.setString(6, carta.getAtributo().toString());             
            preparedStatement.setLong(7, carta.getCodigo());
            
            int updates = preparedStatement.executeUpdate();
            
            if(updates == 0) {
            	String message = "Código da carta " + carta.getCodigo() + " não encontrado!";
            	
            	throw new MyException(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //updateCarta
	
public List<CartaBEAN> getAllPeoples() throws MyException {
        
    	List<CartaBEAN> cartas = new ArrayList<CartaBEAN>();
        
        try {
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM carta");
            
            boolean found = false;
            
            while (rs.next()) {
            	
            	found = true;
                
            	CartaBEAN carta = new CartaBEAN();
                
            	carta.setCodigo(rs.getInt("codigo"));
                carta.setNome(rs.getString("nome"));
                carta.setAtaque(rs.getInt("ataque"));
                carta.setDefesa(rs.getInt("defesa"));
                carta.setFoto(rs.getBlob("foto"));    
                
                TipoBEAN tipo = new TipoDAO().getTipoById(rs.getInt("tipo"));                
                carta.setTipo(tipo);                
                
                carta.setAtributo(AtributoENUM.valueOf(rs.getString("atributo")));

                cartas.add(carta);
            }
            
            if (!found) {
            	String message = "Nenhuma carta disponível!";
            	
            	throw new MyException(message);
			}
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartas;
    } //getAllCartas
}
