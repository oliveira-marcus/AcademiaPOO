package Controller.JsonController;

import com.google.gson.JsonDeserializer;
import java.io.IOException;
import java.util.Collection;

/**
 * Interface que define operações básicas para controle de coleções JSON.
 * 
 * @param <T> Tipo dos elementos da coleção.
 */
public interface JsonCollectionController<T> {
    
    /**
     * Inicializa o controlador com o tipo de classe dos elementos.
     *
     * @param tipoClasse Classe dos elementos da coleção.
     */
    public void init(Class<T> tipoClasse);
    
    /**
     * Inicializa o controlador com o tipo de classe e um deserializador personalizado.
     *
     * @param tipoClasse Classe dos elementos da coleção.
     * @param deserializer Deserializador personalizado para os elementos.
     */
    public void init(Class<T> tipoClasse, JsonDeserializer deserializer);
    
    /**
     * Lê uma coleção de elementos de um arquivo JSON.
     *
     * @param caminhoArquivo Caminho do arquivo JSON.
     * @return Coleção de elementos lidos.
     * @throws IOException Se ocorrer erro na leitura do arquivo.
     */
    public Collection<T> read(String caminhoArquivo) throws IOException;
    
    /**
     * Escreve uma coleção de elementos em um arquivo JSON.
     *
     * @param colecao Coleção a ser escrita.
     * @param caminhoArquivo Caminho do arquivo JSON.
     * @throws IOException Se ocorrer erro na escrita do arquivo.
     */
    public void write(Collection<T> colecao, String caminhoArquivo) throws IOException;
}
