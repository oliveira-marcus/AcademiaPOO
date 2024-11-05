package View;

import Model.Agendamento;
import java.util.Scanner;

/**
 * Classe responsável pela interface de usuário para operações relacionadas a agendamentos.
 * Fornece métodos para exibir menus, coletar inputs do usuário e mostrar mensagens do sistema.
 */
public class TelaAgenda {
    
    /** Scanner para leitura de entrada do usuário */
    Scanner scanner = new Scanner(System.in);
    
    /**
     * Exibe o menu principal de operações de agendamento e retorna a opção escolhida pelo usuário.
     * 
     * @return Número inteiro representando a opção selecionada
     */
    public int exibirMenu(){
        System.out.println("1 - Fazer Agendamento");
        System.out.println("2 - Confirmar Agendamento");
        System.out.println("3 - Cancelar Agendamento");
        System.out.println("4 - Editar Agendamento");
        System.out.println("5 - Verificar Vaga");
        System.out.println("6 - Sair");
        System.out.println("Digite a opcao: ");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    /**
     * Solicita e retorna o ID de um agendamento.
     * 
     * @return ID do agendamento informado pelo usuário
     */
    public int getIdAgendamento(){
        System.out.println("Digite o ID da Reserva");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    /**
     * Solicita e retorna o ID do cliente para um agendamento.
     * 
     * @return ID do cliente informado pelo usuário
     */
    public int getIdClienteAgendamento(){
        System.out.println("Digite o ID do Cliente");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    /**
     * Exibe as opções de salas disponíveis e retorna a escolha do usuário.
     * 
     * @return Número inteiro representando a sala selecionada
     */
    public int getSalaAgendamento(){
        System.out.println("1 - Musculacao: Sala com foco em Hipertrofia!");
        System.out.println("2 - Pilates: Sala com foco em melhorar a Flexibilidade!");
        System.out.println("3 - Spinning: Sala com foco em melhorar a Resistencia");
        System.out.println("4 - Fit Dance: Sala para exercitar com diversao!");
        
        System.out.println("Qual das Salas sera?");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    /**
     * Solicita e retorna o preço da aula para o agendamento.
     * 
     * @return Valor da aula informado pelo usuário
     */
    public double getPrecoAulaAgendamento(){
        System.out.println("Digite o Preco da Aula");
        double opcao = scanner.nextDouble();
        scanner.nextLine();
        return opcao;
    }
    
    /**
     * Solicita e retorna o nome do instrutor para o agendamento.
     * 
     * @return Nome do instrutor informado pelo usuário
     */
    public String getNomeInstrutorAgendamento(){
        System.out.println("Digite o nome do Instrutor");
        return scanner.nextLine();
    }
    
    /**
     * Solicita e retorna a data e horário para o agendamento no formato [DD MM AAAA HH MM].
     * 
     * @return String contendo a data e horário informados pelo usuário
     */
    public String getDataHorarioAgendamento(){
        System.out.println("Digite o Horario: [DD MM AAAA HH MM]");
        return scanner.nextLine();
    }
    
    /**
     * Solicita e retorna o ID para uma nova diária.
     * 
     * @return ID da diária informado pelo usuário
     */
    public int getIdDiaria(){
        System.out.println("Digite o Id da diaria a ser criada");
        return scanner.nextInt();
    }
    
    /**
     * Exibe menu de opções para modificação de um agendamento e retorna a escolha do usuário.
     * 
     * @return Número inteiro representando o aspecto a ser modificado
     */
    public int modificarAgendamento(){
        System.out.println("1 - Sala");
        System.out.println("2 - Instrutor");
        System.out.println("3 - Data");
        
        System.out.println("Digite o que deseja alterar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    /**
     * Exibe todas as informações de um agendamento.
     * 
     * @param agendamento Objeto Agendamento cujas informações serão exibidas
     */
    public void mostrarAgendamento(Agendamento agendamento){
        System.out.printf("Id: %s%nEstado Reserva: %s%nId Cliente: %s%n"
                + "Sala: %s%nPreco Aula: %s%nNome Instrutor: %s%n"
                + "Data e Horario: %s%n",
                agendamento.getId(), agendamento.getEstadoReserva(),
                agendamento.getIdCliente(), agendamento.getSala(),
                agendamento.getPrecoAula(), agendamento.getNomeInstrutor(),
                agendamento.getDataHorario());
    }
    
    /**
     * Exibe o número de vagas disponíveis em uma determinada sala.
     * 
     * @param sala Nome ou identificador da sala
     * @param numVagas Número de vagas disponíveis
     */
    public void mostrarNumVagas(String sala, int numVagas){
        System.out.printf("Existem %s vagas na sala %s neste horario%n", numVagas, sala);
    }
    
    /**
     * Exibe mensagem de confirmação de criação de agendamento.
     * 
     * @param id ID do agendamento criado
     */
    public void displayMsgAgendamentoCriado(int id){
        System.out.printf("Novo produto criado com o ID %s%n", id);
    }
    
    /**
     * Exibe mensagem de confirmação de criação de diária.
     * 
     * @param id ID da diária criada
     */
    public void displayMsgDiariaCriada(int id){
        System.out.printf("Uma nova Conta Diaria sera criada com o Id %s%n", id);
    }
    
    /**
     * Exibe mensagem de erro ao tentar confirmar uma reserva já cancelada.
     */
    public void displayConfirmarCanceladaError(){
        System.out.println("Nao e possivel Confimar uma Reserva ja Cancelada");
    }
    
    /**
     * Exibe mensagem de erro ao tentar confirmar uma reserva já confirmada.
     */
    public void displayJaConfirmadaError(){
        System.out.println("Esta reserva ja foi Confirmada.");
    }
    
    /**
     * Exibe mensagem de erro ao tentar cancelar uma reserva já cancelada.
     */
    public void displayJaCanceladaError(){
        System.out.println("Esta reserva ja foi Cancelada.");
    }
    
    /**
     * Exibe mensagem de erro ao tentar cancelar uma reserva já confirmada.
     */
    public void displayCancelarConfirmadaError(){
        System.out.println("Nao e possivel Cancelar uma Reserva ja Confirmada");
    }
    
    /**
     * Exibe mensagem informativa sobre o cancelamento de diária próximo à data prevista.
     */
    public void displayMsgCancelarDiariaFeita(){
        System.out.println("Este agendamento esta sendo cancelada menos de 72 horas antes da data prevista");
        System.out.println("Por causa disso, metade do valor sera devolvido ao cliente");
    }
    
    /**
     * Exibe mensagem de erro ao tentar editar um agendamento próximo à data prevista.
     */
    public void displayEditarAtrasadoError(){
        System.out.println("Não é possível alterar o dia de um Agendamento menos de 72 horas antes da data prevista");
    }
    
    /**
     * Sobrescreve o toString para retornar informações sobre a classe
     * 
     * @return informações sobre a tela
     */
    @Override
    public String toString(){
        return "Tela com metodos de interface para a Agenda";
    }
}
