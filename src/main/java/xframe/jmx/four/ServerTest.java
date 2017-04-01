package xframe.jmx.four;

import java.lang.management.ManagementFactory;  

import javax.management.MBeanServer;  
import javax.management.ObjectName;  

public class ServerTest {

	public static void main(String[] args) throws Exception {  
        testServerMBean();  
    }  
      
    public static void testServerMBean() throws Exception {  
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();  
  
        ServerConfigure serverConfigure = new ServerConfigure(8080,  
                "test.haitao.com", 20, 100);  
  
        Server server = new Server(serverConfigure);  
  
        ObjectName serverName = new ObjectName(  
                "xframe.jmx.four:type=Server");  
        mbs.registerMBean(server, serverName);  
        System.out.println("Waiting...");  
        Thread.sleep(Long.MAX_VALUE);  
    }  
}
