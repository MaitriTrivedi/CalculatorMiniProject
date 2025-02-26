package org.example;
import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error! Division by zero.");
        }
        return a / b;
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double factorial(double n) {
        if (n < 0) {
            throw new ArithmeticException("Error! Factorial of a negative number is undefined.");
        }
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static double squareRoot(double num) {
        if (num < 0) {
            throw new ArithmeticException("Error! Square root of a negative number.");
        }
        return Math.sqrt(num);
    }

    public static double logarithm(double num) {
        if (num <= 0) {
            throw new ArithmeticException("Error! Logarithm of zero or negative number.");
        }
        return Math.log(num);
    }

    public static void displayMenu() {
        System.out.println("\n--- Scientific Calculator ---");
        System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide");
        System.out.println("5. Power\n6. Square Root\n7. Natural Log\n8. Factorial");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            double num1, num2;

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter two numbers: ");
                        num1 = scanner.nextDouble();
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + add(num1, num2));
                        break;
                    case 2:
                        System.out.print("Enter two numbers: ");
                        num1 = scanner.nextDouble();
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + subtract(num1, num2));
                        break;
                    case 3:
                        System.out.print("Enter two numbers: ");
                        num1 = scanner.nextDouble();
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + multiply(num1, num2));
                        break;
                    case 4:
                        System.out.print("Enter two numbers: ");
                        num1 = scanner.nextDouble();
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + divide(num1, num2));
                        break;
                    case 5:
                        System.out.print("Enter base and exponent: ");
                        num1 = scanner.nextDouble();
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + power(num1, num2));
                        break;
                    case 6:
                        System.out.print("Enter number: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Result: " + squareRoot(num1));
                        break;
                    case 7:
                        System.out.print("Enter number: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Result: " + logarithm(num1));
                        break;
                    case 8:
                        System.out.print("Enter number: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Result: " + factorial(num1));
                        break;
                    case 9:
                        System.out.println("Exiting Calculator. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 9);

        scanner.close();
    }
}
