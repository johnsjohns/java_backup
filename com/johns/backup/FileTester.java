package com.johns.backup;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.johns.Delay.Delay;

class FileTester {
    public static void main(String[] args){
        File file = new File("temp");
        listar(file);     
    }


    static public void listar(File arquivo){
        File destino = new File("temp2");
        String caminho = destino.getAbsolutePath();
        String barra = File.separator;
        
        File arquivos[] = arquivo.listFiles();
        for (File arq : arquivos){
             
            if(arq.isDirectory()){
                System.out.println(arq.getAbsolutePath());
                listar(arq);
            }else{
                System.out.println(arq.getAbsolutePath());
                File novo = new File(caminho + barra + arq.getPath());
                try{
                FileUtils.copyFile(arq, novo);
                } catch (IOException e){
                    System.out.println("FUdeu");
                }
            }
            Delay.delay(50);
        }
    }
}