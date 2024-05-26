package packing;

import java.io.*;
import java.util.*;

/**
 * The class Packing calculates the maximum number of small boxes that can fit inside a large box.
 * The dimensions of the small box and the large box are read from the file 'dimensions.txt'.
 * The result of the calculation is written to the file 'result.txt'.
 */
public class Packing {
  public static void main(String[] args) {
    Scanner input = null;
    PrintWriter output = null;
    
    /**
     * Try to open and read from the file 'dimensions.txt',
     * and to open and write to the file 'result.txt'.
     * If any errors occur, catch the exception and print the error message.
     */
    try {
      // Open the file 'dimensions.txt' for reading.
      input = new Scanner(new File("dimensions.txt"));
      // Open the file 'result.txt' for writing.
      output = new PrintWriter(new File("result.txt"));
      
      // Read the dimensions of the small box from the file 'dimensions.txt'.
      int smallBox = input.nextInt();
      // Read the dimensions of the large box from the file 'dimensions.txt'.
      int largeBoxLength = input.nextInt();
      int largeBoxWidth = input.nextInt();
      int largeBoxHeight = input.nextInt();
      
      // Calculate the maximum number of small boxes that can fit inside the large box.
      int maxNumberOfSmallBoxes = (largeBoxLength / smallBox) * (largeBoxWidth / smallBox) * (largeBoxHeight / smallBox);
      
      // Write the result to the file 'result.txt'.
      output.println(maxNumberOfSmallBoxes);
      
    } catch (Exception e) {
      // If an error occurs, print the error message.
      System.out.println("Error: " + e);
    } finally {
      // Close the file 'dimensions.txt' and 'result.txt' even if an error occurred.
      if (input != null) {
        input.close();
      }
      if (output != null) {
        output.close();
      }
    }
  }
}
