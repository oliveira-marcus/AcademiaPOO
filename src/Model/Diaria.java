/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Calendar;

/**
 *
 * @author caio
 */
public class Diaria extends Conta{
    int idAgendamento;
    
    public Diaria(double valor, Calendar data, int id, int idAgendamento){
        super("Diaria", "Ganho", valor, data, id);
        this.idAgendamento = idAgendamento;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
    
    
}
