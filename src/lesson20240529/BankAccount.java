package lesson20240529;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {

    private AtomicInteger balance = new AtomicInteger();

    public int getBalance() {
        return balance.get();
    }

    public void setBalance(int balance) {
        this.balance.set (balance);
    }

    public  void deposit(int amount) {
        balance.addAndGet(amount);
    }

    public boolean withdraw(int amount) {
        while (true) {
            int currentBalance = balance.get();
            if (currentBalance < amount) {
                return false; // Not enough balance to withdraw
            }
            int newBalance = currentBalance - amount;
            if (balance.compareAndSet(currentBalance, newBalance)) {
                return true; // Withdrawal successful
            }
        }
    }

//    public static synchronized void deposit(int amount, BankAccount account) {
//        account.setBalance(account.getBalance() + amount);
//    }

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.setBalance(1000);

        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.setBalance(500);

        // deposit
        new Thread(() -> {
            bankAccount2.deposit(100);
//            deposit(100, bankAccount2);
        }).start();

        // deposit
        new Thread(() -> {
            bankAccount1.deposit(100);
//            deposit(100, bankAccount1);
        }).start();

        // deposit
        new Thread(() -> {
            bankAccount1.deposit(100);
//            deposit(100, bankAccount1);
        }).start();

        // deposit
        new Thread(() -> {
            bankAccount1.deposit(100);
//            deposit(100, bankAccount1);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       new Thread(()->{
           boolean success = bankAccount1.withdraw(200);
           System.out.println("Withdrawal of 200 from bankAccount1 was " + (success ? "successful" : "unsuccessful"));
       }).start();
        System.out.println(bankAccount1.getBalance());
    }
}