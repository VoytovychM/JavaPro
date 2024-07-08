package lesson20240327;

import java.util.*;

public class BankAccount {

        private String name;
        private int account1;
        private int account2;


        public BankAccount(String name, int account1, int account2) {
            this.name = name;
            this.account1 = account1;
            this.account2 = account2;
        }

        @Override
        public int hashCode() {
            return account1 + account2 * 31 + (name == null ? 0 : name.hashCode()) * 31 * 31;
//        return Objects.hash(account1, account2, name);
        }

        @Override
        public boolean equals(Object o){
            if (o == null || this.getClass() != o.getClass()) return false;
            BankAccount anotherAccount = (BankAccount) o;
            return Objects.equals(this.name, anotherAccount.name) && this.account1 == anotherAccount.account1 && this.account2 == anotherAccount.account2;
        }

        @Override
        public String toString() {
            return "BankAccount{" +
                    "name='" + name + '\'' +
                    ", account1=" + account1 +
                    ", account2=" + account2 +
                    '}';
        }

        public static void main(String[] args) {
            BankAccount bankAccount1 = new BankAccount("main" , 20, 10);
            BankAccount bankAccount2 = new BankAccount("main", 10, 20);

            System.out.println(bankAccount1.hashCode());
            System.out.println(bankAccount2.hashCode());
            Set<BankAccount> set = new HashSet<>();
            set.add(bankAccount1);
            set.add(bankAccount2);

            System.out.println(set.size());

            Map<BankAccount, String> map = new HashMap<>(16, 0.75f);
            // put(), get(), contains() ----> O(1)
            map.put(bankAccount1, "data1");
            map.put(bankAccount2, "data2");
            System.out.println(map);
        }
    }