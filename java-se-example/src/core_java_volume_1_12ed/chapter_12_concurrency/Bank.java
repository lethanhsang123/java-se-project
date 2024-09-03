package core_java_volume_1_12ed.chapter_12_concurrency;

import java.util.Arrays;

public class Bank {

    private final double[] accounts;

    /**
     * Constructs the bank.
     * @param n the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Transfers money from one account to another.
     * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     */
    public void transfer(int from, int to, double amount) {
        if ( accounts[from] < amount ) return;
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
    }

    /**
     * Gets the number of accounts in the bank
     * @return the number of accounts
     */
    private int size() {
        return accounts.length;
    }

    /**
     * Get the number of accounts in the bank
     * @return The number of accounts
     */
    private Object getTotalBalance() {
        double sum = 0;

        for (double a : accounts)
            sum += a;

        return sum;
    }
}
