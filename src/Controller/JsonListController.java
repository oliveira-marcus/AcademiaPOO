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

/**
 *
 * @author caio
 * @param <T>
 */
public class JsonListController<T> {
    private final Class<T> tipoClasse;
    private final Gson gson;

    public JsonListController(Class<T> tipoClasse) {
        this.tipoClasse = tipoClasse;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    public List<T> readJsonToList(String caminhoArquivo) throws IOException {
        String jsonString = Files.readString(Paths.get(caminhoArquivo));
        Type listType = TypeToken.getParameterized(List.class, tipoClasse).getType();
        return gson.fromJson(jsonString, listType);
    }
    
    public void writeListToJsonFile(List<T> objetos, String caminhoArquivo) throws IOException {
        String jsonString = gson.toJson(objetos);
        Files.writeString(Paths.get(caminhoArquivo), jsonString);
    }
}
