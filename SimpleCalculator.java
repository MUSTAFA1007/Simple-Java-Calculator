import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        System.out.println("*************************");
        System.out.println("*** Simple Calculator ***");
        System.out.println("*************************");

        while (isRunning){
            try {
                System.out.print("Enter the first number: ");
                double TheFirstNumber = scanner.nextDouble();

                System.out.print("Enter the symbols(+,-,*,/): ");
                char TheSymbols = scanner.next().charAt(0);

                System.out.print("Enter the second number: ");
                double TheSecondNumber = scanner.nextDouble();

                switch (TheSymbols) {
                    case '+' -> System.out.println("Result: " + (TheFirstNumber + TheSecondNumber));
                    case '-' -> System.out.println("Result: " + (TheFirstNumber - TheSecondNumber));
                    case '*' -> System.out.println("Result: " + (TheFirstNumber * TheSecondNumber));
                    case '/' -> {
                        if (TheSecondNumber != 0) {
                            System.out.println("Result: " + (TheFirstNumber / TheSecondNumber));
                        } else {
                            System.out.println("Error: cannot divide by zero!");
                        }
                    }
                    default -> System.out.println("Invalid operator!");
                }
            }
            catch (InputMismatchException error){
                System.out.println("Error: Invalid input!");

                scanner.next();
                continue;
            }
            System.out.print("Do you want to perform another calculation? (y/n): ");
            char response = scanner.next().toLowerCase().charAt(0);

            if(response == 'n'){
                isRunning = false;
                System.out.println("Goodbye!");
            }
            System.out.println("_____________________");
        }
        scanner.close();
    }
}
