/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Controller.AreaClientes;

/**
 *
 * @author caio
 */
public class AcademiaPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AreaClientes areaClientes = new AreaClientes();
        
        areaClientes.adicionarCliente("Caio", "Rua dos Bobo, 0", "000000000", "caiobruno@gmail.com", "000.312.000-00", "0000 0000 0000 0000", 100);
        areaClientes.adicionarCliente("Bruno", "Rua dos Bobo, 0", "005340000", "bruno@gmail.com", "000.000.050-00", "0000 0000 0000 0000", 101);
        areaClientes.adicionarCliente("Roberto", "Rua dos Bobo, 0", "098706540", "roberto@gmail.com", "000.543.000-00", "0000 0000 0000 0000", 102);
        areaClientes.adicionarCliente("Tiago", "Rua dos Bobo, 0", "005346100", "tiago@gmail.com", "000.000.000-00", "0000 0000 0000 0000", 103);
        areaClientes.adicionarCliente("Marcus", "Rua dos Bobo, 0", "050703200", "marcus@gmail.com", "000.000.123-00", "0000 0000 0000 0000", 104);
        areaClientes.adicionarCliente("Diego", "Rua dos Bobo, 0", "003132100", "diego@gmail.com", "000.678.000-00", "0000 0000 0000 0000", 105);
        areaClientes.adicionarCliente("Katia", "Rua dos Bobo, 0", "000534000", "katia@gmail.com", "000.543.000-00", "0000 0000 0000 0000", 106);
        
        areaClientes.removerCliente(101);
        areaClientes.removerCliente(103);
        areaClientes.removerCliente(105);
        
        areaClientes.mostrarClientes();
    }
    
}
