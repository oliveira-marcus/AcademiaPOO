package Controller.Manipulator;

import Controller.JsonController.JsonCollectionController;
import com.google.gson.JsonDeserializer;
import java.io.IOException;
import java.util.Collection;

/**
 * Classe abstrata base para manipulação de coleções.
 * Fornece funcionalidades básicas de CRUD para coleções serializadas em JSON.
 *
 * @param <T> Tipo dos elementos da coleção.
 */
public abstract class Manipulator<T> {
    
    private String caminho;
    protected Collection <T> colecao;
    private JsonCollectionController jsonController;
    
    /**
     * Construtor que inicializa o manipulador com um controlador JSON.
     *
     * @param jsonController Controlador JSON para operações de serialização.
     * @param caminho Caminho do arquivo JSON.
     * @param classe Classe dos elementos da coleção.
     * @throws IOException Se ocorrer erro na leitura do arquivo.
     */
    public Manipulator(JsonCollectionController jsonController, String caminho, Class<T> classe) throws IOException{
        this.jsonController = jsonController;
        this.caminho = caminho;
        jsonController.init(classe);
        colecao = jsonController.read(caminho);
    }
    
    /**
     * Construtor que inicializa o manipulador com um controlador JSON e deserializador personalizado.
     *
     * @param jsonController Controlador JSON para operações de serialização.
     * @param caminho Caminho do arquivo JSON.
     * @param classe Classe dos elementos da coleção.
     * @param deserializer Deserializador personalizado para os elementos.
     * @throws IOException Se ocorrer erro na leitura do arquivo.
     */
    public Manipulator(JsonCollectionController jsonController, String caminho, Class<T> classe, JsonDeserializer deserializer) throws IOException{
        this.jsonController = jsonController;
        this.caminho = caminho;
        jsonController.init(classe, deserializer);
        colecao = jsonController.read(caminho);
    }
    
    /**
     * Adiciona um elemento à coleção.
     *
     * @param elem Elemento a ser adicionado.
     */
    public void adicionar(T elem){
        colecao.add(elem);
    }
    
    /**
     * Remove um elemento da coleção.
     *
     * @param elem Elemento a ser removido.
     */
    public void remover(T elem){
        colecao.remove(elem);
    }
    
    /**
     * Salva a coleção atual no arquivo JSON especificado.
     *
     * @throws IOException Se ocorrer erro na escrita do arquivo.
     */
    public void salvar() throws IOException{
        this.getJsonController().write(this.getColecao(), this.getCaminho());
    };

    /**
     * Obtém o caminho do arquivo JSON.
     *
     * @return Caminho do arquivo.
     */
    public String getCaminho() {
        return caminho;
    }

    /**
     * Define o caminho do arquivo JSON.
     *
     * @param caminho Novo caminho do arquivo.
     */
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    /**
     * Obtém a coleção de elementos.
     *
     * @return Coleção de elementos.
     */
    public Collection<T> getColecao() {
        return colecao;
    }

    /**
     * Define a coleção de elementos.
     *
     * @param colecao Nova coleção de elementos.
     */
    public void setColecao(Collection<T> colecao) {
        this.colecao = colecao;
    }

    /**
     * Obtém o controlador JSON.
     *
     * @return Controlador JSON.
     */
    public JsonCollectionController getJsonController() {
        return jsonController;
    }

    /**
     * Define o controlador JSON.
     *
     * @param jsonController Novo controlador JSON.
     */
    public void setJsonController(JsonCollectionController jsonController) {
        this.jsonController = jsonController;
    }
}
