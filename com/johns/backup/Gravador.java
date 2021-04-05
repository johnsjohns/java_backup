package com.johns.backup;

import com.johns.log.Log;
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
        file = new File("./com/johns/temp.dir");

        lista = new ArrayList<String>();
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            lista.addAll(FileUtils.readLines(file, StandardCharsets.UTF_8));
        } catch (IOException e) {
            Log.gravar("Arquivo não encontrado\n" + e);
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

    public List<String> getLista(){

        return lista;
    }

    public void limpar(){

        lista.removeAll(lista);
    }

}
