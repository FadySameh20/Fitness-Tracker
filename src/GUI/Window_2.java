package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class Window_2 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblCalories;
	JLabel lblHeartRate ;
	JLabel lblRank;
	JTextArea textArea;

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Window_2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 100, 520, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Results:");
		label.setForeground(new Color(0, 0, 102));
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(22, 11, 91, 38);
		contentPane.add(label);
		
		JLabel lblTotalCaloriesBurnt = new JLabel("Total Calories Burnt:");
		lblTotalCaloriesBurnt.setForeground(new Color(153, 0, 0));
		lblTotalCaloriesBurnt.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalCaloriesBurnt.setBounds(22, 58, 138, 26);
		contentPane.add(lblTotalCaloriesBurnt);
		
		lblCalories = new JLabel("Ans");
		lblCalories.setForeground(Color.BLACK);
		lblCalories.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCalories.setBounds(170, 65, 34, 14);
		contentPane.add(lblCalories);
		
		JLabel label_1 = new JLabel("calories");
		label_1.setForeground(new Color(153, 0, 153));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(214, 64, 58, 14);
		contentPane.add(label_1);
		
		JLabel lblTotalHeartRate = new JLabel("Total Heart Rate:");
		lblTotalHeartRate.setForeground(new Color(255, 255, 0));
		lblTotalHeartRate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalHeartRate.setBounds(22, 95, 118, 23);
		contentPane.add(lblTotalHeartRate);
		
		lblHeartRate = new JLabel("Ans");
		lblHeartRate.setForeground(Color.BLACK);
		lblHeartRate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHeartRate.setBounds(165, 99, 57, 14);
		contentPane.add(lblHeartRate);
		
		JLabel lblBeatminute = new JLabel("beat/minute");
		lblBeatminute.setForeground(new Color(153, 0, 153));
		lblBeatminute.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBeatminute.setBounds(224, 99, 91, 14);
		contentPane.add(lblBeatminute);
		
		JLabel lblNewLabel = new JLabel("~");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(150, 99, 20, 14);
		contentPane.add(lblNewLabel);
		
		lblRank = new JLabel("Activity Rank:");
		lblRank.setForeground(new Color(51, 0, 204));
		lblRank.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRank.setBounds(22, 144, 104, 20);
		contentPane.add(lblRank);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(204, 255, 102));
		textArea.setFont(new Font("Calibri", Font.BOLD, 14));
		textArea.setBounds(22, 175, 428, 271);
		contentPane.add(textArea);
	}
}
