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
 * Implementação do controlador JSON para coleções do tipo List.
 * 
 * @param <T> Tipo dos elementos da lista.
 */
public class JsonListController<T> implements JsonCollectionController<T>{
    
    private Class<T> tipoClasse;
    private Gson gson;

    /**
     * Inicializa o controlador com o tipo de classe dos elementos.
     *
     * @param tipoClasse Classe dos elementos da lista.
     */
    @Override
    public void init(Class<T> tipoClasse) {
        this.tipoClasse = tipoClasse;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    /**
     * Inicializa o controlador com o tipo de classe e um deserializador personalizado.
     *
     * @param tipoClasse Classe dos elementos da lista.
     * @param deserializer Deserializador personalizado para os elementos.
     */
    @Override
    public void init(Class<T> tipoClasse, JsonDeserializer deserializer){
        this.tipoClasse = tipoClasse;
        this.gson = new GsonBuilder().registerTypeAdapter(tipoClasse, deserializer).setPrettyPrinting().create();
    }
    
    /**
     * Lê uma lista de elementos de um arquivo JSON.
     *
     * @param caminhoArquivo Caminho do arquivo JSON.
     * @return Lista de elementos lidos ou lista vazia se arquivo estiver vazio.
     * @throws IOException Se ocorrer erro na leitura do arquivo.
     */
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
    
    /**
     * Escreve uma lista de elementos em um arquivo JSON.
     *
     * @param colecao Coleção a ser escrita.
     * @param caminhoArquivo Caminho do arquivo JSON.
     * @throws IOException Se ocorrer erro na escrita do arquivo.
     */
    @Override
    public void write(Collection<T> colecao, String caminhoArquivo) throws IOException {
        String jsonString = gson.toJson((List<T>)colecao);
        Files.writeString(Paths.get(caminhoArquivo), jsonString);
    }

    /**
     * Retorna o tipo de Classe que o Gson está lidando 
     * 
     * @return Tipo da classe
     */
    public Class<T> getTipoClasse() {
        return tipoClasse;
    }

    /**
     * Define o tipo de Classe que o Gson está lidando 
     * 
     * @param tipoClasse Tipo da classe
     */
    public void setTipoClasse(Class<T> tipoClasse) {
        this.tipoClasse = tipoClasse;
    }

    /**
     * Obtem a instancia Gson usada para manipular arquivos Json
     * 
     * @return instancia Gson
     */
    public Gson getGson() {
        return gson;
    }

    /**
     * Define a instancia Gson usada para manipular arquivos Json
     * 
     * @param gson Instancia Gson
     */
    public void setGson(Gson gson) {
        this.gson = gson;
    }
    
    /**
     * Método que sobrescreve o toString para exibir informações sobre o JsonController
     * @return Informações sobre o JsonController
     */
    @Override 
    public String toString(){
        return "JsonController que le e escreve dados de uma lista para um arquivo json";
    }
}
