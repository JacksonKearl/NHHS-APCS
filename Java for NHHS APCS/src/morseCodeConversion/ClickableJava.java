package morseCodeConversion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ClickableJava {

	private JFrame frame;
	private JLabel enteredMorse;
	private JLabel output;
	private JButton playButton;
	private Runnable r;
	private Thread thread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClickableJava window = new ClickableJava();
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
	public ClickableJava() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 358, 234);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[58.00,right][201.00,center][]", "[][][][][][][]"));
		
		JLabel enterMorseLbl = new JLabel("Enter morse:");
		frame.getContentPane().add(enterMorseLbl, "cell 1 0");
		
		JButton addDash = new JButton("-");
		addDash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enteredMorse.setText(enteredMorse.getText()+"-");
			}
		});
		frame.getContentPane().add(addDash, "cell 0 1");
		
		JButton addDot = new JButton(".");
		addDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enteredMorse.setText(enteredMorse.getText()+".");
			}
		});
		
		r = new PlaybackThreadDriver();
		
		playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (playButton.getText().equals("Stop")){
					((PlaybackThreadDriver) r).kill();
					playButton.setText("Play Morse");
				}
				else {
					thread = new Thread(r);
					thread.start();
					playButton.setText("Stop");
				}
			}
		});
		
		enteredMorse = new JLabel("");
		enteredMorse.setBackground(Color.WHITE);
		frame.getContentPane().add(enteredMorse, "cell 1 1");
		frame.getContentPane().add(playButton, "cell 2 1");
		frame.getContentPane().add(addDot, "cell 0 2");
		
		JButton newLttr = new JButton("New Letter");
		newLttr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enteredMorse.setText(enteredMorse.getText()+" ");
			}
		});
		frame.getContentPane().add(newLttr, "cell 1 3");
		
		JButton newWrd = new JButton("New Word");
		newWrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enteredMorse.setText(enteredMorse.getText()+"  ");
			}
		});
		frame.getContentPane().add(newWrd, "cell 1 4");
		
		JButton translate = new JButton("Translate");
		translate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText(Morse.toAlpha(enteredMorse.getText(), ' '));
			}
		});
		frame.getContentPane().add(translate, "cell 1 5");
		
		output = new JLabel("");
		frame.getContentPane().add(output, "cell 1 6");
	}

}
