import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        read();
    }
    public static void read() {
        Scanner scanner = new Scanner(System.in);
        int employees;
        String day;
        do {
            System.out.println("Please enter employees number");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
            }
            employees = scanner.nextInt();
        } while (employees > 100 || employees < 0);

        do {
            System.out.println("Please enter valid day");
            while (!scanner.hasNextLine()) {
                String input = scanner.next();
            }
            day = scanner.nextLine();
        } while (!Days.contains(day.toUpperCase()));

        System.out.println("Day of week: "+ Days.dayValue(day) + "," +"\nOffice Occupancy " +
                Days.of(Days.dayValue(day.toUpperCase())).getOccupancy(employees) + "%");
    }
}
