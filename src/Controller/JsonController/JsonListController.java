/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.JsonController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author caio
 * @param <T>
 */
public class JsonListController<T> implements JsonCollectionController<T>{
    private Class<T> tipoClasse;
    private Gson gson;

    @Override
    public void init(Class<T> tipoClasse) {
        this.tipoClasse = tipoClasse;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    @Override
    public void init(Class<T> tipoClasse, JsonDeserializer deserializer){
        this.tipoClasse = tipoClasse;
        this.gson = new GsonBuilder().registerTypeAdapter(tipoClasse, deserializer).setPrettyPrinting().create();
    }
    
    @Override
    public List<T> read(String caminhoArquivo) throws IOException {
        String jsonString = Files.readString(Paths.get(caminhoArquivo));
        Type listType = TypeToken.getParameterized(List.class, tipoClasse).getType();
        
        var list = gson.fromJson(jsonString, listType);
        
        if (list != null){
            return gson.fromJson(jsonString, listType);
        }
        
        else{
            return new ArrayList<>();
        }
    }
    
    @Override
    public void write(Collection<T> colecao, String caminhoArquivo) throws IOException {
        String jsonString = gson.toJson((List<T>)colecao);
        Files.writeString(Paths.get(caminhoArquivo), jsonString);
    }
}
