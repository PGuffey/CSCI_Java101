package IslandPerimeter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IslandPerimeter {
    
    /**
     * Calculates the perimeter of the island in the grid.
     *
     * @param grid a 2-dimensional array of integers (0 or 1) representing the grid of land/water.
     * @return the calculated perimeter of the island.
     */
    public static int calcPerimeter(int[][] grid) {
        int perimeter = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // If the current cell is land, add its border to the perimeter.
                    perimeter += 4;
                    
                    // Check the cell's neighbors to subtract the common border.
                    if (i > 0 && grid[i-1][j] == 1) {
                        perimeter -= 2;
                    }
                    if (j > 0 && grid[i][j-1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        
        return perimeter;
    }
    
    public static void main(String[] args) {
        // Read the input file.
        File inputFile = new File("island.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found.");
            return;
        }
        
        // Read the grid dimensions.
        int numRows = scanner.nextInt();
        int numCols = scanner.nextInt();
        
        // Create the 2-dimensional array.
        int[][] grid = new int[numRows][numCols];
        
        // Read the grid values.
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        
        // Close the input file.
        scanner.close();
        
        // Calculate the perimeter of the island.
        int perimeter = calcPerimeter(grid);
        
        // Write the output file.
        File outputFile = new File("perimeter.txt");
        try {
            PrintWriter writer = new PrintWriter(outputFile);
            writer.println(perimeter);
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("Output file not found.");
        }
    }
}