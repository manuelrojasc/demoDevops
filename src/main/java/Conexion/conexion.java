package Conexion;

import java.sql.Connection;
import java.sql.SQLException;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class conexion {
	private static BasicDataSource dataSource=null;
	
	private static DataSource getDataSource() throws ClassNotFoundException {
		if (dataSource==null) {
			dataSource= new BasicDataSource();
	     	//Class.forName("com.mysql.cj.jdbc.Driver");
	     	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("");
			dataSource.setUrl("jdbc:mysql://localhost:3306/prueba?serverTimezone=UTC");
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxTotal(20);
			dataSource.setMaxWaitMillis(5000);
		}
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		return getDataSource().getConnection();
	}
 
}




