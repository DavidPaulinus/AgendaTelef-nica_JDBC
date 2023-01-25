package infra;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource cpd = new ComboPooledDataSource();
		cpd.setJdbcUrl("jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC");
		cpd.setUser("root");
		cpd.setPassword("root");
		
		cpd.setMaxPoolSize(15);
		
		dataSource = cpd;
	}

	public Connection getConection() throws SQLException {
		return dataSource.getConnection();
	}
	
}
