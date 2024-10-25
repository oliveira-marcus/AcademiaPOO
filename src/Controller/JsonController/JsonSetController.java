/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.JsonController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author caio
 * @param <T>
 */
public class JsonSetController<T> implements JsonCollectionController<T>{
    private Class<T> tipoClasse;
    private Gson gson;

    @Override
    public void init(Class<T> tipoClasse) {
        this.tipoClasse = tipoClasse;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    @Override
    public Set<T> read(String caminhoArquivo) throws IOException {
        String jsonString = Files.readString(Paths.get(caminhoArquivo));
        Type setType = TypeToken.getParameterized(Set.class, tipoClasse).getType();
        
        var set = gson.fromJson(jsonString, setType);
        
        if (set != null){
            return gson.fromJson(jsonString, setType);
        }
        
        else{
            return new HashSet<>();
        }
    }
    
    @Override
    public void write(Collection<T> colecao, String caminhoArquivo) throws IOException {
        String jsonString = gson.toJson((Set<T>)colecao);
        Files.writeString(Paths.get(caminhoArquivo), jsonString);
    }
}
