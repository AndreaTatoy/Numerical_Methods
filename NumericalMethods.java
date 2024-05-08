import java.util.Scanner;

public class NumericalMethods {

    public static void antiDifferentiation() {
        Scanner scanner = new Scanner(System.in);

        int m = -1;
        while (m < 0 || m > 20) {
            System.out.print("\nEnter an integer value for m (from 0 to 20): ");
            m = scanner.nextInt();

            if (m < 0 || m > 20) {
                System.out.println("Invalid input. Please enter a value between 0 and 20.");
            }
        }

        String result = antiDifferentiate(m);

        System.out.println("\nThe antiderivative of x^-" + m + " is:");
        System.out.println(result);
    }

    public static String antiDifferentiate(int m) {
        String process = "";
        String result = "";  

        if (m == 1) {
            process = "Since the derivative of ln(x) is 1/x, the antiderivative of x^-1 is ln(x).";
            result = "ln(x) + C";
        } else {
            int power = -m + 1;
            double coefficient = 1.0 / power; 
            process = "The power of x increases by one (from -" + m + " to " + power + ").\n"
                    + "The new coefficient is 1 / " + power + " = " + coefficient + ".";
            result = String.format("%.2f * x^ %d + C", coefficient, power);
        }

        System.out.println("\n" + process);

        return result; 
    }

    public static void finiteDifference() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a value of x to approximate the derivative: ");
        double x = scanner.nextDouble();

        System.out.print("Enter a small step size (h): ");
        double h = scanner.nextDouble();

        double derivative = finiteDifference(x, h);

        System.out.println("\nThe estimated derivative of f(x) = x^2 at x = " + x + " is: " + derivative);
    }

    public static double finiteDifference(double x, double h) {
        double fx = x * x;  
        double fxh = (x + h) * (x + h);  
        return (fxh - fx) / h;
    }

    public static void lagrangeInterpolation() {
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

        System.out.println("");
        double yp = lagrangeInterpolation(x, y, xp);

        System.out.println("\nInterpolated value at x = " + xp + " is: " + yp);
    }

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

        System.out.print("\nHello! Welcome! \n");

        while (true) {
            System.out.print("\nMENU" 
            + "\n1. Anti-Differentiation"
            + "\n2. Finite Difference"
            + "\n3. Lagrange Interpolation"
            + "\n4. Exit"
            + "\n\nPlease enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    antiDifferentiation();
                    break;
                case 2:
                    finiteDifference();
                    break;
                case 3:
                    lagrangeInterpolation();
                    break;
                case 4:
                    System.out.println("\nProgrammer: Tatoy, Louise Andrea R."
                                        + "\nExiting... \n");
                    scanner.close();
                    return;  
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}
