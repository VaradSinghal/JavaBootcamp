class FoodOrder {
    String customerName;
    String foodItem;
    int quantity;
    double price;
    static final double fixedRate = 150; // default price per item

    FoodOrder() {
        this.customerName = "Unknown";
        this.foodItem = "Unknown";
        this.quantity = 0;
        this.price = 0;
    }

    FoodOrder(String foodItem) {
        this.customerName = "Unknown";
        this.foodItem = foodItem;
        this.quantity = 1;
        this.price = fixedRate;
    }

    FoodOrder(String foodItem, int quantity) {
        this.customerName = "Unknown";
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * fixedRate;
    }

    FoodOrder(String customerName, String foodItem, int quantity) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * fixedRate;
    }

    void printBill() {
        System.out.println("----- Food Order -----");
        System.out.println("Customer: " + customerName);
        System.out.println("Food Item: " + foodItem);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: ₹" + price);
        System.out.println("---------------------\n");
    }
    public static void main(String[] args) {
        FoodOrder order1 = new FoodOrder();
        FoodOrder order2 = new FoodOrder("Pizza");
        FoodOrder order3 = new FoodOrder("Burger", 3);
        FoodOrder order4 = new FoodOrder("Varad", "Pasta", 2);

        order1.printBill();
        order2.printBill();
        order3.printBill();
        order4.printBill();
    }
}
