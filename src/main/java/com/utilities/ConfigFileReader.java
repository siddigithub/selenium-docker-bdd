package com.utilities;

import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    public Properties loadProperties(String filename){
        Properties properties = new Properties();
        try{
            properties.load(this.getClass().getClassLoader().getResourceAsStream(filename));
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
        return properties;
    }
}
