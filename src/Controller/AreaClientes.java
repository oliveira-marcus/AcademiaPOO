/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CPF;
import Model.Cliente;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caio
 */
public class AreaClientes extends Subsistema {
    private final Path caminhoClientes = Paths.get("src/data/clientes.json");
    private List<Cliente> clientes = new ArrayList<>();
    
    public void adicionarCliente(String nome, String endereco, String telefone, String email, String cpf, String cartaoCredito, int id){
        CPF cpfCliente = new CPF(cpf);
        Cliente novoCliente = new Cliente(nome, endereco, telefone, email, cpfCliente, cartaoCredito, id);
        clientes.add(novoCliente);
    }
    
    public void removerCliente(int id){
        Cliente resultado = buscarCliente(id);
        
        if (resultado != null){
            System.out.println("Concluido!");
            clientes.remove(resultado);
        }
    }
    
    public void editarCliente(int id){ // Provavelmente vamos ter que usar sobrecarga nesse
        
    }
    
    public Cliente buscarCliente(int id){
        for (Cliente cliente : clientes){
            if (cliente.getId() == id){
                return cliente;
            }
        }
        System.out.println("O cliente não existe! ");
        return null;
    }
    
    public void mostrarClientes(){
        System.out.println(clientes);
    }
}
