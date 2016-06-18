// concurrent issues
package com.headfirstjava.chapter15;
class RyanAndMonicaJob implements Runnable {
	
	private BankAccount account = new BankAccount();
	
	public static void main(String[] args) {
		RyanAndMonicaJob theJob = new RyanAndMonicaJob();
		Thread one = new Thread(theJob);
		Thread two = new Thread(theJob);
		one.setName("Ryan");
		two.setName("Monica");
		one.start();
		two.start();
	}
	
	// must override run() in Runnable interface
	public void run() {
		for (int i = 0; i < 10; i++) {
			makeWithdrawl(10);
			if (account.getBalance() < 0) {
				System.out.println("Overdrawn!");
			}
		}
	}
	
	// synchronized: only one thread at a time can access this method
	public synchronized void makeWithdrawl(int amt) {
		if (account.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() + " is about to withdraw.");
			try {
				System.out.println(Thread.currentThread().getName() + " is going to sleep.");
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " woke up.");
			
			account.withdraw(amt);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawl.");
		} else {
			System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
		}
	}
}

class BankAccount {
	private int balance = 100;
	
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
}