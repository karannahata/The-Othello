package Design;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MainPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame .setTitle("The Othello");
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		btnNewButton.setBounds(200, 180, 143, 44);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		btnNewButton_1.setBounds(200, 259, 143, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(150, 11, 247, 129);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		ImageIcon icon = new ImageIcon("title.png") ;
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 247, 129);
		//frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(icon);
		panel.add(lblNewLabel);
		
		btnNewButton.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	MenuPage mp = new MenuPage();
		    	frame.dispose();
		    }
		    });
		btnNewButton_1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	frame.dispose();
		    }
		    });
	}
}
