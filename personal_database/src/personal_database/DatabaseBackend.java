package personal_database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class DatabaseBackend {
	//IMPORTANT MYSQL userName and Password
	static final String username = "root";
	static final String password = "10732351";
	static final String datab = "animuDatabase";
	private static Connection connection = null;
	static GUIDatabase window;
	
	public static void viewTables(Connection c, String db) throws SQLException{
		Statement statement = null;
		String query = "SELECT title, release_date, adaptation_of, network, studio_name, completed, genre "
					 + "FROM "+ db + ".mediaType";
		
		try{
			statement = c.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()){
				
			}
		} catch (SQLException e){
				JOptionPane.showMessageDialog(null, e.toString());
			
		} finally {
			if (statement != null) { statement.close();
			}
		}
		
		statement.close();

	}
	
	public static void updateTable() throws SQLException{

	}
	
	public static void seeLastEntry(Connection c, String db) throws SQLException{	
		Statement statement = null;
		String query = "";
		ResultSet rs = statement.executeQuery(query);
		statement.close();
	}
	
	public static void viewAll(Connection c, String db, String type) throws SQLException{
		Statement statement = null;
		String query = "";
		if(type.equals("manga")){
			query = "SELECT m_title, release_date, m_mangaka, current_chapter, completed FROM "+
					db+".manga, "+ db +".mediaType WHERE m_title = title GROUP BY m_title";
		} else if(type.equals("cartoon")){
			query = "SELECT c_title, release_date, network, current_season, current_episode, completed FROM "+
					db+".cartoon, "+ db +".mediaType WHERE c_title = title GROUP BY c_title";
		} else if(type.equals("game")){
			query = "SELECT v_title, release_date, game_studio, year_founded, completed FROM "+
					db+".videogame, "+ db +".mediaType WHERE v_title = title GROUP BY v_title";
		} else {
			query = "SELECT a_title, release_date, network, current_season, current_episode, completed FROM "+
					db+".anime, "+ db +".mediaType "+ db + ".cartoon " + "WHERE a_title = title AND a_title = c.title "
							+ "GROUP BY m_title";			
		}
		ResultSet rs = statement.executeQuery(query);
		statement.close();
	}
	
	public static void addEntry(Connection c, String db) throws SQLException{
		Statement statement = null;
		String table_name = EditEnter.getMediaType();
		String query0 = "INSERT INTO "+ db + ".mediaType VALUES (" + EditEnter.insertIntoMediaType() + ");";
		String query1 = "INSERT INTO "+ db + "." + table_name + " VALUES " + "(" + EditEnter.entries() + ");";
		String query2 = "INSERT INTO " + db;
		String query3 = "";
		int i = 0;
						
		statement = c.createStatement();
		if(table_name.equals("anime") || table_name.equals("manga") || table_name.equals("videogame")){
			query2 += EditEnter.otherQueries();
			System.out.println(query2);
			int rs2 = statement.executeUpdate(query2);
		} //executes minor updates to creators.
		System.out.println(query0);
		int rs0 = statement.executeUpdate(query0); //executes mediatype
		int rs1 = statement.executeUpdate(query1); // executes the individual media
		

		
		while(i!=EditEnter.getGenres().size()){
			query3 = "INSERT INTO "+ db + ".genre VALUES ("+EditEnter.getGenres().get(i)+");";
			System.out.println(query3);
			int rs3 = statement.executeUpdate(query3);
			i++;
		}
		
		statement.close();
		JOptionPane.showMessageDialog(null, "Item successfully added!");
	}
	
	
	public static void deleteEntry(Connection c, String db) throws SQLException{
		Statement statement = null;
		String table_name = "";
		String title = "";
		String query = "DROP FROM " + table_name + " WHERE " + db + "title == " + title;
		
		statement = c.createStatement();
		int rs = statement.executeUpdate(query);
		JOptionPane.showMessageDialog(null, table_name + " deleted.");
		statement.close();
	}
	
	public static void searchEntry(Connection c, String db, String searchBy) throws SQLException{
		Statement statement = null;
		String query = "SELECT * FROM animuDatabase.mediaType, animuDatabase.anime, animuDatabase.cartoon, animuDatabase.manga, animuDatabase.videogame " + "WHERE " +
		;
		ResultSet rs = statement.executeQuery(query);
		
		statement.close();
	}
	
	public static void editEntry(Connection c, String db) throws SQLException{
		Statement statement = null;
		String table_name = EditEnter.getMediaType(); 
		String queryMedia = "UPDATE " + db + ".mediaType SET ";
		String querySpecific = "UPDATE "+ db + "." + table_name + " SET ";
		if(table_name.equals("anime")){
			querySpecific += "a.title = " + EditEnter.returnField(0) + ", releaseDate = " + EditEnter.returnField(3) + ", adaptationOf = " + EditEnter.returnField(6) 
							+ " WHERE ";
		} else if(table_name.equals("manga")){
			
		} else if(table_name.equals("videogame")){
			
		} else if(table_name.equals("cartoon")){
			
		}
		int rs = statement.executeUpdate(queryMedia);
		int rs1 = statement.executeUpdate(querySpecific);
		statement.close();
	}

	public static void main(String[] args) throws ClassNotFoundException,InstantiationException,
	IllegalAccessException, SQLException {

		new GUIDatabase();
		Object instance; //create new instance
		instance = Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/animudatabase", username, password);
		PreparedStatement update;
		Statement queryStatement = connection.createStatement();
		update = null;
				try {
					window = new GUIDatabase();
					window.frmDatabase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				EditEnter.addButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							addEntry(connection,datab);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "An error occurred.");
							e.printStackTrace();
						}
					}					
				});
				String querys="select title, release_date, game_studio, summary, completed from animuDatabase.mediaType, animuDatabase.videoGame WHERE title = \"TES: Skyrim\" AND v_title = \"TES: Skyrim\";";
				ResultSet results = queryStatement.executeQuery(querys);
				
				while(results.next()){
					window.titleOfMediaLabel.setText(results.getString("title"));
					window.releaseLabel.setText(results.getString("release_date"));
					window.authorLabel.setText(results.getString("game_studio"));
					window.chckbxNewCheckBox.setSelected(results.getBoolean("completed"));
					window.setSummary(results.getString("summary"));
				}
				results.close();
				update = connection.prepareStatement(querys);


		// TODO Auto-generated method stub

	}

}
