/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.List;

/**
 *
 * @author caio
 */
public class Sistema {
    private static List<Subsistema> subsistemas;
    
    public Sistema(List<Subsistema> subsistemas){
        Sistema.subsistemas = subsistemas;
    }
    
    public static <T extends Subsistema> T getSubsistemaPorTipo(Class<T> tipo){
        for (Subsistema s : subsistemas){
            if (tipo.isInstance(s)){
                return tipo.cast(s);
            }
        }
        return null;
    }
   
}
