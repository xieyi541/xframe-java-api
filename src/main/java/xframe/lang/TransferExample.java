package xframe.lang;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TransferExample {
	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
		Random rand = new Random();
		for(int i =0; i<Bank.ACCOUNT_NUM; i++){
			//按顺序转账
			//int from = rand.nextInt(Bank.ACCOUNT_NUM);
			int from = i;
			int to = rand.nextInt(Bank.ACCOUNT_NUM);
			int amount = rand.nextInt(Bank.INITIAL_AMOUNT);
			TransferRunnable task = new TransferRunnable(bank, from, to, amount);
			Thread t = new Thread(task);
			t.start();
			t.join();
		}
	
		
		System.out.println(bank.toString());
		bank.getTotalBalance();
	}
}

class TransferRunnable implements Runnable{
	
	private Bank bank;
	private int from;
	private int to;
	private int amount;
	
	public TransferRunnable(Bank bank, int from , int to , int amount){
		this.bank = bank;
		this.from = from;
		this.to = to;
		this.amount = amount;
		
	}
	
	public void run(){
		try {
			bank.transfer(from, to, amount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Bank{
	
	public static final int ACCOUNT_NUM = 100;
	
	public static final int INITIAL_AMOUNT = 10000;
	
	private Lock readLock;
	
	private Lock writeLock;
	
	private ReadWriteLock readWriteLock;
	
	private Condition sufficentBalance;

	//余额
	private int[] balance;
	
	public Bank(){
		readWriteLock = new ReentrantReadWriteLock();
		readLock = readWriteLock.readLock();
		writeLock = readWriteLock.writeLock();
		sufficentBalance = writeLock.newCondition();
		balance = new int[ACCOUNT_NUM];
		for(int i=0; i< ACCOUNT_NUM; i++){
			balance[i] = INITIAL_AMOUNT;
		}
	}
	
	public void transfer(int from, int to, int amount) throws InterruptedException{
		writeLock.lockInterruptibly();
		try{
			
			while(balance[from] < amount){
				sufficentBalance.await(100, TimeUnit.MILLISECONDS);
			}
			
			balance[from] = balance[from] - amount;
			balance[to] = balance[to] + amount;
		
			getTotalBalance();
			
			sufficentBalance.signalAll();
		} finally{
			writeLock.unlock();
		}
	}
	
	public void getTotalBalance() throws InterruptedException{
		readLock.lockInterruptibly();
		try{
			long sum = 0;
			for(int i =0; i<balance.length; i++){
				sum = sum + balance[i];
			}
			
			System.out.println("total balance:"+ sum);
		}finally{
			readLock.unlock();
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.balance);
	}
	
	
	
}
