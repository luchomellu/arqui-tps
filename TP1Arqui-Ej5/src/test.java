import java.sql.SQLException;

import dao.PersonaDAO;
import entidades.Persona;
import factory.JPAFactory;

public class test {

	public static void main(String[] args) throws SQLException {
		Persona ej1 = new Persona(22,"lucho");
		JPAFactory factory = JPAFactory.getInstance();
		PersonaDAO pd = factory.getPersonaDAO();
		pd.insert(ej1);
	}
}
