public class FinancialForecast {
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }

        return calculateFutureValue(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static double calculateFutureValueIterative(double currentValue, double growthRate, int years) {
        double result = currentValue;

        for (int year = 1; year <= years; year++) {
            result = result * (1 + growthRate);
        }

        return result;
    }

    public static void main(String[] args) {
        double currentValue = 10000.0;
        double growthRate = 0.08;
        int years = 5;

        double recursiveValue = calculateFutureValue(currentValue, growthRate, years);
        double iterativeValue = calculateFutureValueIterative(currentValue, growthRate, years);

        System.out.printf("Recursive future value after %d years: %.2f%n", years, recursiveValue);
        System.out.printf("Iterative future value after %d years: %.2f%n", years, iterativeValue);
    }
}
