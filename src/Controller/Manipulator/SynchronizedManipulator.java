/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

/**
 *
 * @author caio
 * @param <T>
 */
public abstract class SynchronizedManipulator<T> extends Manipulator<T> {
    public SynchronizedManipulator(String caminho){
        super(caminho);
    }
    
    @Override
    public synchronized void adicionar(T elem){
        super.adicionar(elem);
    }
    
    @Override
    public synchronized void remover(T elem){
        super.remover(elem);
    }
}
