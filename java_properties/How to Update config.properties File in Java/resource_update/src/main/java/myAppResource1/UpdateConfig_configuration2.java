package myAppResource1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.PropertiesConfigurationLayout;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class UpdateConfig_configuration2 {
	
	public PropertiesConfiguration config = new PropertiesConfiguration();
	public PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout();

	
	public UpdateConfig_configuration2(String resourceFilePath) throws FileNotFoundException, ConfigurationException  
	{
		this.config.setLayout(this.layout);
		this.layout.load(this.config, new FileReader(resourceFilePath));
		this.layout.setGlobalSeparator("=");
		
		
	}

	public void Update(String KEY, String VALUE) throws ConfigurationException {
		// TODO Auto-generated method stub
		if(this.config.containsKey(KEY))
		{
	    	System.out.println("case1");
			this.config.setProperty(KEY, VALUE);
		}
		else
		{
			this.config.addProperty(KEY, VALUE);
		}
		
		
		StringWriter stringWriter = new StringWriter();
		this.layout.save(this.config, stringWriter);

		

		System.out.println("Config Property Successfully Updated..");

	}

}
