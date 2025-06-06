package hotelReservationSystemGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyBooking extends JFrame implements ActionListener {

	private JTextArea checkInsArea;
	private JTextArea reservationsArea;
	private JButton checkOutRoomButton;
	private JButton roomCancellationButton;
	private JButton settleReservationButton;
	private JLabel checkInsLabel;
	private JLabel reservationsLabel;
	private static int[] reservations = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
	private static int[] checkIns = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	public MyBooking() {
		super("My Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);

		checkInsLabel = new JLabel("Check-Ins: ");
		reservationsLabel = new JLabel("Reservations: ");

		checkInsArea = new JTextArea();
		reservationsArea = new JTextArea();
		checkInsArea.setRows(10);
		checkInsArea.setColumns(20);
		reservationsArea.setRows(10);
		reservationsArea.setColumns(20);
		Font font = new Font("Bookman Old Style", Font.PLAIN, 13);
		checkInsArea.setFont(font);
		reservationsArea.setFont(font);
		checkInsArea.setEditable(false);
		reservationsArea.setEditable(false);

		StringBuilder checkInsStringBuilder = new StringBuilder();
		StringBuilder reservationsStringBuilder = new StringBuilder();

		for (int i = 0; i < checkIns.length; i++) {
			if (checkIns[i] != 0) {
				checkInsStringBuilder.append("Room ").append(checkIns[i]);
				if (i < checkIns.length - 1) {
					checkInsStringBuilder.append("\n");
				}
			}
		}

		for (int i = 0; i < reservations.length; i++) {
			if (reservations[i] != 0) {
				reservationsStringBuilder.append("Room ").append(reservations[i]);
				if (i < reservations.length - 1) {
					reservationsStringBuilder.append("\n");
				}
			}
		}

		String checkInsArrayString = checkInsStringBuilder.toString();
		String reservationsArrayString = reservationsStringBuilder.toString();

		checkInsArea.setText(checkInsArrayString);
		reservationsArea.setText(reservationsArrayString);

		Color textAreaBackground1 = new Color(242, 241, 211);
		Color textAreaBackground2 = new Color(250, 244, 219);
		Color textAreaText = new Color(0, 0, 0);
		checkInsArea.setBackground(textAreaBackground1);
		checkInsArea.setForeground(textAreaText);
		reservationsArea.setBackground(textAreaBackground2);
		reservationsArea.setForeground(textAreaText);

		checkOutRoomButton = new JButton("Check-Out");
		roomCancellationButton = new JButton("Cancel Room");
		settleReservationButton = new JButton("Settle Room Reservation");
		checkOutRoomButton.addActionListener(this);
		roomCancellationButton.addActionListener(this);
		settleReservationButton.addActionListener(this);

		JPanel topPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 1.0;

		JPanel checkInsPanel = new JPanel(new BorderLayout());
		checkInsPanel.add(checkInsLabel, BorderLayout.NORTH);
		checkInsPanel.add(new JScrollPane(checkInsArea), BorderLayout.CENTER);
		topPanel.add(checkInsPanel, gbc);

		gbc.gridx = 1;
		gbc.weightx = 0.5;

		JPanel reservationsPanel = new JPanel(new BorderLayout());
		reservationsPanel.add(reservationsLabel, BorderLayout.NORTH);
		reservationsPanel.add(new JScrollPane(reservationsArea), BorderLayout.CENTER);
		topPanel.add(reservationsPanel, gbc);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3));

		buttonPanel.add(checkOutRoomButton);
		buttonPanel.add(roomCancellationButton);
		buttonPanel.add(settleReservationButton);
		Color buttonColor = new Color(189, 147, 23);
		checkOutRoomButton.setBackground(buttonColor);
		roomCancellationButton.setBackground(buttonColor);
		settleReservationButton.setBackground(buttonColor);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(topPanel, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkOutRoomButton) {

		} else if (e.getSource() == roomCancellationButton) {

		} else if (e.getSource() == settleReservationButton) {
			
		}
	}

	public static void main(String[] args) {
		new MyBooking();
	}
}
