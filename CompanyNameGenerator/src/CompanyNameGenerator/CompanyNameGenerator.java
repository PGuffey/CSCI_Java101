package CompanyNameGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CompanyNameGenerator {

    public static void main(String[] args) {
        
        // Define input and output file paths
        String inputFilePath = "input/words.txt";
        String outputFilePath = "output/names.txt";
        
        // Create ArrayLists to store the words in each column
        ArrayList<String> column1 = new ArrayList<String>();
        ArrayList<String> column2 = new ArrayList<String>();
        
        // Read the input file and add words to the ArrayLists
        try {
            // Open the input file
            File inputFile = new File(inputFilePath);
            Scanner inputScanner = new Scanner(inputFile);
            
            // Loop through each line of the input file
            while (inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine().trim();
                
                // Ignore empty lines
                if (!line.isEmpty()) {
                    // Split the line into words using space as a delimiter
                    String[] words = line.split("\\s+");
                    
                    // Add the first word to column1 and the second word to column2
                    column1.add(words[0]);
                    column2.add(words[1]);
                }
            }
            
            // Close the input file
            inputScanner.close();
            
        } catch (FileNotFoundException e) {
            // Print an error message if the input file is not found
            e.printStackTrace();
        }
        
        // Generate all possible company names and write them to the output file
        try {
            // Create a PrintWriter to write to the output file
            PrintWriter writer = new PrintWriter(outputFilePath);
            
            // Loop through each word in column1
            for (String word1 : column1) {
                // Loop through each word in column2
                for (String word2 : column2) {
                    // Make sure the two words are not the same
                    if (!word1.equals(word2)) {
                        // Concatenate the two words with a space in between to create a company name
                        String companyName = word1 + " " + word2;
                        
                        // Write the company name to the output file
                        writer.println(companyName);
                    }
                }
            }
            
            // Close the PrintWriter
            writer.close();
            
        } catch (FileNotFoundException e) {
            // Print an error message if the output file is not found
            e.printStackTrace();
        }
        
        // Print a success message to the console
        System.out.println("Company names generated successfully!");
    }
}