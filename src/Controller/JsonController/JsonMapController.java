package Controller.JsonController;

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
 * Controlador JSON para manipulação de Map (dicionários).
 * 
 * @param <K> Tipo das chaves do Map.
 * @param <V> Tipo dos valores do Map.
 */
public class JsonMapController <K,V> {
    
    private Class<K> tipoClasseChave;
    private Class<V> tipoClasseValor;
    private Gson gson;
    
    /**
     * Inicializa o controlador com os tipos das chaves e valores.
     *
     * @param tipoChave Classe das chaves do Map.
     * @param tipoValor Classe dos valores do Map.
     */
    public void init(Class<K> tipoChave, Class<V> tipoValor){
        this.tipoClasseChave = tipoChave;
        this.tipoClasseValor = tipoValor;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    /**
     * Lê um Map de um arquivo JSON.
     *
     * @param caminhoArquivo Caminho do arquivo JSON.
     * @return Map com os elementos lidos ou Map vazio se arquivo estiver vazio.
     * @throws IOException Se ocorrer erro na leitura do arquivo.
     */
    public Map<K, V> read(String caminhoArquivo) throws IOException{
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
    
    /**
     * Escreve um Map em um arquivo JSON.
     *
     * @param map Map a ser escrito.
     * @param caminhoArquivo Caminho do arquivo JSON.
     * @throws IOException Se ocorrer erro na escrita do arquivo.
     */
    public void write(Map<K, V> map, String caminhoArquivo) throws IOException{
        String jsonString = gson.toJson(map);
        Files.writeString(Paths.get(caminhoArquivo), jsonString);
    }

    
    /**
     * Retorna o tipo de Classe da chave do Map
     * 
     * @return Tipo da classe da chave
     */
    public Class<K> getTipoClasseChave() {
        return tipoClasseChave;
    }

    /**
     * Define o tipo de Classe da chave do Map
     * 
     * @param tipoClasseChave Tipo da classe da chave
     */
    public void setTipoClasseChave(Class<K> tipoClasseChave) {
        this.tipoClasseChave = tipoClasseChave;
    }

    /**
     * Retorna o tipo de Classe do valor do Map
     * 
     * @return Tipo da classe do valor
     */
    public Class<V> getTipoClasseValor() {
        return tipoClasseValor;
    }

    /**
     * Define o tipo de Classe do valor do Map
     * 
     * @param tipoClasseValor Tipo da classe do valor
     */
    public void setTipoClasseValor(Class<V> tipoClasseValor) {
        this.tipoClasseValor = tipoClasseValor;
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
        return "JsonController que le e escreve dados de um Map para um arquivo json";
    }
}
