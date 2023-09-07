package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLFactoryDAO<T> extends DAOFactory<T>{

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URI = "jdbc:mysql://localhost:3306/test_arqui";
	public static Connection conn;
	
	public static Connection createConnection() {
		try {
			Class.forName(DRIVER).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		try {
			Connection conn = DriverManager.getConnection(URI, "root", "tudai2023");
			conn.setAutoCommit(false);
			
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
			
	@Override
	public CrudDAO<T> getPersonaDAO() {
		return new PersonaDAO<T>(createConnection());
	}
	
}
