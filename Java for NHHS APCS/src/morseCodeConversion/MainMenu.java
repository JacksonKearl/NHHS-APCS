package morseCodeConversion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextArea morseText;
	private JTextArea englishText;
	private JLabel errorLabel;
	private JTextField delimText;
	private JLabel demLabel;
	public static JButton playButton;
	private Thread thread;
	private Runnable r;

	private char delimiter = '/';
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setResizable(false);

		setTitle("Morse Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[159px,grow][40.00px,grow][159px,grow]", "[][grow][][]"));

		JLabel morseLabel = new JLabel("Morse:");
		contentPane.add(morseLabel, "cell 0 0,alignx center,aligny center");

		JLabel englishLabel = new JLabel("English:");
		contentPane.add(englishLabel, "cell 2 0,alignx center,aligny center");
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
				morseText = new JTextArea();
				scrollPane.setViewportView(morseText);
				morseText.setLineWrap(true);
				morseText.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						if (morseText.getText().length()>0){
							char key = morseText.getText().substring(morseText.getText().length()-1, morseText.getText().length()).charAt(0);
							String valid = " .-";
							valid += delimiter;
							if (valid.indexOf(key) != -1){
								if (morseText.getText().length()>0){
									String engVal = Morse.cleanUp(morseText.getText(), delimiter);
									engVal = Morse.toAlpha(engVal, delimiter);


									if (engVal.equals("Error: Invalid morse."))
										errorLabel.setText(engVal);
									else {
										englishText.setText(engVal);
										errorLabel.setText("");
									}
								}
							}
							else {
								morseText.setText(morseText.getText().substring(0, morseText.getText().length()-1));
							}
						}
						else {
							englishText.setText("");
						}
					}
				});
		
		scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, "cell 2 1,grow");
		
				englishText = new JTextArea();
				scrollPane_1.setViewportView(englishText);
				englishText.setLineWrap(true);
				englishText.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						morseText.setText(Morse.toMorse(englishText.getText(), delimiter));
					}
				});

		r = new PlaybackThreadDriver();


		playButton = new JButton("Play Morse");
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
		contentPane.add(playButton, "cell 0 2,alignx center");

		errorLabel = new JLabel("");
		contentPane.add(errorLabel, "cell 2 2,alignx center");

		demLabel = new JLabel("Word Break:");
		contentPane.add(demLabel, "cell 0 3,alignx trailing");

		delimText = new JTextField();
		delimText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (delimText.getText().length() != 0)
					delimiter = delimText.getText().charAt(0);
				else 
					delimiter = ' ';
				morseText.setText(Morse.toMorse(englishText.getText().trim(), delimiter));
				String engVal = Morse.cleanUp(morseText.getText(), delimiter);
				engVal = Morse.toAlpha(engVal, delimiter);
				englishText.setText(engVal);

			}
		});
		delimText.setText("/");
		contentPane.add(delimText, "cell 1 3,growx");
		delimText.setColumns(10);
	}

}
