package xframe.util.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	
	public static void main(String[] args) throws InterruptedException {
		int i = 10;
		CountDownLatch latch = new CountDownLatch(i);
		for(i = 0; i< 10; i++){
			Thread t = new Thread(new Task(latch,i));
			t.start();
		}
		latch.await();
		System.out.println("all complete.");
	}
	
}


class Task implements Runnable{
	
	private CountDownLatch latch;
	private int i;
	
	public Task(CountDownLatch latch,int i) {
		// TODO Auto-generated constructor stub
		this.latch = latch;
		this.i = i;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
			System.out.println("work of i="+i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	}
}