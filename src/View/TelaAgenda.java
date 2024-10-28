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
        System.out.println("5 - Sair");
        
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
        System.out.println("1 - Musculação: Sala com foco em Hipertrofia!");
        System.out.println("2 - Pilates: Sala com foco em melhorar a Flexibilidade!");
        System.out.println("3 - Spinning: Sala com foco em melhorar a Resistência");
        System.out.println("4 - Fit Dance: Sala para exercitar com diversão!");
        
        System.out.println("Qual das Salas será?");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    public double getPrecoAulaAgendamento(){
        System.out.println("Digite o Preço da Aula");
        double opcao = scanner.nextDouble();
        scanner.nextLine();
        return opcao;
    }
    
    public String getNomeInstrutorAgendamento(){
        System.out.println("Digite o nome do Instrutor");
        return scanner.nextLine();
    }
    
    public String getDataHorarioAgendamento(){
        System.out.println("Digite o Horário: [DD MM AAAA HH MM]");
        return scanner.nextLine();
    }
    
    public int getIdDiaria(){
        System.out.println("Digite o Id da diária a ser criada");
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
    
    public void displayMsgNovaDiaria(){
        System.out.println("Uma nova Conta DIÁRIA será criada");
    }
}
