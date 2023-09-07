package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Persona;

public class PersonaDAO implements CrudDAO<Persona>{
	private EntityManager em;
	
	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Persona p) throws SQLException {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Persona find(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Persona dao) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> selectList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
