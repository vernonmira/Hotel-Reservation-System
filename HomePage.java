package hotelReservationSystemGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.border.Border;

public class HomePage implements ActionListener, MouseListener {

	JFrame frame;
	JPanel panelCont, panelNavigation, panelHome, panelRooms, panelRegLogIn, panelRegistration, panelLogIn, panelManage,
			panelBookNow;
	JButton buttonHome, buttonRooms, buttonRegister, buttonLogIn, buttonRegLogIn, buttonMyBooking, buttonBookNow,
			roomDetailsButton1, roomDetailsButton2, roomDetailsButton3, buttonBookNow2;
	ImageIcon homePageBg, logo;
	JLabel hotelBg, labelCont, line;
	Border border;
	JScrollPane scrollPane;
	CardLayout cardLayout;
	GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice device = graphics.getDefaultScreenDevice();

	public HomePage() {
		// MAIN FRAME
		frame = new JFrame();
		frame.setLayout(null);
		frame.setTitle("Mira's Hotel Reservation System");
		frame.setLocationRelativeTo(null);
		device.setFullScreenWindow(frame);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// BUTTONS
		buttonHome = new JButton("HOME");
		buttonHome.setFont(new Font("BEBAS NEUE", Font.PLAIN, 15));
		buttonHome.setForeground(new Color(255, 255, 255));
		buttonHome.setFocusPainted(false);
		buttonHome.setBorderPainted(false);
		buttonHome.setContentAreaFilled(false);

		buttonRooms = new JButton("ROOMS");
		buttonRooms.setFont(new Font("BEBAS NEUE", Font.PLAIN, 15));
		buttonRooms.setForeground(new Color(255, 255, 255));
		buttonRooms.setFocusPainted(false);
		buttonRooms.setBorderPainted(false);
		buttonRooms.setContentAreaFilled(false);

		buttonRegister = new JButton("REGISTER");
		buttonRegister.setFont(new Font("BEBAS NEUE", Font.PLAIN, 15));
		buttonRegister.setForeground(new Color(255, 255, 255));
		buttonRegister.setFocusPainted(false);
		buttonRegister.setBorderPainted(false);
		buttonRegister.setContentAreaFilled(false);

		buttonLogIn = new JButton("LOG IN");
		buttonLogIn.setFont(new Font("BEBAS NEUE", Font.PLAIN, 15));
		buttonLogIn.setForeground(new Color(255, 255, 255));
		buttonLogIn.setFocusPainted(false);
		buttonLogIn.setBorderPainted(false);
		buttonLogIn.setContentAreaFilled(false);

		buttonMyBooking = new JButton("MY BOOKING");
		buttonMyBooking.setFont(new Font("BEBAS NEUE", Font.PLAIN, 15));
		buttonMyBooking.setForeground(new Color(255, 255, 255));
		buttonMyBooking.setFocusPainted(false);
		buttonMyBooking.setBorderPainted(false);
		buttonMyBooking.setContentAreaFilled(false);

		buttonBookNow = new JButton("BOOK NOW");
		buttonBookNow.setFont(new Font("BEBAS NEUE", Font.PLAIN, 15));
		buttonBookNow.setForeground(new Color(0, 0, 0));
		buttonBookNow.setBackground(new Color(189, 147, 23));
		buttonBookNow.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		buttonBookNow.setBounds(600, 450, 130, 50);
		buttonBookNow.addMouseListener(this);
		buttonBookNow.addActionListener(this);

		// NAVIGATION BAR
		border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
		panelNavigation = new JPanel();
		panelNavigation.setLayout(null);
		panelNavigation.setBackground(new Color(26, 20, 0));
		
		panelNavigation.setBounds(0, 0, frame.getWidth(), 70);
		panelNavigation.setBorder(border);
		panelNavigation.add(buttonHome);
		buttonHome.setBounds(300, 15, 100, 40);
		panelNavigation.add(buttonRooms);
		buttonRooms.setBounds(400, 15, 100, 40);
		panelNavigation.add(buttonMyBooking);
		panelNavigation.add(buttonRegister);
		buttonMyBooking.setBounds(480, 15, 150, 40);
		buttonRegister.setBounds(1065, 15, 140, 40);
		line = new JLabel("|");
		line.setBounds(1195, 15, 10, 40);
		panelNavigation.add(line);
		panelNavigation.add(buttonLogIn);
		buttonLogIn.setBounds(1200, 15, 90, 40);

		// PANEL CONTAINER
		panelCont = new JPanel();
		cardLayout = new CardLayout();
		panelCont.setLayout(cardLayout);
		panelCont.setBackground(new Color(242, 241, 211));
		panelCont.setBounds(0, 0, frame.getWidth(), frame.getHeight());

		// HOME PANEL
		JLabel homeLabelText = new JLabel("Feel like royalty with your stay at the luxurious");
		homeLabelText.setFont(new Font("BEBAS NEUE", Font.ITALIC, 40));
		homeLabelText.setForeground(new Color (255, 247, 219));
		JLabel homeLabelText2 = new JLabel("Mira's Hotel");
		homeLabelText2.setFont(new Font("Bookman Old Style", Font.ITALIC, 60));
		homeLabelText2.setForeground(new Color (255, 247, 219));
		homeLabelText.setBounds(275, 170, 900, 200);
		homeLabelText2.setBounds(532, 240, 500, 200);
		panelHome = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon bgImage = new ImageIcon("Images/background.jpg");
				Image image = bgImage.getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelHome.setLayout(null);
		panelHome.setOpaque(false);
		panelHome.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panelHome.add(homeLabelText);
		panelHome.add(homeLabelText2);
		panelHome.add(buttonBookNow);

		// ROOMS PANEL
		panelRooms = new JPanel();
		panelRooms.setLayout(null);
		panelRooms.setBackground(new Color(242, 241, 211));

		JLabel roomLabel1 = new JLabel("KING DELUXE ROOM");
		roomLabel1.setFont(new Font("CASTELLAR", Font.PLAIN, 18));
		JLabel imageLabel1 = new JLabel(new ImageIcon("Images/hotelb.jpg"));
		roomDetailsButton1 = new JButton(" VIEW ROOM DETAILS");
		roomDetailsButton1.setFont(new Font("BEBAS NEUE", Font.PLAIN, 15));

		JLabel roomLabel2 = new JLabel("TWIN DELUXE ROOM");
		roomLabel2.setFont(new Font("CASTELLAR", Font.PLAIN, 18));
		JLabel imageLabel2 = new JLabel(new ImageIcon("Images/hotelb.jpg"));
		roomDetailsButton2 = new JButton(" VIEW ROOM DETAILS");
		roomDetailsButton2.setFont(new Font("BEBAS NEUE", Font.PLAIN, 15));

		JLabel roomLabel3 = new JLabel("FAMILY DELUXE ROOM");
		roomLabel3.setFont(new Font("CASTELLAR", Font.PLAIN, 18));
		JLabel imageLabel3 = new JLabel(new ImageIcon("Images/hotelb.jpg"));
		roomDetailsButton3 = new JButton(" VIEW ROOM DETAILS");
		roomDetailsButton3.setFont(new Font("BEBAS NEUE", Font.PLAIN, 15));

		roomLabel1.setBounds(115, 90, 250, 50);
		imageLabel1.setBounds(30, 150, 400, 300);
		// roomDetailsButton1.setBounds(120, 480, 210, 30);

		roomLabel2.setBounds(560, 90, 250, 50);
		imageLabel2.setBounds(475, 150, 400, 300);
		// roomDetailsButton2.setBounds(565, 480, 210, 30);

		roomLabel3.setBounds(1005, 90, 250, 50);
		imageLabel3.setBounds(920, 150, 400, 300);
		// roomDetailsButton3.setBounds(1010, 480, 210, 30);

		JTextArea room1 = new JTextArea();
		room1.setFont(new Font("Antique Olive", Font.PLAIN, 15));
		room1.setBounds(50, 470, 350, 110);
		room1.setBackground(null);
		room1.setLineWrap(true);
		room1.setWrapStyleWord(true);
		room1.setText(
				"Our King Deluxe Room offers spacious rooms with largen windows showcasing a dazzling view of the city landscape. The interiors are accentuated with a taste for local culture, shown by tropical colors and rich wood furnishes.");
		room1.setEditable(false);

		JLabel roomSizeLabel1 = new JLabel("Room Size: 872 Sq ft");
		roomSizeLabel1.setFont(new Font("Calisto MT", Font.BOLD, 15));
		roomSizeLabel1.setBounds(50, 590, 400, 20);
		JLabel roomRateLabel1 = new JLabel("Room Rate: 11,700.00 pesos per night");
		roomRateLabel1.setFont(new Font("Calisto MT", Font.BOLD, 15));
		roomRateLabel1.setBounds(50, 610, 400, 20);

		JTextArea room2 = new JTextArea();
		room2.setFont(new Font("Antique Olive", Font.PLAIN, 15));
		// roomDescLabel2.setBounds(475, 470, 400, 20);
		room2.setBounds(500, 470, 350, 110);
		room2.setBackground(null);
		room2.setLineWrap(true);
		room2.setWrapStyleWord(true);
		room2.setText(
				"Our Twin Deluxe Room offers spacious areas, including a master bedroom and a guest bedroom, with state-of-the-art technology that is tastefully concealed, reflecting an impeccable urban design were function blends well with old world beauty. ");
		room2.setEditable(false);

		JLabel roomSizeLabel2 = new JLabel("Room Size: 1647 Sq ft");
		roomSizeLabel2.setFont(new Font("Calisto MT", Font.BOLD, 15));
		roomSizeLabel2.setBounds(500, 590, 400, 20);

		JLabel roomRateLabel2 = new JLabel("Room Rate: 18,200.00 pesos per night");
		roomRateLabel2.setFont(new Font("Calisto MT", Font.BOLD, 15));
		roomRateLabel2.setBounds(500, 610, 400, 20);

		JTextArea room3 = new JTextArea();
		room3.setFont(new Font("Antique Olive", Font.PLAIN, 15));
		// roomDescLabel2.setBounds(475, 470, 400, 20);
		room3.setBounds(945, 470, 350, 110);
		room3.setBackground(null);
		room3.setLineWrap(true);
		room3.setWrapStyleWord(true);
		room3.setText(
				"Our Family Deluxe Room features lavish living and dining spaces, kitchen, laundry area, and a marble spa bathroom with rain shower head and deep-soaking tub. Each residence characterized by rich wood furnishes and floor-to-ceiling windows.");
		room3.setEditable(false);

		JLabel roomSizeLabel3 = new JLabel("Room Size: 2508 Sq ft");
		roomSizeLabel3.setFont(new Font("Calisto MT", Font.BOLD, 15));
		roomSizeLabel3.setBounds(945, 590, 400, 20);
		JLabel roomRateLabel3 = new JLabel("Room Rate: 21,800.00 pesos per night");
		roomRateLabel3.setFont(new Font("Calisto MT", Font.BOLD, 15));
		roomRateLabel3.setBounds(945, 610, 400, 20);

		buttonBookNow2 = new JButton("BOOK NOW");
		buttonBookNow2.setFont(new Font("CHARLESWORTH", Font.PLAIN, 20));
		buttonBookNow2.setForeground(new Color(0, 0, 0));
		buttonBookNow2.setBackground(new Color(189, 147, 23));
		buttonBookNow2.setBounds(600, 650, 160, 50);
		buttonBookNow2.addMouseListener(this);
		buttonBookNow2.addActionListener(this);

		panelRooms.add(room1);
		panelRooms.add(roomSizeLabel1);
		panelRooms.add(roomRateLabel1);

		panelRooms.add(room2);
		panelRooms.add(roomSizeLabel2);
		panelRooms.add(roomRateLabel2);

		panelRooms.add(room3);
		panelRooms.add(roomSizeLabel3);
		panelRooms.add(roomRateLabel3);

		// panelRooms.add(roomSizeLabel2);
		// panelRooms.add(roomRateLabel2);

		// panelRooms.add(roomSizeLabel3);
		// panelRooms.add(roomRateLabel3);

		panelRooms.add(roomLabel1);
		panelRooms.add(imageLabel1);
		// panelRooms.add(roomDetailsButton1);
		panelRooms.add(roomLabel2);
		panelRooms.add(imageLabel2);
		// panelRooms.add(roomDetailsButton2);
		panelRooms.add(roomLabel3);
		panelRooms.add(imageLabel3);
		// panelRooms.add(roomDetailsButton3);
		panelRooms.add(buttonBookNow2);

		// REGISTRATION PANEL
		panelRegistration = new JPanel();
		panelRegistration.setLayout(null);
		panelRegistration.setBackground(new Color(242, 241, 211));
		panelRegistration.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panelRegistration.add(new AccRegistration());

		// LOG IN PANEL
		panelLogIn = new JPanel();
		panelLogIn.setLayout(null);
		panelLogIn.setBackground(new Color(242, 241, 211));
		panelLogIn.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panelLogIn.add(new LogIn());

		// MANAGE PANEL
		panelManage = new JPanel();
		panelManage.setLayout(null);
		panelManage.setBackground(new Color(242, 241, 211));
		panelManage.setBounds(0, 0, frame.getWidth(), frame.getHeight());

		// BOOK NOW PANEL
		panelBookNow = new JPanel();
		panelBookNow.setLayout(null);
		panelBookNow.setBackground(new Color(167, 0, 57));
		panelBookNow.setBounds(0, 0, frame.getWidth(), frame.getHeight());

		// ADD PANELS TO PANEL CONTAINER
		panelCont.add(panelHome, "Home");
		panelCont.add(panelRooms, "Rooms");
		panelCont.add(panelRegistration, "Registration");
		panelCont.add(panelLogIn, "Log In");
		panelCont.add(panelManage, "Manage");

		buttonHome.addActionListener(this);
		buttonRooms.addActionListener(this);
		buttonRegister.addActionListener(this);
		buttonLogIn.addActionListener(this);
		buttonMyBooking.addActionListener(this);

		buttonHome.addMouseListener(this);
		buttonRooms.addMouseListener(this);
		buttonRegister.addMouseListener(this);
		buttonLogIn.addMouseListener(this);
		buttonMyBooking.addMouseListener(this);

		// SET UP
		frame.add(panelNavigation);
		frame.add(panelCont);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new HomePage();
			}
		});
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == buttonHome) {
			buttonHome.setForeground(new Color(189, 147, 23));
			buttonRooms.setForeground(Color.black);
			buttonRegister.setForeground(Color.black);
			buttonLogIn.setForeground(Color.black);
			buttonMyBooking.setForeground(Color.black);
		} else if (e.getSource() == buttonRooms) {
			buttonHome.setForeground(Color.black);
			buttonRooms.setForeground(new Color(189, 147, 23));
			buttonRegister.setForeground(Color.black);
			buttonLogIn.setForeground(Color.black);
			buttonMyBooking.setForeground(Color.black);
		} else if (e.getSource() == buttonRegister) {
			buttonHome.setForeground(Color.black);
			buttonRooms.setForeground(Color.black);
			buttonRegister.setForeground(new Color(189, 147, 23));
			buttonLogIn.setForeground(Color.black);
			buttonMyBooking.setForeground(Color.black);
		} else if (e.getSource() == buttonLogIn) {
			buttonHome.setForeground(Color.black);
			buttonRooms.setForeground(Color.black);
			buttonRegister.setForeground(Color.black);
			buttonLogIn.setForeground(new Color(189, 147, 23));
			buttonMyBooking.setForeground(Color.black);
		} else if (e.getSource() == buttonMyBooking) {
			buttonHome.setForeground(Color.black);
			buttonRooms.setForeground(Color.black);
			buttonRegister.setForeground(Color.black);
			buttonLogIn.setForeground(Color.black);
			buttonMyBooking.setForeground(new Color(189, 147, 23));
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

		if (e.getSource() == buttonBookNow) {
			buttonBookNow.setForeground(new Color(189, 147, 23));
			buttonBookNow.setBackground(Color.black);
			buttonBookNow.setBorder(null);
		}
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == buttonBookNow) {
			buttonBookNow.setBackground(new Color(189, 147, 23));
			buttonBookNow.setForeground(Color.black);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonHome) {
			cardLayout.show(panelCont, "Home");
			panelHome.add(panelNavigation);

		} else if (e.getSource() == buttonRooms) {
			cardLayout.show(panelCont, "Rooms");
			panelRooms.add(panelNavigation);
			;

		} else if (e.getSource() == buttonRegister) {
			cardLayout.show(panelCont, "Registration");
			panelRegistration.add(panelNavigation);

		} else if (e.getSource() == buttonLogIn) {
			cardLayout.show(panelCont, "Log In");
			panelLogIn.add(panelNavigation);

		} else if (e.getSource() == buttonMyBooking) {
			if (Main.currentUsername != null && !Main.currentUsername.isEmpty()) {
				new MyBooking();
			} else {
				JDialog dialog = new JDialog(frame, "Message");
				dialog.setUndecorated(true);
				dialog.setLocationRelativeTo(frame);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				JOptionPane.showMessageDialog(dialog, "Please log in first to see your bookings.");
				dialog.dispose();
			}

		} else if (e.getSource() == buttonBookNow) {
			if (Main.currentUsername != null && !Main.currentUsername.isEmpty()) {
				// call booking
			} else {
				JDialog dialog = new JDialog(frame, "Message");
				dialog.setUndecorated(true);
				dialog.setLocationRelativeTo(frame);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				JOptionPane.showMessageDialog(dialog, "Please log in first to continue with booking.");
				dialog.dispose();
			}

		} else if (e.getSource() == buttonBookNow2) {
			if (Main.currentUsername != null && !Main.currentUsername.isEmpty()) {
				// call booking
			} else {
				JDialog dialog = new JDialog(frame, "Message");
				dialog.setUndecorated(true);
				dialog.setLocationRelativeTo(frame);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

				JOptionPane.showMessageDialog(dialog, "Please log in first to continue with booking.");

				dialog.dispose();
			}

		}

	}
}