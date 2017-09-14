package Design;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Process.PlayerDetails;

import javax.swing.JButton;

public class MenuPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	String s1,s2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPage window = new MenuPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public MenuPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Player 1 Name :");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 27, 140, 62);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(176, 40, 176, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblPlayerName = new JLabel("Player 2 Name :");
		lblPlayerName.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblPlayerName.setBounds(36, 110, 140, 56);
		frame.getContentPane().add(lblPlayerName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(176, 120, 176, 36);
		frame.getContentPane().add(textField_1);
		
		
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		btnNewButton.setBounds(151, 209, 114, 41);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	s2=textField_1.getText();
		    	s1=textField.getText();
		    	if(s1.length()==0 || s2.length()==0){
		    		JOptionPane.showMessageDialog(frame,"Fill Names","Alert",JOptionPane.ERROR_MESSAGE);
		    	}
		    	else{
			    	PlayerDetails pd = new PlayerDetails(s1, s2);
			    	Board b = new Board(pd);
			    	frame.dispose();
		    	}
		    }
		});
		
		frame.setVisible(true);
	}

	
}
