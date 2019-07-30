package com.manager;

import com.utilities.ConfigFileReader;

//We are using singleton pattern, only one object is created.
public class FileReaderManager {

    private static  FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    private FileReaderManager(){
        //Define the constructor as private
    }

    public static FileReaderManager getInstance(){
        return fileReaderManager;
    }

    public static ConfigFileReader getConfigFileReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}
