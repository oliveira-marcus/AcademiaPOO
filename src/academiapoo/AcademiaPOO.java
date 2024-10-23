/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Controller.Agenda;
import Controller.AreaClientes;
import Controller.AreaColaboradores;
import Controller.Sistema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Controller.Manipulator;
import Model.CompAgendamDataHorarioCresc;
import java.util.Collections;

/**
 *
 * @author caio
 */
public class AcademiaPOO {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        List<Manipulator> manipuladores = new ArrayList<>();
        
        manipuladores.add(new Agenda());
        manipuladores.add(new AreaClientes());
        manipuladores.add(new AreaColaboradores());
        
        Sistema sistema = new Sistema(manipuladores);
        
        Agenda agenda = Sistema.getSubsistemaPorTipo(Agenda.class);
        
        System.out.println(agenda.getAgendamentos());
        
        Collections.sort(agenda.getAgendamentos(), new CompAgendamDataHorarioCresc());
        
        System.out.println(agenda.getAgendamentos());
 
        Sistema.salvarDados();
    }
    
}
