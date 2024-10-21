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
            scanner.nextLine();
            
            switch (opcao){
                case 1 -> {        
                    adicionarCliente();
                }
              
                case 2 -> {
                    modificarCliente();
                }
                
                case 3 -> {
                    removerCliente();
                }
            }
        }
        
    }
    
    public void adicionarCliente(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();

        System.out.println("Digite o telefone do cliente: ");
        String fone = scanner.nextLine();

        System.out.println("Digite o email do cliente: ");
        String email = scanner.nextLine();

        System.out.println("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        System.out.println("Digite o Cartão de Crédito do cliente: ");
        String cartao = scanner.nextLine();

        System.out.println("Digite o ID do cliente: ");
        int id = scanner.nextInt();

        areaClientes.adicionarCliente(nome, endereco, fone, email, cpf, cartao, id);
    }
    
    public void modificarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do cliente que quer editar: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        
        Cliente cliente = areaClientes.buscarCliente(idCliente);
        mostrarCliente(cliente);
        
        System.out.println("1 - Endereço");
        System.out.println("2 - Telefone");
        System.out.println("3 - Email");
        System.out.println("4 - Cartão de Crédito");
        
        System.out.println("Digite o que deseja alterar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao){
            case 1 -> {
                System.out.println("Digite o novo endereço: ");
                String endereco = scanner.nextLine();
                
                areaClientes.editarEndereco(idCliente, endereco);
            }
            case 2 -> {
                System.out.println("Digite o novo telefone: ");
                String telefone = scanner.nextLine();
                
                areaClientes.editarTelefone(idCliente, telefone);
            }
            case 3 -> {
                System.out.println("Digite o novo email: ");
                String email = scanner.nextLine();
                
                areaClientes.editarEmail(idCliente, email);
            }
            case 4 -> {
                System.out.println("Digite o novo Cartão de Crédito: ");
                String cartao = scanner.nextLine();
                
                areaClientes.editarCartao(idCliente, cartao);
            }
        }
        
    }
    
    public void removerCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do cliente que quer editar: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        
        Cliente cliente = areaClientes.buscarCliente(idCliente);
        mostrarCliente(cliente);
        
        System.out.println("Tem certeza que quer remover o Cliente? [S, N] ");
        String resposta = scanner.nextLine();
        
        if (resposta.equals("S")){
            areaClientes.removerCliente(idCliente);
        }      
    }
    
    public void mostrarCliente(Cliente cliente){
        System.out.printf("Nome: %s%nEndereco: %s%nTelefone: %s%nEmail: %s%n", 
                cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getEmail());
    }
}
