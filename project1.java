// import java.lang.invoke.SwitchPoint;
// import java.util.Scanner;

import java.util.Scanner;
 class LoanStatementViewer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Loan Statement Viewer");

        // Input loan details
        System.out.print("Enter the loan amount: ");
        double loanAmount = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (in percentage): ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Enter the loan term (in months): ");
        int loanTermMonths = scanner.nextInt();

        // Calculate monthly interest rate
        double monthlyInterestRate = (annualInterestRate / 100) / 12;

        // Calculate monthly payment
        double monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, loanTermMonths);

        // Display loan statement
        System.out.println("\nLoan Statement");
        System.out.println("Loan Amount: $" + loanAmount);
        System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
        System.out.println("Loan Term (Months): " + loanTermMonths);
        System.out.println("Monthly Payment: $" + monthlyPayment);

        // Close the scanner
        scanner.close();
    }

    private static double calculateMonthlyPayment(double loanAmount, double monthlyInterestRate, int loanTermMonths) {
        // Formula for calculating monthly payment: M = P[r(1+r)^n] / [(1+r)^n-1]
        double r = monthlyInterestRate;
        double n = loanTermMonths;
        double numerator = loanAmount * r * Math.pow(1 + r, n);
        double denominator = Math.pow(1 + r, n) - 1;
        return numerator / denominator;
    }
}

