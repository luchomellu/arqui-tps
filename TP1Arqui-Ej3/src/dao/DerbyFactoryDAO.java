package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DerbyFactoryDAO<T> extends DAOFactory<T>{
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String URI = "jdbc:derby:MyDerbyDb;create=true";
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
			Connection conn = DriverManager.getConnection(URI);
			
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
