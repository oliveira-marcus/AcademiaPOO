/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import java.io.IOException;

/**
 *
 * @author caio
 * @param <T>
 */
public abstract class LoggingManipulator<T> extends Manipulator<T>{
    
    public LoggingManipulator(String caminho) {
        super(caminho);
        System.out.println("[LOG]: DADOS LIDOS");
    }
    
    @Override
    public void adicionar(T elem){
        System.out.println("[LOG]: ELEMENTO ADICIONADO");
    }
    
    @Override
    public void remover(T elem){
        System.out.println("[LOG]: ELEMENTO REMOVIDO");
    }
    
    @Override
    public void salvar() throws IOException{
        System.out.println("[LOG]: DADOS SALVOS");
    }
}
