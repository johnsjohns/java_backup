import java.io.File;
import java.io.IOException;

class FileTester {
    public static void main(String[] args){
        File file = new File("arquivo.txt");
        try{
        file.createNewFile();
        } catch (IOException e){}
        System.out.println(file.getAbsolutePath());
    }
}