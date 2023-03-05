import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TicTocTeo {
	
	public static void main(String[] args) {
		
		JFrame frame1 = new JFrame("Tic Toc Teo");
		
		frame1.setSize(400,600);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create Button
		JButton b1 = new JButton();
		JButton b2 = new JButton();		
		JButton b3 = new JButton();
		JButton b4 = new JButton();
		JButton b5 = new JButton();
		JButton b6 = new JButton();
		JButton b7 = new JButton();
		JButton b8 = new JButton();
		JButton b9 = new JButton();
		JButton b10 = new JButton("Start");
		JLabel l1 = new JLabel("Player 1");
		
		//frame set on layout
		GridBagLayout gb = new GridBagLayout();
		frame1.setLayout(gb);
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx=0.33;
		gc.weighty=0.25;
				
		//Row-1 added gc.gridx=0 and gc.gridy=1 by default
		frame1.add(b1,gc);
		frame1.add(b2,gc);
		frame1.add(b3,gc);
		
		//Row-2 added
		gc.gridy=1;
		gc.gridx=0;
		
		frame1.add(b4,gc);
		frame1.add(b5,gc);
		frame1.add(b6,gc);

		//Row-3 added
		gc.gridy=2;
		gc.gridx=0;
		
		frame1.add(b7,gc);
		gc.gridx=GridBagConstraints.RELATIVES;
		frame1.add(b8,gc);
		frame1.add(b9,gc);
		
		//Final Row..
		gc.gridy=3;
		gc.gridx=0;
		gc.gridwidth=2;
		gc.fill = GridBagConstraints.BOTH;
		frame1.add(b10,gc);
		
		gc.gridx=2;
		gc.gridy=1;
		frame1.add(l1,gc);
		

		frame1.setResizable(false);
		frame1.setVisible(true);
	}
}