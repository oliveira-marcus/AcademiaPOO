package Controller;

import Controller.Manipulator.Manipulator;
import Model.Agendamento;
import Model.Sala;
import View.TelaAgenda;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author caio
 */
public class AgendamentosController implements ManipulatorController{   
    Manipulator<Agendamento> manipulador;
    TelaAgenda telaAgenda = new TelaAgenda();
    
    Sala[] salas = new Sala[]{
        new Sala("Musculação", "Sala com foco em Hipertrofia!", 60),
        new Sala("Pilates", "Sala com foco em melhorar a Flexibilidade!", 30),
        new Sala("Spinning", "Sala com foco em melhorar a Resistencia!", 25),
        new Sala("Fit Dance", "Sala para exercitar com diversão!", 40)
    };
    
    public AgendamentosController(Manipulator manipulador) throws IOException{
        this.manipulador = manipulador;
    }
    
    public void adicionarAgendamento(){        
        int id = telaAgenda.getIdAgendamento();
        int idCliente = telaAgenda.getIdClienteAgendamento();
        String sala = salas[telaAgenda.getSalaAgendamento()].getNome();
        double precoAula = telaAgenda.getPrecoAulaAgendamento();
        String nomeInstrutor = telaAgenda.getNomeInstrutorAgendamento();
        String dataHorarioStr = telaAgenda.getDataHorarioAgendamento();
        
        // faz a busca do Cliente
        ClientesController areaClientes = Sistema.getManipuladorContrPorTipo(ClientesController.class);
        areaClientes.buscarCliente(idCliente);
        
        // faz a busca do Colaborador
        ColaboradoresController areaColaboradores = Sistema.getManipuladorContrPorTipo(ColaboradoresController.class);
        areaColaboradores.buscarColaborador(nomeInstrutor);
        
        Calendar dataHorario = formatarHorario(dataHorarioStr);
        
        manipulador.adicionar(new Agendamento(id, "FEITA", idCliente, sala, 
                precoAula, nomeInstrutor, dataHorario));
    }
    
    public void confirmarAgendamento(){
        int id = telaAgenda.getIdAgendamento();
        Agendamento agendamento = buscarAgendamento(id);
        
        switch (agendamento.getEstadoReserva()) {

            case "CANCELADA" -> {
            }

            case "CONFIRMADA" -> {
            }
            default -> agendamento.setEstadoReserva("CONFIRMADA");
        }
        // telaAgenda.displayConfirmarCanceladaError();
        // telaAgenda.displayJaConfirmadaError();
            }
    
    public void cancelarAgendamento(){
        int id = telaAgenda.getIdAgendamento();
        Agendamento agendamento = buscarAgendamento(id);
        
        switch (agendamento.getEstadoReserva()) {
            case "CONFIRMADA" -> {
                // telaAgenda.displayAgoraJaEraError();
            }

            case "CANCELADA" -> {
                // telaAgenda.displayJaCanceladaError();
            }
            default -> {
                Calendar agora = Calendar.getInstance();
                Calendar dataLimite = (Calendar) agendamento.getDataHorario().clone();
                dataLimite.add(Calendar.HOUR_OF_DAY, -72);
                if (agora.before(dataLimite)){
                    agendamento.setEstadoReserva("CANCELADA");
                }
                else{
                    ContasController contasController = Sistema.getManipuladorContrPorTipo(ContasController.class);
                    contasController.cortarValorDiariaMetade(agendamento.getId());
                    
                    agendamento.setEstadoReserva("CANCELADA");
                }
            }
        }
        
        
            }
    
    public void editarAgendamento(){
        int id = telaAgenda.getIdAgendamento();
        Agendamento agendamento = buscarAgendamento(id);
        telaAgenda.mostrarAgendamento(agendamento);
        System.out.println();
        int opcaoModificacao = telaAgenda.modificarAgendamento();

        switch(opcaoModificacao){
            case 1 -> {
                int novaSala = telaAgenda.getSalaAgendamento();
                editarSala(agendamento, salas[novaSala].getNome());
                
                double novoPrecoAula = telaAgenda.getPrecoAulaAgendamento();
                editarPrecoAula(agendamento, novoPrecoAula);
            }
            case 2 -> {
                String novoNomeInstrutor = telaAgenda.getNomeInstrutorAgendamento();
                editarNomeInstrutor(agendamento, novoNomeInstrutor);
            }
            case 3 -> {
                Calendar agora = Calendar.getInstance();
                Calendar dataLimite = (Calendar) agendamento.getDataHorario().clone();
                dataLimite.add(Calendar.HOUR_OF_DAY, -72);
                
                if(agora.before(dataLimite)){
                    String novaDataHorario = telaAgenda.getDataHorarioAgendamento();
                    editarDataHorario(agendamento, formatarHorario(novaDataHorario));
                }
                else{
                    // telaAgenda.displayAgoraJaEraError();
                }
                
            }
        }
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
    
    public static Calendar formatarHorario(String dataHorarioString){
        String[] dataHorarioStringSplitted = dataHorarioString.split(" ");
        int dia = Integer.parseInt(dataHorarioStringSplitted[0]);
        int mes = Integer.parseInt(dataHorarioStringSplitted[1]);  
        int ano = Integer.parseInt(dataHorarioStringSplitted[2]);
        int hora = Integer.parseInt(dataHorarioStringSplitted[3]);
        int minuto = Integer.parseInt(dataHorarioStringSplitted[4]);
        
        Calendar dataHorario = Calendar.getInstance();
        dataHorario.set(ano, mes-1, dia, hora, minuto, 0);
        
        return dataHorario;
    }
    
    @Override
    public void salvar() throws IOException{
        this.manipulador.salvar();
    }
    
    public void run(){
        int opcao = 0;
        
        while(opcao != 5){
            opcao = telaAgenda.exibirMenu();
            
            switch (opcao){
                case 1 -> {
                    adicionarAgendamento();
                }
                case 2 -> {
                    confirmarAgendamento();
                }
                case 3 -> {
                    cancelarAgendamento();
                }
                case 4 -> {
                    editarAgendamento();
                }
            }
        }
    }
}