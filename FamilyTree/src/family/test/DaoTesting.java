package family.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import family.Dao.DatabaseDao;
import family.util.ConnectionFactory;

class DaoTesting {

	@BeforeEach
	void setUp() throws SQLException {

		DatabaseDao databaseDao = new DatabaseDao();

		PreparedStatement pstmt = ConnectionFactory.getConnection().prepareStatement("delete from family_members;delete from parent_child;");

		pstmt.executeUpdate();

	}

	// ConnectionTest
	@Test
	void testConnection() {
		assertNotNull(ConnectionFactory.getConnection());
	}
}
