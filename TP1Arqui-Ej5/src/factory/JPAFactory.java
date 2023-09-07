package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.PersonaDAO;

public class JPAFactory {
	private static JPAFactory instance = null;
	private static EntityManagerFactory emf;
	
	private JPAFactory() {
	}
	
	public static synchronized JPAFactory getInstance() {
        if (instance == null) {
            instance = new JPAFactory();
        }
        return instance;
    }
	
	public void closeConnection() {
		JPAFactory.emf.close();
	}
	
	public EntityManager createConnection() {
		if(emf != null) {
			return emf.createEntityManager();
		}
		else {
			JPAFactory.emf = Persistence.createEntityManagerFactory("test");
			return emf.createEntityManager();
		}
	}
	
	public PersonaDAO getPersonaDAO() {
		return new PersonaDAO(createConnection());
	}
	
	
}
