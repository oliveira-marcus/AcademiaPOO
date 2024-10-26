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
            return scanner.nextInt();
            
        }
        return 4;
    }
    
    public String getNomeCliente(){
        System.out.println("Digite o nome do cliente: ");
        return scanner.nextLine();
        }
        
        
    public String getEnderecoCliente(){
        System.out.println("Digite o endereço do cliente: ");
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
        System.out.println("Digite o Cartão de Crédito do cliente: ");
        return scanner.nextLine();
    }
    
    public int getIdCliente(){
        System.out.println("Digite o ID do cliente: ");
        return scanner.nextInt();
    }
        
    public int modificarCliente(){       
        System.out.println("1 - Endereço");
        System.out.println("2 - Telefone");
        System.out.println("3 - Email");
        System.out.println("4 - Cartão de Crédito");
        
        System.out.println("Digite o que deseja alterar: ");
        return scanner.nextInt();
    }
    
    public String removeConfirmation(){
        System.out.println("Tem certeza que quer remover o Cliente? [S, N] ");
        return scanner.nextLine();     
    }
    
    public void mostrarCliente(Cliente cliente){
        System.out.printf("Nome: %s%nEndereco: %s%nTelefone: %s%nEmail: %s%n", 
                cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getEmail());
    }
}
