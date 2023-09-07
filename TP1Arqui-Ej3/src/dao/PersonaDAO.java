package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Persona;

public class PersonaDAO<T> implements CrudDAO<T>{
	
	private Connection conn;    

    public PersonaDAO(Connection conn) {
        this.conn = conn;
    }

	@Override
	public int insert(T persona) throws SQLException {
		Persona p = (Persona) persona;
		String insert = "INSERT INTO persona (id,nombre,edad) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1,p.getId());
		ps.setString(2,p.getName());
		ps.setInt(3,p.getAge());
		ps.executeUpdate();
		ps.close();
		
		return 0;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T find(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(T dao) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> selectList() throws SQLException {
		List<Persona> res = new ArrayList<>();
		String select = "SELECT * FROM persona";
		PreparedStatement ps = conn.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Persona n = new Persona(rs.getInt(1),rs.getInt(3),rs.getString(2));
			res.add(n);
		}
		
		conn.close();
		return (List<T>) res;
	}
    
	public void createTables() throws SQLException {
		String tabla = "CREATE TABLE persona(id INT,nombre VARCHAR(100),edad INT,PRIMARY KEY(id))";
		this.conn.prepareStatement(tabla).execute();
		this.conn.commit();
	}
    
}
