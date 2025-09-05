import java.time.*;
import java.util.*;

class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private boolean isIssued;
    private String issueDate;
    private String dueDate;
    private int timesIssued;

    public Book(String bookId, String title, String author, String isbn, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.isIssued = false;
        this.issueDate = "";
        this.dueDate = "";
        this.timesIssued = 0;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }
    public String getDueDate() { return dueDate; }
    public int getTimesIssued() { return timesIssued; }

    public void issue(String issueDate, String dueDate) {
        this.isIssued = true;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.timesIssued++;
    }

    public void returnBook() {
        this.isIssued = false;
        this.issueDate = "";
        this.dueDate = "";
    }

    public void renew(String newDueDate) {
        this.dueDate = newDueDate;
    }

    public String toString() {
        return "[" + bookId + "] " + title + " by " + author + (isIssued ? " (Issued, Due: " + dueDate + ")" : " (Available)");
    }
}

class Member {
    private String memberId;
    private String memberName;
    private String memberType;
    private List<Book> booksIssued;
    private double totalFines;
    private String membershipDate;

    private static int totalBooks = 0;
    private static int totalMembers = 0;
    private static String libraryName = "Central Library";
    private static double finePerDay = 5.0;
    private static int maxBooksAllowed = 3;

    public Member(String memberId, String memberName, String memberType, String membershipDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberType = memberType;
        this.membershipDate = membershipDate;
        this.booksIssued = new ArrayList<>();
        this.totalFines = 0.0;
        totalMembers++;
    }

    public String getMemberName() { return memberName; }
    public String getMemberType() { return memberType; }
    public double getTotalFines() { return totalFines; }
    public List<Book> getBooksIssued() { return booksIssued; }

    public void issueBook(Book book) {
        int allowed = getMaxBooksForType();
        if (booksIssued.size() >= allowed) {
            System.out.println(memberName + " cannot issue more than " + allowed + " books.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book already issued.");
            return;
        }
        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(getDueDaysForType());
        book.issue(issueDate.toString(), dueDate.toString());
        booksIssued.add(book);
        System.out.println(memberName + " issued " + book.getTitle() + " | Due: " + dueDate);
    }

    public void returnBook(Book book) {
        if (!booksIssued.contains(book)) {
            System.out.println("This book is not issued by " + memberName);
            return;
        }
        double fine = calculateFine(book);
        totalFines += fine;
        book.returnBook();
        booksIssued.remove(book);
        System.out.println(memberName + " returned " + book.getTitle() + " | Fine: " + fine);
    }

    public double calculateFine(Book book) {
        if (!book.isIssued()) return 0.0;
        LocalDate due = LocalDate.parse(book.getDueDate());
        LocalDate today = LocalDate.now();
        if (today.isAfter(due)) {
            long daysOverdue = Duration.between(due.atStartOfDay(), today.atStartOfDay()).toDays();
            return daysOverdue * finePerDay;
        }
        return 0.0;
    }

    public void renewBook(Book book) {
        if (!booksIssued.contains(book)) {
            System.out.println("Book not issued by this member.");
            return;
        }
        LocalDate newDueDate = LocalDate.now().plusDays(getDueDaysForType());
        book.renew(newDueDate.toString());
        System.out.println("Book renewed till: " + newDueDate);
    }

    public void reserveBook(Book book) {
        if (book.isIssued()) {
            System.out.println("Book " + book.getTitle() + " reserved by " + memberName);
        } else {
            System.out.println("Book is available, no need to reserve.");
        }
    }

    private int getMaxBooksForType() {
        switch (memberType.toLowerCase()) {
            case "student": return 3;
            case "faculty": return 5;
            case "general": return 2;
            default: return maxBooksAllowed;
        }
    }

    private int getDueDaysForType() {
        switch (memberType.toLowerCase()) {
            case "student": return 14;
            case "faculty": return 30;
            case "general": return 10;
            default: return 14;
        }
    }

    public static void generateLibraryReport(List<Member> members, List<Book> books) {
        System.out.println("\n--- Library Report (" + libraryName + ") ---");
        System.out.println("Total Members: " + totalMembers);
        System.out.println("Total Books: " + books.size());
        System.out.println("Overdue Books:");
        for (Book b : getOverdueBooks(books)) {
            System.out.println("  " + b);
        }
        System.out.println("Most Popular Books:");
        for (Book b : getMostPopularBooks(books, 3)) {
            System.out.println("  " + b.getTitle() + " | Times Issued: " + b.getTimesIssued());
        }
        System.out.println("-------------------------------------------\n");
    }

    public static List<Book> getOverdueBooks(List<Book> books) {
        List<Book> overdue = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Book b : books) {
            if (b.isIssued()) {
                LocalDate due = LocalDate.parse(b.getDueDate());
                if (today.isAfter(due)) {
                    overdue.add(b);
                }
            }
        }
        return overdue;
    }

    public static List<Book> getMostPopularBooks(List<Book> books, int count) {
        List<Book> sorted = new ArrayList<>(books);
        sorted.sort((a, b) -> Integer.compare(b.getTimesIssued(), a.getTimesIssued()));
        return sorted.subList(0, Math.min(count, sorted.size()));
    }
}

public class LibrarySystemMain {
    public static void main(String[] args) {
        Book b1 = new Book("B001", "Java Programming", "James Gosling", "1111", "Programming");
        Book b2 = new Book("B002", "Data Structures", "Mark Allen", "2222", "Computer Science");
        Book b3 = new Book("B003", "Database Systems", "Codd", "3333", "Database");
        List<Book> books = new ArrayList<>(Arrays.asList(b1, b2, b3));

        Member m1 = new Member("M001", "Alice", "Student", "2023-01-01");
        Member m2 = new Member("M002", "Bob", "Faculty", "2022-06-01");
        List<Member> members = new ArrayList<>(Arrays.asList(m1, m2));

        m1.issueBook(b1);
        m1.issueBook(b2);
        m2.issueBook(b3);

        m1.renewBook(b1);
        m1.returnBook(b2);

        Member.generateLibraryReport(members, books);
    }
}
