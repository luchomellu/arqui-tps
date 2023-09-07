package dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> {
	public void insert(T dao) throws SQLException;
    public boolean delete(Integer id);
    public T find(Integer pk);
    public boolean update(T dao);
    public List<T> selectList() throws SQLException;
}
