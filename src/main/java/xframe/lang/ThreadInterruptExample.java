package xframe.lang;

public class ThreadInterruptExample {

	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Task());
		t.start();
		Thread.sleep(1000);
		t.interrupt();
	}
}

class Task implements Runnable{
	
	public void run(){
		System.out.println("begin call");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// if any thread has interrupted the current thread. The
		    //          <i>interrupted status</i> of the current thread is
		    //          cleared when this exception is thrown.
			if(Thread.currentThread().isInterrupted()){
				System.out.println("thread interrupted");
			}
		}
		System.out.println("end call");
	}
	
//	public void run(){
//		while(true){
//			int i =0;
//			i++;
//			//if(Thread.currentThread().isInterrupted()){
//			if(Thread.currentThread().interrupted()){
//				break;
//			}
//		}
//		
//		if(Thread.currentThread().isInterrupted()){
//			System.out.println("still interrupted.");
//		}
//		
//		System.out.println("task end.");
//	}
}
