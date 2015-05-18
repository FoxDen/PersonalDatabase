package personal_database;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;

import java.awt.Color;

import javax.swing.JScrollPane;

import java.awt.List;

import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SearchThing extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField titleField;
	private JTextField creatorField;
	private JTextField releaseField;
	private JComboBox<String> typeBox;
	
	private JLabel primaryKeySearchLabel;
	private JLabel titleLabel;
	private JLabel releaseLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchThing dialog = new SearchThing();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	public SearchThing() {
		setTitle("Search");
		setBounds(100, 100, 450, 295);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 204, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		
		JScrollPane scrollPaneOfGenres = new JScrollPane();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, scrollPaneOfGenres, 0, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, scrollPaneOfGenres, 315, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, scrollPaneOfGenres, 0, SpringLayout.EAST, contentPanel);
		scrollPaneOfGenres.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneOfGenres.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPanel.add(scrollPaneOfGenres);
		
		JList listOfGenres = new JList();
		listOfGenres.setBackground(new Color(255, 250, 240));
		listOfGenres.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
			}
		});
		scrollPaneOfGenres.setViewportView(listOfGenres);
		listOfGenres.setModel(new AbstractListModel() {
			String[] values = new String[] {"Horror", "Action", "Shojo", "Shonen", "Seinen", "Tragedy", "Angst", "Yaoi", "Yuri", "Genderbending", "Ecchi", "Psychological", 
					"Sci Fi", "Harem", "Smut", "Supernatural", "Romance", "Comedy","Shooter", "RPG", "Simulation", "Strategy", "Sports", "Casual", "Puzzle"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		titleLabel = new JLabel("Title");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, titleLabel, 0, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, titleLabel, 0, SpringLayout.WEST, contentPanel);
		contentPanel.add(titleLabel);
		
		titleField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, titleField, 6, SpringLayout.SOUTH, titleLabel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, titleField, 0, SpringLayout.WEST, titleLabel);
		titleField.setBackground(new Color(255, 250, 240));
		contentPanel.add(titleField);
		titleField.setColumns(10);
		
		primaryKeySearchLabel = new JLabel("Developer/Mangaka");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, primaryKeySearchLabel, 48, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, primaryKeySearchLabel, 0, SpringLayout.WEST, titleLabel);
		contentPanel.add(primaryKeySearchLabel);
		
		creatorField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, creatorField, 6, SpringLayout.SOUTH, primaryKeySearchLabel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, creatorField, 0, SpringLayout.WEST, titleLabel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, creatorField, 0, SpringLayout.EAST, titleField);
		creatorField.setBackground(new Color(255, 250, 240));
		contentPanel.add(creatorField);
		creatorField.setColumns(10);
		
		releaseLabel = new JLabel("Release");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, releaseLabel, 0, SpringLayout.NORTH, primaryKeySearchLabel);
		contentPanel.add(releaseLabel);
		
		releaseField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.WEST, releaseField, 6, SpringLayout.EAST, creatorField);
		sl_contentPanel.putConstraint(SpringLayout.EAST, releaseField, -56, SpringLayout.WEST, scrollPaneOfGenres);
		sl_contentPanel.putConstraint(SpringLayout.WEST, releaseLabel, 0, SpringLayout.WEST, releaseField);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, releaseField, 0, SpringLayout.NORTH, creatorField);
		releaseField.setBackground(new Color(255, 250, 240));
		contentPanel.add(releaseField);
		releaseField.setColumns(10);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 204, 204));
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JLabel genresLabel = new JLabel("Genres                   ");
				panel.add(genresLabel, BorderLayout.EAST);
			}
			
			JLabel descriptionLabel = new JLabel("CTRL-Click will select multiple individual genres.");
			descriptionLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
			panel.add(descriptionLabel, BorderLayout.WEST);
			
			JButton searchTitleButton = new JButton("Search by Title");
			searchTitleButton.setBackground(new Color(255, 245, 238));
			searchTitleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			contentPanel.add(searchTitleButton);
			
			JButton searchReleaseDateButton = new JButton("Search by Creator");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, searchTitleButton, 0, SpringLayout.NORTH, searchReleaseDateButton);
			sl_contentPanel.putConstraint(SpringLayout.WEST, searchTitleButton, 6, SpringLayout.EAST, searchReleaseDateButton);
			sl_contentPanel.putConstraint(SpringLayout.WEST, searchReleaseDateButton, 0, SpringLayout.WEST, titleLabel);
			searchReleaseDateButton.setBackground(new Color(255, 245, 238));
			searchReleaseDateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//store sql code here
				}
			});
			contentPanel.add(searchReleaseDateButton);
			
			JButton searchGenresButton = new JButton("Search by Genres");
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, scrollPaneOfGenres, 0, SpringLayout.SOUTH, searchGenresButton);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, searchReleaseDateButton, -6, SpringLayout.NORTH, searchGenresButton);
			searchGenresButton.setBackground(new Color(255, 245, 238));
			searchGenresButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//store sql code here
				}
			});
			sl_contentPanel.putConstraint(SpringLayout.WEST, searchGenresButton, 0, SpringLayout.WEST, titleLabel);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, searchGenresButton, -10, SpringLayout.SOUTH, contentPanel);
			contentPanel.add(searchGenresButton);
			
			JButton searchAllButton = new JButton("Search All");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, searchAllButton, 0, SpringLayout.NORTH, searchGenresButton);
			sl_contentPanel.putConstraint(SpringLayout.WEST, searchAllButton, 10, SpringLayout.EAST, searchGenresButton);
			searchAllButton.setBackground(new Color(255, 245, 238));
			searchAllButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//store sql code here.
				}
			});
			contentPanel.add(searchAllButton);
			
			JButton releaseDateButton = new JButton("Search by Release Date");
			sl_contentPanel.putConstraint(SpringLayout.WEST, releaseDateButton, 0, SpringLayout.WEST, titleLabel);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, releaseDateButton, -6, SpringLayout.NORTH, searchTitleButton);
			releaseDateButton.setBackground(new Color(255, 250, 240));
			contentPanel.add(releaseDateButton);
			
			typeBox = new JComboBox();
			sl_contentPanel.putConstraint(SpringLayout.NORTH, typeBox, 18, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, typeBox, 188, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, typeBox, -11, SpringLayout.WEST, scrollPaneOfGenres);
			sl_contentPanel.putConstraint(SpringLayout.EAST, titleField, -6, SpringLayout.WEST, typeBox);
			typeBox.setBackground(new Color(255, 250, 240));
			typeBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String type = (String)typeBox.getSelectedItem();
					if(type.equals("Manga")){
						primaryKeySearchLabel.setText("Mangaka");
					} else if(type.equals("Anime") || type.equals("Cartoon")){
						primaryKeySearchLabel.setText("Network");
					} else if(type.equals("Video Game")){
						primaryKeySearchLabel.setText("Developer");
					} else
						primaryKeySearchLabel.setText("Developer/Mangaka");
				}
			});
			typeBox.setModel(new DefaultComboBoxModel(new String[] {"Unknown", "Manga", "Anime", "Video Game", "Cartoon"}));
			contentPanel.add(typeBox);
			{

			}
		}
	}
}
