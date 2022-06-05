package problem478;

import java.util.Random;

public class Solution478 {

    private double radius;

    private double x_center;

    private double y_center;
    private Random random;

    public Solution478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.random = new Random();
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * radius) - radius;
            double y = random.nextDouble() * (2 * radius) - radius;
            if (x * x + y * y <= radius * radius) {
                return new double[]{x_center + x, y_center + y};
            }
        }
    }

}
