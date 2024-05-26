package CalendarGenerator;

import java.util.Scanner;
import java.time.DayOfWeek;
import java.time.Month;

public class CalendarGenerator {

    public static void main(String[] args) {

        // Set up input scanner to read from standard input
        Scanner input = new Scanner(System.in);

        // Get year input from user
        System.out.print("Enter a 4-digit year: ");
        int year = input.nextInt();

        // Get month input from user
        System.out.print("Enter a month (1-12): ");
        int month = input.nextInt();

        // Get day-of-week of the first day of the month from user
        System.out.print("Enter the day-of-week of the first day of the month (e.g. Mon): ");
        String dayOfWeekString = input.next();
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(dayOfWeekString.toUpperCase());

        // Determine if input year is a leap year
        boolean isLeapYear = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }

        // Determine number of days in the input month
        int numDaysInMonth;
        if (month == 2) {
            numDaysInMonth = isLeapYear ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            numDaysInMonth = 30;
        } else {
            numDaysInMonth = 31;
        }

        // Print calendar header
        String monthName = Month.of(month).name();
        String yearString = String.valueOf(year);
        int headerWidth = 27;
        int numSpaces = (headerWidth - monthName.length() - yearString.length()) / 2;
        System.out.print(" ".repeat(numSpaces) + monthName + " " + yearString);
        if ((headerWidth - numSpaces * 2 - monthName.length() - yearString.length()) % 2 != 0) {
            System.out.print(" ");
        }
        System.out.println("\nSun Mon Tue Wed Thu Fri Sat");

        // Print calendar days
        for (int i = 1; i <= numDaysInMonth; i++) {
            if (i == 1) {
                // Print leading spaces for the first row based on the day of week
                for (int j = 0; j < dayOfWeek.getValue() - 1; j++) {
                    System.out.print("    ");
                }
            }
            // Print the day of the month, padded with leading spaces if necessary
            System.out.printf("%3d ", i);
            // If this is the last day of a week, start a new line
            if ((i + dayOfWeek.getValue() - 1) % 7 == 0) {
                System.out.println();
            }
        }
        // Print a final newline character to end the calendar
        System.out.println();
    }
}
