public class HotelBooking {

    public void calculatePrice(String roomType, int nights) {
        double rate = getRate(roomType);
        double total = rate * nights;
        System.out.println("Standard Booking: " + roomType + " for " + nights + " nights | Total = ₹" + total);
    }

    public void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        double rate = getRate(roomType);
        double total = rate * nights * seasonalMultiplier;
        System.out.println("Seasonal Booking: " + roomType + " for " + nights + " nights | Multiplier = " + seasonalMultiplier + " | Total = ₹" + total);
    }

    public void calculatePrice(String roomType, int nights, double corporateDiscount, boolean mealIncluded) {
        double rate = getRate(roomType);
        double total = rate * nights;
        double discountAmount = total * corporateDiscount / 100;
        total -= discountAmount;
        if (mealIncluded) total += 500; 
        System.out.println("Corporate Booking: " + roomType + " for " + nights + " nights | Discount = " + corporateDiscount + "% | Meal included = " + mealIncluded + " | Total = ₹" + total);
    }

    public void calculatePrice(String roomType, int nights, int guestCount, double decorationFee, boolean catering) {
        double rate = getRate(roomType);
        double total = rate * nights;
        total += decorationFee;
        if (catering) total += guestCount * 200; 
        System.out.println("Wedding Package: " + roomType + " for " + nights + " nights | Guests = " + guestCount + " | Decoration = ₹" + decorationFee + " | Catering = " + catering + " | Total = ₹" + total);
    }

    private double getRate(String roomType) {
        switch (roomType.toLowerCase()) {
            case "deluxe": return 3000;
            case "suite": return 5000;
            default: return 2000;
        }
    }

    public static void main(String[] args) {
        HotelBooking booking = new HotelBooking();
        booking.calculatePrice("Deluxe", 3);
        booking.calculatePrice("Suite", 2, 1.5);
        booking.calculatePrice("Deluxe", 4, 10, true);
        booking.calculatePrice("Suite", 5, 50, 2000, true);
    }
}
