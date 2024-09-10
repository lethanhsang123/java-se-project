package core_java_volume_1_12ed.chapter_12_concurrency.sync.synchronized_blocks;

class BankAccount {
    private int balance = 0;
    private Object depositLock = new Object();
    private Object withdrawalLock = new Object();

    // Synchronized block for deposit
    public void deposit(int amount) {
        synchronized (depositLock) {
            balance += amount;
        }
    }

    // Synchronized block for withdrawal
    public void withdraw(int amount) {
        synchronized (withdrawalLock) {
            balance -= amount;
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class MultipleLocksExample {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(1);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Balance: " + account.getBalance());
    }
}
