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
    private String  estadoReserva;
    private Cliente cliente;
    private String tipoAula;
    private double precoAula;
    private Funcionario instrutor;
    public Calendar dataHorario;
    
    public Agendamento(int id, String estadoReserva, Cliente cliente, String tipoAula, double precoAula, Funcionario instrutor, Calendar dataHorario) {
        this.id = id;
        this.estadoReserva = estadoReserva;
        this.cliente = cliente;  
        this.tipoAula = tipoAula;
        this.precoAula = precoAula;
        this.instrutor = instrutor;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public double getPrecoAula() {
        return precoAula;
    }

    public void setPrecoAula(double precoAula) {
        this.precoAula = precoAula;
    }

    public Funcionario getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Funcionario instrutor) {
        this.instrutor = instrutor;
    }
    
    public Calendar getDataHorario(){
        return dataHorario;
    }
    
    public void setDataHorario(Calendar horario){
        this.dataHorario = horario;
    }
    
    @Override
    public String toString() {
        return this.estadoReserva + ", Reserva feita por " + this.cliente.getNome();
    }
}
