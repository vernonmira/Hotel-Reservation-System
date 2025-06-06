package hotelReservationSystemGUI;

import java.util.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
	static final int maxAcc = 1000;
	static String[] usernames = new String[maxAcc];
	static String currentUsername;
	static String[] passwords = new String[maxAcc];
	static boolean[] blockedAccounts = new boolean[maxAcc];
	static int[] loginAttempts = new int[maxAcc];
	static int accountCount = 0;
	static final int maxRooms = 12;
	static String[] roomTypes = { "King", "Twin", "Family" };
	static double[] roomRates = { 11700.0, 11700.0, 11700.0, 11700.0, 18200.0, 18200.0, 18200.0, 18200.0, 21800.0,
			21800.0, 21800.0, 21800.0 };
	static int[] roomNumber = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
	static boolean[] roomAvailability = new boolean[maxRooms];
	static boolean[] rooms = new boolean[12];
	static String[] roomStatus = new String[maxRooms];
	static int[] nightsOfStay = new int[maxRooms];
	static int[] checkIns = new int[maxRooms];
	static int[] reservations = new int[maxRooms];
	static int[] cancellations = new int[maxRooms];
	static int[] checkOuts = new int[maxRooms];
	static int checkInCount = 0;
	static int reservationCount = 0;
	static int cancellationCount = 0;
	static int checkOutCount = 0;
	static int transactionCounter = checkInCount + reservationCount + cancellationCount;
	static String[] checkInDateReports = new String[maxRooms];
	static String[] reservationDateReports = new String[maxRooms];
	static String[] cancellationDateReports = new String[maxRooms];
	static String[] checkOutDateReports = new String[maxRooms];
	static LocalDateTime now = LocalDateTime.now();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	static String currentTime = now.format(formatter);
	static LocalDate currentDate = LocalDate.now();

	public static void main(String[] args) {
		AdminMenu.main(args);
	}
}