package at.ac.tuwien.swa;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.startup.Tomcat;


public class Server {
	
	private final static Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] argv) throws IOException {
    	
        String msg = "Please pass the port for the web services as argument.";    	
    	 if (argv.length < 1) {
             logger.log(Level.SEVERE, msg);
             return;
         }    	        
         try {
             Integer.valueOf(argv[0]);
         } catch (NumberFormatException e) {
        	 logger.log(Level.SEVERE, "Port is missing or malformed! " + msg);
             return;
         }

       
         startTomcatEmbedded();	  	
    }

    private static void startTomcatEmbedded() {
    	String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();        
        tomcat.setPort(8080);
        
        Context context;

        try {
			context = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
			WebappLoader solrLoader = new WebappLoader(Server.class.getClassLoader());
			context.setLoader(solrLoader); 
			tomcat.start();
	        tomcat.getServer().await();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
  	}
}
