package First;

import java.util.Scanner;

public class Solver {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        Discriminant d = new Discriminant(a, b, c);

        if (d.getDiscriminant() < 0){
            System.out.println("No roots");
        } else  if (d.getDiscriminant() == 0) {
           double x = (-b)/(2*a);
           System.out.println("One root: " + x);
        } else {
            double x1 = (-b+Math.pow(d.getDiscriminant(), 0.5))/(2*a);
            double x2 = (-b-Math.pow(d.getDiscriminant(), 0.5))/(2*a);
            System.out.println("Two roots: " + x1 + " and " + x2);
        }
    }

    static class Discriminant {
        private double a;
        private double b;
        private double c;

        public Discriminant(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getDiscriminant() {
            return b * b - 4 * a * c;
        }
    }
}
