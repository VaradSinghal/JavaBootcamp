import java.util.*;

class Room {
    private final String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int maxOccupancy;

    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.maxOccupancy = maxOccupancy;
        this.isAvailable = true;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String toString() {
        return "Room " + roomNumber + " | Type: " + roomType + " | Price: " + pricePerNight + " | Max Occupancy: " + maxOccupancy + " | Available: " + isAvailable;
    }
}

class Guest {
    private String guestId;
    private String guestName;
    private String phoneNumber;
    private String email;
    private List<String> bookingHistory;

    public Guest(String guestId, String guestName, String phoneNumber, String email) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingHistory = new ArrayList<>();
    }

    public String getGuestId() {
        return guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void addBookingHistory(String bookingId) {
        bookingHistory.add(bookingId);
    }

    public List<String> getBookingHistory() {
        return bookingHistory;
    }

    public String toString() {
        return guestId + " - " + guestName + " | Phone: " + phoneNumber + " | Email: " + email;
    }
}

class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private String checkInDate;
    private final String checkOutDate;
    private final double totalAmount;

    private static double hotelRevenue = 0.0;
    private static String hotelName = "GrandStay";
    private static Map<String, Integer> roomTypeCounter = new HashMap<>();

    public Booking(String bookingId, Guest guest, Room room, String checkInDate, String checkOutDate, double totalAmount) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;

        hotelRevenue += totalAmount;
        roomTypeCounter.put(room.getRoomType(), roomTypeCounter.getOrDefault(room.getRoomType(), 0) + 1);

        guest.addBookingHistory(bookingId);
        room.setAvailable(false);
    }

    public Booking(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public static double getTotalRevenue() {
        return hotelRevenue;
    }

    public static double getOccupancyRate(List<Room> rooms) {
        int occupied = 0;
        for (Room r : rooms) {
            if (!r.isAvailable()) {
                occupied++;
            }
        }
        return (occupied * 100.0) / rooms.size();
    }

    public static String getMostPopularRoomType() {
        String popular = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : roomTypeCounter.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                popular = entry.getKey();
            }
        }
        return popular;
    }

    public String toString() {
        return "BookingID: " + bookingId + " | Guest: " + guest.getGuestName() + " | Room: " + room.getRoomNumber() +
                " (" + room.getRoomType() + ") | CheckIn: " + checkInDate + " | CheckOut: " + checkOutDate +
                " | Amount: " + totalAmount;
    }
}

class HotelReservationSystem {
    private List<Room> rooms;
    private List<Guest> guests;
    private List<Booking> bookings;

    public HotelReservationSystem() {
        rooms = new ArrayList<>();
        guests = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void showAvailableRooms() {
        for (Room r : rooms) {
            if (r.isAvailable()) {
                System.out.println(r);
            }
        }
    }

    public Room findRoom(String roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber().equals(roomNumber)) {
                return r;
            }
        }
        return null;
    }

    public Guest findGuest(String guestId) {
        for (Guest g : guests) {
            if (g.getGuestId().equals(guestId)) {
                return g;
            }
        }
        return null;
    }

    public void makeReservation(String bookingId, String guestId, String roomNumber, String checkIn, String checkOut, int nights) {
        Guest guest = findGuest(guestId);
        Room room = findRoom(roomNumber);
        if (guest != null && room != null && room.isAvailable()) {
            double total = room.getPricePerNight() * nights;
            Booking booking = new Booking(bookingId, guest, room, checkIn, checkOut, total);
            bookings.add(booking);
            System.out.println("Reservation successful: " + booking);
        } else {
            System.out.println("Reservation failed.");
        }
    }

    public void cancelReservation(String bookingId) {
        Iterator<Booking> it = bookings.iterator();
        while (it.hasNext()) {
            Booking b = it.next();
            if (b.getBookingId().equals(bookingId)) {
                b.getRoom().setAvailable(true);
                it.remove();
                System.out.println("Booking " + bookingId + " cancelled.");
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    public void showBookings() {
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }

    public void generateReport() {
        System.out.println("Total Revenue: " + Booking.getTotalRevenue());
        System.out.println("Occupancy Rate: " + Booking.getOccupancyRate(rooms) + "%");
        System.out.println("Most Popular Room Type: " + Booking.getMostPopularRoomType());
    }
}

public class HotelSystemMain {
    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();

        system.addRoom(new Room("R101", "Single", 2000, 1));
        system.addRoom(new Room("R102", "Double", 3000, 2));
        system.addRoom(new Room("R103", "Suite", 5000, 4));
        system.addRoom(new Room("R104", "Double", 3000, 2));
        system.addRoom(new Room("R105", "Single", 2000, 1));

        system.addGuest(new Guest("G001", "Alice", "9876543210", "alice@mail.com"));
        system.addGuest(new Guest("G002", "Bob", "9876543211", "bob@mail.com"));
        system.addGuest(new Guest("G003", "Charlie", "9876543212", "charlie@mail.com"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hotel Reservation Menu ---");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Show All Bookings");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    system.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter Booking ID: ");
                    String bid = sc.next();
                    System.out.print("Enter Guest ID: ");
                    String gid = sc.next();
                    System.out.print("Enter Room Number: ");
                    String rid = sc.next();
                    System.out.print("Enter Check-in Date: ");
                    String in = sc.next();
                    System.out.print("Enter Check-out Date: ");
                    String out = sc.next();
                    System.out.print("Enter Number of Nights: ");
                    int nights = sc.nextInt();
                    system.makeReservation(bid, gid, rid, in, out, nights);
                    break;
                case 3:
                    System.out.print("Enter Booking ID to cancel: ");
                    String cbid = sc.next();
                    system.cancelReservation(cbid);
                    break;
                case 4:
                    system.showBookings();
                    break;
                case 5:
                    system.generateReport();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
