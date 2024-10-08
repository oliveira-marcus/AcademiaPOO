/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author caio
 * @param <K>
 * @param <V>
 */
public class JsonMapController <K,V> {
    private final Class<K> tipoClasseChave;
    private final Class<V> tipoClasseValor;
    private final Gson gson;
    
    public JsonMapController(Class<K> tipoChave, Class<V> tipoValor){
        this.tipoClasseChave = tipoChave;
        this.tipoClasseValor = tipoValor;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    public Map<K, V> readJsonToMap(String caminhoArquivo) throws IOException{
        String jsonString = Files.readString(Paths.get(caminhoArquivo));
        Type mapType = TypeToken.getParameterized(Map.class, tipoClasseChave, tipoClasseValor).getType();
        var map = gson.fromJson(jsonString, mapType);
        
        if (map != null){
            return gson.fromJson(jsonString, mapType);
        }
        
        else{
            return new HashMap<>();
        }
    }
    
    public void writeMapToJson(Map<K, V> map, String caminhoArquivo) throws IOException{
        String jsonString = gson.toJson(map);
        Files.writeString(Paths.get(caminhoArquivo), jsonString);
    }
}
