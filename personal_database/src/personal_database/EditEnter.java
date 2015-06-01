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

import javax.swing.UIManager;

public class EditEnter extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4003433170350177974L;
	private final JPanel contentPanel = new JPanel();

	private static JTextField titleField, authorField, artworkField, releaseField, currentField, totalField, textField_6;
	private static JComboBox<String> mediaTypeBox;
	@SuppressWarnings("rawtypes")
	private JComboBox addedGenreBox;
	private String[] mediaTypes = {"Select Media","Cartoon", "Anime", "Game", "Manga"};
	private static ArrayList<String> addedGenres = new ArrayList<String>();
	private String[] genreTypes = {"Horror", "Action", "Shojo", "Shonen", "Seinen", "Tragedy", "Angst", "Yaoi", "Yuri", "Genderbending", "Ecchi", "Psychological", 
									"Sci Fi", "Harem", "Smut", "Supernatural", "Mystery", "Romance", "Comedy"};
	private String[] gameGenreTypes = {"Shooter", "RPG", "Simulation", "Strategy", "Sports", "Casual", "Puzzle"};
	JLabel currentChapter;
	JLabel totalChapters;
	JLabel urlLabel;
	JLabel authorLabel;
	
	private static JTextArea summaryArea;
	static JButton addButton;
	static JButton editButton;
	static JCheckBox completedCheckBox;

	public void setVisibility(JLabel a, JTextField b, boolean c){
		a.setVisible(c);
		b.setVisible(c);
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditEnter dialog = new EditEnter();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String getMediaType(){
		String c = mediaTypeBox.getSelectedItem().toString().toLowerCase();
		if(c.equals("game")){
			return "videogame";
		}
		return c;
	}
	
	public static String getColumns(){
		//what i want to do is test out the 
	}
	
	public static String entries(){
		String entry="";
		if(getMediaType().equals("anime") || getMediaType().equals("cartoon")){
			entry = "\"" + titleField.getText() + "\", " + currentField.getText() + ", "+totalField.getText()+", "+"\""+authorField.getText()+"\""; 
			System.out.println(entry);
		} else if(getMediaType().equals("manga")){
			entry = "\"" + titleField.getText() + "\", " + currentField.getText() + ", \""+authorField.getText()+"\", " + totalField.getText() + ", \""+textField_6.getText()+"\"";
		} else if(getMediaType().equals("videogame")){
			entry = "\"" + titleField.getText() + "\", \"" + authorField.getText() + "\", \""+addedGenres.get(0)+"\""; 
		}
		
		return entry;
	}
	
	public static ArrayList<String> getGenres(){
		ArrayList<String> genres = new ArrayList<String>();
		int i = 0;
		while(i<addedGenres.size()){
			genres.add("\""+addedGenres.get(i)+"\", "+"\""+titleField.getText()+"\"");
			i++;
		}
		return genres;
	}
	
	public static String otherQueries(){
		String otherEntry = "";
		if(getMediaType().equals("anime")){
			otherEntry = ".anime VALUES(\""+EditEnter.titleField.getText()+"\" , "+EditEnter.releaseField.getText()+");"; //fix
		} else if(getMediaType().equals("manga")){
			otherEntry = ".mangaka VALUES(\""+EditEnter.authorField.getText() + "\");";
		} else if(getMediaType().equals("")){
			otherEntry = ".gamestudio VALUES(\""+EditEnter.authorField.getText() + "\");";
		}
		return otherEntry;
	}
	
	public static String insertIntoMediaType(){
		String entry = "";
		if(!releaseField.getText().equals("")){
			entry = "\""+titleField.getText() +"\", " + releaseField.getText()+ ", " + Boolean.toString(completedCheckBox.isSelected()) + ", \"" + artworkField.getText()+"\", \""+ summaryArea.getText()+ "\"";
		} else
			entry =  "\""+titleField.getText() +"\", " + "0000" + ", " + Boolean.toString(completedCheckBox.isSelected()) + ", \"" + artworkField.getText()+"\", \""+ summaryArea.getText()+ "\"";
		return entry;
	}
	
	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EditEnter() {
		setTitle("Add or Edit Entries");
		getContentPane().setBackground(new Color(255, 182, 193));
		setBounds(100, 100, 379, 464);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel SearchEdit = new JPanel();
		SearchEdit.setBackground(new Color(255, 153, 153));
		getContentPane().add(SearchEdit, BorderLayout.SOUTH);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int textLen = summaryArea.getText().length()-500;
				if(textLen>0){
					JOptionPane.showMessageDialog(contentPanel, "This summary is too long by " + textLen + " characters. Please trim this down.");
				
				} else if(titleField.getText().equals("") || authorField.getText().equals("")|| 
						(urlLabel.getText().equals("Adaptation Of:") && textField_6.getText().equals(""))){
					JOptionPane.showMessageDialog(contentPanel, "An important field was missed. Please try again.");

				} else if(mediaTypeBox.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(contentPanel,"The type of media was not selected.");
					
				}

			}
		});
		addButton.setBackground(new Color(255, 245, 238));
		SearchEdit.add(addButton);
		
		editButton = new JButton("Edit");
		editButton.setBackground(new Color(255, 245, 238));
		SearchEdit.add(editButton);

		contentPanel.setBackground(new Color(255, 153, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			mediaTypeBox = new JComboBox(mediaTypes);
			mediaTypeBox.setFont(UIManager.getFont("Button.font"));
			mediaTypeBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisibility(currentChapter, currentField, false);
					setVisibility(totalChapters, totalField, false);
					setVisibility(urlLabel, textField_6,false);
					
					 String cb = (String)mediaTypeBox.getSelectedItem();
					 if(cb.equals("Cartoon")){
						 currentChapter.setText("Current Ep");
						 totalChapters.setText("Current Season");
						 authorLabel.setText("Network");
						setVisibility(currentChapter, currentField, true);
						setVisibility(totalChapters, totalField, true);
						
					 } else if(cb.equals("Anime")){
						 urlLabel.setText("Adaptation Of");
						 textField_6.setColumns(10);
						 currentChapter.setText("Current Ep");
						 totalChapters.setText("Current Season");
						 authorLabel.setText("Studio");
						setVisibility(currentChapter, currentField, true);
						setVisibility(totalChapters, totalField, true);
						setVisibility(urlLabel, textField_6, true);		
						
					 } else if(cb.equals("Manga")){
						currentChapter.setText("Current Chapter");
						totalChapters.setText("Total Chapters");
						authorLabel.setText("Mangaka");
						urlLabel.setText("URL");

						setVisibility(currentChapter, currentField, true);
						setVisibility(totalChapters, totalField, true);
						setVisibility(urlLabel, textField_6,true);						
						
					 } else if(cb.equals("Game")){
						 authorLabel.setText("Game Developer");	 
					 }
				}
			});
			mediaTypeBox.setForeground(new Color(105, 105, 105));
			mediaTypeBox.setBackground(new Color(204, 153, 153));
		}
		
		
		JLabel titleLabel = new JLabel("Title");
		
		titleField = new JTextField("");
		titleField.setBackground(new Color(255, 250, 240));
		titleField.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		
		addedGenreBox = new JComboBox();
		addedGenreBox.setBackground(new Color(255, 250, 240));
		
		JButton addGenreButton = new JButton("Add");
		addGenreButton.setBackground(new Color(255, 245, 238));
		addGenreButton.addActionListener(new ActionListener() {
			@SuppressWarnings(value = { })
			public void actionPerformed(ActionEvent arg0) {
				
				if(mediaTypeBox.getSelectedIndex()==3){
					String genre = (String) JOptionPane.showInputDialog(contentPanel, "Genre to be Added:","Add Genre",JOptionPane.QUESTION_MESSAGE, null, gameGenreTypes, gameGenreTypes[0]);
					if(addedGenres.lastIndexOf(genre)!=-1){
						JOptionPane.showMessageDialog(contentPanel,"The genre is already there.");
					}else
						addedGenres.add(genre);
						addedGenreBox.addItem(genre);
				} else{
					String genre = (String) JOptionPane.showInputDialog(contentPanel, "Genre to be Added:","Add Genre",JOptionPane.QUESTION_MESSAGE, null, genreTypes, genreTypes[0]);
					if(addedGenres.lastIndexOf(genre)!=-1){
						JOptionPane.showMessageDialog(contentPanel,"The genre is already there.");
					}else
						addedGenres.add(genre);
						addedGenreBox.addItem(genre);
				} 
			}
		}
		);
		
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
		
		authorField = new JTextField("");
		authorField.setBackground(new Color(255, 250, 240));
		authorField.setColumns(10);
		
		artworkField = new JTextField("");
		artworkField.setBackground(new Color(255, 250, 240));
		artworkField.setColumns(10);
		
		JLabel artworkLabel = new JLabel("Artwork Link");
		
		JLabel releaseLabel = new JLabel("Released");
		
		releaseField = new JTextField("");
		releaseField.setBackground(new Color(255, 250, 240));
		releaseField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Summary");
		
		completedCheckBox = new JCheckBox("Complete?");
		completedCheckBox.setForeground(Color.DARK_GRAY);
		completedCheckBox.setBackground(new Color(255, 153, 153));
		
		currentChapter = new JLabel("Init");
		urlLabel = new JLabel("Init");
		totalChapters = new JLabel("Init");
		
		currentField = new JTextField("");
		currentField.setBackground(new Color(255, 250, 240));
		currentField.setColumns(10);
		
		totalField = new JTextField("");
		totalField.setBackground(new Color(255, 250, 240));
		totalField.setColumns(10);
		
		textField_6 = new JTextField("");
		textField_6.setBackground(new Color(255, 250, 240));
		textField_6.setColumns(10);		
		
		setVisibility(currentChapter, currentField, false);
		setVisibility(totalChapters, totalField, false);
		setVisibility(urlLabel, textField_6, false);
		
		summaryArea = new JTextArea();
		summaryArea.setBackground(new Color(255, 250, 240));
		summaryArea.setSize(new Dimension(20, 6));
		summaryArea.setLineWrap(true);
		summaryArea.setDragEnabled(true);
	



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
									.addComponent(summaryArea, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(titleLabel, Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
													.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(addedGenreBox, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPanel.createSequentialGroup()
															.addComponent(lblGenre, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
															.addGap(75)))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
														.addComponent(removeGenreButton)
														.addComponent(completedCheckBox))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(addGenreButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
													.addGap(137))
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
																		.addComponent(currentField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
																		.addComponent(currentChapter))
																	.addPreferredGap(ComponentPlacement.UNRELATED)
																	.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																		.addComponent(totalChapters)
																		.addComponent(totalField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))))
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
						.addComponent(completedCheckBox))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(addedGenreBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(removeGenreButton)
						.addComponent(addGenreButton))
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
						.addComponent(currentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(totalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addComponent(urlLabel)
							.addGap(14))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(summaryArea, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		
	}
	

}
