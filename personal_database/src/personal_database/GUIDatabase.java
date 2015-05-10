package personal_database;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.Box;

import java.awt.GridLayout;

import javax.swing.SpringLayout;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.Font;

public class GUIDatabase {

	private JFrame frmDatabase;
	private JTable table;
	private JPanel descriptionPanel,searchBarPanel, outerPanel; //outermost panels.
	private JPanel searchPanel, viewMediaPanel, addNewPanel, recentlyViewed, tableDisplay, mediaInfo; //innermost panels
	private JPanel searchMedia = new JPanel();
	private JPanel addMedia = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIDatabase window = new GUIDatabase();
					window.frmDatabase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIDatabase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatabase = new JFrame();
		frmDatabase.getContentPane().setBackground(new Color(250, 128, 114));
		frmDatabase.setForeground(new Color(153, 51, 0));
		frmDatabase.setTitle("Database for Anime, Cartoons, Manga and Vidya");
		frmDatabase.setBounds(100, 100, 725, 450);
		frmDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDatabase.setBackground(new Color(204, 51, 0));
		
		descriptionPanel = new JPanel();
		descriptionPanel.setBackground(Color.pink);
		descriptionPanel.setLayout(new BorderLayout(0, 0));


		searchBarPanel = new JPanel();
			searchBarPanel.setBackground(Color.pink);
			searchBarPanel.setBorder(new LineBorder(new Color(205, 92, 92)));
			searchBarPanel.setLayout(new BoxLayout(searchBarPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		searchBarPanel.add(verticalStrut_2);
		
		searchPanel = new JPanel();
			searchPanel.setBackground(Color.pink);
			searchBarPanel.add(searchPanel);
			searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton fullSearch = new JButton("Search");
		fullSearch.setBackground(new Color(255, 245, 238));
		fullSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediaInfo.setVisible(false);
				searchMedia.setVisible(true);
			}
		});
		fullSearch.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
		});
		searchPanel.add(fullSearch);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		searchBarPanel.add(verticalStrut_1);
		
		addNewPanel = new JPanel();
		addNewPanel.setBorder(null);
			addNewPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			addNewPanel.setBackground(Color.PINK);
		searchBarPanel.add(addNewPanel);
		
		
		JButton addNew = new JButton("Add New Media");
		addNew.setBackground(new Color(255, 245, 238));
		addNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediaInfo.setVisible(false);
				addMedia.setVisible(true);
			}
		});
		addNew.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
			}
		});
		addNewPanel.add(addNew);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBackground(new Color(255, 153, 0));
		searchBarPanel.add(verticalStrut);
		
		viewMediaPanel = new JPanel();
		searchBarPanel.add(viewMediaPanel);
			viewMediaPanel.setLayout(new GridLayout(4, 1, 0, 0));
			viewMediaPanel.setBackground(Color.pink);
		
		JButton viewManga = new JButton("View All Manga");
		viewManga.setBackground(new Color(255, 245, 238));
		viewManga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		viewMediaPanel.add(viewManga);
		
		JButton viewCartoons = new JButton("View All Cartoons");
		viewCartoons.setBackground(new Color(255, 245, 238));
		viewCartoons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		viewMediaPanel.add(viewCartoons);
		
		JButton viewAnime = new JButton("View All Anime");
		viewAnime.setBackground(new Color(255, 245, 238));
		viewAnime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		viewMediaPanel.add(viewAnime);
		
		JButton viewGames = new JButton("View All Games");
		viewGames.setBackground(new Color(255, 245, 238));
		viewGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		viewMediaPanel.add(viewGames);
		
		outerPanel = new JPanel();
		outerPanel.setBorder(new LineBorder(new Color(205, 92, 92)));
		outerPanel.setBackground(Color.PINK);
		
		GroupLayout groupLayout = new GroupLayout(frmDatabase.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(descriptionPanel, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(searchBarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(outerPanel, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(descriptionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(searchBarPanel, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
						.addComponent(outerPanel, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		recentlyViewed = new JPanel();
		recentlyViewed.setForeground(Color.WHITE);
		recentlyViewed.setBorder(new LineBorder(new Color(205, 92, 92)));
		recentlyViewed.add(searchMedia);
		recentlyViewed.add(addMedia);
		
		searchMedia.setVisible(false);
		addMedia.setVisible(false);
		
		tableDisplay = new JPanel();
		tableDisplay.setBackground(new Color(255, 240, 245));
		tableDisplay.setBorder(new LineBorder(new Color(205, 92, 92)));
		
		JLabel recentlyReadLabel = new JLabel("Recently Viewed");
		
		JLabel IMAGE = new JLabel("IMAGE");
		
		mediaInfo = new JPanel();
		mediaInfo.setBackground(new Color(255, 240, 245));
		mediaInfo.setBorder(null);
		GroupLayout gl_recentlyViewed = new GroupLayout(recentlyViewed);
		gl_recentlyViewed.setHorizontalGroup(
			gl_recentlyViewed.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_recentlyViewed.createSequentialGroup()
					.addGroup(gl_recentlyViewed.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_recentlyViewed.createSequentialGroup()
							.addContainerGap()
							.addComponent(recentlyReadLabel))
						.addGroup(gl_recentlyViewed.createSequentialGroup()
							.addGap(32)
							.addComponent(IMAGE)))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(mediaInfo, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		gl_recentlyViewed.setVerticalGroup(
			gl_recentlyViewed.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_recentlyViewed.createSequentialGroup()
					.addComponent(recentlyReadLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(IMAGE)
					.addContainerGap(89, Short.MAX_VALUE))
				.addComponent(mediaInfo, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
		);
		SpringLayout sl_mediaInfo = new SpringLayout();
		mediaInfo.setLayout(sl_mediaInfo);
		
		JLabel titleOfMediaLabel = new JLabel("Title of Media");
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, titleOfMediaLabel, 0, SpringLayout.NORTH, mediaInfo);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, titleOfMediaLabel, 153, SpringLayout.WEST, mediaInfo);
		mediaInfo.add(titleOfMediaLabel);
		
		JLabel current = new JLabel("Current:");
		current.setFont(new Font("Lekton", Font.PLAIN, 10));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, current, 20, SpringLayout.NORTH, mediaInfo);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, current, 10, SpringLayout.WEST, mediaInfo);
		mediaInfo.add(current);
		
		JLabel releaseDate = new JLabel("Release Date:");
		releaseDate.setFont(new Font("Lekton", Font.PLAIN, 10));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, releaseDate, 6, SpringLayout.SOUTH, current);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, releaseDate, 0, SpringLayout.WEST, current);
		mediaInfo.add(releaseDate);
		
		JLabel authorDev = new JLabel("Author/Developer:");
		authorDev.setFont(new Font("Lekton", Font.PLAIN, 10));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, authorDev, 6, SpringLayout.SOUTH, releaseDate);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, authorDev, 0, SpringLayout.WEST, current);
		mediaInfo.add(authorDev);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Completed?");
		chckbxNewCheckBox.setFont(new Font("Consolas", Font.PLAIN, 10));
		chckbxNewCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox, 6, SpringLayout.SOUTH, authorDev);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, chckbxNewCheckBox, 0, SpringLayout.WEST, mediaInfo);
		mediaInfo.add(chckbxNewCheckBox);
		
		JLabel URL = new JLabel("URL:");
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, URL, 0, SpringLayout.NORTH, current);
		URL.setFont(new Font("Lekton", Font.PLAIN, 10));
		mediaInfo.add(URL);
		
		JLabel genre = new JLabel("Genre:");
		sl_mediaInfo.putConstraint(SpringLayout.WEST, URL, 0, SpringLayout.WEST, genre);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, genre, 208, SpringLayout.WEST, mediaInfo);
		genre.setFont(new Font("Lekton", Font.PLAIN, 10));
		sl_mediaInfo.putConstraint(SpringLayout.SOUTH, genre, 0, SpringLayout.SOUTH, releaseDate);
		mediaInfo.add(genre);
		
		JButton btnViewSummary = new JButton("View Summary");
		btnViewSummary.setBackground(new Color(255, 245, 238));
		sl_mediaInfo.putConstraint(SpringLayout.WEST, btnViewSummary, 47, SpringLayout.EAST, chckbxNewCheckBox);
		sl_mediaInfo.putConstraint(SpringLayout.SOUTH, btnViewSummary, -10, SpringLayout.SOUTH, mediaInfo);
		btnViewSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmDatabase, "This will store the summary", "Summary", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mediaInfo.add(btnViewSummary);
		
		JLabel genreLabel1 = new JLabel("New label");
		sl_mediaInfo.putConstraint(SpringLayout.WEST, genreLabel1, 244, SpringLayout.WEST, mediaInfo);
		genreLabel1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel1, 0, SpringLayout.NORTH, releaseDate);
		mediaInfo.add(genreLabel1);
		
		JLabel genreLabel2 = new JLabel("New label");
		genreLabel2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel2, 0, SpringLayout.NORTH, authorDev);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, genreLabel2, 0, SpringLayout.WEST, genreLabel1);
		mediaInfo.add(genreLabel2);
		
		JLabel genreLabel3 = new JLabel("New label");
		genreLabel3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel3, 0, SpringLayout.NORTH, chckbxNewCheckBox);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, genreLabel3, 0, SpringLayout.WEST, genreLabel1);
		mediaInfo.add(genreLabel3);
		
		JLabel genreLabel4 = new JLabel("New label");
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel4, -1, SpringLayout.NORTH, releaseDate);
		genreLabel4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		mediaInfo.add(genreLabel4);
		
		JLabel genreLabel5 = new JLabel("New label");
		sl_mediaInfo.putConstraint(SpringLayout.WEST, genreLabel5, 26, SpringLayout.EAST, genreLabel2);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, genreLabel4, 0, SpringLayout.WEST, genreLabel5);
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel5, -1, SpringLayout.NORTH, authorDev);
		genreLabel5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		mediaInfo.add(genreLabel5);
		
		JLabel genreLabel6 = new JLabel("New label");
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel6, 0, SpringLayout.NORTH, chckbxNewCheckBox);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, genreLabel6, 26, SpringLayout.EAST, genreLabel3);
		genreLabel6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		mediaInfo.add(genreLabel6);
		
		JLabel urlLabel = new JLabel("New label");
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, urlLabel, -1, SpringLayout.NORTH, current);
		sl_mediaInfo.putConstraint(SpringLayout.EAST, urlLabel, 0, SpringLayout.EAST, genreLabel1);
		urlLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		mediaInfo.add(urlLabel);
		
		JLabel currentStatusLabel = new JLabel("New label");
		currentStatusLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, currentStatusLabel, 0, SpringLayout.NORTH, current);
		mediaInfo.add(currentStatusLabel);
		
		JLabel releaseLabel = new JLabel("New label");
		releaseLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.EAST, currentStatusLabel, 0, SpringLayout.EAST, releaseLabel);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, releaseLabel, 25, SpringLayout.EAST, releaseDate);
		sl_mediaInfo.putConstraint(SpringLayout.SOUTH, releaseLabel, 0, SpringLayout.SOUTH, releaseDate);
		mediaInfo.add(releaseLabel);
		
		JLabel authorLabel = new JLabel("New label");
		authorLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, authorLabel, 0, SpringLayout.NORTH, authorDev);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, authorLabel, 0, SpringLayout.WEST, releaseLabel);
		mediaInfo.add(authorLabel);
		recentlyViewed.setLayout(gl_recentlyViewed);
		
		JLabel[] storageArray = {genreLabel1, genreLabel2, genreLabel3, genreLabel4, genreLabel5, genreLabel6};
		
		table = new JTable();
		tableDisplay.add(table);
		SpringLayout sl_outerPanel = new SpringLayout();
		sl_outerPanel.putConstraint(SpringLayout.EAST, recentlyViewed, 523, SpringLayout.WEST, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.WEST, tableDisplay, 11, SpringLayout.WEST, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.EAST, tableDisplay, -11, SpringLayout.EAST, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.NORTH, recentlyViewed, 12, SpringLayout.NORTH, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.WEST, recentlyViewed, 11, SpringLayout.WEST, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.SOUTH, recentlyViewed, 137, SpringLayout.NORTH, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.NORTH, tableDisplay, 143, SpringLayout.NORTH, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.SOUTH, tableDisplay, 363, SpringLayout.NORTH, outerPanel);
		
		outerPanel.setLayout(sl_outerPanel);
		outerPanel.add(tableDisplay);
		outerPanel.add(recentlyViewed);
		frmDatabase.getContentPane().setLayout(groupLayout);
	

	}
}
