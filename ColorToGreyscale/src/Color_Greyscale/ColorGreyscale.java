package Color_Greyscale;

//Import necessary classes for reading and writing files
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//Define a class called ColorGreyscale
public class ColorGreyscale {

 // Define the main method for the program
 public static void main(String[] args) throws FileNotFoundException {
     
     // Read in the input image file
     Scanner input = new Scanner(new File("colorImage.ppm"));

     // Read the magic number from the PPM header
     String magicNumber = input.next();

     // Read the image dimensions from the PPM header
     int width = input.nextInt();
     int height = input.nextInt();

     // Read the color depth from the PPM header
     int colorDepth = input.nextInt();

     // Create a 3D array to store the pixel values
     int[][][] pixels = new int[height][width][3];

     // Read in the pixel values from the input file
     for (int row = 0; row < height; row++) {
         for (int col = 0; col < width; col++) {
             pixels[row][col][0] = input.nextInt(); // red value
             pixels[row][col][1] = input.nextInt(); // green value
             pixels[row][col][2] = input.nextInt(); // blue value
         }
     }

     // Close the input file
     input.close();

     // Convert the pixel values to greyscale
     for (int row = 0; row < height; row++) {
         for (int col = 0; col < width; col++) {
             // Calculate the greyscale value as a weighted sum of the red, green, and blue values
             int grayValue = (int) (0.3 * pixels[row][col][0] + 0.59 * pixels[row][col][1] + 0.11 * pixels[row][col][2]);
             // Set the red, green, and blue values to the greyscale value
             pixels[row][col][0] = grayValue;
             pixels[row][col][1] = grayValue;
             pixels[row][col][2] = grayValue;
         }
     }

     // Write out the output image file
     PrintWriter output = new PrintWriter(new File("grayscaleImage1.ppm"));

     // Write the PPM header to the output file
     output.println(magicNumber);
     output.println(width + " " + height);
     output.println(colorDepth);

     // Write the pixel values to the output file
     for (int row = 0; row < height; row++) {
         for (int col = 0; col < width; col++) {
             // Write out the red, green, and blue values for each pixel
             output.println(pixels[row][col][0]);
             output.println(pixels[row][col][1]);
             output.println(pixels[row][col][2]);
         }
     }

     // Close the output file
     output.close();
 }
}