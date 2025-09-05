import java.util.*;

class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;

    private static int totalProducts = 0;
    private static Set<String> categories = new HashSet<>();

    public Product(String productId, String productName, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
        categories.add(category);
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void reduceStock(int quantity) {
        this.stockQuantity -= quantity;
    }

    public void increaseStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    public static List<Product> getProductsByCategory(Product[] products, String category) {
        List<Product> list = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                list.add(p);
            }
        }
        return list;
    }

    public static int getTotalProducts() {
        return totalProducts;
    }

    public static Set<String> getCategories() {
        return categories;
    }

    public String toString() {
        return productId + " - " + productName + " | Price: " + price + " | Category: " + category + " | Stock: " + stockQuantity;
    }
}

class ShoppingCart {
    private String cartId;
    private String customerName;
    private List<Product> products;
    private List<Integer> quantities;
    private double cartTotal;

    public ShoppingCart(String cartId, String customerName) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.cartTotal = 0.0;
    }

    public void addProduct(Product product, int quantity) {
        if (product.getStockQuantity() >= quantity) {
            int index = products.indexOf(product);
            if (index >= 0) {
                quantities.set(index, quantities.get(index) + quantity);
            } else {
                products.add(product);
                quantities.add(quantity);
            }
            product.reduceStock(quantity);
            calculateTotal();
            System.out.println(product.getProductName() + " added to cart.");
        } else {
            System.out.println("Insufficient stock for " + product.getProductName());
        }
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                products.get(i).increaseStock(quantities.get(i));
                System.out.println(products.get(i).getProductName() + " removed from cart.");
                products.remove(i);
                quantities.remove(i);
                calculateTotal();
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public void calculateTotal() {
        cartTotal = 0.0;
        for (int i = 0; i < products.size(); i++) {
            cartTotal += products.get(i).getPrice() * quantities.get(i);
        }
    }

    public void displayCart() {
        System.out.println("\n--- Cart Summary for " + customerName + " ---");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getProductName() + " x " + quantities.get(i) +
                               " = " + (products.get(i).getPrice() * quantities.get(i)));
        }
        System.out.println("Cart Total: " + cartTotal);
        System.out.println("-------------------------------\n");
    }

    public void checkout() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty. Cannot checkout.");
        } else {
            System.out.println("Checkout successful! Total bill: " + cartTotal);
            products.clear();
            quantities.clear();
            cartTotal = 0.0;
        }
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = {
            new Product("P101", "Laptop", 60000, "Electronics", 10),
            new Product("P102", "Phone", 30000, "Electronics", 15),
            new Product("P103", "Headphones", 2000, "Electronics", 30),
            new Product("P104", "Shoes", 2500, "Fashion", 20),
            new Product("P105", "T-Shirt", 800, "Fashion", 40),
            new Product("P106", "Watch", 5000, "Fashion", 25),
            new Product("P107", "Book", 500, "Stationery", 50),
            new Product("P108", "Pen", 50, "Stationery", 100),
            new Product("P109", "Bag", 1500, "Stationery", 35),
            new Product("P110", "Bottle", 300, "Stationery", 60)
        };

        ShoppingCart cart = new ShoppingCart("CART001", "Alice");

        while (true) {
            System.out.println("\n--- Online Shopping Menu ---");
            System.out.println("1. Browse All Products");
            System.out.println("2. Browse Products by Category");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.println("Available categories: " + Product.getCategories());
                    System.out.print("Enter category: ");
                    String cat = sc.next();
                    List<Product> catProducts = Product.getProductsByCategory(products, cat);
                    for (Product p : catProducts) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.print("Enter Product ID: ");
                    String pid = sc.next();
                    Product product = Product.findProductById(products, pid);
                    if (product != null) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        cart.addProduct(product, qty);
                    } else {
                        System.out.println("Invalid Product ID.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Product ID to remove: ");
                    String rid = sc.next();
                    cart.removeProduct(rid);
                    break;
                case 5:
                    cart.displayCart();
                    break;
                case 6:
                    cart.checkout();
                    break;
                case 7:
                    System.out.println("Exiting... Thank you for shopping!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
