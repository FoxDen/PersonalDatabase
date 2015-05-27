package personal_database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class DatabaseBackend {
	//IMPORTANT MYSQL userName and Password
	static final String username = "root";
	static final String password = "10732351";
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
	
	}
	
	public static void deleteEntry(Connection c, String db) throws SQLException{
	}
	
	public static void searchEntry(Connection c, String db) throws SQLException{
	}
	
	public static void editEntry(Connection c, String db) throws SQLException{
	}
	
	public static void seeLastEntry(Connection c, String db) throws SQLException{	
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
				
				
				
				String genreQuerys = "SELECT genre from animuDatabase.genre WHERE genre_title = \"TES: Skyrim\";";
				ResultSet res =  queryStatement.executeQuery(genreQuerys);
				
				int r=0;
				while(res.next()){		
					//window.genreLabels[r].setText(res.getString("genre"));
					//r++;
					System.out.print(res.getString("genre"));
				}
				update = connection.prepareStatement(genreQuerys);
			

		// TODO Auto-generated method stub

	}

}
