import java.util.Scanner;

class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully...!!!");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Transaction failed. Insufficient balance..!!!!");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash.......");
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }
}

public class ATMInterface {

    private BankAccount account;

    public ATMInterface(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------ ATM MENU ------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {

                account.checkBalance();

            } else if (choice == 2) {

                System.out.print("Enter amount to deposit: ");
                double amount = sc.nextDouble();

                if (amount > 0) {
                    account.deposit(amount);
                } else {
                    System.out.println("Invalid amount...!!!!");
                }

            } else if (choice == 3) {

                System.out.print("Enter amount to withdraw: ");
                double amount = sc.nextDouble();

                if (amount > 0) {
                    account.withdraw(amount);
                } else {
                    System.out.println("Invalid amount.....!!!!");
                }

            } else if (choice == 4) {

                System.out.println("Thank you for using ATM....");

            } else {

                System.out.println("Invalid choice. Try again....!!!!!");
            }

        } while (choice != 4);

        sc.close();
    }

    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(1000); 
        ATMInterface atm = new ATMInterface(userAccount);

        atm.showMenu();
    }
}