package myAppResource;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        ResourceGetPropertyValues properties = new ResourceGetPropertyValues();
        String value1 = properties.getPropValues("config.properties", "myApp");
        String value2 = properties.getPropValues("config.properties", "valueProps1");
    }
}
