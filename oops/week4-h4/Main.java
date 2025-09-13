class MovieTicket {
    String movieName;
    String theatreName;
    int seatNumber;
    double price;

    MovieTicket() {
        this("Unknown", "PVR", 0, 200);
    }

    MovieTicket(String movieName) {
        this(movieName, "PVR", 0, 200);
    }

    MovieTicket(String movieName, int seatNumber) {
        this(movieName, "PVR", seatNumber, 200);
    }

    MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void printTicket() {
        System.out.println("----- Movie Ticket -----");
        System.out.println("Movie Name: " + movieName);
        System.out.println("Theatre Name: " + theatreName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: ₹" + price);
        System.out.println("------------------------\n");
    }
}

public class Main {
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket();
        MovieTicket ticket2 = new MovieTicket("Avatar");
        MovieTicket ticket3 = new MovieTicket("Inception", 12);
        MovieTicket ticket4 = new MovieTicket("Interstellar", "INOX", 5, 350);

        ticket1.printTicket();
        ticket2.printTicket();
        ticket3.printTicket();
        ticket4.printTicket();
    }
}
