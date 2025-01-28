

import java.util.Scanner;

public class ATM {

    private Scanner input;

    // BankAccount object 
    private BankAccount account;

    // initialize menu 
    private final int WITHDRAW = 1;
    private final int DEPOSIT = 2;
    private final int CHECK_BALANCE = 3;
    private final int EXIT = 4;

   
    public ATM(BankAccount account) {
        // the input scanner
        input = new Scanner(System.in);

        // Initialize the bank account
        this.account = account;
    }

    // method to display the user interface and user choices
    public void run() {
      
        System.out.println("Welcome to the ATM!");

        // Declare and initialize a variable 
        int choice = 0;

        // Loop until user chooses to exit
        while (choice != EXIT) {

            // Display the menu options
            System.out.println("\nPlease choose an option:");
            System.out.println(WITHDRAW + ". Withdraw");
            System.out.println(DEPOSIT + ". Deposit");
            System.out.println(CHECK_BALANCE + ". Check balance");
            System.out.println(EXIT + ". Exit");

          
            System.out.print("Your choice: ");
            choice = input.nextInt();

            // Perform different actions based on the user's choice
            switch (choice) {
                case WITHDRAW:
                   
                    withdraw();
                    break;
                case DEPOSIT:
               
                    deposit();
                    break;
                case CHECK_BALANCE:
                   
                    checkBalance();
                    break;
                case EXIT:
                   
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

  
    public void withdraw() {
       
        System.out.print("Enter the amount to withdraw: ");
        double amount = input.nextDouble();

   
        if (amount > 0 && amount <= account.getBalance()) {
           
            account.setBalance(account.getBalance() - amount);

            System.out.println("Withdrawal successful. Your new balance is: " + account.getBalance());
        } else {
       
            System.out.println("Withdrawal failed. Please enter a positive amount that is less than or equal to your balance.");
        }
    }

    public void deposit() {
        
        System.out.print("Enter the amount to deposit: ");
        double amount = input.nextDouble();

     
        if (amount > 0) {
         
            account.setBalance(account.getBalance() + amount);

            System.out.println("Deposit successful. Your new balance is: " + account.getBalance());
        } else {
            
            System.out.println("Deposit failed. Please enter a positive amount.");
        }
    }

    
        System.out.println("Your current balance is: " + account.getBalance());
    }
}

class BankAccount {

    
    private double balance;

    
    public BankAccount(double balance) {
      
        this.balance = Math.max(balance, 0);
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class Main {
    public static void main(String[] args) {

      
        BankAccount account = new BankAccount(1000);

        
        ATM atm = new ATM(account);

     
        atm.run();
    }
}
