/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import Controller.JsonController.JsonListController;
import com.google.gson.JsonDeserializer;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author caio
 * @param <T>
 */
public class ListManipulator<T> extends Manipulator<T> {
    public ListManipulator(String caminho, Class<T> classe) throws IOException{
        super(new JsonListController(), caminho, classe);
    }
    
    public ListManipulator(String caminho, Class<T> classe, JsonDeserializer deserializer) throws IOException{
        super(new JsonListController(), caminho, classe, deserializer);
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
        this.getJsonController().write(this.getColecao(), this.getCaminho());
    };
    
    @Override
    public List<T> getColecao(){
        return (List<T>)this.colecao;
    }
}