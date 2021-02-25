import java.io.File;
import java.io.IOException;

class FileTester {
    public static void main(String[] args){
        File file = new File("arquivo.txt");
        try{
            System.out.println(file.createNewFile()? "Arquivo criado":"Arquivo ja exite");
            
        } catch (IOException e){
            
        }
        System.out.println(file.getAbsolutePath());
    }
}