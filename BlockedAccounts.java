package hotelReservationSystemGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Scanner;

public class BlockedAccounts extends JFrame implements ActionListener, MouseListener {
	JPanel blockedAccPanel;
	JTextField blockedAccLists;
	JLabel title, unblockAccLabel;
	JButton unblockButton, cancel;
	Color button;
	static JComboBox unblockAcc;

	BlockedAccounts() {
		blockedAccPanel = new JPanel(new GridLayout(8, 1, 10, 10));
		button = new Color(189, 147, 23);
		title = new JLabel("BLOCKED ACCOUNTS");
		title.setFont(new Font("Monospace", Font.BOLD, 26));
		title.setPreferredSize(getSize());

		unblockAcc = new JComboBox();
		unblockAcc.setModel(new DefaultComboBoxModel<String>(LogIn.blockedAccountsTemp.toArray(new String[0])));
		unblockAcc.setSelectedIndex(-1);

		blockedAccLists = new JTextField(String.join("\n", LogIn.blockedAccountsTemp));
		unblockAccLabel = new JLabel("Unblock an account ");

		unblockAcc.setBorder(BorderFactory.createLineBorder(Color.black));
		unblockAcc.setBackground(Color.white);
		unblockAcc.addActionListener(this);
		unblockButton = new JButton("UNBLOCK");
		unblockButton.setBackground(button);
		unblockButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		unblockButton.addActionListener(this);
		cancel = new JButton("CANCEL");
		cancel.setBackground(button);
		cancel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		blockedAccPanel.add(title);
		blockedAccPanel.add(blockedAccLists);
		blockedAccPanel.add(unblockAccLabel);
		blockedAccPanel.add(unblockAcc);
		blockedAccPanel.add(unblockButton);
		blockedAccPanel.add(cancel);
		add(blockedAccPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(null);
		setSize(350, 450);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedItem = (String) unblockAcc.getSelectedItem();
		System.out.println(selectedItem);
		System.out.println(Main.usernames[0]);
		System.out.println(LogIn.blockedAccountsTemp.get(0));
		System.out.println(Main.accountCount);
		if (e.getSource() == unblockButton) {
			for (int i = 0; i < Main.accountCount; i++) {
				if (selectedItem.contains(Main.usernames[i])) {
					Main.blockedAccounts[i] = false;
					LogIn.blockedAccountsTemp.remove(i);
					JOptionPane.showMessageDialog(null, "You have successfully unblocked: " + selectedItem);
					new LogIn(); // delete later
					// new AdminMenuGUI();
					dispose();
					break;

				}
			}
		} else if (e.getSource() == cancel) {

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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

	}

}