import java.util.Scanner;

public class AntiDifferentiation {

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
            result = String.format("%.2f * x^ % d + C", coefficient, power);
        }

        System.out.println("Anti-differentiation process:");
        System.out.println(process);
        
        return result;
    }

    public static void main(String[] args) {
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

        scanner.close();
    }
}
