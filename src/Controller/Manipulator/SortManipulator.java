/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import java.util.Comparator;

/**
 *
 * @author caio
 * @param <T>
 */
public abstract class SortManipulator<T> extends Manipulator<T>{
    public SortManipulator(String caminho) {
        super(caminho);
    }
    
    public abstract void sort(Comparator<T> comparator);
}
