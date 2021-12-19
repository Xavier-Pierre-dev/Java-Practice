package myAppResource;
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
 

public class ResourceGetPropertyValues {
	String result = "";
	InputStream inputStream;
 
	public String getPropValues(String propFilename, String Property) throws IOException {
 
		try {
			Properties prop = new Properties();
			
			
			inputStream = getClass().getClassLoader().getResourceAsStream(propFilename);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFilename + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());
 
			// get the property value and print it out
			result = prop.getProperty(Property);

 
			result = "Property = " + result + " for propFilename : " + propFilename;
			System.out.println(result + "\nProgram Ran on " + time);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
}