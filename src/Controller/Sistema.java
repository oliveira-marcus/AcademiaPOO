/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author caio
 */
public class Sistema {
    private static List<ListManipulator> subsistemas;
    
    public Sistema(List<ListManipulator> subsistemas){
        Sistema.subsistemas = subsistemas;
    }
    
    public static <T extends ListManipulator> T getSubsistemaPorTipo(Class<T> tipo){
        for (ListManipulator s : subsistemas){
            if (tipo.isInstance(s)){
                return tipo.cast(s);
            }
        }
        return null;
    }
    
    public static void salvarDados() throws IOException{
        for (ListManipulator subsistema : subsistemas){
            subsistema.salvar();
        }
    }
}
