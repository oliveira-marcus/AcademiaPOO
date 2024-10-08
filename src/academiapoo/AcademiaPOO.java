/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Controller.AreaClientes;
import Controller.AreaEstoque;
import Controller.ListManipulator;
import Controller.Sistema;
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
//        subsistemas.add(new AreaColaboradores());
        subsistemas.add(new AreaEstoque());
        
        Sistema sistema = new Sistema(subsistemas);
        
        AreaClientes areaClientes = Sistema.getSubsistemaPorTipo(AreaClientes.class);
        AreaEstoque areaEstoque = Sistema.getSubsistemaPorTipo(AreaEstoque.class);
        
        areaClientes.adicionarCliente("Bob Esponja", "Fenda do Biquini, 10", "912345678", "bobesponja@gmail.com", "987.654.321-21", "1111 2222 3333 4444", 777);
        
        areaEstoque.adicionarProduto("Colete", 150, 231);
        
        Sistema.salvarDados();
    }
    
}
