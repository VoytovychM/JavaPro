package start.lesson_3;

public interface AdminAccess {
    void setStatus(AccountStatus status);
    void setMaxDeposit(double maxDeposit);
    void setCreditLimit(double creditLimit);
    void setMaxWithdraw(double maxWithdraw);
    void setOverdraft(double overdraft);
}
