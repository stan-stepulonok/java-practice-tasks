package ComparableComparatorMix.task2;

import java.util.Comparator;

public class BankAccount implements Comparable<BankAccount> {

    private String accountHolder;
    private double balance;

    public static Comparator<BankAccount> mixedComparator = new Comparator<>(){
        @Override
        public int compare(BankAccount account1, BankAccount account2) {
            int compareResult = account1.accountHolder.compareTo(account2.accountHolder);
            if (compareResult == 0) {
                compareResult = account1.compareTo(account2);
            }
            return compareResult;
        }
    };

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public int compareTo(BankAccount accountCompareTo) {
        return Double.compare(this.balance, accountCompareTo.balance);
    }

}
