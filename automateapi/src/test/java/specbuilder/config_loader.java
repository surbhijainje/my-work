package specbuilder;

import java.io.FileInputStream;
import java.util.Properties;

public class config_loader {
	public static Properties prop;
	public static Properties prop1;
	
	public static void init() throws Exception { 
     FileInputStream fis=new FileInputStream("C:\\Users\\surbh\\RESTASSUREDAPI WORKSPACE\\automateapi\\config.properties");
       prop = new Properties();
       prop.load(fis);
       
       FileInputStream fis1=new FileInputStream("C:\\Users\\surbh\\RESTASSUREDAPI WORKSPACE\\automateapi\\data.properties");
       prop1 = new Properties();
       prop1.load(fis1);
   
}
}
