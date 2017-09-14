package Design;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.sun.prism.Image;

import Process.BoardOperations;
import Process.PlayerDetails;

import java.awt.Font;
import java.awt.Graphics;

public class Board implements ActionListener {

	private JFrame frame;
	BoardOperations oper;
	JButton btn[];
	JLabel lblName,lblcount1,lblcount2;
	PlayerDetails pd;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board window = new Board();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Board(PlayerDetails pd) {
		this.pd=pd;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.oper = new BoardOperations();
		btn=new JButton[64];
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 264, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		int x=0,y=0;
		for(int i=0;i<64;){
			btn[i]=new JButton();
			btn[i].setBounds(x, y, 33, 30);
			btn[i].addActionListener(this);
			btn[i].setBackground(Color.GREEN);
			panel.add(btn[i]);
			x+=33;
			i++;
			if(i%8==0){
				x=0;
				y+=30;
			}
		}
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(284, 11, 140, 239);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTurn = new JLabel("Turn");
		lblTurn.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		lblTurn.setBounds(0, 5, 52, 24);
		lblTurn.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblTurn);
		
		lblName = new JLabel();
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 14));
		lblName.setBounds(0, 35, 127, 24);
		panel_1.add(lblName);
		
		JLabel lblPlayerTokenCount = new JLabel("Player1 Count");
		lblPlayerTokenCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerTokenCount.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
		lblPlayerTokenCount.setBounds(0, 70, 140, 24);
		panel_1.add(lblPlayerTokenCount);
		
		lblcount1= new JLabel();
		lblcount1.setHorizontalAlignment(SwingConstants.CENTER);
		lblcount1.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 14));
		lblcount1.setBounds(40,105, 60, 24);
		panel_1.add(lblcount1);
		
		JLabel lblPlayerCount = new JLabel("Player2 Count");
		lblPlayerCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerCount.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
		lblPlayerCount.setBounds(0, 156, 140, 24);
		panel_1.add(lblPlayerCount);
		
		lblcount2= new JLabel();
		lblcount2.setHorizontalAlignment(SwingConstants.CENTER);
		lblcount2.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 14));
		lblcount2.setBounds(40, 195, 60, 24);
		panel_1.add(lblcount2);
		
		setframe();
		frame.setVisible(true);
	}
	public void setframe(){
		int board[][]=oper.getBoard();
		int i=0,j=0;
		for(i=0;i<8;i++){
			for(j=0;j<8;j++){
				if(board[i][j]==1){
					btn[8*i+j].setBackground(Color.BLACK);
					btn[8*i+j].setEnabled(false);
				}
				else if(board[i][j]==2){
					btn[8*i+j].setBackground(Color.WHITE);
					btn[8*i+j].setEnabled(false);
				}
				else if(board[i][j]==3){
					btn[8*i+j].setEnabled(true);
				}
				else{
					btn[8*i+j].setEnabled(false);
				}
			}
		}
		int count1=oper.countP1();
		int count2=oper.countP2();
		
		lblcount1.setText(""+count1);
		lblcount2.setText(""+count2);
		
		int turn = oper.getTurn();
		if(turn==1){
			lblName.setText(pd.getP1());
		}
		else{
			lblName.setText(pd.getP2());
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		
		JButton btn1=(JButton)e.getSource();
	
		for(int i=0;i<64;i++){
			if(btn1==btn[i]){
				oper.updateBoard(i/8,i%8);
				break;
			}
		}
		setframe();
		int win =oper.winCase();
		if(win==1){
			frame.dispose();
			if(oper.countP1()>oper.countP2())
				JOptionPane.showMessageDialog(frame,"Congratulations!!!! "+pd.getP1()+"  Wins.");
			else
				JOptionPane.showMessageDialog(frame,"Congratulations!!!! "+pd.getP2()+"  Wins.");
			MainPage m = new MainPage();
		}
	}

	
	
}
