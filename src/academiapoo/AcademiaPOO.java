/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Controller.Manipulator.AgendamentosManipulator;
import Controller.Manipulator.ClientesManipulator;
import Controller.Manipulator.ColaboradoresManipulator;
import Controller.Manipulator.EstoqueManipulator;
import Controller.Sistema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Controller.Manipulator.Manipulator;
import Controller.Manipulator.ProdutosManipulator;
import Model.Agendamento;
import Model.Cliente;
import Model.Comparator.CompAgendamDataHorarioCresc;
import Model.Funcionario;
import Model.Produto;
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
        Sistema.adicionarManipulador(new AgendamentosManipulator("src/data/agendamentos.json", Agendamento.class));
        Sistema.adicionarManipulador(new ClientesManipulator("src/data/clientes.json", Cliente.class));
        Sistema.adicionarManipulador(new ColaboradoresManipulator("src/data/colaboradores.json", Funcionario.class));
        Sistema.adicionarManipulador(new EstoqueManipulator("src/data/colaboradores.json"));
        Sistema.adicionarManipulador(new ProdutosManipulator("src/data/produtos.json", Produto.class));
        
        AgendamentosManipulator agenda = Sistema.getSubsistemaPorTipo(AgendamentosManipulator.class);
        
        System.out.println(agenda.getLista());
        
        Collections.sort(agenda.getLista(), new CompAgendamDataHorarioCresc());
        
        System.out.println(agenda.getLista());
 
        Sistema.salvarDados();
    }
    
}
