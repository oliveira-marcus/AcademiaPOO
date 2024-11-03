package View;

import Model.Funcionario;
import java.util.Scanner;

/**
 * Classe responsável pela interface de usuário para gestão de colaboradores.
 * Fornece métodos para incluir, editar, remover e exibir informações de funcionários.
 */
public class TelaColaboradores {
    
    /** Scanner para leitura de entrada do usuário */
    Scanner scanner = new Scanner(System.in);

    /**
     * Exibe o menu principal de gestão de colaboradores.
     *
     * @return Opção selecionada pelo usuário (1-4).
     */
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
    
    /**
     * Obtém o nome do colaborador via entrada do usuário.
     *
     * @return Nome do colaborador informado.
     */
    public String getNomeColaborador(){
        System.out.println("Digite o nome do Colaborador");
        String nome = scanner.nextLine();
        return nome;
    }
    
    /**
     * Obtém o endereço do colaborador via entrada do usuário.
     *
     * @return Endereço do colaborador informado.
     */
    public String getEnderecoColaborador(){
        System.out.println("Digite o Endereco");
        String endereco = scanner.nextLine();
        return endereco;
    }   

    /**
     * Obtém o telefone do colaborador via entrada do usuário.
     *
     * @return Telefone do colaborador informado.
     */
    public String getFoneColaborador(){
        System.out.println("Digite o Telefone");
        String telefone = scanner.nextLine();
        return telefone;
    }
        
    /**
     * Obtém o telefone do colaborador via entrada do usuário.
     *
     * @return Telefone do colaborador informado.
     */
    public String getEmailColaborador(){
        System.out.println("Digite o Email");
        String email = scanner.nextLine();
        return email;
    }

    /**
     * Obtém o CPF do colaborador via entrada do usuário.
     *
     * @return CPF do colaborador informado.
     */
    public String getCpfColaborador(){
        System.out.println("Digite o CPF");
        String cpf = scanner.nextLine();
        return cpf;
    }      

    /**
     * Obtém o salário do colaborador via entrada do usuário.
     *
     * @return Salário do colaborador informado.
     */
    public double getSalarioColaborador(){
        System.out.println("Digite o Salario");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        return salario;
    }
        
    /**
     * Obtém o login do colaborador via entrada do usuário.
     *
     * @return Login do colaborador informado.
     */
    public String getLoginColaborador(){
        System.out.println("Digite o Login");
        String login = scanner.nextLine();
        return login;
    }
        
    /**
     * Obtém a senha do colaborador via entrada do usuário.
     *
     * @return Senha do colaborador informada.
     */
    public String getSenhaColaborador(){
        System.out.println("Digite o Senha");
        String senha = scanner.nextLine();
        return senha;
    }
    
    /**
     * Obtém o cargo do colaborador via entrada do usuário.
     *
     * @return Cargo do colaborador informado.
     */
    public String getCargoColaborador(){
        System.out.println("Digite o Cargo");
        String cargo = scanner.nextLine();
        return cargo;
    }
    
    /**
     * Exibe menu de opções para modificação de dados do colaborador.
     *
     * @return Opção selecionada para modificação (1-5).
     */
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
    
    /**
     * Solicita confirmação para remoção do colaborador.
     *
     * @return Resposta do usuário ('S' para sim, 'N' para não).
     */
    public String removeConfirmation(){
        System.out.println("Tem certeza que quer remover o Cliente? [S, N] ");
        return scanner.nextLine();     
    }
    
    /**
     * Exibe as informações do funcionário.
     *
     * @param funcionario Objeto {@link Funcionario} contendo as informações a serem exibidas.
     */
    public void mostrarColaborador(Funcionario funcionario){
        System.out.printf("Nome: %s%nEndereco: %s%nTelefone: "
                + "%s%nEmail: %s%nCpf: %s%nSalario: %s%nLogin: "
                + "%s%nSenha: %s%nCargo: %s%n",
                funcionario.getNome(), funcionario.getEndereco(), funcionario.getTelefone(),
                funcionario.getEmail(), funcionario.getCpf(), funcionario.getSalario(), funcionario.getLogin(),
                funcionario.getSenha(), funcionario.getCargo());
    }
}