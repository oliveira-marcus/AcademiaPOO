package Controller;

import Controller.Manipulator.Manipulator;
import Model.Agendamento;
import Model.Sala;
import View.TelaAgenda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador responsável pela gestão de agendamentos de salas e interação com a tela de agenda.
 */
public class AgendamentosController implements ManipulatorController{
    
    private Manipulator<Agendamento> manipulador;
    private TelaAgenda telaAgenda = new TelaAgenda();
    private int idMaximo;
    
    Sala[] salas = new Sala[]{
        new Sala("Musculacao", "Sala com foco em Hipertrofia!", 60),
        new Sala("Pilates", "Sala com foco em melhorar a Flexibilidade!", 30),
        new Sala("Spinning", "Sala com foco em melhorar a Resistencia!", 25),
        new Sala("Fit Dance", "Sala para exercitar com diversao!", 40)
    };
    
    /**
     * Construtor da classe {@code AgendamentosController}.
     * Inicializa o controlador de agendamentos com um manipulador específico.
     *
     * @param manipulador Manipulador de agendamentos.
     * @throws IOException Se ocorrer um erro durante a inicialização do manipulador.
     */
    public AgendamentosController(Manipulator manipulador) throws IOException{
        this.manipulador = manipulador;
        cancelarAgendamentosFeitos();
        
        List<Integer> ids = this.manipulador.getColecao().stream().map(agendamento -> agendamento.getId()).collect(Collectors.toList());
        this.idMaximo = Collections.max(ids);
    }
    
    /**
     * Cancela os agendamentos feitos que já passaram da data limite (5 dias) para confirmar
     */
    public final void cancelarAgendamentosFeitos(){
        for (Agendamento agendamento : this.manipulador.getColecao()){
            Calendar agora = Calendar.getInstance();
            Calendar dataLimite = (Calendar) agendamento.getDataHorario().clone();
            dataLimite.add(Calendar.HOUR_OF_DAY, -120); 
            
            if (agendamento.getEstadoReserva().equals("FEITA") && !agora.before(dataLimite)){
                agendamento.setEstadoReserva("CANCELADA");
            }
        }
    }
    
    /**
     * Adiciona um novo agendamento baseado nas informações obtidas da interface de agenda.
     */
    public void adicionarAgendamento(){
        idMaximo++;
        int idAgendamento = idMaximo;
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
        contasController.setIdMaximo(contasController.getIdMaximo() + 1);
        int idDiaria = contasController.getIdMaximo();
        contasController.criarDiaria(precoAula, dataHorario, idDiaria, idAgendamento);
        telaAgenda.displayMsgDiariaCriada(idDiaria);
    }
    
    /**
     * Confirma um agendamento específico, alterando seu estado para "CONFIRMADA", se aplicável.
     */
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
    
    /**
     * Cancela um agendamento específico, aplicando penalidades se necessário.
     */
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
    
    /**
     * Edita um agendamento existente, permitindo modificar a sala, o preço, o instrutor e o horário.
     */
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
                dataLimite.add(Calendar.HOUR_OF_DAY, -120); 
                
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
    /**
     * Altera o estado de reserva de um agendamento.
     *
     * @param agendamento Agendamento a ser modificado.
     * @param estadoReserva Novo estado de reserva.
     */
    public void editarEstadoReserva(Agendamento agendamento, String estadoReserva){
        agendamento.setEstadoReserva(estadoReserva);
    }
    
    /**
     * Altera a sala associada a um agendamento.
     *
     * @param agendamento Agendamento a ser modificado.
     * @param sala Nova sala para o agendamento.
     */
    public void editarSala(Agendamento agendamento, String sala){
        agendamento.setSala(sala);
    }
    
    /**
     * Modifica o preço da aula associada a um agendamento.
     *
     * @param agendamento Agendamento a ser modificado.
     * @param precoAula Novo preço da aula.
     */
    public void editarPrecoAula(Agendamento agendamento, double precoAula){
        agendamento.setPrecoAula(precoAula);
    }
    
    /**
     * Define um novo instrutor para o agendamento.
     *
     * @param agendamento Agendamento a ser modificado.
     * @param nomeInstrutor Novo nome do instrutor.
     */
    public void editarNomeInstrutor(Agendamento agendamento, String nomeInstrutor){
        agendamento.setNomeInstrutor(nomeInstrutor);    
    }
    
