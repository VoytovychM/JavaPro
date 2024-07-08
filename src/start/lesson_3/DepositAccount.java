package start.lesson_3;

public class DepositAccount extends ClientAccount implements AdminAccess{


    private double maxDeposit;

    public DepositAccount(double maxDeposit, String accountOwner, String accountNumber) {
        this.maxDeposit = maxDeposit;
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
        this.status = AccountStatus.OPEN;
        this.openDate = "today";
    }

    @Override
    public double withdrawBalance(double sum) {
        if (sum <= balance) {
            balance -= sum;
            System.out.println("Your balance has been changed");
        } else {
            System.out.println("You try to withdraw more as you have");
        }
        return balance;
    }


    @Override
    public void addBalance(double sum) {
        if (sum <= maxDeposit) {
            balance += sum;
            System.out.println("Your balance has been changed");
        } else {
            System.out.println("You try to deposit more as allowed");
        }
    }
    @Override
    public double getMaxDeposit() {
        return maxDeposit;
    }

    @Override
    public double getMaxWithdraw() {
        return -1;
    }

    @Override
    public double getOverdraft() {
        return -1;
    }

    @Override
    public double getCreditLimit() {
        return 0;
    }

    public void setMaxDeposit(double maxDeposit) {
        if(maxDeposit >= 0) {
            this.maxDeposit = maxDeposit;
        }
        else {
            System.out.println("Incorrect max sum deposit, try again.");
        }
    }

    @Override
    public void setCreditLimit(double creditLimit) {

    }

    @Override
    public void setMaxWithdraw(double maxWithdraw) {

    }

    @Override
    public void setOverdraft(double overdraft) {

    }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "maxDeposit=" + maxDeposit +
                ", accountOwner='" + accountOwner + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                ", openDate='" + openDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                "} ";
    }


}

//    Депозитный счет (DepositAccount) - может быть только положительным или 0
//        доп.характеристики: макс.сумма пополнения.
//        Поведение: Установить макс.сумма пополнения, Получить макс.сумма пополнения.

