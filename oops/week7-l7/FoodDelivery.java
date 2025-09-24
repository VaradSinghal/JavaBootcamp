public class FoodDelivery {

    public void calculateDelivery(double distance) {
        double cost = distance * 10;
        System.out.println("Basic Delivery: Distance = " + distance + " km | Cost = ₹" + cost);
    }

    public void calculateDelivery(double distance, double priorityFee) {
        double cost = (distance * 10) + priorityFee;
        System.out.println("Premium Delivery: Distance = " + distance + " km + Priority Fee = ₹" + priorityFee + " | Total = ₹" + cost);
    }

    public void calculateDelivery(double distance, int orders) {
        double baseCost = distance * 10;
        double discount = orders * 5;
        double finalCost = baseCost - discount;
        if (finalCost < 0) finalCost = 0;
        System.out.println("Group Delivery: Distance = " + distance + " km | Orders = " + orders + " | Discount = ₹" + discount + " | Total = ₹" + finalCost);
    }

    public void calculateDelivery(double distance, double discountPercent, double freeLimit) {
        double cost = distance * 10;
        if (cost >= freeLimit) {
            System.out.println("Festival Special: Free delivery! (Order above ₹" + freeLimit + ")");
        } else {
            double discount = (cost * discountPercent) / 100;
            double finalCost = cost - discount;
            System.out.println("Festival Special: Distance = " + distance + " km | Discount = " + discountPercent + "% | Total = ₹" + finalCost);
        }
    }

    public static void main(String[] args) {
        FoodDelivery delivery = new FoodDelivery();
        delivery.calculateDelivery(5);
        delivery.calculateDelivery(8, 50.0);
        delivery.calculateDelivery(10, 3);
        delivery.calculateDelivery(12, 20.0, 150.0);
    }
}
