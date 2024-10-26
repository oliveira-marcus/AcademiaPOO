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
public class Agendamento {
    private int id;
    private String estadoReserva;
    private int idCliente;
    private String sala;
    private double precoAula;
    private String nomeInstrutor;
    public Calendar dataHorario;
    
    public Agendamento(int id, String estadoReserva, int idCliente, String sala, double precoAula, String nomeInstrutor, Calendar dataHorario) {
        this.id = id;
        this.estadoReserva = estadoReserva;
        this.idCliente = idCliente;  
        this.sala = sala;
        this.precoAula = precoAula;
        this.nomeInstrutor = nomeInstrutor;
        this.dataHorario = dataHorario;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public double getPrecoAula() {
        return precoAula;
    }

    public void setPrecoAula(double precoAula) {
        this.precoAula = precoAula;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }
    
    public Calendar getDataHorario(){
        return dataHorario;
    }
    
    public void setDataHorario(Calendar horario){
        this.dataHorario = horario;
    }
    
    @Override
    public String toString() {
        return this.estadoReserva;
    }
}
