package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fitness.Activity;
import fitness.KickBoxing;
import fitness.Running;
import fitness.StrengthTraining;
import fitness.Swimming;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Window_1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Window_2 gui = new Window_2();
	DecimalFormat df = new DecimalFormat("#.###");
	Swimming swim = new Swimming();
	Running run = new Running();
	KickBoxing kb = new KickBoxing();
	StrengthTraining strength = new StrengthTraining();
	
	private JPanel contentPane;
	private JTextField textFieldTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window_1 frame = new Window_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 474, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Add Activity:");
		label.setForeground(new Color(204, 0, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(23, 57, 86, 34);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Type:");
		label_1.setForeground(new Color(102, 0, 102));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(23, 108, 46, 20);
		contentPane.add(label_1);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setForeground(Color.BLACK);
		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] {"", "Swimming", "Running", "Kick_Boxing", "Strength_Training"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(91, 109, 134, 20);
		contentPane.add(comboBox);

		JLabel label_2 = new JLabel("Time:");
		label_2.setForeground(new Color(255, 255, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(23, 154, 46, 14);
		contentPane.add(label_2);

		textFieldTime = new JTextField();
		textFieldTime.setForeground(Color.BLACK);
		textFieldTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldTime.setColumns(10);
		textFieldTime.setBounds(91, 151, 86, 20);
		contentPane.add(textFieldTime);

		JButton button = new JButton("Add Activity");
		button.setForeground(Color.BLACK);
		button.setBackground(new Color(204, 0, 0));
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {  //Adds a new activity
				gui.setVisible(false);
				String activity = comboBox.getSelectedItem().toString();
				int time = 0;
				boolean flag = false;
				try {
					time = Integer.parseInt(textFieldTime.getText());
				}
				catch(Exception e){
					flag = true;
				}
				if(time <= 0) {
					flag = true;
				}
				if(flag == true){
					if(comboBox.getSelectedItem() == "") {
						JOptionPane.showMessageDialog(null, "Invalid Activity");
						comboBox.setSelectedItem("");
					}
					JOptionPane.showMessageDialog(null, "Invalid Time");
					textFieldTime.setText("");
					return;
				}
				switch(activity.toUpperCase()) {
				case "SWIMMING":
					swim.calcCaloriesBurnt(time);
					swim.calcHeartRate(time, 0.002);
					break;
				case "RUNNING":
					run.calcCaloriesBurnt(time);
					run.calcHeartRate(time, 0.003);
					break;
				case "KICK_BOXING":
					kb.calcCaloriesBurnt(time);
					kb.calcHeartRate(time, 0.005);
					break;
				case "STRENGTH_TRAINING":
					strength.calcCaloriesBurnt(time);
					strength.calcHeartRate(time, 0.006);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid Activity");
					flag = true;
					comboBox.setSelectedItem("");
					break;
				}
				if(flag == false) {
					JOptionPane.showMessageDialog(null, "Activity Successfully Recorded");
					comboBox.setSelectedItem("");
					textFieldTime.setText("");
				}
			}
		});

		button.setBounds(80, 209, 110, 35);
		contentPane.add(button);

		JButton button_1 = new JButton("Show Results");
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(new Color(153, 0, 204));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   //Shows total calories burnt and total heart rate
				gui.setVisible(true);
				gui.lblRank.setVisible(false);
				gui.textArea.setVisible(false);
				gui.lblCalories.setText(Integer.toString(Activity.getCaloriesBurnt()));
				df.setRoundingMode(RoundingMode.HALF_UP);
				gui.lblHeartRate.setText(df.format(Activity.getHeartRate()));
			}
		});
		button_1.setBounds(262, 209, 124, 35);
		contentPane.add(button_1);

		JButton btnNewButton = new JButton("Sort & Print");
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {   //Sorts and prints the activity ranking in addition to total calories burnt and total heart rate
			public void actionPerformed(ActionEvent e) { 
				if ((Swimming.getTotalSwimCalories() == 0) && (Running.getTotalRunCalories() == 0) && (KickBoxing.getTotalKbCalories() == 0)
						&& (StrengthTraining.getTotalStrengthCalories() == 0)) {
					gui.lblRank.setVisible(false);
					gui.textArea.setVisible(false);
					JOptionPane.showMessageDialog(null, "No activivties added yet");
				} else {
				gui.setVisible(true);
				gui.lblCalories.setText(Integer.toString(Activity.getCaloriesBurnt()));
				df.setRoundingMode(RoundingMode.HALF_UP);
				gui.lblHeartRate.setText(df.format(Activity.getHeartRate()));
				gui.lblRank.setVisible(true);
				gui.textArea.setVisible(true);
				gui.textArea.setEditable(false);
				gui.textArea.setText("");
				Activity.sortActivity();
				for (int i = 0; i < Activity.caloriesArray.length; i++) {
					if ((Activity.caloriesArray[i] == Swimming.getTotalSwimCalories())
							&& (Activity.heartRateIncArray[i] == Swimming.getTotalSwimHRInc()) && (Swimming.getTotalSwimCalories() != 0)) {
						gui.textArea.append((i+1) + ". Swimming:" + "\n");
						gui.textArea.append("         Calories Burnt: "+ Swimming.getTotalSwimCalories() + " calories" + "\n");
						gui.textArea.append("         Heart Rate Increase: "+ df.format(Swimming.getTotalSwimHRInc()) + " beat/minute" + "\n\n");
						
					} else if ((Activity.caloriesArray[i] == Running.getTotalRunCalories())
							&& (Activity.heartRateIncArray[i] == Running.getTotalRunHRInc()) && (Running.getTotalRunCalories() != 0)) {
						gui.textArea.append((i+1) + ". Running:" + "\n");
						gui.textArea.append("         Calories Burnt: "+ Running.getTotalRunCalories() + " calories" + "\n");
						gui.textArea.append("         Heart Rate Increase: "+ df.format(Running.getTotalRunHRInc()) + " beat/minute" + "\n\n");
						
					} else if ((Activity.caloriesArray[i] == KickBoxing.getTotalKbCalories())
							&& (Activity.heartRateIncArray[i] == KickBoxing.getTotalKbHRInc()) && (KickBoxing.getTotalKbCalories() != 0)) {
						gui.textArea.append((i+1) + ". Kick_Boxing:" + "\n");
						gui.textArea.append("         Calories Burnt: "+ KickBoxing.getTotalKbCalories() + " calories" + "\n");
						gui.textArea.append("         Heart Rate Increase: "+ df.format(KickBoxing.getTotalKbHRInc()) + " beat/minute" + "\n\n");
						
					} else if ((Activity.caloriesArray[i] == StrengthTraining.getTotalStrengthCalories())
							&& (Activity.heartRateIncArray[i] == StrengthTraining.getTotalStrengthHRInc())
							&& (StrengthTraining.getTotalStrengthCalories() != 0)) {
						gui.textArea.append((i+1) + ". Strength_Training:" + "\n");
						gui.textArea.append("         Calories Burnt: "+ StrengthTraining.getTotalStrengthCalories() + " calories" + "\n");
						gui.textArea.append("         Heart Rate Increase: "+ df.format(StrengthTraining.getTotalStrengthHRInc()) + " beat/minute" + "\n\n");
					}
				}
				}
			}
		});
		btnNewButton.setBounds(165, 274, 124, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Fitness Tracker");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(165, 22, 142, 34);
		contentPane.add(lblNewLabel);
	}
}
