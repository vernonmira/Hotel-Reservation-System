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

public class CustomerInterface {
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

	public CustomerInterface() {
		 frame = new JFrame();
	        frame.setTitle("Mira's Hotel Reservation and Management System");
	    	frame.setLocationRelativeTo(null);
			device.setFullScreenWindow(frame);
			frame.setResizable(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panelNavigation = new JPanel();
	        panelNavigation.setBackground(new Color(242, 241, 211));
	        panelNavigation.setPreferredSize(null);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
