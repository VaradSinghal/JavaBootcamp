class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    Book() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.isAvailable = true;
    }

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = "";
        this.isAvailable = true;
    }

    Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    void borrowBook() {
        if(isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is currently not available.");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    void displayBookInfo() {
        System.out.println("----- Book Info -----");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("---------------------\n");
    }


    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("The Alchemist", "Paulo Coelho", "1234567890", true);

        book1.displayBookInfo();
        book2.displayBookInfo();
        book3.displayBookInfo();

        book2.borrowBook();
        book3.borrowBook();

        book2.displayBookInfo();
        book3.displayBookInfo();

        book2.returnBook();
        book2.displayBookInfo();
    }
}
