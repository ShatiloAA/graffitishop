package com.spring.core;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger{
    File file;
    String fileName;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        file = new File(fileName);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + fileName);
        } else if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void logEvent(Event event){
        //System.out.println(event.toString());
        try {

            FileUtils.writeStringToFile(file,event.toString() + "\n",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
