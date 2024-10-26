package Controller;

import Controller.Manipulator.Manipulator;
import Model.Agendamento;
import Model.Sala;
import View.TelaAgenda;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author caio
 */
public class AgendamentosController implements ManipulatorController{   
    Manipulator<Agendamento> manipulador;
    TelaAgenda telaAgenda = new TelaAgenda();
    Scanner scanner = new Scanner(System.in);
    
    Sala[] salas = new Sala[]{
        new Sala("Musculação", "Sala com foco em Hipertrofia!", 30.0, 100, 60),
        new Sala("Pilates", "Sala com foco em melhorar a Flexibilidade!", 40.0, 110, 30),
        new Sala("Spinning", "Sala com foco em melhorar a Resistencia!", 35, 90, 25),
        new Sala("Fit Dance", "Sala para exercitar com diversão!", 35.0, 90, 40)
    };
    
    public AgendamentosController(Manipulator manipulador) throws IOException{
        this.manipulador = manipulador;
    }
    
    public void adicionarAgendamento(int id, int idCliente, String sala, double precoAula, String nomeInstrutor, String dataHorarioStr){        
        Agendamento novoAgendamento = validarAgendamento(id, idCliente, sala, precoAula, nomeInstrutor, dataHorarioStr);
        manipulador.adicionar(novoAgendamento);
    }
    
    public Agendamento validarAgendamento(int id, int idCliente, String sala, double precoAula, String nomeInstrutor, String dataHorarioStr){
        // faz a busca do Cliente
        ClientesController areaClientes = Sistema.getManipuladorContrPorTipo(ClientesController.class);
        areaClientes.buscarCliente(idCliente);
        
        // faz a busca do Colaborador
        ColaboradoresController areaColaboradores = Sistema.getManipuladorContrPorTipo(ColaboradoresController.class);
        areaColaboradores.buscarColaborador(nomeInstrutor);
        
        Calendar dataHorario = formatarHorario(dataHorarioStr);
        
        return new Agendamento(id, "FEITA", idCliente, sala, precoAula, nomeInstrutor, dataHorario);
    }
    
    public void remover(Agendamento agendamento){
        this.manipulador.remover(agendamento);
    }
    
    public static Calendar formatarHorario(String dataHorarioString){
        String[] dataHorarioStringSplitted = dataHorarioString.split(" ");
        int dia = Integer.parseInt(dataHorarioStringSplitted[0]);
        int mes = Integer.parseInt(dataHorarioStringSplitted[1]);  
        int ano = Integer.parseInt(dataHorarioStringSplitted[2]);
        int hora = Integer.parseInt(dataHorarioStringSplitted[3]);
        int minuto = Integer.parseInt(dataHorarioStringSplitted[4]);
        
        Calendar dataHorario = Calendar.getInstance();
        dataHorario.set(Calendar.YEAR, ano);
        dataHorario.set(Calendar.MONTH, mes - 1); // Janeiro é 0 e Dezembro é 11, por isso diminuir 1
        dataHorario.set(Calendar.DAY_OF_MONTH, dia);
        dataHorario.set(Calendar.HOUR, hora);
        dataHorario.set(Calendar.MINUTE, minuto);
        
        return dataHorario;
    }

    public void editarEstadoReserva(Agendamento agendamento, String estadoReserva){
        agendamento.setEstadoReserva(estadoReserva);
    }
    
    public void editarSala(Agendamento agendamento, String sala){
        agendamento.setSala(sala);
    }
    
    public void editarPrecoAula(Agendamento agendamento, double precoAula){
        agendamento.setPrecoAula(precoAula);
    }
    
    public void editarNomeInstrutor(Agendamento agendamento, String nomeInstrutor){
        agendamento.setNomeInstrutor(nomeInstrutor);    
    }
    
    public void editarDataHorario(Agendamento agendamento, Calendar dataHorario){
        agendamento.setDataHorario(dataHorario);
    }
    
    public Agendamento buscarAgendamento(Integer id){
        for (Agendamento agendamento : this.manipulador.getColecao()){
            if (agendamento.getId() == id){
                return agendamento;
            }
        }
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        this.manipulador.salvar();
    }
    
    public void run(){
        int opcao = 0;
        
        while(opcao != 5){
            opcao = telaAgenda.exibirMenu();
        }
    }
}