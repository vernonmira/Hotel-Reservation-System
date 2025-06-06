package hotelReservationSystemGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Scanner;

public class AccRegistration extends JPanel implements ActionListener, MouseListener, KeyListener {
	JPanel accountPanel;
	JLabel title, usernameLabel, passwordLabel, confirmPassLabel;
	JTextField usernameField;
	JPasswordField passwordField, confirmPasswordField;
	JButton signUp;
	JCheckBox checkBox1, checkBox2;
	Color button;
	int clickedUser = 0, clickedPass = 0, clickedConfirm = 0;
	private Main mainObj = new Main();
	private String username, password, confirmPassword;

	AccRegistration() {
		
		accountPanel = new JPanel(new GridLayout(9, 1, 20, 10));
		title = new JLabel("Time to Feel Like Home,");
		title.setFont(new Font("Monospace", Font.BOLD, 26));
		usernameField = new JTextField(" username");
		usernameField.setForeground(Color.lightGray);
		usernameField.setBorder(null);
		usernameLabel = new JLabel("must be 6-8 characters");
		usernameLabel.setFont(new Font("Arial", Font.ITALIC, 10));
		checkBox1 = new JCheckBox();
		passwordField = new JPasswordField(" password");
		passwordField.setEchoChar((char) 0);
		passwordField.setForeground(Color.lightGray);
		passwordField.setBorder(null);
		passwordLabel = new JLabel("must be 6-8 characters");
		passwordLabel.setFont(new Font("Arial", Font.ITALIC, 10));
//		 checkBox2 = new JCheckBox();
		confirmPasswordField = new JPasswordField(" confirm password");
		confirmPasswordField.setEchoChar((char) 0);
		confirmPasswordField.setForeground(Color.lightGray);
		confirmPasswordField.setBorder(null);
		confirmPassLabel = new JLabel("");
		confirmPassLabel.setFont(new Font("Arial", Font.ITALIC, 10));
		button = new Color(189, 147, 23);
		signUp = new JButton("Sign Up");
		signUp.setBackground(button);
		signUp.setBorder(null);
		checkBox1.addActionListener(this);
//		 checkBox2.addActionListener(this);
		signUp.addActionListener(this);
		signUp.addMouseListener(this);
		confirmPasswordField.addMouseListener(this);
		confirmPasswordField.addKeyListener(this);
		passwordField.addMouseListener(this);
		passwordField.addKeyListener(this);
		usernameField.addMouseListener(this);
		usernameField.addKeyListener(this);
		add(accountPanel, BorderLayout.CENTER);
		accountPanel.add(title);
		accountPanel.add(usernameField);
		accountPanel.add(usernameLabel);
		accountPanel.add(passwordField);
		accountPanel.add(passwordLabel);
		accountPanel.add(checkBox1);
		accountPanel.add(confirmPasswordField);
		accountPanel.add(confirmPassLabel);
		accountPanel.add(signUp);
	//	accountPanel.add(checkBox1);
//		accountPanel.add(checkBox2);
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setTitle(null);
		setSize(350, 450);
	//	setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signUp) {
			accRegistration();
		}
		if (checkBox1.isSelected()) {
			passwordField.setEchoChar((char) 0);
		} else {
			passwordField.setEchoChar('*');
		}
	}

	public void accRegistration() {
		username = usernameField.getText().trim();
		password = passwordField.getText().trim();
		confirmPassword = confirmPasswordField.getText().trim();
		if (mainObj.accountCount == mainObj.maxAcc) {
			JOptionPane.showMessageDialog(this, "Maximum number of accounts reached. Unable to register.");
			return;
		}

			if (username.equalsIgnoreCase("admin")) {
				JOptionPane.showMessageDialog(this, "You can't use \"admin\" as your username.");
			}
		

		for (int i = 0; i < mainObj.accountCount; i++) {
			if (mainObj.usernames[i].equals(username)) {
				JOptionPane.showMessageDialog(this, "This username already exists in our system.");
			}
		}

		if (username.length() >= 6 && username.length() <=8) {
			if ( password.length() >= 6 && password.length() <= 8 ) {
			if (confirmPassword.equals(password)) {
				mainObj.usernames[mainObj.accountCount] = username;
				mainObj.passwords[mainObj.accountCount] = password;
				mainObj.blockedAccounts[mainObj.accountCount] = false;
				mainObj.accountCount++;
				JOptionPane.showMessageDialog(this, "Account registered successfully.");
				new LogIn();
				this.setVisible(false);
			} else {
				confirmPassLabel.setText("Passwords does not match.");
				confirmPassLabel.setForeground(Color.red);
				passwordField.setBorder(BorderFactory.createLineBorder(Color.red, 2));
				confirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			}
			}else {
				confirmPassLabel.setText("You can only have 6-8 characters as your password.");
				confirmPassLabel.setForeground(Color.red);
				passwordField.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			}
		} else {
			confirmPassLabel.setText("You can only have 6-8 characters as your username.");
			confirmPassLabel.setForeground(Color.red);
			usernameField.setBorder(BorderFactory.createLineBorder(Color.red, 2));
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == usernameField) {
			usernameField.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
			if (clickedUser == 0) {
				usernameField.setForeground(Color.black);
				usernameField.setText("");
			}
			clickedUser++;
		} else if (e.getSource() == passwordField) {
			passwordField.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
			if (clickedPass == 0) {
				passwordField.setForeground(Color.black);
				passwordField.setText("");
				passwordField.setEchoChar('*');
			}
			clickedPass++;
		} else if (e.getSource() == confirmPasswordField) {
			confirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
			if (clickedConfirm == 0) {
				confirmPasswordField.setForeground(Color.black);
				confirmPasswordField.setText("");
				confirmPasswordField.setEchoChar('*');
			}
			clickedConfirm++;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (usernameField.getText().trim().equals("")) {
			usernameField.setText(" username");
			usernameField.setForeground(Color.lightGray);
			clickedUser = 0;
		} else if (passwordField.getText().trim().equals("")) {
			passwordField.setText(" password");
			passwordField.setEchoChar((char) 0);
			passwordField.setForeground(Color.lightGray);
			clickedPass = 0;
		} else if (confirmPasswordField.getText().trim().equals("")) {
			confirmPasswordField.setText(" confirm password");
			confirmPasswordField.setEchoChar((char) 0);
			confirmPasswordField.setForeground(Color.lightGray);
			clickedConfirm = 0;
		}
		usernameField.setBorder(null);
		passwordField.setBorder(null);
		confirmPasswordField.setBorder(null);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == usernameField && clickedUser == 0) {
			usernameField.setText("");
			usernameField.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
			usernameField.setForeground(Color.black);
			clickedUser++;
		} else if (e.getSource() == passwordField && clickedPass == 0) {
			passwordField.setText("");
			passwordField.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
			passwordField.setForeground(Color.black);
			passwordField.setEchoChar('*');
			clickedPass++;
		} else if (e.getSource() == confirmPasswordField && clickedConfirm == 0) {
			confirmPasswordField.setText("");
			confirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
			confirmPasswordField.setForeground(Color.black);
			confirmPasswordField.setEchoChar('*');
			clickedConfirm++;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}