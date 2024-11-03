package Controller;

import Controller.Manipulator.Manipulator;
import Model.Agendamento;
import Model.Sala;
import View.TelaAgenda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author caio
 */
public class AgendamentosController implements ManipulatorController{   
    Manipulator<Agendamento> manipulador;
    TelaAgenda telaAgenda = new TelaAgenda();
    
    Sala[] salas = new Sala[]{
        new Sala("Musculacao", "Sala com foco em Hipertrofia!", 60),
        new Sala("Pilates", "Sala com foco em melhorar a Flexibilidade!", 30),
        new Sala("Spinning", "Sala com foco em melhorar a Resistencia!", 25),
        new Sala("Fit Dance", "Sala para exercitar com diversao!", 40)
    };
    
    public AgendamentosController(Manipulator manipulador) throws IOException{
        this.manipulador = manipulador;
    }
    
    public void adicionarAgendamento(){
        int idAgendamento = manipulador.getColecao().size() + 1;
        int idCliente = telaAgenda.getIdClienteAgendamento();
        String sala = salas[telaAgenda.getSalaAgendamento() - 1].getNome();
        double precoAula = telaAgenda.getPrecoAulaAgendamento();
        String nomeInstrutor = telaAgenda.getNomeInstrutorAgendamento();
        String dataHorarioStr = telaAgenda.getDataHorarioAgendamento();
        Calendar dataHorario = formatarHorario(dataHorarioStr);
        
        // faz a busca do Cliente
        ClientesController areaClientes = Sistema.getManipuladorContrPorTipo(ClientesController.class);
        areaClientes.buscarCliente(idCliente);
        
        // faz a busca do Colaborador
        ColaboradoresController areaColaboradores = Sistema.getManipuladorContrPorTipo(ColaboradoresController.class);
        areaColaboradores.buscarColaborador(nomeInstrutor);
        
        manipulador.adicionar(new Agendamento(idAgendamento, "FEITA", idCliente, sala, 
                precoAula, nomeInstrutor, dataHorario));
        telaAgenda.displayMsgAgendamentoCriado(idAgendamento);
        
        ContasController contasController = Sistema.getManipuladorContrPorTipo(ContasController.class);
        int idDiaria = contasController.getManipulador().getColecao().size() + 1;
        contasController.criarDiaria(precoAula, dataHorario, idDiaria, idAgendamento);
        telaAgenda.displayMsgDiariaCriada(idDiaria);
    }
    
    public void confirmarAgendamento(){
        int id = telaAgenda.getIdAgendamento();
        Agendamento agendamento = buscarAgendamento(id);
        
        switch (agendamento.getEstadoReserva()) {

            case "CANCELADA" -> {
                 telaAgenda.displayConfirmarCanceladaError();
            }

            case "CONFIRMADA" -> {
                 telaAgenda.displayJaConfirmadaError();
            }
            default -> agendamento.setEstadoReserva("CONFIRMADA");
        }
    }
    
    public void cancelarAgendamento(){
        int id = telaAgenda.getIdAgendamento();
        Agendamento agendamento = buscarAgendamento(id);
        
        switch (agendamento.getEstadoReserva()) {
            case "CONFIRMADA" -> {
                 telaAgenda.displayCancelarConfirmadaError();
            }

            case "CANCELADA" -> {
                 telaAgenda.displayJaCanceladaError();
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
                    
                    telaAgenda.displayMsgCancelarDiariaFeita();
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
                editarSala(agendamento, salas[novaSala - 1].getNome());
                
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
                     telaAgenda.displayEditarAtrasadoError();
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
    
    public void verificarVaga(){
        String dataHorarioStr = telaAgenda.getDataHorarioAgendamento();
        String sala = salas[telaAgenda.getSalaAgendamento() - 1].getNome();
        Calendar dataHorario = formatarHorario(dataHorarioStr);
        int numVagas = getVagasHorario(sala, dataHorario);
        
        telaAgenda.mostrarNumVagas(sala, numVagas);
    }
    
    public int getVagasHorario(String salaAgendamento, Calendar dataHorarioAgendamento1){
        List<Agendamento> agendamentosMesmaHora = new ArrayList<>();
        
        for (Agendamento agendamento2 : manipulador.getColecao()){
            if (!agendamento2.getEstadoReserva().equals("CANCELADA")){
                Calendar dataHorarioAgendamento2 = agendamento2.getDataHorario();
            
                int hora1 = dataHorarioAgendamento1.get(Calendar.HOUR_OF_DAY);
                int hora2 = dataHorarioAgendamento2.get(Calendar.HOUR_OF_DAY);
                int dia1 = dataHorarioAgendamento1.get(Calendar.DAY_OF_MONTH);
                int dia2 = dataHorarioAgendamento2.get(Calendar.DAY_OF_MONTH);
                int mes1 = dataHorarioAgendamento1.get(Calendar.MONTH);
                int mes2 = dataHorarioAgendamento2.get(Calendar.MONTH);
                int ano1 = dataHorarioAgendamento1.get(Calendar.YEAR);
                int ano2 = dataHorarioAgendamento2.get(Calendar.YEAR);


                if (hora1 == hora2 && dia1 == dia2 && mes1 == mes2 && ano1 == ano2){
                   agendamentosMesmaHora.add(agendamento2);
                }
            }
        }
        
        int salaIndice = 0;
        for (int i = 0; i < salas.length; i++){
            if (salas[i].getNome().equals(salaAgendamento)){
                salaIndice = i; 
            }
        }
        
        return salas[salaIndice].getCapacidade() - agendamentosMesmaHora.size();
    }
    
    public static Calendar formatarHorario(String dataHorarioString){
        String[] dataHorarioStringSplitted = dataHorarioString.split(" ");
        int dia = Integer.parseInt(dataHorarioStringSplitted[0]);
        int mes = Integer.parseInt(dataHorarioStringSplitted[1]) - 1;  
        int ano = Integer.parseInt(dataHorarioStringSplitted[2]);
        int hora = Integer.parseInt(dataHorarioStringSplitted[3]);
        int minuto = Integer.parseInt(dataHorarioStringSplitted[4]);
        
        Calendar dataHorario = Calendar.getInstance();
        dataHorario.set(ano, mes, dia, hora, minuto, 0);
        
        return dataHorario;
    }
    
    public static String converterCalendarString(Calendar dataHorario){
        String dataHorarioStr = dataHorario.get(Calendar.DAY_OF_MONTH) +
                "/" + (dataHorario.get(Calendar.MONTH) + 1) +
                "/" + dataHorario.get(Calendar.YEAR) +
                " " + dataHorario.get(Calendar.HOUR_OF_DAY) + 
                ":" + dataHorario.get(Calendar.MINUTE);
        
        return dataHorarioStr;
    }
    
    @Override
    public void salvar() throws IOException{
        this.manipulador.salvar();
    }
    
    public Manipulator<Agendamento> getManipulador() {
        return manipulador;
    }

    public void setManipulador(Manipulator<Agendamento> manipulador) {
        this.manipulador = manipulador;
    }
    
    public void run(){
        int opcao = 0;
        
        while(opcao != 6){
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
                case 5 -> {
                    verificarVaga();
                }
            }
        }
    }
}