package com.johns.log;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class Log {



    public static void gravar(String string){
        File file = new File("./com/johns/log/log.txt");;
        try {
            FileUtils.writeStringToFile(file, string + "\n", "UTF-8", true);
        } catch (IOException e) {
            Log.gravar("log:" + e.getMessage());

        }
    }
}
