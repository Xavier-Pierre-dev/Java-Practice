package myAppResource1;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


public class UpdateConfig_configuration1 {
	
	public PropertiesConfiguration config = new PropertiesConfiguration();

	
	public UpdateConfig_configuration1(String resourceFilePath) throws ConfigurationException  
	{
		this.config = new PropertiesConfiguration(resourceFilePath);
		this.config.setAutoSave(true);
		
	}


	public void Update(String KEY, String VALUE) throws ConfigurationException
, UnsupportedEncodingException
	{
		
		if(this.config.containsKey(KEY))
		{
			this.config.setProperty(KEY, VALUE);
		}
		else
		{
			this.config.addProperty(KEY, VALUE);
		}
		

		
		System.out.println(URLDecoder.decode(this.config.getBasePath(), "UTF-8"));		
		this.config.save();
		
		System.out.println("Config Property Successfully Updated..");

	}

}
