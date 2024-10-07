/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.AreaClientes;
import Controller.Sistema;
import Model.Cliente;
import java.util.Scanner;

/**
 *
 * @author caio
 */
public class TelaClientes {
    private final AreaClientes areaClientes = Sistema.getSubsistemaPorTipo(AreaClientes.class);
    
    public void exibirMenu(){
        int opcao = 0;
        
        while (opcao != 4){
            System.out.println("1 - Incluir Cliente (Fazer Reserva)");
            System.out.println("2 - Editar Cliente");
            System.out.println("3 - Remover Cliente");
            System.out.println("4 - Sair");
            System.out.println();
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite a opcao: ");
            opcao = scanner.nextInt();
            
            switch (opcao){
                case 1 -> {
                }
              
                case 2 -> {
                }
                
                case 3 -> {
                }
            }
        }
        
    }
    
    public void modificarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do cliente que quer editar: ");
        int idCliente = scanner.nextInt();
        System.out.println();
        
        Cliente cliente = areaClientes.buscarCliente(idCliente);
        mostrarCliente(cliente);
        
        System.out.println("1 - Nome");
        System.out.println("2 - CPF");
        System.out.println("3 - Id");
        
        System.out.println("Digite o que deseja alterar: ");
        int opcao = scanner.nextInt();
        
        switch (opcao){
            case 1 -> {
            }
            case 2 -> {
            }
            case 3 -> {
            }
        }
        
    }
    
    public void mostrarCliente(Cliente cliente){
        System.out.printf("Nome: %s%nEndereco: %s%nTelefone: %s%nEmail: %s%n", 
                cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getEmail());
    }
}
