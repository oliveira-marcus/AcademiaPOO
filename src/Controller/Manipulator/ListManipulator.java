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
    public ListManipulator(String caminho, Class<T> classe) throws IOException{
        super(new JsonListController(), caminho, classe);
    }
    
    @Override
    public void adicionar(T elem){
        super.adicionar(elem);
    }
    
    @Override
    public void remover(T elem){
        super.remover(elem);
    }
    
    @Override
    public void salvar() throws IOException{
        jsonController.write(this.getColecao(), this.getCaminho());
    };
    
    public abstract T buscar(E identificador);
    
    public List<T> getLista(){
        return (List<T>)this.getColecao();
    }
}