import java.sql.Connection;
import java.sql.SQLException;

public class TablesCreator {
	private Connection conn;

    public TablesCreator(Connection conn) {
        this.conn = conn;
    }
    
    public void createTables() throws SQLException {
		String tabla = "CREATE TABLE persona(id INT,nombre VARCHAR(100),edad INT,PRIMARY KEY(id))";
		this.conn.prepareStatement(tabla).execute();
		this.conn.commit();
	}
}
