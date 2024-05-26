package Railroad_Cars;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

abstract class RailroadCar {
    protected double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public abstract double volume();
}

class TankCar extends RailroadCar {
    private double radius;

    public TankCar() {
    }

    public TankCar(double length, double radius) {
        this.length = length;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * length;
    }
}

class BoxCar extends RailroadCar {
    private double width;
    private double height;

    public BoxCar() {
    }

    public BoxCar(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double volume() {
        return length * width * height;
    }
}

class RefrigeratorCar extends BoxCar {
    private int temperature;

    public RefrigeratorCar() {
    }

    public RefrigeratorCar(double length, double width, double height, int temperature) {
        super(length, width, height);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}

public class Railroad_Cars {
    public static void main(String[] args) {
        RailroadCar car = null;
        try (Scanner scanner = new Scanner(new File("cars_1.txt"));
             PrintWriter writer = new PrintWriter("volumes_1.txt")) {
            while (scanner.hasNext()) {
                String carType = scanner.next();

                switch (carType) {
                    case "Tank":
                        double length = scanner.nextDouble();
                        double radius = scanner.nextDouble();
                        car = new TankCar(length, radius);
                        break;

                    case "Box":
                        length = scanner.nextDouble();
                        double width = scanner.nextDouble();
                        double height = scanner.nextDouble();
                        car = new BoxCar(length, width, height);
                        break;

                    case "Refrigerator":
                        length = scanner.nextDouble();
                        width = scanner.nextDouble();
                        height = scanner.nextDouble();
                        int temperature = scanner.nextInt();
                        car = new RefrigeratorCar(length, width, height, temperature);
                        break;
                }

                if (car != null) {
                    writer.printf("%.2f%n", car.volume());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}