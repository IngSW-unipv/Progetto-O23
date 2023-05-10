package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDaoImpl {
	private Connection getConnection() throws SQLException {
	    String url = "jdbc:mysql://localhost:3306/hotel";
	    String user = "MatteoDilo99";
	    String password = "Parmenide1!";
	    return DriverManager.getConnection(url, user, password);
	}
}
