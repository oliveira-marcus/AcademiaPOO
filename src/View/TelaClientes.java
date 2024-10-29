/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Cliente;
import java.util.Scanner;

/**
 *
 * @author caio
 */
public class TelaClientes {
    Scanner scanner = new Scanner(System.in);
    
    public int exibirMenu(){
        int opcao = 0;
        
        while (opcao != 4){
            System.out.println("1 - Incluir Cliente (Fazer Reserva)");
            System.out.println("2 - Editar Cliente");
            System.out.println("3 - Remover Cliente");
            System.out.println("4 - Sair");
            System.out.println();
            
            System.out.println("Digite a opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
            
        }
        return 4;
    }
    
    public String getNomeCliente(){
        System.out.println("Digite o nome do cliente: ");
        return scanner.nextLine();
        }
        
        
    public String getEnderecoCliente(){
        System.out.println("Digite o endereco do cliente: ");
        return scanner.nextLine();
    }


    public String getFoneCliente(){
        System.out.println("Digite o telefone do cliente: ");
        return scanner.nextLine();
    }


    public String getEmailCliente(){
        System.out.println("Digite o email do cliente: ");
        return scanner.nextLine();
    }


    public String getCpfCliente(){
        System.out.println("Digite o CPF do cliente: ");
        return scanner.nextLine();
    }


    public String getCartaoCliente(){
        System.out.println("Digite o Cartao de Credito do cliente: ");
        return scanner.nextLine();
    }
    
    public int getIdCliente(){
        System.out.println("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        return idCliente;
    }
        
    public int modificarCliente(){       
        System.out.println("1 - Endereco");
        System.out.println("2 - Telefone");
        System.out.println("3 - Email");
        System.out.println("4 - Cartao de Credito");
        
        System.out.println("Digite o que deseja alterar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    public String removeConfirmation(){
        System.out.println("Tem certeza que quer remover o Cliente? [S, N] ");
        return scanner.nextLine();
    }
    
    public void mostrarCliente(Cliente cliente){
        System.out.printf("Nome: %s%nEndereco: %s%nTelefone: %s%nEmail: %s%n", 
                cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getEmail());
    }
    
    public void displayNomeInvalido(){
        System.out.println("O nome que voce digitou e invalido! ");
    }
}
