/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Controller.AreaClientes;
import Controller.ListManipulator;
import Controller.Sistema;
import View.TelaClientes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caio
 */
public class AcademiaPOO {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        List<ListManipulator> subsistemas = new ArrayList<>();
        
        subsistemas.add(new AreaClientes());
        
        Sistema sistema = new Sistema(subsistemas);
        
        TelaClientes telaClientes = new TelaClientes();
        
        telaClientes.exibirMenu();
 
        Sistema.salvarDados();
    }
    
}
