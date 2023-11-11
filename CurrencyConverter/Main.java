package CurrencyConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        try (Scanner scanner = new Scanner(System.in)) {
            double amount;
            String sourceCurrency, targetCurrency;

            // Get input from the user with error handling
            try {
                System.out.println("Enter the amount to convert:");
                amount = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid amount. Please enter a numeric value.");
                return;
            }

            System.out.println("Enter the source currency (e.g., USD):");
            sourceCurrency = scanner.next().toUpperCase();

            System.out.println("Enter the target currency (e.g., EUR):");
            targetCurrency = scanner.next().toUpperCase();

            // Perform the conversion
            double convertedAmount = converter.convert(amount, sourceCurrency, targetCurrency);

            // Print the result
            printConversionResult(amount, sourceCurrency, convertedAmount, targetCurrency);
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
        }
    }

    private static void printConversionResult(double amount, String sourceCurrency, double convertedAmount, String targetCurrency) {
        if (convertedAmount != -1) {
            System.out.println(amount + " " + sourceCurrency + " is equivalent to " + convertedAmount + " " + targetCurrency);
        } else {
            System.out.println("Conversion failed. Please check the currencies.");
        }
    }
}
