package coolSet4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimeApp {

	private JFrame frame;
	private JTextField millField;
	private JTextField standField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeApp window = new TimeApp();
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
	public TimeApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 181, 188);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][][][][]"));
		
		JLabel lblMillitaryTime = new JLabel("Millitary Time:");
		frame.getContentPane().add(lblMillitaryTime, "cell 0 0,alignx center");
		
		millField = new JTextField();
		frame.getContentPane().add(millField, "cell 0 1,growx");
		millField.setColumns(10);
		
		JLabel lblStandardTime = new JLabel("Standard Time:");
		frame.getContentPane().add(lblStandardTime, "cell 0 2,alignx center");
		
		standField = new JTextField();
		frame.getContentPane().add(standField, "cell 0 3,growx");
		standField.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (standField.getText() != null) {
					
				} else if (millField.getText() != null) {
					
				}
			}
		});
		frame.getContentPane().add(btnCalculate, "cell 0 5,alignx center");
	}

}
