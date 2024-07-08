package start.lesson_3;

public abstract class Account implements OwnerAccess, AdminAccess, CashierAccess {

    protected String accountNumber; //IBAN
    protected double balance;
    protected AccountStatus status; //закрыт, приостановлен, открыт
    protected String openDate;
    protected String closeDate;

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void closeAccount(String closeDate) {
        if (balance == 0) {
            this.status = AccountStatus.CLOSED;
            this.closeDate = closeDate;
            System.out.println("Your account is closed");
        } else {
            System.out.println("You can't close your account");
        }
    }

    public double getBalance() {
        return balance;
    }


}

//    Есть класс Банковский счет (Account)
//Характеристики: номер счета, баланс счета (количество денег на счете),
//        статус счета (закрыт, приостановлен, открыт), дата открытия счета, дата закрытия счета.
//        Поведение: положить деньги на счет, снять деньги со счета,
//        сменить статус счета, закрыть счет , вернуть остаток по счету.
