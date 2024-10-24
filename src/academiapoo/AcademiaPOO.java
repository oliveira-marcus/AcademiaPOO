/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Controller.Manipulator.AgendamentosManipulator;
import Controller.Manipulator.ClientesManipulator;
import Controller.Manipulator.ColaboradoresManipulator;
import Controller.Sistema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Controller.Manipulator.Manipulator;
import Model.Comparator.CompAgendamDataHorarioCresc;
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
        
        manipuladores.add(new AgendamentosManipulator());
        manipuladores.add(new ClientesManipulator());
        manipuladores.add(new ColaboradoresManipulator());
        
        Sistema sistema = new Sistema(manipuladores);
        
        AgendamentosManipulator agenda = Sistema.getSubsistemaPorTipo(AgendamentosManipulator.class);
        
        System.out.println(agenda.getAgendamentos());
        
        Collections.sort(agenda.getAgendamentos(), new CompAgendamDataHorarioCresc());
        
        System.out.println(agenda.getAgendamentos());
 
        Sistema.salvarDados();
    }
    
}
