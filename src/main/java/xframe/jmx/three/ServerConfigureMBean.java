package xframe.jmx.three;

public interface ServerConfigureMBean {  
	  
    public int getPort();  
  
    public void setPort(int port);  
  
    public String getHost();  
  
    public void setHost(String host);  
  
    public int getMaxThread();  
  
    public void setMaxThread(int maxThread);  
  
    public int getMinThread();  
  
    public void setMinThread(int minThread);  
      
} 
