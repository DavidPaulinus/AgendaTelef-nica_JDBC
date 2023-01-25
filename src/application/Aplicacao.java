package application;

import java.sql.Connection;
import java.sql.SQLException;

import infra.ConnectionFactory;

public class Aplicacao {

	public static void main(String[] args) {
		
//		ConnectionFactory coF= new ConnectionFactory();
//		Connection conn = coF.getConection();
		
		try(Connection conn = new ConnectionFactory().getConection();){
			
			
			
		}catch(SQLException e){
			
		}
		
	}

}
