package start.lesson_3;

public class Main {
    public static void main(String[] args) {
        DepositAccount depositAccount = new DepositAccount(1000, "Ivan", "1234567890123456");
        System.out.println(depositAccount);

        depositAccount.addBalance(999);
        System.out.println(depositAccount);

        depositAccount.withdrawBalance(500);
        System.out.println(depositAccount);

        depositAccount.setStatus(AccountStatus.CLOSED);
        System.out.println(depositAccount);

        CreditAccount creditAccount = new CreditAccount("Ivan", "1234567890123456", 1000, 2000);
        System.out.println(creditAccount);

        System.out.println(creditAccount.withdrawBalance(1000)); // снятие
        System.out.println(creditAccount);

        creditAccount.addBalance(500);
        System.out.println(creditAccount);

        CardAccount cardAccount = new CardAccount(1000, "Ivan", "1234567890123456");
        cardAccount.withdrawBalance(575);
        System.out.println(cardAccount);

        cardAccount.addBalance(1000);
        System.out.println(cardAccount);

        // ограничили доступ с помощью интерфейса только конкретнім поведением
        OwnerAccess owner1 = new DepositAccount(1000, "Misha", "1234567890123456");
        System.out.println(owner1);
        owner1.addBalance(590);
        owner1.withdrawBalance(333);
        owner1.closeAccount("today");
        double balance = owner1.getBalance();
        System.out.println("Account Balance is: " + balance);
        double maxDeposit = owner1.getMaxDeposit();
        System.out.println("Max deposit=" + maxDeposit);
        double maxWithdraw = owner1.getMaxWithdraw();
        System.out.println("Max withdrawal=" + maxWithdraw);








    }
}




