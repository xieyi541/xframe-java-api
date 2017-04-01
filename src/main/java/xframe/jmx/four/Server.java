package xframe.jmx.four;

public class Server implements ServerMXBean {  
    
    /** 
     * 封装 
     */  
    private ServerConfigure serverConfigure;  
      
    public Server(ServerConfigure serverConfigure) {  
        this.serverConfigure = serverConfigure;  
    }  
      
    @Override  
    public ServerConfigure getServerConfigure() {  
        synchronized (serverConfigure) {  
            return this.serverConfigure;  
        }  
    }  
      
    @Override  
    public void setServerConfigure(ServerConfigure serverConfigure) {  
        synchronized (serverConfigure) {  
            this.serverConfigure = serverConfigure;  
        }  
    }  
      
    @Override  
    public void defaultServerConfigure() {  
        synchronized (serverConfigure) {  
            serverConfigure.setPort(80);  
            serverConfigure.setHost("www.haitao.com");  
            serverConfigure.setMinThread(10);  
            serverConfigure.setMaxThread(500);  
        }  
    }  
      
}  
