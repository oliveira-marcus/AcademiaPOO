/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalTime;

/**
 *
 * @author caio
 */
public class Reserva {
    
    private String  estadoReserva;
    private Cliente cliente;
    private Aula tipoAula;
    private double precoAula;
    private Funcionario instrutor;
    private LocalTime horario;
    
    public Reserva(String estadoReserva, Cliente cliente, Aula tipoAula, double precoAula, Funcionario instrutor) {
        this.estadoReserva = estadoReserva;
        this.cliente = cliente;
        this.tipoAula = tipoAula;
        this.precoAula = precoAula;
        this.instrutor = instrutor;
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

    public Aula getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(Aula tipoAula) {
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
    
    @Override
    public String toString() {
        return this.estadoReserva + ", Reserva feita por " + this.cliente.getNome();
    }
}

