package Model;

import java.util.Calendar;

/**
 * Representa uma diária como um tipo de conta financeira de ganho.
 * A diária está associada a um agendamento específico.
 */
public class Diaria extends Conta{
    
    int idAgendamento;
    
    /**
     * Construtor da classe {@code Diaria}.
     * Inicializa uma nova diária com valor, data, identificador e o ID do agendamento associado.
     *
     * @param valor        Valor da diária.
     * @param data         Data da diária.
     * @param id           Identificador único da diária.
     * @param idAgendamento Identificador do agendamento associado a esta diária.
     */
    public Diaria(double valor, Calendar data, int id, int idAgendamento){
        super("Diaria", "Ganho", valor, data, id);
        this.idAgendamento = idAgendamento;
        setType("Diaria");
    }
    
    /**
     * Obtém o identificador do agendamento associado a esta diária.
     * 
     * @return ID do agendamento.
     */
    public int getIdAgendamento() {
        return idAgendamento;
    }
    
    /**
     * Define o identificador do agendamento associado a esta diária.
     * 
     * @param idAgendamento Novo ID do agendamento.
     */
    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
    
    /**
     * Sobrescreve o método toString para retornar o nome da conta.
     *
     * @return Nome do conta.
     */
    @Override
    public String toString(){
        return this.getNome();
    }
}
