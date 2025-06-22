//Week1
//Data Structures and Algorithms
//Exercise-7 Financial Forecasting

import java.util.*;

public class ForecastTool {

    static Map<Integer, Double> cache = new HashMap<>();

    public static double computeForecast(double baseValue, double[] yearlyRates, int targetYear) {
    
        if (targetYear == 0) return baseValue;

        if (cache.containsKey(targetYear)) {
            return cache.get(targetYear);
        }

        double previousValue = computeForecast(baseValue, yearlyRates, targetYear - 1);
        double updatedValue = previousValue * (1 + yearlyRates[targetYear - 1]);

        cache.put(targetYear, updatedValue);

        return updatedValue;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the starting amount (e.g., 1000): ");
        double initialAmount = input.nextDouble();

        System.out.print("Enter forecast duration in years: ");
        int years = input.nextInt();

    
        double[] growthPercentages = new double[years];
        System.out.println("Input growth rate for each year (as percentage, e.g., 6 for 6%):");
        for (int i = 0; i < years; i++) {
            System.out.printf("Year %d growth rate: ", i + 1);
            growthPercentages[i] = input.nextDouble() / 100.0;  
        }

    
        double finalValue = computeForecast(initialAmount, growthPercentages, years);
        System.out.printf("Predicted value after %d years: %.2f%n", years, finalValue);

     
        System.out.println("\nTime Complexity: O(n) due to memoized recursion.");
        System.out.println("Optimization: Memoization prevents redundant calculations and improves performance.");

        input.close();
    }
}

