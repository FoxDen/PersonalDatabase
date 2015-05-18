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

public class SearchThing extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, scrollPane, 310, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, scrollPane, 200, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, scrollPane, -5, SpringLayout.EAST, contentPanel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPanel.add(scrollPane);
		
		JList list = new JList();
		list.setBackground(new Color(255, 250, 240));
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
			}
		});
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Horror", "Action", "Shojo", "Shonen", "Seinen", "Tragedy", "Angst", "Yaoi", "Yuri", "Genderbending", "Ecchi", "Psychological", 
					"Sci Fi", "Harem", "Smut", "Supernatural", "Romance", "Comedy","Shooter", "RPG", "Simulation", "Strategy", "Sports", "Casual", "Puzzle"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Title");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, scrollPane);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, contentPanel);
		contentPanel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 240));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPanel.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_contentPanel.putConstraint(SpringLayout.EAST, textField, 214, SpringLayout.WEST, contentPanel);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Developer/Mangaka");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, textField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_2);
		contentPanel.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 250, 240));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textField_1, 8, SpringLayout.SOUTH, lblNewLabel_3);
		sl_contentPanel.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_contentPanel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Release");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblNewLabel_3);
		contentPanel.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 250, 240));
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, textField_2);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, textField_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, textField_1);
		sl_contentPanel.putConstraint(SpringLayout.EAST, textField_2, 77, SpringLayout.EAST, textField_1);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 204, 204));
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JLabel lblNewLabel_1 = new JLabel("Genres                   ");
				panel.add(lblNewLabel_1, BorderLayout.EAST);
			}
			
			JLabel lblCtrlclickWillSelect = new JLabel("CTRL-Click will select multiple individual genres.");
			lblCtrlclickWillSelect.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
			panel.add(lblCtrlclickWillSelect, BorderLayout.WEST);
			
			JButton btnSearchByTitle = new JButton("Search by Title");
			btnSearchByTitle.setBackground(new Color(255, 245, 238));
			btnSearchByTitle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			contentPanel.add(btnSearchByTitle);
			
			JButton btnNewButton = new JButton("Search by Creator");
			sl_contentPanel.putConstraint(SpringLayout.WEST, btnSearchByTitle, 6, SpringLayout.EAST, btnNewButton);
			btnNewButton.setBackground(new Color(255, 245, 238));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			sl_contentPanel.putConstraint(SpringLayout.NORTH, btnSearchByTitle, 0, SpringLayout.NORTH, btnNewButton);
			sl_contentPanel.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, lblNewLabel_2);
			contentPanel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Search by Genres");
			btnNewButton_1.setBackground(new Color(255, 245, 238));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnNewButton, -16, SpringLayout.NORTH, btnNewButton_1);
			sl_contentPanel.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, lblNewLabel_2);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, contentPanel);
			contentPanel.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Search All");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton_1);
			sl_contentPanel.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnSearchByTitle);
			btnNewButton_2.setBackground(new Color(255, 245, 238));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			contentPanel.add(btnNewButton_2);
			{

			}
		}
	}
}
