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
public abstract class Manipulator<T> {
    private String caminho;
    
    public Manipulator(String caminho){
        this.caminho = caminho;
    }
    
    public abstract void adicionar(T elem);
    
    public abstract void remover(T elem);
    
    public abstract void salvar() throws IOException;

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    
}
