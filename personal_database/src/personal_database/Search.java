package personal_database;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;

public class Search extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6053829116067594767L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Search dialog = new Search();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Search() {
		getContentPane().setBackground(new Color(255, 204, 204));
		setTitle("Search Box");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 204, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JLabel lblFillInThe = new JLabel(" Fill in the remembered fields.");
			lblFillInThe.setBackground(new Color(255, 235, 205));
			getContentPane().add(lblFillInThe, BorderLayout.NORTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 204, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Search");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
