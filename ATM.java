//Here is a possible Java program that implements the ATM interface task:

import java.util.Scanner;

public class ATM {

    private Scanner input;

    // Declare a BankAccount object to access and modify the account balance
    private BankAccount account;

    // Declare and initialize constants for the menu options
    private final int WITHDRAW = 1;
    private final int DEPOSIT = 2;
    private final int CHECK_BALANCE = 3;
    private final int EXIT = 4;

    // Define the constructor for the ATM class
    public ATM(BankAccount account) {
        // Initialize the input scanner
        input = new Scanner(System.in);

        // Initialize the bank account
        this.account = account;
    }

    // Define the method to display the user interface and handle user choices
    public void run() {
        // Print a welcome message
        System.out.println("Welcome to the ATM!");

        // Declare and initialize a variable for the user's choice
        int choice = 0;

        // Loop until the user chooses to exit
        while (choice != EXIT) {

            // Display the menu options
            System.out.println("\nPlease choose an option:");
            System.out.println(WITHDRAW + ". Withdraw");
            System.out.println(DEPOSIT + ". Deposit");
            System.out.println(CHECK_BALANCE + ". Check balance");
            System.out.println(EXIT + ". Exit");

            // Prompt the user to enter their choice
            System.out.print("Your choice: ");
            choice = input.nextInt();

            // Perform different actions based on the user's choice
            switch (choice) {
                case WITHDRAW:
                    // Call the withdraw method
                    withdraw();
                    break;
                case DEPOSIT:
                    // Call the deposit method
                    deposit();
                    break;
                case CHECK_BALANCE:
                    // Call the checkBalance method
                    checkBalance();
                    break;
                case EXIT:
                    // Print a farewell message and end the loop
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    // Print an error message for invalid choices
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Define the method to withdraw money from the account
    public void withdraw() {
        // Prompt the user to enter the amount to withdraw
        System.out.print("Enter the amount to withdraw: ");
        double amount = input.nextDouble();

        // Check if the amount is positive and less than or equal to the account balance
        if (amount > 0 && amount <= account.getBalance()) {
            // Deduct the amount from the account balance
            account.setBalance(account.getBalance() - amount);

            // Print a success message and show the updated balance
            System.out.println("Withdrawal successful. Your new balance is: " + account.getBalance());
        } else {
            // Print an error message for invalid amounts
            System.out.println("Withdrawal failed. Please enter a positive amount that is less than or equal to your balance.");
        }
    }

    public void deposit() {
        // Prompt the user to enter the amount to deposit
        System.out.print("Enter the amount to deposit: ");
        double amount = input.nextDouble();

        // Check if the amount is positive
        if (amount > 0) {
            // Add the amount to the account balance
            account.setBalance(account.getBalance() + amount);

            // Print a success message and show the updated balance
            System.out.println("Deposit successful. Your new balance is: " + account.getBalance());
        } else {
            // Print an error message for invalid amounts
            System.out.println("Deposit failed. Please enter a positive amount.");
        }
    }

    // Define the method to check the account balance
    public void checkBalance() {
        // Print the current balance of the account
        System.out.println("Your current balance is: " + account.getBalance());
    }
}

class BankAccount {

    // Declare a variable for the account balance
    private double balance;

    // Define the constructor for the BankAccount class
    public BankAccount(double balance) {
        // Initialize the balance with a given value or zero if negative
        this.balance = Math.max(balance, 0);
    }

    // Define a getter method for the balance variable
    public double getBalance() {
        return balance;
    }

    // Define a setter method for the balance variable
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class Main {
    public static void main(String[] args) {

        // Create a BankAccount object with an initial balance of 1000
        BankAccount account = new BankAccount(1000);

        // Create an ATM object with the bank account
        ATM atm = new ATM(account);

        // Run the ATM user interface
        atm.run();
    }
}
