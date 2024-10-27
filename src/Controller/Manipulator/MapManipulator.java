/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import Controller.JsonController.JsonMapController;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author caio
 * @param <K>
 * @param <V>
 */
public class MapManipulator<K, V> {
    private String caminho;
    private Map<K, V> map;
    private JsonMapController jsonController = new JsonMapController();
    
    public MapManipulator(String caminho,
            Class<K> classeChave, Class<V> classeValor) throws IOException{
        this.caminho = caminho;
        jsonController.init(classeChave, classeValor);
        map = jsonController.read(caminho);
    }
    
    public void colocar(K chave, V valor){
       map.put(chave, valor);
    }
    
    public void remover(K chave){
        map.remove(chave);
    }
    
    public void salvar() throws IOException{
        this.getJsonController().write(this.map, this.getCaminho());
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Map<K, V> getMap() {
        return map;
    }

    public void setMap(Map<K, V> map) {
        this.map = map;
    }

    public JsonMapController getJsonController() {
        return jsonController;
    }

    public void setJsonController(JsonMapController jsonController) {
        this.jsonController = jsonController;
    }
}
