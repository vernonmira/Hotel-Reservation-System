package hotelReservationSystemGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminMenu {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static LocalDate currentDate = LocalDate.now();
    private static final int maxRooms = 10;
    private static final String[] roomStatus = new String[maxRooms];
    private static final boolean[] roomAvailability = new boolean[maxRooms];
    private static final String[] cancellationDateReports = new String[maxRooms];
    private static final int[] cancellations = new int[maxRooms];
    private static int cancellationCount = 0;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Admin Menu");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500); // Set a specific size for the frame
       
        
        // "ADMIN"  label sa taas
        JLabel titleLabel = new JLabel("Mira's Hotel Management System");
        titleLabel.setFont(new Font("Monospace", Font.BOLD, 28));
        titleLabel.setForeground(new Color(218, 174, 105));
        titleLabel.setBackground(Color.BLACK); // Set the background color
        titleLabel.setOpaque(true); // Make the label opaque
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(0, 0, 0));

        JButton btnBlockedAccounts = new JButton("Blocked accounts");
        JButton btnCheckInReports = new JButton("Check In Reports");
        JButton btnReservationReports = new JButton("Reservation Reports");
        JButton btnCheckOutReports = new JButton("Check Out Reports");
        JButton btnCancellationReports = new JButton("Cancellation Reports");
        JButton btnAdjustDate = new JButton("Adjust Date");
        JButton btnLogOut = new JButton("Log-Out");
        
        //button color
        Color AllbuttonColor = new Color(218, 174, 105);
        btnBlockedAccounts.setBackground(AllbuttonColor);
        btnCheckInReports.setBackground(AllbuttonColor);
        btnReservationReports.setBackground(AllbuttonColor);
        btnCheckOutReports.setBackground(AllbuttonColor);
        btnCancellationReports.setBackground(AllbuttonColor);
        btnAdjustDate.setBackground(AllbuttonColor);        
       
        
          //button Font
        Font buttonFont = new Font("BEBAS NEUE", Font.BOLD, 16);
        btnBlockedAccounts.setFont(buttonFont);
        btnCheckInReports.setFont(buttonFont);
        btnReservationReports.setFont(buttonFont);
        btnCheckOutReports.setFont(buttonFont);
        btnCancellationReports.setFont(buttonFont);
        btnAdjustDate.setFont(buttonFont);

        Font LGbuttonFont = new Font("Arial", Font.BOLD, 14);
        btnLogOut.setFont(LGbuttonFont);

        // hidni ko alam bakit ayaw maging square
        Dimension buttonSize = new Dimension(200, 200);
        btnBlockedAccounts.setPreferredSize(buttonSize);
        btnCheckInReports.setPreferredSize(buttonSize);
        btnReservationReports.setPreferredSize(buttonSize);
        btnCheckOutReports.setPreferredSize(buttonSize);
        btnCancellationReports.setPreferredSize(buttonSize);
        btnAdjustDate.setPreferredSize(buttonSize);

        panel.add(btnBlockedAccounts);
        panel.add(btnCheckInReports);
        panel.add(btnReservationReports);
        panel.add(btnCheckOutReports);
        panel.add(btnCancellationReports);
        panel.add(btnAdjustDate);
        

        mainPanel.add(panel, BorderLayout.CENTER); 

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(btnLogOut);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH); 
        frame.add(mainPanel); 

        btnBlockedAccounts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Displaying list of blocked accounts...");
            }
        });

        btnCheckInReports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Generating the Check In Reports...");
            }
        });

        btnReservationReports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Generating the Reservation Reports...");
            }
        });

        btnCheckOutReports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Generating the Check Out Reports...");
            }
        });

        btnCancellationReports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Generating the Cancellation Reports...");
            }
        });

        btnAdjustDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputDate = JOptionPane.showInputDialog(frame, "Enter the number of days to add:");
                if (inputDate != null) {
                    int daysToAdd = Integer.parseInt(inputDate);
                    int option = JOptionPane.showConfirmDialog(frame,
                            "Are you sure you want to adjust the day by " + daysToAdd + " days?",
                            "Confirm Date Adjustment", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        LocalDate adjustedDate = currentDate.plusDays(daysToAdd);

                        if (daysToAdd >= 2) {
                            for (int i = 0; i < maxRooms; i++) {
                                if (roomStatus[i] != null && roomStatus[i].equals("Reserved")) {
                                    roomAvailability[i] = false;
                                    LocalDateTime cancellationTime = LocalDateTime.now().plusDays(2);
                                    String transactionDate = cancellationTime.format(formatter);
                                    cancellationDateReports[cancellationCount] = transactionDate;
                                    cancellations[cancellationCount] = i;
                                    cancellationCount++;
                                    roomStatus[i] = "Available";
                                }
                            }
                            JOptionPane.showMessageDialog(frame, "All reservations have been cancelled.");
                        }

                        currentDate = adjustedDate;
                        JOptionPane.showMessageDialog(frame,
                                "Adjusted to " + daysToAdd + " days.\nAdjusted Date: " + currentDate);
                    }
                }
            }
        });

       btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to log out?", "Confirm Log-Out", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });


        frame.setVisible(true);
    }
}
