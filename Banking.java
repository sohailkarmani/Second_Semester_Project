import java.util.ArrayList;
import java.util.Scanner;

class Banking extends Thread {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Demo de = new Demo();
        try {
            Thread.sleep(500);
            de.start();
            de.join();
        } catch (InterruptedException e) {
        }

        ArrayList<BankAccount> list = new ArrayList<>();
        int choice = menu();
        while (choice != 5) {

            switch (choice) {
                case 1:
                    input.nextLine();
                    System.out.print("Enter your name  :");
                    String name = input.nextLine();

                    System.out.print("Enter your Acount number  :");
                    int accNo = input.nextInt();
                    System.out.print("Enter your balance  :");
                    double balance = input.nextDouble();

                    BankAccount b = new BankAccount(name, accNo, balance);
                    list.add(b);
                    System.out.print("Wait your data is processing");

                    for (int s = 1; s < 5; s++) {
                        try {
                            System.out.print(".");
                            Thread.sleep(1000);

                        } catch (InterruptedException e) {
                        }
                    }
                    System.out.println("\nData has been added");
                    choice = menu();

                    break;

                case 2:
                    System.out.print("Enter account number that want to search for :");
                    accNo = input.nextInt();

                    BankAccount bac = search(list, accNo);

                    if (bac != null) {
                        System.out.println(bac);

                    } else {
                        System.out.print("Your number does not exist :");
                    }

                    choice = menu();
                    break;
                case 3:

                    System.out.print("Enter account number that want to remove  :");
                    accNo = input.nextInt();

                    bac = search(list, accNo);
  
                    if (bac != null) {

                        list.remove(bac);
                        System.out.print("Account is removing");
                        for (int t = 1; t < 5; t++) {
                            try {
                                System.out.print(".");
                                Thread.sleep(1000);

                            } catch (InterruptedException e) {
                            }
                        }
                        System.out.print("\n the account has removed");

                    } else {
                        System.out.print("The account does not exist");

                        choice = menu();
                        break;
                    }
                case 4:
                    for (BankAccount ba : list) {
                        System.out.println(ba.toString());

                    }

                    choice = menu();
                    break;

            }

        }
        while (choice != 5);
            

        System.out.println("Thank you for using our services");

    }

    public static int menu() {

        System.out.println("\n");
        System.out.println(" 1. Add\n 2. Search\n 3. Remove\n 4. Dispaly\n 5.Exit");
        System.out.print("Enter choice  :");
        int choice = input.nextInt();

        return choice;

    }

    public static BankAccount search(ArrayList<BankAccount> list, int accNo) {
        BankAccount ba = null;
        for (BankAccount bb : list) {
            if (bb.getAccountNumber() == accNo) {
                ba = bb;
            }
        }
        return ba;
    }

}

class BankAccount extends Banking {

    private String AccountHolder;
    private int AccountNumber;
    private double balance;

    public BankAccount(String AccountHolder, int AccountNumber, double balance) {
        this.AccountHolder = AccountHolder;
        this.AccountNumber = AccountNumber;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return AccountHolder;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountHolder(String AccountHolder) {
        this.AccountHolder = AccountHolder;
    }

    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String toString() {
        System.out.println("\n");
        return "BankTest{" + "AccountHolder=" + AccountHolder + ", AccountNumber=" + AccountNumber + ", balance="
                + balance + '}';
    }
    

}

class Demo extends Thread {
    public void run() {
        System.out.println("            Dear customer Welcome to our survices");
        System.out.println("                    How can we help you");
    }
}