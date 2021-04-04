package com.johns;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Propriedades {
    private Properties prop;

    public Propriedades(){
        prop = new Properties();
        criarArquivo();
        try {
            FileReader reader = new FileReader("./com/johns/prop.props");
            prop.load(reader);
        } catch (IOException e){
            System.out.println("Não foi possivel carregar propriedades");

        }


    }

    private void criarArquivo(){
        File arquivo = new File("./com/johns/prop.props");
        if(!arquivo.exists()){

            try {
                arquivo.createNewFile();
            } catch (IOException e){
                System.out.println("Não foi possivel achar arquivo de propriedades");
            }
        }
    }

    public String getProp(String key){
        return prop.getProperty(key);
    }

    public void setProp(String key, String valor) {
        prop.setProperty(key, valor);
        try {
            prop.store(new FileWriter("./com/johns/prop.props"),"Java Backup props");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
