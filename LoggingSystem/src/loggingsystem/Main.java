package loggingsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("users.txt");
        File outputFile = new File("log.txt");

        try (Scanner scanner = new Scanner(inputFile);
             PrintWriter logFile = new PrintWriter(outputFile)) {

            RegularUser user = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                Scanner lineScanner = new Scanner(line);
                String activity = lineScanner.next();
                String userType = lineScanner.next();

                if (userType.equals("REG")) {
                    String username = lineScanner.next();
                    user = new RegularUser(username);
                } else if (userType.equals("ADM")) {
                    String username = lineScanner.next();
                    int id = lineScanner.nextInt();
                    user = new Administrator(username, id);
                }

                String dateAndTime = lineScanner.nextLine().trim();

                if (activity.equals("IN")) {
                    user.signIn(dateAndTime, logFile);
                } else if (activity.equals("OUT")) {
                    user.signOut(dateAndTime, logFile);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
