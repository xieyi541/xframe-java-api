package xframe.jmx.cs;

public interface HelloWorldMBean {  
    public String getName();          
    public void setName(String name);      
    public void printHello();         
    public void printHello(String whoName);    
} 
