/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Controller.Manipulator.Manipulator;
import Model.Conta;
import Model.Produto;
import Model.Venda;
import View.TelaClientes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author caio
 */
public class ContasController implements ManipulatorController{
    Manipulator<Conta> manipulador;
    TelaClientes telaFinanceira = new TelaClientes();
    Scanner scanner = new Scanner(System.in);
    
    public void adicionarConta(String nome, String tipo, double valor, String dataStr, int id){
        Conta novaConta = validarConta(nome, tipo, valor, dataStr, id);
        manipulador.adicionar(novaConta);
    }
    
    public Conta validarConta(String nome, String tipo, double valor, String dataStr, int id){
        Calendar data = AgendamentosController.formatarHorario(dataStr);
        
        return new Conta(nome, tipo, valor, data, id);
    }
    
    public void adicionarVenda(String data, int id, int idCliente, int[] idProdutos, int[] quantidades){
        Venda novaVenda = validarVenda(data, id, idCliente, idProdutos, quantidades);
        manipulador.adicionar(novaVenda);
    }
    
    public Venda validarVenda(String dataStr, int id, int idCliente, int[] idProdutos, int[] quantidades){
        Calendar data = AgendamentosController.formatarHorario(dataStr);
        
        // Parte do código para obter os valores unitários de cada produto
        double[] valoresUnit = new double[idProdutos.length];
        ProdutoEstoqueController produtosController = Sistema.getManipuladorContrPorTipo(ProdutoEstoqueController.class);
        
        for (int i = 0; i < idProdutos.length; i++){
            Produto produto = produtosController.buscarProduto(idProdutos[i]);
            valoresUnit[i] = produto.getPreco();
            i++;
        }
        
        // Parte do código para calcular o Valor total
        double valor = 0;
        
        for (int i = 0; i < valoresUnit.length; i++){
            valor += valoresUnit[i] * quantidades[i];
        }
        
        return new Venda(valor, data, id, idCliente, idProdutos, quantidades, valoresUnit);
    }
    
    public void gerarBalancoMensal(int mes, int ano){

    }
    
    public void emitirRelatorioVendasMensal(Calendar mes){
        
    }
    
    public void emitirRelatorioVendasDiario(Calendar dia){
        
    }
    
    public List<Conta> buscarGanhosMes(int mes, int ano){
        ArrayList<Conta> ganhos = (ArrayList<Conta>)manipulador.getColecao();
        List<Conta> ganhosNoMes = new ArrayList<>();
        
        for (Conta ganho : ganhos){
            int mesGanho = ganho.getData().get(Calendar.MONTH);
            int anoGanho = ganho.getData().get(Calendar.YEAR);
            
            if (mesGanho == mes - 1 && anoGanho == ano - 1){
                ganhosNoMes.add(ganho);
            } 
        }
        
        return ganhosNoMes;
    }
    
    public List<Conta> buscarGastosMes(int mes, int ano){
        ArrayList<Conta> gastos = (ArrayList<Conta>)manipulador.getColecao();
        List<Conta> gastosNoMes = new ArrayList<>();
        
        for (Conta gasto : gastos){
            int mesGasto = gasto.getData().get(Calendar.MONTH);
            int anoGasto = gasto.getData().get(Calendar.YEAR);
            
            if (mesGasto == mes - 1 && anoGasto == ano - 1){
                gastosNoMes.add(gasto);
            } 
        }
        
        return gastosNoMes;
    }
    
    @Override
    public void salvar() throws IOException{
    
    }
    
    public void run(){
        
    }
}
