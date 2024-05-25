import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number 1: ");
        double num1 = scanner.nextDouble();

        System.out.println("Enter number 2: ");
        double num2 = scanner.nextDouble();

        System.out.println("Enter operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        double result = 0;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0)
                    result = num1 / num2;
                else
                    System.out.println("Error: Division by zero!");
                break;
            default:
                System.out.println("Error: Invalid operation!");
                break;
        }

        System.out.println("Result: " + result);
    }
}
