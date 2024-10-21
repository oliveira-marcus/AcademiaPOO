/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Controller.Agenda;
import Controller.AreaClientes;
import Controller.AreaColaboradores;
import Controller.AreaEstoque;
import Controller.ListManipulator;
import Controller.Sistema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        List<ListManipulator> subsistemas = new ArrayList<>();
        
        subsistemas.add(new AreaClientes());
        subsistemas.add(new AreaColaboradores());
        subsistemas.add(new AreaEstoque());
        subsistemas.add(new Agenda());
        
        Sistema sistema = new Sistema(subsistemas);
        
        Agenda agenda = Sistema.getSubsistemaPorTipo(Agenda.class);
        
        agenda.adicionarAgendamento(1, 101, "Musculação", 0, "Caio Bruno", "11 10 2024 10 0");
 
        Sistema.salvarDados();
    }
    
}
