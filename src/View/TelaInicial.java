package View;

import java.util.Scanner;

/**
* Classe responsável pela interface inicial do sistema.
* Fornece o menu principal que dá acesso às diferentes áreas do sistema
* e exibe mensagens relacionadas à manipulação de dados.
*/
public class TelaInicial {
    
    /** Scanner para leitura de entrada do usuário */
    Scanner scanner = new Scanner(System.in);
    
    /**
    * Exibe o menu principal do sistema com todas as áreas disponíveis.
    * Apresenta opções como acesso a clientes, colaboradores, estoque,
    * agendamentos, financeiro, catraca, além de opções para salvar dados e sair.
    * 
    * @return Número inteiro representando a área selecionada pelo usuário
    */
    public int exibirMenu(){
        System.out.println("1 - Clientes");
        System.out.println("2 - Colaboradores");
        System.out.println("3 - Catalogo/Estoque");
        System.out.println("4 - Agendamentos");
        System.out.println("5 - Financeiro");
        System.out.println("6 - Catraca");
        System.out.println("7 - Salvar Dados");
        System.out.println("8 - Sair");
        System.out.println("Digite a area que deseja acessar: ");
        
        return scanner.nextInt(); 
    }
    
    /**
    * Exibe mensagem confirmando que os dados foram salvos com sucesso.
    */
    public void displayMsgDadosSalvos(){
        System.out.println("Os dados foram Salvos");
    }
    
    /**
     * Sobrescreve o toString para retornar informações sobre a classe
     * 
     * @return informações sobre a tela
     */
    @Override
    public String toString(){
        return "Tela com métodos de interface para a Tela Inicial do programa";
    }
}
