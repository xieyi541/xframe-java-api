package xframe.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;

public class GenericInterfaceExample implements Show<String,Date>{

    @Override  
    public void show(String str,Date date) {  
        System.out.println(str);  
        System.out.println(date);  
    }  
    
//    public static void main(String[] args) {
//    	GenericInterfaceExample test=new GenericInterfaceExample();  
//    	test.show("Hello",new Date());  
//	}
    
    public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {  
        ArrayList<Integer> arrayList3=new ArrayList<Integer>();  
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer  
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");  
        for (int i=0;i<arrayList3.size();i++) {  
            System.out.println(arrayList3.get(i));  
        }  
    }
}
interface Show<T,U>{  
    void show(T t,U u);  
}  