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
    private static final AreaClientes areaClientes = new AreaClientes();
    private static final AreaColaboradores areaColaboradores = new AreaColaboradores();
    private static final AreaEstoque areaEstoque = new AreaEstoque();
    private static final AreaFinanceira areaFinanceira = new AreaFinanceira();
    private static final Agenda agenda = new Agenda();

    public static AreaClientes getAreaClientes() {
        return areaClientes;
    }

    public static AreaColaboradores getAreaColaboradores() {
        return areaColaboradores;
    }

    public static AreaEstoque getAreaEstoque() {
        return areaEstoque;
    }

    public static AreaFinanceira getAreaFinanceira() {
        return areaFinanceira;
    }

    public static Agenda getAgenda() {
        return agenda;
    }
}
