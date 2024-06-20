package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
    public static void main(String args[]) throws IOException {
        InputStream inputStream = null;
        Properties prop = new Properties();

        try {

            String propFileName = "./src/test/utilities/config.properties";
            inputStream = ReadConfig.class.getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            inputStream.close();
        }
    }

    public String getProperty(String key) {
        return getProperty(key);
    }
}
