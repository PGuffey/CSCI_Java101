package islandPerimeter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IslandPerimeter {
    
    public static int calcPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Loop through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // If the current cell is land, check the neighboring cells
                    // If the neighboring cell is water, increase the perimeter
                    // If the neighboring cell is out of bounds, increase the perimeter
                    // This effectively counts the number of water cells surrounding each land cell
                    // and adds to the perimeter accordingly
                    // Note: this assumes the grid has valid boundaries (no out-of-bounds access)
                    if (i == 0 || grid[i-1][j] == 0) {
                        perimeter++; // top
                    }
                    if (j == cols-1 || grid[i][j+1] == 0) {
                        perimeter++; // right
                    }
                    if (i == rows-1 || grid[i+1][j] == 0) {
                        perimeter++; // bottom
                    }
                    if (j == 0 || grid[i][j-1] == 0) {
                        perimeter++; // left
                    }
                }
            }
        }

        return perimeter;
    }
    
    public static void main(String[] args) {
        // Read input file
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("island.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Prints the stack trace of the exception to the console
        }
        int rows = scanner.nextInt(); // Read the number of rows in the grid
        int cols = scanner.nextInt(); // Read the number of columns in the grid
        int[][] grid = new int[rows][cols]; // Create a 2D array to store the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt(); // Read the value of each cell in the grid
            }
        }
        scanner.close(); // Close the input file

        // Calculate perimeter of the island
        int perimeter = calcPerimeter(grid);

        // Write output file
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File("perimeter.txt")); // Create an output file
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Prints the stack trace of the exception to the console
        }
        writer.println(perimeter); // Write the calculated perimeter to the output file
        writer.close(); // Close the output file
    }
}