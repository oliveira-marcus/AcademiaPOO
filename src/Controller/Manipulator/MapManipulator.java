package Controller.Manipulator;

import Controller.JsonController.JsonMapController;
import java.io.IOException;
import java.util.Map;

/**
 * Classe para manipulação de mapas com serialização em JSON.
 * Fornece operações básicas de CRUD para mapas serializados em formato JSON.
 *
 * @param <K> Tipo das chaves do mapa.
 * @param <V> Tipo dos valores do mapa.
 */
public class MapManipulator<K, V> {
    
    private String caminho;
    private Map<K, V> map;
    private JsonMapController jsonController = new JsonMapController();
    
    /**
     * Construtor que inicializa o manipulador de mapa com tipos específicos de chave e valor.
     *
     * @param caminho Caminho do arquivo JSON.
     * @param classeChave Classe das chaves do mapa.
     * @param classeValor Classe dos valores do mapa.
     * @throws IOException Se ocorrer erro na leitura do arquivo.
     */
    public MapManipulator(String caminho,
            Class<K> classeChave, Class<V> classeValor) throws IOException{
        this.caminho = caminho;
        jsonController.init(classeChave, classeValor);
        map = jsonController.read(caminho);
    }
    
    /**
     * Adiciona ou atualiza um par chave-valor no mapa.
     *
     * @param chave Chave do elemento.
     * @param valor Valor a ser associado à chave.
     */
    public void colocar(K chave, V valor){
       map.put(chave, valor);
    }
    
    /**
     * Remove um elemento do mapa pela chave.
     *
     * @param chave Chave do elemento a ser removido.
     */
    public void remover(K chave){
        map.remove(chave);
    }
    
    /**
     * Salva o mapa atual no arquivo JSON especificado.
     *
     * @throws IOException Se ocorrer erro na escrita do arquivo.
     */
    public void salvar() throws IOException{
        this.getJsonController().write(this.map, this.getCaminho());
    }

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
     * Obtém o mapa de elementos.
     *
     * @return Mapa de elementos.
     */
    public Map<K, V> getMap() {
        return map;
    }

    /**
     * Define o mapa de elementos.
     *
     * @param map Novo mapa de elementos.
     */
    public void setMap(Map<K, V> map) {
        this.map = map;
    }

    /**
     * Obtém o controlador JSON do mapa.
     *
     * @return Controlador JSON.
     */
    public JsonMapController getJsonController() {
        return jsonController;
    }

    /**
     * Define o controlador JSON do mapa.
     *
     * @param jsonController Novo controlador JSON.
     */
    public void setJsonController(JsonMapController jsonController) {
        this.jsonController = jsonController;
    }
    
    /**
     * Método que sobrescreve o toString para exibir informações sobre o Manipulator
     * @return Informações sobre o Manipulator
     */
    @Override
    public String toString(){
        return "Manipulator Map, ou seja, que manipula um Map";
    }
}
