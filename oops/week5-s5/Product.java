import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

// a. Immutable Product class
public final class Product implements Serializable {
    private final String productId;
    private final String name;
    private final String category;
    private final String manufacturer;
    private final double basePrice;
    private final double weight;
    private final String[] features;
    private final Map<String, String> specifications;

    private Product(String productId, String name, String category, String manufacturer,
                    double basePrice, double weight, String[] features, Map<String, String> specifications) {
        if (productId == null || name == null || category == null || manufacturer == null || basePrice < 0 || weight < 0) {
            throw new IllegalArgumentException("Invalid product details");
        }
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.basePrice = basePrice;
        this.weight = weight;
        this.features = features != null ? Arrays.copyOf(features, features.length) : new String[0];
        this.specifications = specifications != null ? new HashMap<>(specifications) : new HashMap<>();
    }

    public static Product createElectronics(String id, String name, String manufacturer, double basePrice, double weight,
                                            String[] features, Map<String, String> specifications) {
        return new Product(id, name, "Electronics", manufacturer, basePrice, weight, features, specifications);
    }

    public static Product createClothing(String id, String name, String manufacturer, double basePrice, double weight,
                                         String[] features, Map<String, String> specifications) {
        return new Product(id, name, "Clothing", manufacturer, basePrice, weight, features, specifications);
    }

    public static Product createBooks(String id, String name, String manufacturer, double basePrice, double weight,
                                      String[] features, Map<String, String> specifications) {
        return new Product(id, name, "Books", manufacturer, basePrice, weight, features, specifications);
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getManufacturer() { return manufacturer; }
    public double getBasePrice() { return basePrice; }
    public double getWeight() { return weight; }
    public String[] getFeatures() { return Arrays.copyOf(features, features.length); }
    public Map<String, String> getSpecifications() { return new HashMap<>(specifications); }

    public final double calculateTax(String region) {
        switch (region.toLowerCase()) {
            case "us": return basePrice * 0.07;
            case "eu": return basePrice * 0.20;
            case "in": return basePrice * 0.18;
            default: return basePrice * 0.10;
        }
    }

    @Override
    public String toString() {
        return "Product{" + "id='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", basePrice=" + basePrice +
                ", weight=" + weight +
                ", features=" + Arrays.toString(features) +
                ", specifications=" + specifications + '}';
    }
}

// b. Customer class
class Customer {
    private final String customerId;
    private final String email;
    private final String accountCreationDate;
    private String name;
    private String phoneNumber;
    private String preferredLanguage;

    public Customer(String customerId, String email, String accountCreationDate, String name) {
        if (customerId == null || email == null || accountCreationDate == null) {
            throw new IllegalArgumentException("Invalid customer data");
        }
        this.customerId = customerId;
        this.email = email;
        this.accountCreationDate = accountCreationDate;
        this.name = name;
    }

    public String getCustomerId() { return customerId; }
    public String getEmail() { return email; }
    public String getAccountCreationDate() { return accountCreationDate; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getPreferredLanguage() { return preferredLanguage; }
    public void setPreferredLanguage(String preferredLanguage) { this.preferredLanguage = preferredLanguage; }

    String getCreditRating() {
        return "Good"; // internal use only
    }

    public String getPublicProfile() {
        return "Customer{name='" + name + "', language='" + preferredLanguage + "'}";
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + customerId + '\'' +
                ", email='" + email + '\'' +
                ", created='" + accountCreationDate + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phoneNumber + '\'' +
                ", language='" + preferredLanguage + '\'' +
                '}';
    }
}

// c. ShoppingCart class
class ShoppingCart {
    private final String cartId;
    private final String customerId;
    private final List<Object> items = new ArrayList<>();
    private double totalAmount;
    private int itemCount;

    public ShoppingCart(String cartId, String customerId) {
        this.cartId = cartId;
        this.customerId = customerId;
    }

    public boolean addItem(Object product, int quantity) {
        if (!(product instanceof Product) || quantity <= 0) return false;
        Product p = (Product) product;
        items.add(p);
        totalAmount += p.getBasePrice() * quantity;
        itemCount += quantity;
        return true;
    }

    private double calculateDiscount() {
        if (itemCount > 10) return totalAmount * 0.1;
        return 0;
    }

    String getCartSummary() {
        return "Cart{" + "id='" + cartId + "', customerId='" + customerId + "', items=" + itemCount +
                ", total=" + (totalAmount - calculateDiscount()) + '}';
    }
}

// d. Constructor chaining for orders
class Order {
    private final String orderId;
    private final LocalDateTime orderTime;
    private final Customer customer;
    private final ShoppingCart cart;
    private final String orderType;

    public Order(Customer guest, ShoppingCart cart) {
        this("ORD-" + UUID.randomUUID(), LocalDateTime.now(), guest, cart, "Guest Checkout");
    }

    public Order(Customer registered, ShoppingCart cart, boolean premium) {
        this("ORD-" + UUID.randomUUID(), LocalDateTime.now(), registered, cart,
                premium ? "Premium Member" : "Registered Customer");
    }

    public Order(Customer corporate, ShoppingCart cart, String companyName) {
        this("ORD-" + UUID.randomUUID(), LocalDateTime.now(), corporate, cart,
                "Corporate Account - " + companyName);
    }

    private Order(String orderId, LocalDateTime orderTime, Customer customer, ShoppingCart cart, String type) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.customer = customer;
        this.cart = cart;
        this.orderType = type;
    }

    public String getOrderId() { return orderId; }
    public LocalDateTime getOrderTime() { return orderTime; }
    public String getOrderType() { return orderType; }
    public Customer getCustomer() { return customer; }
    public ShoppingCart getCart() { return cart; }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + orderId + '\'' +
                ", time=" + orderTime +
                ", type='" + orderType + '\'' +
                ", customer=" + customer.getCustomerId() +
                ", cart=" + cart.getCartSummary() +
                '}';
    }
}

// e. Order processing classes
class PaymentProcessor {
    private final String processorId;
    private final String securityKey;

    public PaymentProcessor(String processorId, String securityKey) {
        this.processorId = processorId;
        this.securityKey = securityKey;
    }

    public boolean processPayment(double amount) {
        return amount > 0;
    }
}

class ShippingCalculator {
    private final Map<String, Double> shippingRates;

    public ShippingCalculator(Map<String, Double> shippingRates) {
        this.shippingRates = new HashMap<>(shippingRates);
    }

    public double calculateShipping(String region, double weight) {
        return shippingRates.getOrDefault(region, 10.0) * weight;
    }
}

// f. Final ECommerceSystem
final class ECommerceSystem {
    private static final Map<String, Object> productCatalog = new HashMap<>();

    public static boolean processOrder(Object order, Object customer) {
        if (!(order instanceof Order) || !(customer instanceof Customer)) return false;
        return true;
    }

    public static void addProduct(Product product) {
        productCatalog.put(product.getProductId(), product);
    }

    public static Product getProduct(String id) {
        return (Product) productCatalog.get(id);
    }
}
