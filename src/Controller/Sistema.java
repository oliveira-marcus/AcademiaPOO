/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Manipulator.Manipulator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caio
 */
public class Sistema {
    private final static List<Manipulator> manipuladores = new ArrayList<>();
    private static int quantClientesPriv = 0;
    protected static int quantClientesProtec = 0;
    
    private static int quantProdutosCatalogo = 0;
    
    public static void adicionarManipulador(Manipulator manipulador){
        manipuladores.add(manipulador);
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

    public static int getQuantClientesPriv() {
        return quantClientesPriv;
    }

    public static void setQuantClientesPriv(int quantClientesPriv) {
        Sistema.quantClientesPriv = quantClientesPriv;
    }

    public static int getQuantProdutosCatalogo() {
        return quantProdutosCatalogo;
    }

    public static void setQuantProdutosCatalogo(int quantProdutosCatalogo) {
        Sistema.quantProdutosCatalogo = quantProdutosCatalogo;
    }
}
