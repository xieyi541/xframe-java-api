package xframe.lang;

public class InheritableThreadLocalExample {

	public static void main(String[] args) {
		Worker.print();
		Thread child = new ChildThread();
		child.start();
		
		Thread child2 = new ChildThread();
		child2.start();
	}
}

class Worker{
	
	private static final InheritableThreadLocal<Integer> threadId = new InheritableThreadLocal<Integer>(){
		
		@Override
		protected Integer initialValue() {
			return 0;
		}
		
		@Override
		protected Integer childValue(Integer parentValue) {
			return parentValue+10;
		}
	};
	
	public static void print(){
		System.out.println("thredId="+threadId.get());
	}
	
}

class ChildThread extends Thread{
	public void run(){
		Worker.print();
		
		
	}
}