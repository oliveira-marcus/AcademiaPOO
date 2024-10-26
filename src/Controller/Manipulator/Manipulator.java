/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import Controller.JsonController.JsonCollectionController;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author caio
 * @param <T>
 */
public abstract class Manipulator<T> {
    private String caminho;
    private Collection <T> colecao;
    private JsonCollectionController jsonController;
    
    public Manipulator(JsonCollectionController jsonController, String caminho, Class<T> classe) throws IOException{
        this.jsonController = jsonController;
        this.caminho = caminho;
        jsonController.init(classe);
        colecao = jsonController.read(caminho);
    }
    
    public void adicionar(T elem){
        colecao.add(elem);
    }
    
    public void remover(T elem){
        colecao.remove(elem);
    }
    
    public abstract void salvar() throws IOException;

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Collection<T> getColecao() {
        return colecao;
    }

    public void setColecao(Collection<T> colecao) {
        this.colecao = colecao;
    }

    public JsonCollectionController getJsonController() {
        return jsonController;
    }

    public void setJsonController(JsonCollectionController jsonController) {
        this.jsonController = jsonController;
    }
}
