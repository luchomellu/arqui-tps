package dao;

public abstract class DAOFactory<T> {
	public static final int Derby = 1;
	public static final int MySQL = 2;
	public abstract CrudDAO<T> getPersonaDAO();
	
	public static DAOFactory getDAOFactory(int db) {
		switch(db) {
			case Derby : return new DerbyFactoryDAO();
			case MySQL : return new MySQLFactoryDAO();
			default : return null;
		}
	}
}
