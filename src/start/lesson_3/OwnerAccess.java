package start.lesson_3;

public interface OwnerAccess {
    void addBalance(double sum);
    double withdrawBalance(double sum);
    void closeAccount(String closeDate);
   double getBalance();
   double getMaxDeposit();

   double getMaxWithdraw();

   double getOverdraft();

   double getCreditLimit();

}
