package br.com.gpmodontosystem.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoImpl implements IDao {
	
	protected Connection con;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	@Override
	public void open() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BDODONTOSYSTEM", "root", "coti");
	}
	
	@Override
	public void close() throws Exception{
		con.close();
	}

}
