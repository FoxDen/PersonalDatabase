package personal_database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseBackend {
	//IMPORTANT MYSQL userName and Password
	static final String username = "root";
	static final String password = "10732351";
	private static Connection connection = null;

	public static void main(String[] args) throws ClassNotFoundException,InstantiationException,
	IllegalAccessException, SQLException {
		
		Object instance; //create new instance
		instance = Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/animudatabase", username, password);
		
		// TODO Auto-generated method stub

	}

}
