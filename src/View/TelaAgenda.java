/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Agendamento;
import java.util.Scanner;

/**
 *
 * @author caio
 */
public class TelaAgenda {
    Scanner scanner = new Scanner(System.in);
    
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
    
    public int getIdAgendamento(){
        System.out.println("Digite o ID da Reserva");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    public int getIdClienteAgendamento(){
        System.out.println("Digite o ID do Cliente");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
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
    
    public double getPrecoAulaAgendamento(){
        System.out.println("Digite o Preco da Aula");
        double opcao = scanner.nextDouble();
        scanner.nextLine();
        return opcao;
    }
    
    public String getNomeInstrutorAgendamento(){
        System.out.println("Digite o nome do Instrutor");
        return scanner.nextLine();
    }
    
    public String getDataHorarioAgendamento(){
        System.out.println("Digite o Horario: [DD MM AAAA HH MM]");
        return scanner.nextLine();
    }
    
    public int getIdDiaria(){
        System.out.println("Digite o Id da diaria a ser criada");
        return scanner.nextInt();
    }
    
    public int modificarAgendamento(){
        System.out.println("1 - Sala");
        System.out.println("2 - Instrutor");
        System.out.println("3 - Data");
        
        System.out.println("Digite o que deseja alterar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    public void mostrarAgendamento(Agendamento agendamento){
        System.out.printf("Id: %s%nEstado Reserva: %s%nId Cliente: %s%n"
                + "Sala: %s%nPreco Aula: %s%nNome Instrutor: %s%n"
                + "Data e Horario: %s%n",
                agendamento.getId(), agendamento.getEstadoReserva(),
                agendamento.getIdCliente(), agendamento.getSala(),
                agendamento.getPrecoAula(), agendamento.getNomeInstrutor(),
                agendamento.getDataHorario());
    }
    
    public void mostrarNumVagas(String sala, int numVagas){
        System.out.printf("Existem %s vagas na sala %s neste horario%n", numVagas, sala);
    }
    
    public void displayMsgNovaDiaria(){
        System.out.println("Uma nova Conta DIARIA sera criada");
    }
    
    public void displayConfirmarCanceladaError(){
        System.out.println("Nao e possivel Confimar uma Reserva ja Cancelada");
    }
    
    public void displayJaConfirmadaError(){
        System.out.println("Esta reserva ja foi Confirmada.");
    }
    
    public void displayJaCanceladaError(){
        System.out.println("Esta reserva ja foi Cancelada.");
    }
    
    public void displayCancelarConfirmadaError(){
        System.out.println("Nao e possivel Cancelar uma Reserva ja Confirmada");
    }
    
    public void displayMsgCancelarDiariaFeita(){
        System.out.println("Este agendamento esta sendo cancelada menos de 72 horas antes da data prevista");
        System.out.println("Por causa disso, metade do valor sera devolvido ao cliente");
    }
    
    public void displayEditarAtrasadoError(){
        System.out.println("Não é possível alterar o dia de um Agendamento menos de 72 horas antes da data prevista");
    }
}
