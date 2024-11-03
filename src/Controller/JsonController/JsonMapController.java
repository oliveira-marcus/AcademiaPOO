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
}
