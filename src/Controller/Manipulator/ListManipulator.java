/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import Controller.JsonController.JsonListController;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author caio
 * @param <T>
 * @param <E>
 */
public abstract class ListManipulator<T, E> extends Manipulator<T> {
    private List<T> lista;
    private final JsonListController<T> jsonController;
    
    public ListManipulator(String caminho, Class<T> classe) throws IOException{
        super(caminho);
        jsonController = new JsonListController<>(classe);
        lista = this.jsonController.readJsonToList(this.getCaminho());
    }
    
    @Override
    public void adicionar(T elem){
        lista.add(elem);
    }
    
    @Override
    public void remover(T elem){
        lista.remove(elem);
    }
    
    @Override
    public void salvar() throws IOException{
        jsonController.writeListToJsonFile(lista, this.getCaminho());
    };
    
    public abstract T buscar(E identificador);

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }
}