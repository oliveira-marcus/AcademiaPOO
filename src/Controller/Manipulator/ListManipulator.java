package Controller.Manipulator;

import Controller.JsonController.JsonListController;
import com.google.gson.JsonDeserializer;
import java.io.IOException;
import java.util.List;

/**
 * Manipulador especializado para coleções do tipo List.
 * Estende a classe {@code Manipulator} para fornecer funcionalidades específicas para List.
 *
 * @param <T> Tipo dos elementos da lista.
 */
public class ListManipulator<T> extends Manipulator<T> {
    
    /**
     * Construtor que inicializa o manipulador com um caminho de arquivo e tipo de classe.
     *
     * @param caminho Caminho do arquivo JSON.
     * @param classe Classe dos elementos da lista.
     * @throws IOException Se ocorrer erro na leitura do arquivo.
     */
    public ListManipulator(String caminho, Class<T> classe) throws IOException{
        super(new JsonListController(), caminho, classe);
    }
    /**
     * Construtor que inicializa o manipulador com um caminho, tipo de classe e deserializador personalizado.
     *
     * @param caminho Caminho do arquivo JSON.
     * @param classe Classe dos elementos da lista.
     * @param deserializer Deserializador personalizado para os elementos.
     * @throws IOException Se ocorrer erro na leitura do arquivo.
     */
    public ListManipulator(String caminho, Class<T> classe, JsonDeserializer deserializer) throws IOException{
        super(new JsonListController(), caminho, classe, deserializer);
    }
    
    /**
     * Adiciona um elemento à lista.
     * Sobrescreve o método da classe pai para manter compatibilidade com tipo List.
     *
     * @param elem Elemento a ser adicionado.
     */
    @Override
    public void adicionar(T elem){
        super.adicionar(elem);
    }
    
    /**
     * Remove um elemento da lista.
     * Sobrescreve o método da classe pai para manter compatibilidade com tipo List.
     *
     * @param elem Elemento a ser removido.
     */
    @Override
    public void remover(T elem){
        super.remover(elem);
    }
    
    /**
     * Salva a lista atual no arquivo JSON especificado.
     *
     * @throws IOException Se ocorrer erro na escrita do arquivo.
     */
    @Override
    public void salvar() throws IOException{
        this.getJsonController().write(this.getColecao(), this.getCaminho());
    };
    
    /**
     * Obtém a coleção como uma List.
     * Realiza o cast da coleção genérica para List.
     *
     * @return Lista de elementos.
     */
    @Override
    public List<T> getColecao(){
        return (List<T>)this.colecao;
    }
    
    /**
     * Método que sobrescreve o toString para exibir informações sobre o Manipulator
     * @return Informações sobre o Manipulator
     */
    @Override
    public String toString(){
        return "Manipulator que manipula especificamente uma ArrayList";
    }
}