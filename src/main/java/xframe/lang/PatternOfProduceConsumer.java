package xframe.lang;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PatternOfProduceConsumer {

	public static void main(String[] args) {
		//Queue queue =new SynchronizedQueue();
		Queue queue =new LockQueue();
		Random random = new Random();
		for(int i =0; i<100;i++){
			Thread producer = new Thread(new Producer(queue,i));
			Thread consumer = new Thread(new Consumer(queue));
			producer.start();
			consumer.start();
		}
	}
}

interface Queue{
	public void put(Object element) throws InterruptedException;
	public Object  get() throws InterruptedException;
	
}

class LockQueue implements Queue{
	private static final int MAX_SIZE = 100;
	
	private Object[] array = new Object[MAX_SIZE];
	
	private int size = 0;
	
	private Lock lock = new ReentrantLock();
	
	private Condition empty = lock.newCondition();
	
	private Condition full = lock.newCondition();
	
	public void put(Object element) throws InterruptedException{
		try{
			lock.lock();
			
			while(size == MAX_SIZE){
				full.await(100, TimeUnit.MICROSECONDS);
			}
			
			this.array[size++] = element;
			empty.signalAll();
			
		}finally{
			lock.unlock();
		}
		
	}
	
	public synchronized Object get() throws InterruptedException{
		Object result = null;
		try{
			lock.lock();
			
			while(size == 0){
				empty.await(100, TimeUnit.MICROSECONDS);
			}
			
			result =  this.array[--size]; 
			full.signalAll();
			
		}finally{
			lock.unlock();
		}
		
		return result;
	}
}

class SynchronizedQueue implements Queue{
	
	private static final int MAX_SIZE = 100;
	
	private Object[] array = new Object[MAX_SIZE];
	
	private int size = 0;
	
	public synchronized void put(Object element) throws InterruptedException{
		while(size == MAX_SIZE){
			// be full
			this.wait();
		}
		
		this.array[size++] = element;
		
		this.notifyAll();
	}
	
	public synchronized Object get() throws InterruptedException{
		while(size == 0){
			//be empty
			this.wait();
		}
		Object result =  this.array[--size]; 
		this.notifyAll();
		return result;
	}
}

class Producer implements Runnable{
	
	private Queue q;
	private int value;
	
	public Producer(Queue queue, int value) {
		this.q = queue; 
		this.value =value;
	}
	
	@Override
	public void run() {
		try {
			q.put(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Consumer implements Runnable{
	
	private Queue q;
	
	public Consumer(Queue queue) {
		this.q = queue; 
	}
	
	@Override
	public void run() {
		try {
			System.out.println(q.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}