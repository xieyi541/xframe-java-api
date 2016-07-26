package xframe.lang;

public class ThreadExample {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable(){
			public void run(){
				int sum = 0;
				for(int i=1; i<=100; i++){
					sum = sum + i;
				}
				System.out.println("sum = " + sum);
			}
		});
		thread.start();
		System.out.println("main thread will be end.");
	}
}
