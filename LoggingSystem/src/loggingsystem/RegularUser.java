package loggingsystem;

import java.io.PrintWriter;

public class RegularUser {
    private String username;

    public RegularUser() {
        this.username = "";
    }

    public RegularUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void signIn(String dateAndTime, PrintWriter logFile) {
        logFile.println("Regular user " + username + " signed in @ " + dateAndTime);
    }

    public void signOut(String dateAndTime, PrintWriter logFile) {
        logFile.println("Regular user " + username + " signed out @ " + dateAndTime);
    }
}

