package menugenerator;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Dish {
    private String dishName;
    private int dishType;
    private int dishPrice;

    public Dish() {
        dishName = "";
        dishType = -1;
        dishPrice = -1;
    }

    public Dish(String name, int price, int type) {
        dishName = name;
        dishType = type;
        dishPrice = price;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String name) {
        dishName = name;
    }

    public int getDishType() {
        return dishType;
    }

    public void setDishType(int type) {
        dishType = type;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(int price) {
        dishPrice = price;
    }

    @Override
    public String toString() {
        return dishName + " ($" + dishPrice + ")";
    }

    public static void main(String[] args) {
        ArrayList<Dish> appetizers = new ArrayList<>();
        ArrayList<Dish> entrees = new ArrayList<>();
        ArrayList<Dish> desserts = new ArrayList<>();

        try {
            File inputFile = new File("dishes.txt");
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t+");
                if (parts.length < 3) {
                    throw new IllegalArgumentException("Invalid input format: " + line);
                }
                int type;
                switch (parts[0]) {
                    case "Appetizer":
                        type = 0;
                        break;
                    case "Entree":
                        type = 1;
                        break;
                    case "Dessert":
                        type = 2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid dish type: " + parts[0]);
                }
                int price = Integer.parseInt(parts[1]);
                String name = parts[2].trim();
                Dish dish = new Dish(name, price, type);
                switch (type) {
                    case 0:
                        appetizers.add(dish);
                        break;
                    case 1:
                        entrees.add(dish);
                        break;
                    case 2:
                        desserts.add(dish);
                        break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error parsing input file: " + e.getMessage());
        }

        try {
            PrintWriter writer = new PrintWriter("menu.txt");
            writer.println("Menu");
            writer.println();
            writer.println("Appetizer");
            writer.println();
            for (Dish dish : appetizers) {
                writer.println(dish);
            }
            writer.println();
            writer.println("Entree");
            writer.println();
            for (Dish dish : entrees) {
                writer.println(dish);
            }
            writer.println();
            writer.println("Dessert");
            writer.println();
            for (Dish dish : desserts) {
                writer.println(dish);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error creating output file: " + e.getMessage());
        }
    }
}
