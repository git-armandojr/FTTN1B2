package br.edu.cefsa.ftt.dao;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.edu.cefsa.ftt.bean.TipoBEAN;
import br.edu.cefsa.ftt.util.DbUtil;

public class TipoDAO {
	
	private static Connection connection = null;
	
	public TipoDAO(){
		connection = DbUtil.getConnection();
	}
	
	public static void Inserir(TipoBEAN tipo) throws SQLException{
		String insert = "insert into tipo values (?,?)";
		PreparedStatement sql = connection.prepareStatement(insert);
		sql.setInt(1, tipo.getCodigo());
		sql.setString(2, tipo.getDescricao());
	try 
	{		
		sql.executeUpdate();		
	} 
	catch (SQLException erro) 
	{
		throw new SQLException(erro.getMessage());
	}	
	}
	public static void Alterar(TipoBEAN tipo) throws SQLException{
		String update = "update tipo set descricao = ? where id = ?";
		PreparedStatement sql = connection.prepareStatement(update);
		sql.setString(1, tipo.getDescricao());
		sql.setInt(2, tipo.getCodigo());
	try 
	{	
		sql.executeUpdate();	
	} 
	catch (SQLException erro) 
	{
		throw new SQLException(erro.getMessage());
	}
	}
	
	public static ArrayList<TipoBEAN> Listar() throws SQLException{
		String select = "select * from tipo";
		PreparedStatement sql = connection.prepareStatement(select);
		ResultSet Data = null;
		try 
		{
			Data = sql.executeQuery();
		}
		catch (SQLException erro) 
		{
			throw new SQLException(erro.getMessage());
		}
		ArrayList<TipoBEAN> ListaTipos = new ArrayList<TipoBEAN>();		
		
		while (Data.next())
		{
			TipoBEAN tipo = new TipoBEAN();
			tipo.setCodigo(Data.getInt(1));
			tipo.setDescricao(Data.getString(2));		
			ListaTipos.add(tipo);
		}	
	 return ListaTipos;
	}
	
	public static void Deletar(int id) throws SQLException {
		String delete ="delete from tipo where id = ?";
		PreparedStatement sql = connection.prepareStatement(delete);
		sql.setInt(1, id);
	try
	{
		sql.executeUpdate();
	}
	catch (SQLException erro)
	{
		throw new SQLException(erro.getMessage());
	}
		
	}
	
}
