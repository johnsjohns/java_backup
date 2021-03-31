package com.johns.backup;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Gravador {

    File file;
    List<String> lista;

    public Gravador(){
        file = new File("temp");
        lista = new ArrayList<String>();
        try {
            lista.addAll(FileUtils.readLines(file, StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado\n" + e);
        }
    }

    public static void main(String args[]){
        Gravador  grava = new Gravador();
        try {
            grava.gravar("2");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void gravar(String dados) throws IOException {
        Boolean existe = false;
        for(String item : lista){
            if(item.equals(dados)){
                existe = true;
            }
        }
        if(!existe) {
            lista.add(dados);
            FileUtils.writeLines(file, lista);
        }

    }

}
