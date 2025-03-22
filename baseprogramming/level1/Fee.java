public class Fee{
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;

        double discount = (fee * discountPercent) / 100.0; // Calculate discount amount
        double finalFee = fee - discount; // Calculate final fee after discount

        System.out.println(String.format(
            "The discount amount is INR %.2f and final discounted fee is INR %.2f",
            discount, finalFee
        ));
    }
}
