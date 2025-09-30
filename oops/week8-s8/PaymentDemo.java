interface PaymentGateway {
    void pay(double amount);
    void refund(double amount);
}

class CreditCardPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid via Credit Card: " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund to Credit Card: " + amount);
    }
}

class UPIPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid via UPI: " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund to UPI: " + amount);
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentGateway p1 = new CreditCardPayment();
        p1.pay(5000);
        p1.refund(1000);

        PaymentGateway p2 = new UPIPayment();
        p2.pay(2000);
        p2.refund(500);
    }
}
