package CurrencyConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        // Add more exchange rates as needed
    }

    public double convert(double amount, String sourceCurrency, String targetCurrency) {
        if (exchangeRates.containsKey(sourceCurrency) && exchangeRates.containsKey(targetCurrency)) {
            double sourceRate = exchangeRates.get(sourceCurrency);
            double targetRate = exchangeRates.get(targetCurrency);
            return amount * (targetRate / sourceRate);
        } else {
            System.out.println("Invalid currency selection");
            return -1;
        }
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount to convert:");
        double amount = scanner.nextDouble();

        System.out.println("Enter the source currency (e.g., USD):");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.println("Enter the target currency (e.g., EUR):");
        String targetCurrency = scanner.next().toUpperCase();

        double convertedAmount = converter.convert(amount, sourceCurrency, targetCurrency);

        if (convertedAmount != -1) {
            System.out.println(amount + " " + sourceCurrency + " is equivalent to " + convertedAmount + " " + targetCurrency);
        }
    }
}