    /**
     * Modifica a data e horário de um agendamento.
     *
     * @param agendamento Agendamento a ser modificado.
     * @param dataHorario Nova data e horário para o agendamento.
     */
    public void editarDataHorario(Agendamento agendamento, Calendar dataHorario){
        agendamento.setDataHorario(dataHorario);
    }
    
    /**
     * Busca um agendamento pelo seu identificador.
     *
     * @param id Identificador do agendamento.
     * @return Agendamento correspondente ou null se não encontrado.
     */
    public Agendamento buscarAgendamento(Integer id){
        for (Agendamento agendamento : this.manipulador.getColecao()){
            if (agendamento.getId() == id){
                return agendamento;
            }
        }
        return null;
    }
    
    /**
     * Verifica a disponibilidade de vagas para uma sala e horário específicos.
     */
    public void verificarVaga(){
        String dataHorarioStr = telaAgenda.getDataHorarioAgendamento();
        String sala = salas[telaAgenda.getSalaAgendamento() - 1].getNome();
        Calendar dataHorario = formatarHorario(dataHorarioStr);
        int numVagas = getVagasHorario(sala, dataHorario);
        
        telaAgenda.mostrarNumVagas(sala, numVagas);
    }
    
    /**
     * Calcula o número de vagas disponíveis para uma sala em um determinado horário.
     *
     * @param salaAgendamento Nome da sala do agendamento.
     * @param dataHorarioAgendamento1 Data e horário do agendamento.
     * @return Número de vagas disponíveis.
     */
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
    
    /**
     * Converte uma string de data e hora em um objeto {@code Calendar}.
     *
     * @param dataHorarioString String no formato "dd MM yyyy HH mm".
     * @return Data e hora no formato {@code Calendar}.
     */
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
    
    /**
     * Converte um objeto {@code Calendar} em uma string no formato "dd/MM/yyyy HH:mm".
     *
     * @param dataHorario Data e hora no formato {@code Calendar}.
     * @return String formatada representando a data e hora.
     */
    public static String converterCalendarString(Calendar dataHorario){
        String dataHorarioStr = dataHorario.get(Calendar.DAY_OF_MONTH) +
                "/" + (dataHorario.get(Calendar.MONTH) + 1) +
                "/" + dataHorario.get(Calendar.YEAR) +
                " " + dataHorario.get(Calendar.HOUR_OF_DAY) + 
                ":" + dataHorario.get(Calendar.MINUTE);
        
        return dataHorarioStr;
    }
    
    /**
     * Salva o estado atual dos agendamentos.
     *
     * @throws IOException Se ocorrer um erro ao salvar os dados.
     */
    @Override
    public void salvar() throws IOException{
        this.manipulador.salvar();
    }
    
    /**
     * Executa o loop principal para interação com a interface de agenda.
     */
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
    
    /**
     * Obtém o manipulador de agendamentos.
     *
     * @return Manipulador de agendamentos.
     */
    public Manipulator<Agendamento> getManipulador() {
        return manipulador;
    }

    /**
     * Define o manipulador de agendamentos.
     *
     * @param manipulador Novo manipulador de agendamentos.
     */
    public void setManipulador(Manipulator<Agendamento> manipulador) {
        this.manipulador = manipulador;
    }

    /**
     * Retorna a tela da Agenda.
     * 
     * @return tela da Agenda.
     */
    public TelaAgenda getTelaAgenda() {
        return telaAgenda;
    }

    /**
     * Define a tela do Agenda.
     * 
     * @param telaAgenda tela do Agenda
     */
    public void setTelaAgenda(TelaAgenda telaAgenda) {
        this.telaAgenda = telaAgenda;
    }

    /**
     * Retorna o maior Id dos agendamentos
     * @return Maior id das agendamnetos
     */
    public int getIdMaximo() {
        return idMaximo;
    }
    
    /**
     * Define o id máximo dos agendamentos
     * @param idMaximo id máximo dos agendamentos
     */
    public void setIdMaximo(int idMaximo) {
        this.idMaximo = idMaximo;
    }

    /**
     * Retorna o array com as salas da academia
     * @return Salas da Academia
     */
    public Sala[] getSalas() {
        return salas;
    }

    /**
     * Define as salas da Academia
     * @param salas Array com as Salas da Academia
     */
    public void setSalas(Sala[] salas) {
        this.salas = salas;
    }
    
    /**
     * Método que sobrescreve o toString para exibir informações sobre o Controller
     * @return Informações sobre o Controller
     */
    @Override
    public String toString(){
        return "Controller referente a área de Agendamentos da Academia";
    }
}