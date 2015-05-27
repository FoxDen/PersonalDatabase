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
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class GUIDatabase {

	JFrame frmDatabase;
	private JPanel descriptionPanel,searchBarPanel, outerPanel; //outermost panels.
	private JPanel searchPanel, viewMediaPanel, addNewPanel, recentlyViewed, tableDisplay, mediaInfo; //innermost panels
	private EditEnter addEditWindow = new EditEnter();
	private SearchThing searchWindow = new SearchThing();
	private JButton btnDeleteEntry, btnViewSummary, addNew, fullSearch;
	private JTable table;
	private String summaryString = "";
	public JLabel titleOfMediaLabel, genreLabel1, genreLabel2, genreLabel3, genreLabel4, genreLabel5, genreLabel6;
	public JLabel urlLabel, currentStatusLabel, releaseLabel, authorLabel;
	
	public JLabel[] genreLabels = {genreLabel1, genreLabel2, genreLabel3, genreLabel4, genreLabel5, genreLabel6};
	public JCheckBox chckbxNewCheckBox;
	//public Object titleOfMediaLabel1;
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
	
	public void setSummary(String s){
		summaryString = s;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatabase = new JFrame();
		frmDatabase.getContentPane().setBackground(new Color(250, 128, 114));
		frmDatabase.setForeground(new Color(153, 51, 0));
		frmDatabase.setTitle("Database for Anime, Cartoons, Manga and Vidya");
		frmDatabase.setBounds(100, 100, 725, 439);
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
		
		fullSearch = new JButton("Search");
		fullSearch.setBackground(new Color(255, 245, 238));
		fullSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchWindow.setVisible(true);
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
		
		
		addNew = new JButton("Add/Edit New Media");
		addNew.setBackground(new Color(255, 245, 238));
		addNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediaInfo.setVisible(true);
				addEditWindow.setVisible(true);
			}
		});
		addNew.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
			}
		});
		addNewPanel.add(addNew);
		
		JPanel deletePanel = new JPanel();
		deletePanel.setBackground(Color.PINK);
		searchBarPanel.add(deletePanel);
		
		btnDeleteEntry = new JButton("Delete Current Entry");
		btnDeleteEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediaInfo.setVisible(true);
			}
		});
		btnDeleteEntry.setBackground(new Color(255, 245, 238));
		deletePanel.add(btnDeleteEntry);
		
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
		recentlyViewed.setBackground(new Color(255, 250, 240));
		recentlyViewed.setForeground(Color.WHITE);
		recentlyViewed.setBorder(new LineBorder(new Color(205, 92, 92)));
		
		tableDisplay = new JPanel();
		tableDisplay.setBackground(new Color(255, 240, 245));
		tableDisplay.setBorder(new LineBorder(new Color(205, 92, 92)));
		
		JLabel IMAGE = new JLabel("IMAGE");
		
		mediaInfo = new JPanel();
		mediaInfo.setBackground(new Color(255, 240, 245));
		mediaInfo.setBorder(null);
		GroupLayout gl_recentlyViewed = new GroupLayout(recentlyViewed);
		gl_recentlyViewed.setHorizontalGroup(
			gl_recentlyViewed.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_recentlyViewed.createSequentialGroup()
					.addGap(32)
					.addComponent(IMAGE)
					.addPreferredGap(ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
					.addComponent(mediaInfo, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);
		gl_recentlyViewed.setVerticalGroup(
			gl_recentlyViewed.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_recentlyViewed.createSequentialGroup()
					.addGap(20)
					.addComponent(IMAGE)
					.addContainerGap(89, Short.MAX_VALUE))
				.addComponent(mediaInfo, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
		);
		SpringLayout sl_mediaInfo = new SpringLayout();
		mediaInfo.setLayout(sl_mediaInfo);
		
		titleOfMediaLabel = new JLabel("Title of Media");
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
		
		chckbxNewCheckBox = new JCheckBox("Completed?");
		chckbxNewCheckBox.setBackground(new Color(255, 240, 245));
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
		
		btnViewSummary = new JButton("View Summary");
		btnViewSummary.setBackground(new Color(255, 245, 238));
		sl_mediaInfo.putConstraint(SpringLayout.WEST, btnViewSummary, 47, SpringLayout.EAST, chckbxNewCheckBox);
		sl_mediaInfo.putConstraint(SpringLayout.SOUTH, btnViewSummary, -10, SpringLayout.SOUTH, mediaInfo);
		btnViewSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmDatabase, summaryString, "Summary", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mediaInfo.add(btnViewSummary);
		
		genreLabel1 = new JLabel("New label");
		sl_mediaInfo.putConstraint(SpringLayout.WEST, genreLabel1, 244, SpringLayout.WEST, mediaInfo);
		genreLabel1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel1, 0, SpringLayout.NORTH, releaseDate);
		mediaInfo.add(genreLabel1);
		
		genreLabel2 = new JLabel("New label");
		genreLabel2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel2, 0, SpringLayout.NORTH, authorDev);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, genreLabel2, 0, SpringLayout.WEST, genreLabel1);
		mediaInfo.add(genreLabel2);
		
		genreLabel3 = new JLabel("New label");
		genreLabel3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel3, 0, SpringLayout.NORTH, chckbxNewCheckBox);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, genreLabel3, 0, SpringLayout.WEST, genreLabel1);
		mediaInfo.add(genreLabel3);
		
		genreLabel4 = new JLabel("New label");
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel4, -1, SpringLayout.NORTH, releaseDate);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, genreLabel4, 13, SpringLayout.EAST, genreLabel1);
		genreLabel4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		mediaInfo.add(genreLabel4);
		
		genreLabel5 = new JLabel("New label");
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel5, -1, SpringLayout.NORTH, authorDev);
		sl_mediaInfo.putConstraint(SpringLayout.EAST, genreLabel5, 0, SpringLayout.EAST, genreLabel4);
		genreLabel5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		mediaInfo.add(genreLabel5);
		
		genreLabel6 = new JLabel("New label");
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, genreLabel6, 0, SpringLayout.NORTH, chckbxNewCheckBox);
		sl_mediaInfo.putConstraint(SpringLayout.EAST, genreLabel6, 0, SpringLayout.EAST, genreLabel4);
		genreLabel6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		mediaInfo.add(genreLabel6);
		
		urlLabel = new JLabel("New label");
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, urlLabel, -1, SpringLayout.NORTH, current);
		sl_mediaInfo.putConstraint(SpringLayout.EAST, urlLabel, 0, SpringLayout.EAST, genreLabel1);
		urlLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		mediaInfo.add(urlLabel);
		
		currentStatusLabel = new JLabel("New label");
		currentStatusLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, currentStatusLabel, 0, SpringLayout.NORTH, current);
		mediaInfo.add(currentStatusLabel);
		
		releaseLabel = new JLabel("New label");
		releaseLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.EAST, currentStatusLabel, 0, SpringLayout.EAST, releaseLabel);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, releaseLabel, 25, SpringLayout.EAST, releaseDate);
		sl_mediaInfo.putConstraint(SpringLayout.SOUTH, releaseLabel, 0, SpringLayout.SOUTH, releaseDate);
		mediaInfo.add(releaseLabel);
		
		authorLabel = new JLabel("New label");
		authorLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_mediaInfo.putConstraint(SpringLayout.NORTH, authorLabel, 0, SpringLayout.NORTH, authorDev);
		sl_mediaInfo.putConstraint(SpringLayout.WEST, authorLabel, 0, SpringLayout.WEST, releaseLabel);
		mediaInfo.add(authorLabel);
		recentlyViewed.setLayout(gl_recentlyViewed);
		SpringLayout sl_outerPanel = new SpringLayout();
		sl_outerPanel.putConstraint(SpringLayout.NORTH, recentlyViewed, 12, SpringLayout.NORTH, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.WEST, recentlyViewed, 11, SpringLayout.WEST, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.SOUTH, recentlyViewed, -6, SpringLayout.NORTH, tableDisplay);
		sl_outerPanel.putConstraint(SpringLayout.EAST, recentlyViewed, 0, SpringLayout.EAST, tableDisplay);
		sl_outerPanel.putConstraint(SpringLayout.WEST, tableDisplay, 11, SpringLayout.WEST, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.EAST, tableDisplay, -11, SpringLayout.EAST, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.NORTH, tableDisplay, 143, SpringLayout.NORTH, outerPanel);
		sl_outerPanel.putConstraint(SpringLayout.SOUTH, tableDisplay, 363, SpringLayout.NORTH, outerPanel);
		
		outerPanel.setLayout(sl_outerPanel);
		outerPanel.add(tableDisplay);
		tableDisplay.setLayout(new BorderLayout(0, 0));
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Title", "Released", "Creator"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBackground(new Color(255, 250, 240));
		JScrollPane scrollPane = new JScrollPane(table);
		tableDisplay.add(scrollPane, BorderLayout.CENTER);
		
		
		//tableDisplay.add(table, BorderLayout.NORTH);
		outerPanel.add(recentlyViewed);
		frmDatabase.getContentPane().setLayout(groupLayout);
	

	}
}
