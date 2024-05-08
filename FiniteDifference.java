import java.util.Scanner;

public class FiniteDifference {
    public static double function(double x) {
        return x * x;
    }

    public static double finiteDifference(double x, double h) {
        double fx = function(x);
        double fxh = function(x + h);
        return (fxh - fx) / h;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a value of x to approximate the derivative: ");
        double x = scanner.nextDouble();

        System.out.print("Enter a small step size (h): ");
        double h = scanner.nextDouble();

        double derivative = finiteDifference(x, h);

        System.out.println("\nThe estimated derivative of f(x) = x^2 at x = " + x + " is: " + derivative);

        scanner.close();
    }
}
