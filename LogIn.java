package hotelReservationSystemGUI;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Scanner;

public class LogIn extends JPanel implements ActionListener, MouseListener, KeyListener {
	JPanel logIn;
	JLabel title, usernameLabel, passwordLabel;
	JTextField usernameField;
	JPasswordField passwordField;
	JButton signIn, forgetPass;
	Color button;
	int clickedUser = 0, clickedPass = 0;
	private String loginUsername;
	private String loginPassword;
	private Main mainObj2 = new Main();
	static int blockedAccountsCount = 0;
	static ArrayList<String> blockedAccountsTemp = new ArrayList<>();

	LogIn() {
		logIn = new JPanel(new GridLayout(9, 1, 20, 10));
		title = new JLabel("Welcome back,");
		title.setFont(new Font("Monospace", Font.BOLD, 26));
		usernameField = new JTextField(" username");
		usernameField.setForeground(Color.lightGray);
		usernameField.setBorder(null);
		usernameField.addKeyListener(this);
		usernameField.addMouseListener(this);
		usernameLabel = new JLabel("must be 6-8 characters");
		usernameLabel.setFont(new Font("Arial", Font.ITALIC, 10));
		passwordField = new JPasswordField();
		passwordField.setEchoChar((char) 0);
		passwordField.setText(" password");
		passwordField.setForeground(Color.lightGray);
		passwordField.setBorder(null);
		passwordField.addKeyListener(this);
		passwordField.addMouseListener(this);
		passwordLabel = new JLabel("must be 6-8 characters");
		passwordLabel.setFont(new Font("Arial", Font.ITALIC, 10));
		button = new Color(189, 147, 23);
		signIn = new JButton("LOGIN");
		signIn.setBackground(button);
		signIn.setForeground(Color.black);
		signIn.setBorder(null);
		signIn.setFont(new Font("ARIAL", Font.BOLD, 14));
		signIn.addActionListener(this);
		signIn.addMouseListener(this);
		signIn.addKeyListener(this);
		forgetPass = new JButton("Forgot Password?");
		forgetPass.setFocusPainted(false);
		forgetPass.setBorderPainted(false);
		forgetPass.setContentAreaFilled(false);
		forgetPass.setFont(new Font("Arial", Font.BOLD, 12));
		forgetPass.setForeground(Color.black);
		forgetPass.addActionListener(this);
		forgetPass.addMouseListener(this);
		add(logIn, BorderLayout.CENTER);
		logIn.add(title);
		logIn.add(usernameField);
		logIn.add(usernameLabel);
		logIn.add(passwordField);
		logIn.add(passwordLabel);
		logIn.add(signIn);
		logIn.add(forgetPass);
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setTitle(null);
		setSize(350, 400);
	//	setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	public void logIn() {
		loginUsername = usernameField.getText().trim();
		loginPassword = passwordField.getText().trim();
		if (loginUsername.equals("") || loginPassword.equals("") || clickedUser == 0 || clickedPass == 0) {
			JOptionPane.showMessageDialog(null, "Please don't leave any of the field blank");
		} else {

		}
	}

	public void checkAcc() {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == usernameField) {
			usernameField.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
			if (clickedUser == 0) {
				usernameField.setText("");
				usernameField.setForeground(Color.black);
			}
			clickedUser++;
		} else if (e.getSource() == passwordField) {
			passwordField.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
			if (clickedPass == 0) {
				passwordField.setText("");
				passwordField.setForeground(Color.black);
				passwordField.setEchoChar('*');
			}
			clickedPass++;
		} else if (e.getSource() == signIn) {

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == forgetPass) {
			forgetPass.setForeground(Color.blue);
		} else if (e.getSource() == signIn) {
			Color press = new Color(190, 150, 30);
			signIn.setBackground(press);
			signIn.setForeground(Color.white);
		}
	}

//	@SuppressWarnings("deprecation")
	// same as keytyped (pwedeng ilagay sa isang function then tawagin sa both
	// event)
	@Override
	public void mouseExited(MouseEvent e) {
		if (usernameField.getText().trim().equals("")) {
			usernameField.setText(" username");
			usernameField.setForeground(Color.lightGray);
			usernameField.setBorder(null);
			clickedUser = 0;
		} else if (passwordField.getText().trim().equals("")) {
			passwordField.setEchoChar((char) 0);
			passwordField.setText(" password");
			passwordField.setForeground(Color.lightGray);
			passwordField.setBorder(null);
			clickedPass = 0;
		} else if (e.getSource() == forgetPass) {
			forgetPass.setForeground(Color.black);
		} else if (e.getSource() == signIn) {
			signIn.setBackground(button);
			signIn.setForeground(Color.black);
			signIn.setBorder(null);
		}
		usernameField.setBorder(null);
		passwordField.setBorder(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String username = usernameField.getText().trim();
		String password = new String(passwordField.getPassword());
		if (e.getSource() == signIn) {

			if (username.equals("admin") && password.equals("admin123")) {
				JOptionPane.showMessageDialog(this, "Admin login successful.");
				// call the admin class gagawin latur
				BlockedAccounts blockAccObj = new BlockedAccounts(); //delete later
				return;
			}

			for (int i = 0; i < Main.accountCount; i++) {
				if (Main.blockedAccounts[i] && Main.usernames[i].equals(username)) {
					passwordField.setText("");
					JOptionPane.showMessageDialog(this, "Account is blocked. Please contact the admin for assistance.");
					return;
				}

				if (Main.usernames[i].equals(username)) {
					if (Main.passwords[i].equals(password)) {
						JOptionPane.showMessageDialog(this, "Login successful. Welcome, " + Main.usernames[i] + "!");
						Main.loginAttempts[i] = 0;
						Main.currentUsername = Main.usernames[i];
						//new HomePage();
						return;
					} else {
						Main.loginAttempts[i]++;
						JOptionPane.showMessageDialog(this, "Invalid password.");
						passwordField.setText("");
						if (Main.loginAttempts[i] >= 3) {
							JOptionPane.showMessageDialog(this,
									"Too many failed login attempts. Account is now blocked.");
							blockedAccountsTemp.add(Main.usernames[i]);
							blockedAccountsCount++;
							Main.blockedAccounts[i] = true;
							Main.loginAttempts[i] = 0;
							break;
						}
					}
				}
			}

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
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
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}