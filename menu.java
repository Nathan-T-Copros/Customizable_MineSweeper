import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class menu extends JFrame{
	JPanel groupPanel = new JPanel(); //panel for the JRadio buttons
	JPanel panel2 = new JPanel(); //panel for the new game button
	JRadioButton easy = new JRadioButton("Easy"); 
	JRadioButton medium = new JRadioButton("Medium");
	JRadioButton hard = new JRadioButton("Hard");
	JRadioButton custom = new JRadioButton("Custom");
	ButtonGroup group = new ButtonGroup();
	JButton newGame = new JButton("New Game");
	
	public menu() {
		setSize(700,700); //establish default settings of the window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(500,100);
		setLayout(new BorderLayout());
		setVisible(true);
		
		easy.setSelected(true); //the default selected radio button is easy
		group.add(easy); //add the radio buttons to the group
		group.add(medium);
		group.add(hard);
		group.add(custom);
		groupPanel.add(easy); //add the buttons to the panel
		groupPanel.add(medium);
		groupPanel.add(hard);
		groupPanel.add(custom);
		
		newGame.addActionListener(new action()); //add action listener to new game button
		panel2.add(newGame); //add button to the panel
		add(groupPanel, BorderLayout.CENTER); //set the radio buttons panel on in the layout on the top
		add(panel2, BorderLayout.SOUTH);	//set the new game panel on the bottom
	}
	private class action implements ActionListener { //new game action listener
		public void actionPerformed(ActionEvent e) { 
			if(easy.isSelected()) { //check which radio button is selected
				setVisible(false); //to make menu disappear
				new MineSweeper(6, 10); //start new game with settings corresponding to the difficulty
			}
			else if(medium.isSelected()) {
				setVisible(false);			
				new MineSweeper(10, 13); 
			}
			else if(hard.isSelected()) {
				setVisible(false);
				new MineSweeper(15, 18);
			}
			else { //if custom is selected, let the user choose the size and percentage of mines
				int size = Integer.parseInt(
						JOptionPane.showInputDialog(null, "What size should the Minesweeper have?"));
				int percentage = Integer.parseInt(
						JOptionPane.showInputDialog(null, "What percentage of mines should the MineSweeper have?"));
				setVisible(false); 
				new MineSweeper(size, percentage); 
			}
				
		}
		
	}
}
