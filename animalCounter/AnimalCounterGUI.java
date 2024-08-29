package animalCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalCounterGUI extends JFrame {
	
	private JLabel alligatorLabel;
	private JLabel sheepLabel;
	private Alligator alligator;
	private Sheep sheep;
	private JRadioButton alligatorRadioButton;
	private JRadioButton sheepRadioButton;
	
	public AnimalCounterGUI() {
		super("Animal Counter");
		
		alligator = new Alligator();
		sheep = new Sheep();
		
		setLayout(new FlowLayout());
		
		JLabel welcomeLabel = new JLabel("Welcome to Animal Counter");
		add(welcomeLabel);
		
		alligatorLabel = new JLabel("Alligators: 0");
		sheepLabel = new JLabel("Sheep: 0");
		
		add(alligatorLabel);
		add(sheepLabel);
		
		JButton addAlligatorButton = new JButton("Add Alligator");
		add(addAlligatorButton);
		addAlligatorButton.addActionListener(new ButtonClickHandler());
		
		JButton addSheepButton = new JButton("Add Sheep");
		add(addSheepButton);
		addSheepButton.addActionListener(new ButtonClickHandler());
		
		JButton displayCountsButton = new JButton("Display Counts");
		add(displayCountsButton);
		displayCountsButton.addActionListener(new ButtonClickHandler());
		
		JButton resetCountButton = new JButton("Reset Counts");
		add(resetCountButton);
		resetCountButton.addActionListener(new ButtonClickHandler());
		
		alligatorRadioButton = new JRadioButton("Alligator");
		sheepRadioButton = new JRadioButton("Sheep");
		
		ButtonGroup group = new ButtonGroup();
		group.add(alligatorRadioButton);
		group.add(sheepRadioButton);
		
		add(alligatorRadioButton);
		add(sheepRadioButton);
		
		JButton exitButton = new JButton("Exit");
		add(exitButton);
		exitButton.addActionListener(e -> System.exit(0));
		
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class ButtonClickHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
			if (command.equals("Add Alligator")) {
				alligator.incrementCount();
				if (alligator.getCount() > sheep.getCount()) {
					JOptionPane.showMessageDialog(null, "Please add more sheep for the hungry alligators");
				}
				
				updateLabels();
			} else if (command.equals("Add Sheep")) {
				sheep.incrementCount();
				updateLabels();
			} else if (command.equals("Display Counts")) {
				JOptionPane.showMessageDialog(null, "Alligators: " + alligator.getCount() + "\nSheep: " + sheep.getCount());
			} else if (command.equals("Reset Counts")) {
				if (alligatorRadioButton.isSelected()) {
					alligator.resetCount();
				} else if (sheepRadioButton.isSelected()) {
					sheep.resetCount();
				}
				
				updateLabels();
			}
		}
	}
	
	private void updateLabels() {
		alligatorLabel.setText("Alligators: " + alligator.getCount());
		sheepLabel.setText("Sheep: " + sheep.getCount());
		
		if (alligator.getCount() == 0) {
			JOptionPane.showMessageDialog(null, "No alligators now so the sheep are safe");
		}
	}
}
