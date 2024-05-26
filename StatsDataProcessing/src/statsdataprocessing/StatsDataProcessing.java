package statsdataprocessing;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StatsDataProcessing {
    public static void main(String[] args) throws IOException {
        // Define input and output filenames      
    	String inputFilename = "data_1.txt";
        String outputFilename = "results_1.txt";
     
        // Initialize lists to store x and y values
        List<Double> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();
   
        // Initialize variables for summing x and y values, their squares, and their product
        double sumX = 0, sumY = 0, sumX2 = 0, sumY2 = 0, sumXY = 0;
  
        // Read input file using a BufferedReader
        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFilename))) {
            String line;
            // Read each line and split it into x and y values
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 2) {
                    double x = Double.parseDouble(parts[0]);
                    double y = Double.parseDouble(parts[1]);
                  
                    // Add x and y values to their respective lists
                    xValues.add(x);
                    yValues.add(y);
                
                    // Update the sums for x, y, x^2, y^2, and xy  
                    sumX += x;
                    sumY += y;
                    sumX2 += x * x;
                    sumY2 += y * y;
                    sumXY += x * y;
                }
            }
        }
        
        // Calculate the number of data pairs, averages, standard deviations, and correlation coefficient
        int n = xValues.size();
        double avgX = sumX / n;
        double avgY = sumY / n;
        double stdDevX = Math.sqrt((sumX2 / n) - (avgX * avgX));
        double stdDevY = Math.sqrt((sumY2 / n) - (avgY * avgY));
        double correlation = (n * sumXY - sumX * sumY) /
                Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));

        // Calculate the slope and intercept for the linear fitting function
        double denominator = n * sumX2 - sumX * sumX;
        double a = (sumY * sumX2 - sumX * sumXY) / denominator;
        double b = (n * sumXY - sumX * sumY) / denominator;
     
        // Initialize a DecimalFormat to format output numbers
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat df = (DecimalFormat) nf;
        df.applyPattern("0.0000");
 
        // Format the output string
        String output = String.format(Locale.US,
                "Number of x-y pairs read: %d%n%n" +
                        "Algebraic average of x: %s%n" +
                        "Algebraic average of y: %s%n" +
                        "Standard deviation of x: %s%n" +
                        "Standard deviation of y: %s%n%n" +
                        "Correlation coefficient: %s%n%n" +
                        "Linear fitting function:%n" +
                        "y = %sX + %s%n" +
                        "Slope: %s%n" +
                        "Intercept: %s",
                n,
                df.format(avgX),
                df.format(avgY),
                df.format(stdDevX),
                df.format(stdDevY),
                df.format(correlation),
                df.format(b),
                df.format(a),
                df.format(b),
                df.format(a));
    
        // Print the output to the console
        System.out.println(output);
     // Write the output to a file using a BufferedWriter
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputFilename))) {
            bw.write(output);
        }
    }
}