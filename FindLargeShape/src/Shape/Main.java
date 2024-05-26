package Shape;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	  public static void main(String[] args) {

	    Shape shape1 = null;
	    Shape shape2 = null;
	    StringBuilder sb = new StringBuilder(); // declare StringBuilder object

	    try {
	      File inputFile = new File("shapes_1.txt");
	      Scanner scanner = new Scanner(inputFile);
	      File outputFile = new File("result_1.txt");
	      FileWriter writer = new FileWriter(outputFile);

	      while (scanner.hasNextLine()) {
	        String line = scanner.nextLine().trim();

	        if (line.isEmpty()) {
	          continue;
	        }

	        String[] tokens = line.split("\\s+");
	        String name1 = tokens[0];
	        double dim1 = Double.parseDouble(tokens[1]);
	        String name2 = tokens[2];
	        double dim2 = Double.parseDouble(tokens[3]);

	        if (name1.equalsIgnoreCase("square")) {
	          shape1 = new Square(dim1);
	        } else {
	          shape1 = new Circle(dim1);
	        }

	        if (name2.equalsIgnoreCase("square")) {
	          shape2 = new Square(dim2);
	        } else {
	          shape2 = new Circle(dim2);
	        }

	        Shape largerShape = shape1.compareTo(shape2) > 0 ? shape1 : shape2;

	        // replace System.out.println with calls to sb.append
	        sb.append(largerShape.whatAmI() + "\n");

	        writer.write("Between " + shape1.whatAmI() + " with " + shape1.area() + " area and " + shape2.whatAmI() +
	                     " with " + shape2.area() + " area, the " + largerShape.whatAmI() + " is larger." + "\n");
	      }

	      scanner.close();
	      writer.close();

	      // write the contents of the StringBuilder to the output file
	      FileWriter outputWriter = new FileWriter(outputFile);
	      outputWriter.write(sb.toString());
	      outputWriter.close();

	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	}
