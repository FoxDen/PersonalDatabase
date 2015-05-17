package personal_database;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.io.IOException;

public class SearchEditEnter extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> mediaTypeBox;
	private JTextField titleField;
	private JTextField authorField;
	private JTextField artworkField;
	private JTextField releaseField;
	private String[] mediaTypes = {"Select Media","Cartoon", "Anime", "Game", "Manga"};
	private JComboBox addedGenreBox;
	private ArrayList<String> addedGenres = new ArrayList<String>();
	private String[] genreTypes = {"Horror", "Action", "Shojo", "Shonen", "Seinen", "Tragedy", "Angst", "Yaoi", "Yuri", "Genderbending", "Ecchi", "Psychological", 
									"Sci Fi", "Harem", "Smut", "Supernatural", "Romance", "Comedy"};
	private String[] gameGenreTypes = {"Shooter", "RPG", "Simulation", "Strategy", "Sports", "Casual", "Puzzle"};
	private JTextField textField_4;
	private JTextField textField_5;
	JLabel currentChapter;
	JLabel totalChapters;
	private JTextField textField_6;
	private JLabel authorLabel;
	JTextArea textArea;
	private JLabel urlLabel;
	
	public void setVisibility(JLabel a, JTextField b, boolean c){
		a.setVisible(c);
		b.setVisible(c);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchEditEnter dialog = new SearchEditEnter();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchEditEnter() {
		setTitle("Add or Edit Entries");
		getContentPane().setBackground(new Color(205, 92, 92));
		setBounds(100, 100, 379, 464);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel SearchEdit = new JPanel();
		SearchEdit.setBackground(new Color(205, 92, 92));
		getContentPane().add(SearchEdit, BorderLayout.SOUTH);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int textLen = textArea.getText().length()-500;
				if(textLen>0){
					JOptionPane.showMessageDialog(contentPanel, "This summary is too long by " + textLen + " characters. Please trim this down.");
				
				} else if(titleField.getText().equals("") || authorField.getText().equals("")|| 
						(urlLabel.getText().equals("Adaptation Of:") && textField_6.getText().equals(""))){
					JOptionPane.showMessageDialog(contentPanel, "An important field was missed. Please try again.");

				} else if(mediaTypeBox.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(contentPanel,"The type of media was not selected.");
					
				} else
					JOptionPane.showMessageDialog(contentPanel, "Item Successfully Added!");

			}
		});
		addButton.setBackground(new Color(255, 245, 238));
		SearchEdit.add(addButton);
		
		JButton EditButton = new JButton("Edit");
		EditButton.setBackground(new Color(255, 245, 238));
		SearchEdit.add(EditButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBackground(new Color(255, 245, 238));
		SearchEdit.add(deleteButton);
		contentPanel.setBackground(new Color(205, 92, 92));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			mediaTypeBox = new JComboBox(mediaTypes);
			mediaTypeBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisibility(currentChapter, textField_4, false);
					setVisibility(totalChapters, textField_5, false);
					setVisibility(urlLabel, textField_6,false);
					
					 String cb = (String)mediaTypeBox.getSelectedItem();
					 if(cb.equals("Cartoon")){
						 currentChapter.setText("Current Ep:");
						 totalChapters.setText("Current Season:");
						 authorLabel.setText("Network");
						setVisibility(currentChapter, textField_4, true);
						setVisibility(totalChapters, textField_5, true);
						
					 } else if(cb.equals("Anime")){
						 urlLabel.setText("Adaptation Of:");
							textField_6.setColumns(10);

						setVisibility(urlLabel, textField_6, true);		
						
					 } else if(cb.equals("Manga")){
						currentChapter.setText("Current Chapter");
						totalChapters.setText("Total Chapters");
						authorLabel.setText("Mangaka");
						urlLabel.setText("URL:");

						setVisibility(currentChapter, textField_4, true);
						setVisibility(totalChapters, textField_5, true);
						setVisibility(urlLabel, textField_6,true);						
						
					 } else if(cb.equals("Game")){
						 authorLabel.setText("Game Developer");	 
					 }
				}
			});
			mediaTypeBox.setForeground(new Color(105, 105, 105));
			mediaTypeBox.setBackground(new Color(204, 153, 153));
		}
		
		//comboBox.add(st);
		
		JLabel titleLabel = new JLabel("Title");
		
		titleField = new JTextField();
		titleField.setBackground(new Color(255, 255, 240));
		titleField.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		
		addedGenreBox = new JComboBox();
		addedGenreBox.setBackground(new Color(255, 255, 240));
		
		JButton addGenreButton = new JButton("Add");
		addGenreButton.setBackground(new Color(255, 245, 238));
		addGenreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mediaTypeBox.getSelectedIndex()==3){
					String genre = (String) JOptionPane.showInputDialog(contentPanel, "Genre to be Added:","Added!",JOptionPane.QUESTION_MESSAGE, null, gameGenreTypes, gameGenreTypes[0]);
					addedGenres.add(genre);
					addedGenreBox.addItem(genre);
				} else{
					String genre = (String) JOptionPane.showInputDialog(contentPanel, "Genre to be Added:","Added!",JOptionPane.QUESTION_MESSAGE, null, genreTypes, genreTypes[0]);
					addedGenres.add(genre);
					addedGenreBox.addItem(genre);
				}
			}
		});
		
		JButton removeGenreButton = new JButton("Remove");
		removeGenreButton.setBackground(new Color(255, 245, 238));
		removeGenreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Object item = addedGenreBox.getSelectedItem();
				addedGenreBox.removeItem(item);
				addedGenres.remove(item.toString());
				}
				catch(NullPointerException p){
					JOptionPane.showMessageDialog(contentPanel, "There are no genres to be removed.");
				}
			}
		});
		
		authorLabel = new JLabel("Author");
		
		authorField = new JTextField();
		authorField.setBackground(new Color(255, 255, 240));
		authorField.setColumns(10);
		
		artworkField = new JTextField();
		artworkField.setBackground(new Color(255, 255, 240));
		artworkField.setColumns(10);
		
		JLabel artworkLabel = new JLabel("Artwork Link");
		
		JLabel releaseLabel = new JLabel("Released");
		
		releaseField = new JTextField();
		releaseField.setBackground(new Color(255, 255, 240));
		releaseField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Summary");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Complete?");
		chckbxNewCheckBox.setForeground(Color.DARK_GRAY);
		chckbxNewCheckBox.setBackground(new Color(205, 92, 92));
		
		currentChapter = new JLabel("Init");
		urlLabel = new JLabel("Init");
		totalChapters = new JLabel("Init");
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 255, 240));
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);		
		
		setVisibility(currentChapter, textField_4, false);
		setVisibility(totalChapters, textField_5, false);
		setVisibility(urlLabel, textField_6, false);
		
		textArea = new JTextArea();
		textArea.setSize(new Dimension(20, 6));
		textArea.setLineWrap(true);
		textArea.setDragEnabled(true);
	



		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(77)
							.addComponent(mediaTypeBox, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(10)
									.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(titleLabel, Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
													.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(addedGenreBox, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblGenre, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(addGenreButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPanel.createSequentialGroup()
															.addComponent(removeGenreButton)
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(chckbxNewCheckBox)))
													.addGap(131))
												.addComponent(releaseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(releaseLabel)
												.addGroup(gl_contentPanel.createSequentialGroup()
													.addComponent(urlLabel)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPanel.createSequentialGroup()
													.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(titleField)
														.addGroup(gl_contentPanel.createSequentialGroup()
															.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(authorLabel)
																.addComponent(authorField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
															.addPreferredGap(ComponentPlacement.RELATED)
															.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(artworkLabel)
																.addComponent(artworkField, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
																.addGroup(gl_contentPanel.createSequentialGroup()
																	.addGap(10)
																	.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																		.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
																		.addComponent(currentChapter))
																	.addPreferredGap(ComponentPlacement.UNRELATED)
																	.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																		.addComponent(totalChapters)
																		.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))))
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
											.addGap(284)))
									.addGap(241)))))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(mediaTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(titleLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(titleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(addGenreButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(addedGenreBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(removeGenreButton)
						.addComponent(chckbxNewCheckBox))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(authorLabel)
						.addComponent(artworkLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(authorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(artworkField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(releaseLabel)
						.addComponent(currentChapter)
						.addComponent(totalChapters, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(releaseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(urlLabel))
					.addGap(5)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		
	}
}
