package start.lesson_3;

public class CardAccount extends ClientAccount {
    private double overdraft;

    public CardAccount(double overdraft, String accountOwner, String accountNumber) {
        this.overdraft = overdraft;
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
        this.status = AccountStatus.OPEN;
        this.openDate = "today";
    }


    public double getOverdraft() {
        return overdraft;
    }

    @Override
    public double getCreditLimit() {
        return 0;
    }


    @Override
    public void setMaxDeposit(double maxDeposit) {

    }

    @Override
    public void setCreditLimit(double creditLimit) {

    }

    @Override
    public void setMaxWithdraw(double maxWithdraw) {

    }

    public void setOverdraft(double overdraft) {
        if (overdraft >= 0) {
            this.overdraft = overdraft;
        }
        else {
            System.out.println("Incorrect overdraft, try again.");
        }

    }

    @Override
    public double withdrawBalance(double sum) {
        if (balance - sum >= -overdraft) {
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
    public double getMaxWithdraw() {
        return 0;
    }


    @Override
    public void addBalance(double sum) {
        if (sum > 0) {
            balance += sum;
        }
        else {
            System.out.println("Incorrect sum, try again.");
        }

    }

    @Override
    public String toString() {
        return "CardAccount{" +
                "overdraft=" + overdraft +
                ", accountOwner='" + accountOwner + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                ", openDate='" + openDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                "} ";
    }
}

//    Карточный счет(CardAccount) - может быть положительным и отрицательным,
//        доп.характеритика: размер овердрафта
//        Поведение: Установить размер овердрафта, Получить размер овердрафта.