package loggingsystem;

import java.io.PrintWriter;

public class Administrator extends RegularUser {
    private int id;

    public Administrator() {
        super();
        this.id = 0;
    }

    public Administrator(String username, int id) {
        super(username);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void signIn(String dateAndTime, PrintWriter logFile) {
        logFile.println("Administrator " + getUsername() + " (" + id + ") signed in @ " + dateAndTime);
    }

    @Override
    public void signOut(String dateAndTime, PrintWriter logFile) {
        logFile.println("Administrator " + getUsername() + " (" + id + ") signed out @ " + dateAndTime);
    }
}
