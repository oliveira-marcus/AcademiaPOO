/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Manipulator.Manipulator;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author caio
 */
public class Sistema {
    private static List<Manipulator> manipuladores;
    
    public Sistema(List<Manipulator> manipuladores){
        Sistema.manipuladores = manipuladores;
    }
    
    public static <T extends Manipulator> T getSubsistemaPorTipo(Class<T> tipo){
        for (Manipulator s : manipuladores){
            if (tipo.isInstance(s)){
                return tipo.cast(s);
            }
        }
        return null;
    }
    
    public static void salvarDados() throws IOException{
        for (Manipulator manipulador : manipuladores){
            manipulador.salvar();
        }
    }
}
