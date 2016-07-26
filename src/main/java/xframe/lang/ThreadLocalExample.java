package xframe.lang;

public class ThreadLocalExample {

	public static void main(String[] args) {
		for(int i = 0; i<10; i++ ){
			
			if(i%3==0){
				Thread thread = new Thread(new PrinterTask("3"));
				thread.start();
			}else{
				Thread thread = new Thread(new PrinterTask(null));
				thread.start();
			}
			
			
			
		}
	}
}

class Printer{
	// ThreadLocal instances are typically private static fields in classes 
	private static final ThreadLocal<String> value = new ThreadLocal<String>(){
		@Override
		protected String initialValue() {
			// TODO Auto-generated method stub
			return "Class ThreadLocal";
		}
	};
	
	public static void print(String str){
		if(str==null){
			System.out.println(value.get());
		}else{
			System.out.println(str);
		}
	}
}

class PrinterTask implements Runnable{
	
	private String str;
	
	public PrinterTask(String str){
		this.str = str;
	}
	
	@Override
	public void run() {
		Printer.print(str);		
	}
}

