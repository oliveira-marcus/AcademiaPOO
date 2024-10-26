/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import Controller.JsonController.JsonCollectionController;
import java.io.IOException;

/**
 *
 * @author caio
 * @param <T>
 */
public abstract class LoggingManipulator<T> extends Manipulator<T>{
    
    public LoggingManipulator(JsonCollectionController jsonController, String caminho, Class<T> classe) throws IOException {
        super(jsonController, caminho, classe);
        System.out.println("[LOG]: DADOS LIDOS");
    }
    
    @Override
    public void adicionar(T elem){
        System.out.println("[LOG]: ELEMENTO ADICIONADO");
        super.adicionar(elem);
    }
    
    @Override
    public void remover(T elem){
        System.out.println("[LOG]: ELEMENTO REMOVIDO");
        super.remover(elem);
    }
    
    @Override
    public void salvar() throws IOException{
        System.out.println("[LOG]: DADOS SALVOS");
    }
}