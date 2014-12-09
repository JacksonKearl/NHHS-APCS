package morseCodeConversion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class JavaKey {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaKey window = new JavaKey();
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
	public JavaKey() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 206, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblMorseCodeKey = new JLabel("Morse Code Key");
		lblMorseCodeKey.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblMorseCodeKey, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("A(.-)\nB(-...)\nC(-.-.)\nD(-..)\nE(.)\nF(..-.)\nG(--.)\nH(....)\nI(..)\nJ(.---)\nK(-.-)\nL(.-..)\nM(--)\nN(-.)\nO(---)\nP(.--.)\nQ(--.-)\nR(.-.)\nS(...)\nT(-)\nU(..-)\nV(...-)\nW(.--)\nX(-..-)\nY(-.--)\nZ(--..)\n1(.----)\n2(..---)\n3(...--)\n4(....-)\n5(.....)\n6(-....)\n7(--...)\n8(---..)\n9(----.)\n0(-----) ");
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
	}

}
