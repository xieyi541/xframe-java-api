package xframe.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExample {

	
	public static void main(String[] args) {
//		Set<String> s = new HashSet<>();
//		s.add("one");
//		s.add("two");
//		s.add("three");
//		s.add("four");
//		
//		for(String str : s){
//			System.out.println(str);
//		}
		
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.subList(1, 3).clear();
		
		System.out.println(list);
	}
}
