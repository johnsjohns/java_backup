import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;



class FileTester {
    public static void main(String[] args){
        File file = new File("temp");
        System.out.println(file.isDirectory()? "verdadeiro":"falso");
        System.out.println("absolute path: " + file.getAbsolutePath());
        System.out.println("path: " + file.getPath());
        try{
            System.out.println("canonical path: " + file.getCanonicalPath());
        } catch(Exception e){

        }
        System.out.println("Parent path: " + file.getParent());
        String arquivos[] = file.list();
        for (String arq : arquivos){
            System.out.println(arq);
        }

        File source = new File("temp/1.txt");
        try {
            FileUtils.copyFile(source, new File("temp2/1.txt"));
        } catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
    }
}