/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author caio
 */
public class Sistema {
    public final AreaClientes areaClientes = new AreaClientes();
    public final AreaColaboradores areaColaboradores = new AreaColaboradores();
    public final AreaEstoque areaEstoque = new AreaEstoque();
    public final AreaFinanceira areaFinanceira = new AreaFinanceira();
    public final Agenda agenda = new Agenda();

    public AreaClientes getAreaClientes() {
        return areaClientes;
    }

    public AreaColaboradores getAreaColaboradores() {
        return areaColaboradores;
    }

    public AreaEstoque getAreaEstoque() {
        return areaEstoque;
    }

    public AreaFinanceira getAreaFinanceira() {
        return areaFinanceira;
    }

    public Agenda getAgenda() {
        return agenda;
    }
}
