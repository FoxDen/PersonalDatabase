package personal_database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("unused")
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
		PreparedStatement update;
		Statement queryStatement = connection.createStatement();
		update = null;
			String querys="select * from animuDatabase.mediatype;";
			ResultSet results = queryStatement.executeQuery(querys);
			while(results.next()){
                System.out.print(results.getString("summary"));
                System.out.print("    ");
                System.out.print(results.getString("artwork"));
                System.out.println();
                System.out.println();

			}
			update = connection.prepareStatement(querys);

		// TODO Auto-generated method stub

	}

}
