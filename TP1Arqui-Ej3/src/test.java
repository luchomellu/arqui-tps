import java.sql.SQLException;

import Entidades.Persona;
import dao.DAOFactory;
import dao.PersonaDAO;

public class test {
	public static <T> void main (String[] args) throws SQLException {
		
		DAOFactory<T> system = DAOFactory.getDAOFactory(1);
		
		PersonaDAO<T> persona =  (PersonaDAO<T>) system.getPersonaDAO();
		//persona.createTables();
		//persona.insert((T) new Persona(1,22,"lucho"));
		System.out.println(persona.selectList());
		
		DAOFactory<T> system2 = DAOFactory.getDAOFactory(2);
		
		PersonaDAO<T> persona2 =  (PersonaDAO<T>) system2.getPersonaDAO();
		persona2.createTables();
		persona2.insert((T) new Persona(1,22,"lucho"));
		System.out.println(persona2.selectList());
		
	}
}
