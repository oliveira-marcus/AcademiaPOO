/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Funcionario;
import java.util.Scanner;

/**
 *
 * @author caio
 */
public class TelaColaboradores {
    Scanner scanner = new Scanner(System.in);

    public int exibirMenu(){
        System.out.println("1 - Incluir Colaborador");
        System.out.println("2 - Editar Colaborador");
        System.out.println("3 - Remover Colaborador");
        System.out.println("4 - Sair");

        System.out.println("Digite a opcao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        return opcao;
    }
    
    public String getNomeColaborador(){
        System.out.println("Digite o nome do Colaborador");
        String nome = scanner.nextLine();
        return nome;
    }
    
    public String getEnderecoColaborador(){
        System.out.println("Digite o Endereco");
        String endereco = scanner.nextLine();
        return endereco;
    }   

    public String getFoneColaborador(){
        System.out.println("Digite o Telefone");
        String telefone = scanner.nextLine();
        return telefone;
    }
        

    public String getEmailColaborador(){
        System.out.println("Digite o Email");
        String email = scanner.nextLine();
        return email;
    }

    public String getCpfColaborador(){
        System.out.println("Digite o CPF");
        String cpf = scanner.nextLine();
        return cpf;
    }      

    public double getSalarioColaborador(){
        System.out.println("Digite o Salario");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        return salario;
    }
        
    public String getLoginColaborador(){
        System.out.println("Digite o Login");
        String login = scanner.nextLine();
        return login;
    }
        

    public String getSenhaColaborador(){
        System.out.println("Digite o Senha");
        String senha = scanner.nextLine();
        return senha;
    }
    
    public String getCargoColaborador(){
        System.out.println("Digite o Cargo");
        String cargo = scanner.nextLine();
        return cargo;
    }
    
    public int modificarColaborador(){
        System.out.println("1 - Endereco");
        System.out.println("2 - Telefone");
        System.out.println("3 - Email");
        System.out.println("4 - Login");
        System.out.println("5 - Senha");
        
        System.out.println("Digite o que deseja alterar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    public String removeConfirmation(){
        System.out.println("Tem certeza que quer remover o Cliente? [S, N] ");
        return scanner.nextLine();     
    }
    
    public void mostrarColaborador(Funcionario funcionario){
        System.out.printf("Nome: %s%nEndereco: %s%nTelefone: "
                + "%s%nEmail: %s%nSalario: %s%nLogin: "
                + "%s%nSenha: %s%nCargo: %s%n",
                funcionario.getNome(), funcionario.getEndereco(), funcionario.getTelefone(),
                funcionario.getEmail(), funcionario.getSalario(), funcionario.getLogin(),
                funcionario.getSenha(), funcionario.getCargo());
    }
}