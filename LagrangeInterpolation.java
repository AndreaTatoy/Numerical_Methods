import java.util.Scanner;

public class LagrangeInterpolation {
    public static double lagrangeInterpolation(double[] x, double[] y, double xp) {
        int n = x.length;
        double yp = 0.0;

        for (int i = 0; i < n; i++) {
            double term = y[i];
            System.out.print("L_" + i + "(x) = " + y[i]); 
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double fraction = (xp - x[j]) / (x[i] - x[j]);
                    term = term * fraction;

                    System.out.print(" * ((x - " + x[j] + ") / (" + x[i] + " - " + x[j] + "))");
                }
            }
            System.out.println(" => " + term);
            yp += term;
        }
        return yp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of data points: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.print("Enter the x values: ");
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
        }

        System.out.print("Enter the y values: ");
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextDouble();
        }

        System.out.print("Enter the x value for interpolation: ");
        double xp = scanner.nextDouble();

        System.out.println("\nLagrange Interpolation Process:");
        double yp = lagrangeInterpolation(x, y, xp);

        System.out.println("\nInterpolated value at x = " + xp + " is: " + yp);

        scanner.close();
    }
}
