package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    Double[] userTransactions=new Double[1000];
    int transitionsTracker=0; // keep track to how many changes are made (deposits and withdraws)
    public BankAccount(String name, int startingBalance){
        this.name=name;
        this.currentBalance=startingBalance;
    }

    public void deposit(double amount){
        if(amount>=0){
            currentBalance=currentBalance+amount;
            userTransactions[transitionsTracker]=amount;
            transitionsTracker++;
            System.out.println("the depositor's name : "+name+", the deposited amount : "+amount+" ,the new balance : "+currentBalance);

        }
        else {
            System.out.println("invalid amount , currentBalance can not be changed");
        }
    }



    public void withdraw(double amount){
        if(amount>=0 && amount<=currentBalance){
            currentBalance=currentBalance-amount;
            userTransactions[transitionsTracker]=-amount;
            transitionsTracker++;
            System.out.println("the depositor's name : "+name+", the withrawed amount : "+amount+" ,the current balance : "+currentBalance);

        }
        else {
            System.out.println("invalid amount , currentBalance can not be changed (the amount is negative or greater than the availble balance");
        }


    }

    public void displayTransactions(){
        System.out.println("The transactions : ");
        for (int i=0;i< transitionsTracker;i++){
            System.out.println(userTransactions[i]+" , ");

        }


    }

    public void displayBalance(){
        System.out.println("Current Balance : "+currentBalance);

    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}