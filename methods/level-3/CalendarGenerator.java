import java.util.Scanner;

public class CalendarGenerator {

    static String[] months = {
        "", "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    static int[] daysInMonth = {
        0, 31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int d = 1;
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        return (d + x + (31 * m) / 12) % 7;
    }

    public static void printCalendar(int month, int year) {
        if (month < 1 || month > 12) {
            System.out.println("Invalid month!");
            return;
        }

        int days = daysInMonth[month];
        if (month == 2 && isLeapYear(year)) {
            days = 29;
        }

        int startDay = getFirstDayOfMonth(month, year);

        System.out.printf("\n  %s %d\n", months[month], year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        printCalendar(month, year);

        sc.close();
    }
}
