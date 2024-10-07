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
import java.util.List;
import java.util.Map;

/**
 *
 * @author caio
 * @param <T>
 */
public class JsonController<T> {
    private final Class<T> tipoClasse;
    private final Gson gson;

    public JsonController(Class<T> tipoClasse) {
        this.tipoClasse = tipoClasse;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    public List<T> readJsonToList(String caminhoArquivo) throws IOException {
        String jsonString = Files.readString(Paths.get(caminhoArquivo));
        Type listType = TypeToken.getParameterized(List.class, tipoClasse).getType();
        return gson.fromJson(jsonString, listType);
    }
    
    public <K, V> Map<K, V> readJsonToMap(String caminhoArquivo) throws IOException{
        String content = Files.readString(Paths.get(caminhoArquivo));
        Type mapType = new TypeToken<Map<K, V>>() {}.getType();
        return gson.fromJson(content, mapType);
    }
    
    public void writeListToJsonFile(List<T> objetos, String caminhoArquivo) throws IOException {
        String jsonString = gson.toJson(objetos);
        Files.writeString(Paths.get(caminhoArquivo), jsonString);
    }
    
    public <K, V> void writeMapToJson(Map<K, V> map, String caminhoArquivo) throws IOException{
        String jsonString = gson.toJson(map);
        Files.writeString(Paths.get(caminhoArquivo), jsonString);
    }
}
