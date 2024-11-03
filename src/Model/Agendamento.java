package Model;

import Controller.AgendamentosController;
import java.util.Calendar;

/**
 * Representa um agendamento de aula ou reserva de sala.
 * Contém informações sobre o estado da reserva, cliente, sala, instrutor, data e horário.
 */
public class Agendamento {
    
    private int id;
    private String estadoReserva;
    private int idCliente;
    private String sala;
    private double precoAula;
    private String nomeInstrutor;
    public Calendar dataHorario;
    
    /**
     * Construtor da classe {@code Agendamento}.
     * Inicializa um novo agendamento com os detalhes específicos do cliente, sala, 
     * instrutor, preço da aula e data/hora.
     *
     * @param id            Identificação única do agendamento.
     * @param estadoReserva Estado da reserva (ex: reservado, cancelado).
     * @param idCliente     Identificação única do cliente associado ao agendamento.
     * @param sala          Sala onde a aula será realizada.
     * @param precoAula     Preço da aula agendada.
     * @param nomeInstrutor Nome do instrutor responsável pela aula.
     * @param dataHorario   Data e horário do agendamento.
     */
    public Agendamento(int id, String estadoReserva, int idCliente, String sala, double precoAula, String nomeInstrutor, Calendar dataHorario) {
        this.id = id;
        this.estadoReserva = estadoReserva;
        this.idCliente = idCliente;  
        this.sala = sala;
        this.precoAula = precoAula;
        this.nomeInstrutor = nomeInstrutor;
        this.dataHorario = dataHorario;
    }
    
    /**
     * Obtém o identificador do agendamento.
     * 
     * @return ID do agendamento.
     */
    public int getId(){
        return id;
    }
    
    /**
     * Define o identificador do agendamento.
     * 
     * @param id Novo ID do agendamento.
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * Obtém o estado da reserva.
     * 
     * @return Estado da reserva.
     */
    public String getEstadoReserva() {
        return estadoReserva;
    }
    
    /**
     * Define o estado da reserva.
     * 
     * @param estadoReserva Novo estado da reserva.
     */
    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
    
    /**
     * Obtém o identificador do cliente associado ao agendamento.
     * 
     * @return ID do cliente.
     */
    public int getIdCliente() {
        return idCliente;
    }
    
    /**
     * Define o identificador do cliente associado ao agendamento.
     * 
     * @param idCliente Novo ID do cliente.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    /**
     * Obtém a sala onde a aula será realizada.
     * 
     * @return Sala da aula.
     */
    public String getSala() {
        return sala;
    }
    
    /**
     * Define a sala onde a aula será realizada.
     * 
     * @param sala Nova sala da aula.
     */
    public void setSala(String sala) {
        this.sala = sala;
    }
    
    /**
     * Obtém o preço da aula agendada.
     * 
     * @return Preço da aula.
     */
    public double getPrecoAula() {
        return precoAula;
    }
    
    /**
     * Define o preço da aula agendada.
     * 
     * @param precoAula Novo preço da aula.
     */
    public void setPrecoAula(double precoAula) {
        this.precoAula = precoAula;
    }

    /**
     * Obtém o nome do instrutor responsável pela aula.
     * 
     * @return Nome do instrutor.
     */
    public String getNomeInstrutor() {
        return nomeInstrutor;
    }
    
    /**
     * Define o nome do instrutor responsável pela aula.
     * 
     * @param nomeInstrutor Novo nome do instrutor.
     */
    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }
    
    /**
     * Obtém a data e horário do agendamento.
     * 
     * @return Data e horário do agendamento.
     */
    public Calendar getDataHorario(){
        return dataHorario;
    }
    
    /**
     * Define a data e horário do agendamento.
     * 
     * @param horario Nova data e horário do agendamento.
     */
    public void setDataHorario(Calendar horario){
        this.dataHorario = horario;
    }
    
    /**
     * Sobrescreve o método toString para retornar o estado da reserva.
     *
     * @return Estado atual da reserva.
     */
    @Override
    public String toString() {
        String horario = AgendamentosController.converterCalendarString(dataHorario);
        
        return this.estadoReserva + " no horario " + horario + " na sala de " + sala;
    }
}
