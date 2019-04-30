package com.claro.rpa.app.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    String localPath;
    String remotePath;
    Properties prop;
    File file;

    public ConfigLoader(File f){
        prop = new Properties();
        file = f;
        try {
            prop.load(new FileInputStream(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.remotePath = prop.getProperty("remote_path");
        this.localPath = prop.getProperty("local_path");
    }

    public String getLocalPath() {
        return localPath;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public Properties getProp() {
        return prop;
    }

    public File getFile() {
        return file;
    }
}
