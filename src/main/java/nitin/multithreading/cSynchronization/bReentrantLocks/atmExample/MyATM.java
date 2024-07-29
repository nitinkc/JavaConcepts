package nitin.multithreading.cSynchronization.bReentrantLocks.atmExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyATM {
    private final Lock lock;
    private final int balance = 1000;

    public MyATM() {
        lock = new ReentrantLock();
    }

    public int withdraw(int amount) {
        int temp = balance;
        lock.lock();


        lock.unlock();
        return temp;
    }

    public int deposit(int amount) {
        int temp = balance;
        lock.lock();


        lock.unlock();
        return temp;
    }
}
