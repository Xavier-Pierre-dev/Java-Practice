package myAppResource1;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.configuration2.ex.ConfigurationException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, ConfigurationException, org.apache.commons.configuration.ConfigurationException, UnsupportedEncodingException
    {

    		UpdateConfig_configuration1 config1 = new UpdateConfig_configuration1("config.properties");
			config1.Update("valueKey", "John Snow is here");
			System.out.println("config1 at runtime for the key valueKey as the value : " + config1.config.getProperty("valueKey"));
			
			
			UpdateConfig_configuration1 config1_change = new UpdateConfig_configuration1("config.properties");
			System.out.println("config1 at runtime for the key valueKey as the value : " + config1_change.config.getProperty("valueKey"));

			

    	
        
        UpdateConfig_configuration2 config2 = new UpdateConfig_configuration2("C:\\Users\\xpierre\\Desktop\\DOCUMENTATION\\Productivity\\java_properties\\How to Update config.properties File in Java\\resource_update\\src\\main\\java\\myAppResource1\\config.properties");
        config2.Update("valueKey", "Elon Musk");
        System.out.println("config1 at runtime for the key valueKey as the value : " + config2.config.getProperty("valueKey"));

        
        



    }
}
