/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.Scanner;

/**
 *
 * @author caio
 */
public class TelaColaboradores {
    
    public void exibirMenu(){
        int opcao = 0;
        
        while(opcao != 5){
            System.out.println("1 - Incluir Colaborador");
            System.out.println("2 - Editar Colaborador");
            System.out.println("3 - Remover Colaborador");
            System.out.println("4 - Mudar Senha");
            System.out.println("5 - Sair");
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite a opcao: ");
            opcao = scanner.nextInt();
            
            switch(opcao){
                case 1 -> {
                }
                
                case 2 -> {
                }
                 
                case 3 -> {
                }
                
                case 4 -> {
                }
            }
        }
    }

    public void exibirInterfaceIncluir(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do Colaborador");
        String nome = scanner.nextLine();

        System.out.println("Digite o Endereço");
        String endereco = scanner.nextLine();

        System.out.println("Digite o Telefone");
        String telefone = scanner.nextLine();

        System.out.println("Digite o Email");
        String email = scanner.nextLine();

        System.out.println("Digite o CPF");
        String cpf = scanner.nextLine();

        System.out.println("Digite o Salario");
        double salario = scanner.nextDouble();

        scanner.nextLine();
        System.out.println("Digite o Login");
        String login = scanner.nextLine();

        System.out.println("Digite o Senha");
        String senha = scanner.nextLine();
    }
}
