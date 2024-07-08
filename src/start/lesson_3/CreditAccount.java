package start.lesson_3;

public class CreditAccount extends ClientAccount implements AdminAccess {

    private double maxWithdraw; // максимальная сумма снятия
    private double creditLimit; //кредитный лимит

    public CreditAccount(String accountOwner, String accountNumber, double maxWithdraw, double creditLimit) {
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
        this.maxWithdraw = maxWithdraw;
        this.creditLimit = creditLimit;
        this.status = AccountStatus.OPEN;
        this.openDate = "today";
    }
    public double getMaxWithdraw() {
        return maxWithdraw;
    }

    @Override
    public double getOverdraft() {
        return 0;
    }

    public void setMaxWithdraw(double maxWithdraw) {
        if (maxWithdraw >= 0) {
            this.maxWithdraw = maxWithdraw;
        }
        else {
            System.out.println("Incorrect Max Withdraw, try again.");
        }
    }

    @Override
    public void setOverdraft(double overdraft) {

    }


    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public void setMaxDeposit(double maxDeposit) {

    }

    public void setCreditLimit(double creditLimit) {
        if (creditLimit >= 0) {
            this.creditLimit = creditLimit;
        }
        else {
            System.out.println("Incorrect Credit Limit, try again.");
        }
    }

    @Override
    public double withdrawBalance(double sum) {
        if (sum <= maxWithdraw && balance - sum >= -creditLimit) {
            balance -= sum;
            System.out.println("You have successfully withdrawn money from your account!");
        } else {
            System.out.println("Operation declined");
        }
        return balance;
    }

    @Override
    public double getMaxDeposit() {
        return 0;
    }

    @Override
    public void addBalance(double sum) {
        if (balance + sum <= 0) {
            balance += sum;
            System.out.println("Your balance has been successfully funded!");
        } else {
            System.out.println("Operation declined, your balance can't be greater than 0");
        }
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "maxWithdraw=" + maxWithdraw +
                ", creditLimit=" + creditLimit +
                ", accountOwner='" + accountOwner + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                ", openDate='" + openDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                "} ";
    }
}

//    Кредитный счет (CreditAccount)- содержит отрицательное значение или 0,
//        доп характеристика: кредитный лимит, макс.сумма снятия.
//        Поведение: Установить кредитный лимит, Получить кредитный лимит, Установить макс.сумма снятия, Получить макс.сумма снятия.