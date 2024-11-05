package View;

import Model.Cliente;
import java.util.Scanner;

/**
 * Classe responsável pela interface de usuário para gestão de clientes.
 * Fornece métodos para incluir, editar, remover e exibir informações de clientes.
 */
public class TelaClientes {
    
    /** Scanner para leitura de entrada do usuário */
    Scanner scanner = new Scanner(System.in);
    
    /**
     * Exibe o menu principal de gestão de clientes.
     *
     * @return Opção selecionada pelo usuário (1-5).
     */
    public int exibirMenu(){
        int opcao = 0;
        
        while (opcao != 4){
            System.out.println("1 - Incluir Cliente (Fazer Reserva)");
            System.out.println("2 - Editar Cliente");
            System.out.println("3 - Remover Cliente");
            System.out.println("4 - Mostrar dados de um Cliente");
            System.out.println("5 - Sair");
            System.out.println();
            
            System.out.println("Digite a opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
            
        }
        return 4;
    }
    
    /**
     * Obtém o nome do cliente via entrada do usuário.
     *
     * @return Nome do cliente informado.
     */
    public String getNomeCliente(){
        System.out.println("Digite o nome do cliente: ");
        return scanner.nextLine();
        }
        
    /**
     * Obtém o endereço do cliente via entrada do usuário.
     *
     * @return Endereço do cliente informado.
     */
    public String getEnderecoCliente(){
        System.out.println("Digite o endereco do cliente: ");
        return scanner.nextLine();
    }

    /**
     * Obtém o telefone do cliente via entrada do usuário.
     *
     * @return Telefone do cliente informado.
     */
    public String getFoneCliente(){
        System.out.println("Digite o telefone do cliente: ");
        return scanner.nextLine();
    }

    /**
     * Obtém o email do cliente via entrada do usuário.
     *
     * @return Email do cliente informado.
     */
    public String getEmailCliente(){
        System.out.println("Digite o email do cliente: ");
        return scanner.nextLine();
    }

    /**
     * Obtém o CPF do cliente via entrada do usuário.
     *
     * @return CPF do cliente informado.
     */
    public String getCpfCliente(){
        System.out.println("Digite o CPF do cliente: ");
        return scanner.nextLine();
    }

    /**
     * Obtém o cartão de crédito do cliente via entrada do usuário.
     *
     * @return Cartão de crédito do cliente informado.
     */
    public String getCartaoCliente(){
        System.out.println("Digite o Cartao de Credito do cliente: ");
        return scanner.nextLine();
    }
    
    /**
     * Obtém o ID do cliente via entrada do usuário.
     *
     * @return ID do cliente informado.
     */
    public int getIdCliente(){
        System.out.println("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        return idCliente;
    }
    
    /**
     * Exibe menu de opções para modificação de dados do cliente.
     *
     * @return Opção selecionada para modificação (1-4).
     */
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
    
    /**
     * Solicita confirmação para remoção do cliente.
     *
     * @return Resposta do usuário ('S' para sim, 'N' para não).
     */
    public String removeConfirmation(){
        System.out.println("Tem certeza que quer remover o Cliente? [S, N] ");
        return scanner.nextLine();
    }
    
    /**
     * Exibe as informações do cliente.
     *
     * @param cliente Objeto {@link Cliente} contendo as informações a serem exibidas.
     */
    public void mostrarCliente(Cliente cliente){
        System.out.printf("Nome: %s%nEndereco: %s%nTelefone: %s%nEmail: %s%nCpf: %s%n", 
                cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getEmail(), cliente.getCpf());
    }
    
    /**
     * Exibe mensagem de confirmação de criação de novo cliente.
     *
     * @param id ID do cliente recém-criado.
     */
    public void displayMsgClienteCriado(int id){
        System.out.printf("Novo cliente criado com o ID %s%n", id);
    }
    
    /**
     * Exibe mensagem de erro para nome inválido.
     */
    public void displayNomeInvalido(){
        System.out.println("O nome que voce digitou e invalido! ");
    }
    
    /**
     * Sobrescreve o toString para retornar informações sobre a classe
     * 
     * @return informações sobre a tela
     */
    @Override
    public String toString(){
        return "Tela com metodos de interface para a secao de Clientes";
    }
}
