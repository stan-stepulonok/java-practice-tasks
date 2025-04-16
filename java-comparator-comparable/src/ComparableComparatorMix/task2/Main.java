package ComparableComparatorMix.task2;

/*
Sort Bank Accounts with Mixed Comparators
Create a BankAccount class with accountHolder and balance.
Use Comparable to sort by balance ascending.
Then use a Comparator to sort by account holder name.
Sample Output 1 (by balance):
[BankAccount{name='Anna', balance=100.0}, BankAccount{name='Bob', balance=200.0}]
Sample Output 2 (by name):
[BankAccount{name='Anna', balance=100.0}, BankAccount{name='Bob', balance=200.0}]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount("Anna", 100);
        BankAccount acc2 = new BankAccount("James", 300);
        BankAccount acc3 = new BankAccount("Bob", 200);

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);

        System.out.println("Before: " + accounts);

        Collections.sort(accounts, BankAccount.mixedComparator);
        System.out.println("After comparator: " + accounts);

        Collections.sort(accounts);
        System.out.println("After comparable: " + accounts);

        accounts.sort(BankAccount.mixedComparator);
        System.out.println("After comparator again: " + accounts);

    }

}
