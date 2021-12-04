package java7.a12multithreading;

public class AccountDanger implements Runnable{
	private final Account a = new Account();
	public static void main(String[] args) {
		AccountDanger r = new AccountDanger();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("Alex");
		two.setName("Lucy");
		one.start();
		two.start();
	}
	
	public void run(){
		for (int i=0;i<5;i++){
			makeWithdrawl(10);
			if(a.getBalance()<0){
				System.out.println("Account is overdrawn!");
			}
		}
	}
	
	public synchronized void makeWithdrawl(int amt){
		if (a.getBalance() >= amt){
			System.out.println(Thread.currentThread().getName() + " is going to withdraw");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){}
			a.withDraw(amt);
			System.out.println(Thread.currentThread().getName()	+ " completes the withdrawal");
		}
		else{
			System.out.println("Not enough in account for "
					+ Thread.currentThread().getName()
					+ " to withdraw " + a.getBalance());
		}
	}

}

class Account{
	int balance = 500;
	
	public int getBalance(){
		return balance;
	}
	
	public void withDraw(int amount){
		balance = balance - amount;
		}
}




