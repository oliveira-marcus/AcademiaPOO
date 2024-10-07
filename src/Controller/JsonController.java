/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
        this.gson = new Gson();
    }


    public List<T> readJsonToList(String caminhoArquivo) {
        List<T> list = new ArrayList<>();
        try {
            String conteudoJson = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));

            Type tipoLista = TypeToken.getParameterized(List.class, tipoClasse).getType();

            list = gson.fromJson(conteudoJson, tipoLista);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo Json: " + e.getMessage());
        } catch (JsonSyntaxException e) {
            System.err.println("Erro ao fozer o Parse do Json: " + e.getMessage());
        }
        return list;
    }
    
    public void writeToJsonFile(List<T> objetos, String caminhoArquivo) throws IOException {
        String jsonString = gson.toJson(objetos);
        Files.writeString(Paths.get(caminhoArquivo), jsonString);
    }
}
