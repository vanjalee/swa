package at.ac.tuwien.swa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class LoginPanel extends JPanel {
	
	private static final long serialVersionUID = 5008526318031780589L;
	
	private static JPanel titlePanel;
	private static JLabel labelSwazam;
	private static JButton loginButton;
	private static JLabel usernameLabel;
	private static JTextField usernameField;
	private static JLabel passwordLabel;
	private static JPasswordField passwordField;
	
	public LoginPanel(final JFrame frame, final ServerConnection server) {
		
		final Container pane = frame.getContentPane();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;
		
		titlePanel = new JPanel(new GridBagLayout());
		labelSwazam = new JLabel("SWAzam");
		labelSwazam.setFont(new Font("Agency FB", Font.PLAIN, 48));
		labelSwazam.setForeground(Color.BLACK);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 3;
		titlePanel.add(labelSwazam);
		pane.add(titlePanel, BorderLayout.PAGE_START);
		
		loginButton = new JButton("Log in");

		usernameLabel = new JLabel("Username: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		this.add(usernameLabel, cs);

		usernameField = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		this.add(usernameField, cs);

		passwordLabel = new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		this.add(passwordLabel, cs);

		passwordField = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		passwordField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(arg0.getKeyChar() == KeyEvent.VK_ENTER) {
					loginButton.doClick();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) { }
			
			@Override
			public void keyPressed(KeyEvent arg0) { }
		});
		
		this.add(passwordField, cs);
		this.setBorder(new LineBorder(Color.GRAY));

		final JPanel bp = new JPanel();
		
		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (server.verifyLogin(usernameField.getText().trim(), passwordField.getPassword())) {
					
					pane.removeAll();
					
					new MainPanel(frame, server);					
					
					pane.repaint();
					
				}
			}
		});
		
		bp.add(loginButton);
		pane.add(this, BorderLayout.CENTER);
		pane.add(bp, BorderLayout.PAGE_END);
	}

}
