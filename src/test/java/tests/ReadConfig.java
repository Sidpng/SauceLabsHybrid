package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
        Properties prop = new Properties();

        public ReadConfig() {
            File src = new File("./src/test/resources/config.properties");
            try {

                if (src.exists()) {
                    FileInputStream fis = new FileInputStream(src);
                    prop = new Properties();
                    prop.load(fis);

                }
            } catch (Exception e) {

                System.out.println(e.getMessage());

            }
        }


        public String getProperty(String key){
                return prop.getProperty(key);
            }
        }
