/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Controller.AgendamentosController;
import Controller.ClientesController;
import Controller.ColaboradoresController;
import Controller.ContasController;
import Controller.Manipulator.ListManipulator;
import Controller.Manipulator.MapManipulator;
import Controller.ProdutoEstoqueController;
import Controller.Sistema;
import Model.Agendamento;
import Model.Cliente;
import Model.Conta;
import Model.Funcionario;
import java.io.IOException;

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
        Sistema.adicionarManipuladorContr(new ClientesController(new ListManipulator("src/data/clientes.json", Cliente.class)));
        Sistema.adicionarManipuladorContr(new ColaboradoresController(new ListManipulator("src/data/colaboradores.json", Funcionario.class)));
        Sistema.adicionarManipuladorContr(new AgendamentosController(new ListManipulator("src/data/agendamentos.json", Agendamento.class)));
        Sistema.adicionarManipuladorContr(new ProdutoEstoqueController(new ListManipulator("src/data/produtos.json", Agendamento.class),
        new MapManipulator("estoque.json", String.class, Integer.class)));
        Sistema.adicionarManipuladorContr(new ContasController(new ListManipulator("src/data/agendamentos.json", Conta.class)));
        
        ContasController contasController = Sistema.getManipuladorContrPorTipo(ContasController.class);
    }
}
