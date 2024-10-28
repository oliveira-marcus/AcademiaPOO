/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Controller.AgendamentosController;
import Controller.ClientesController;
import Controller.ColaboradoresController;
import Controller.ContasController;
import Controller.JsonController.ContaDeserializer;
import Controller.Manipulator.ListManipulator;
import Controller.Manipulator.MapManipulator;
import Controller.ProdutoEstoqueController;
import Controller.Sistema;
import Model.Agendamento;
import Model.Cliente;
import Model.Conta;
import Model.Diaria;
import Model.Funcionario;
import Model.Produto;
import Model.Venda;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        Sistema.adicionarManipuladorContr(new ProdutoEstoqueController(new ListManipulator("src/data/produtos.json", Produto.class),
        new MapManipulator("src/data/estoque.json", String.class, Integer.class)));
        
        ContaDeserializer deserializer = new ContaDeserializer("type");
        deserializer.registerContaType("Conta", Conta.class);
        deserializer.registerContaType("Venda", Venda.class);
        deserializer.registerContaType("Diaria", Diaria.class);
        Sistema.adicionarManipuladorContr(new ContasController(new ListManipulator("src/data/contas.json", Conta.class, deserializer)));
        
        
        ContasController contasController = Sistema.getManipuladorContrPorTipo(ContasController.class);
        
        Map<String, Double> balanco;
        balanco = contasController.gerarBalancoMensal(contasController.buscarContasMes(10, 2024));
        
        System.out.println(balanco);
        
//        Map<String, double[]> relatorioOutubro;
//        relatorioOutubro = contasController.emitirRelatorioVendas(contasController.filtrarVendas(contasController.buscarContasDia(22,10, 2024)));
//        
//        for (String key : relatorioOutubro.keySet()){
//            System.out.printf(key + " ");
//            
//            for(double valor : relatorioOutubro.get(key)){
//                System.out.printf(valor + " ");
//            }
//            System.out.println();
//        }
    }
}
