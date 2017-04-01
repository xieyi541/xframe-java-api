package xframe.generic;

import java.util.Date;

public class GenericBridgeMethodExample {

	public static void main(String[] args) throws Exception{
		Date first = new Date();
		Thread.sleep(1000);
		Date second = new Date();
		DateInterval interval = new DateInterval(first,second);
		Pair<Date> pair = interval ;
		pair.setFirst(first);
	}
}

class DateInterval extends Pair<Date>{

	public DateInterval(Date first, Date second) {
		super(first, second);
	}
	
	public void setSecond(Date second){
		if(second.compareTo(getFirst()) >=0){
			super.setSecond(second);
		}
	}
	
	public Date getSecond(){
		return (Date)super.getSecond().clone();
	}
	
	
}

class Pair<T>{
	
	private T first;
	private T second;
	
	public Pair(T first, T second){
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}
	
	
	
}
