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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author caio
 */
public class ContasController implements ManipulatorController{
    Manipulator<Conta> manipulador;
    TelaClientes telaFinanceira = new TelaClientes();
    Scanner scanner = new Scanner(System.in);
    
    public ContasController(Manipulator<Conta> manipulador) throws IOException{
        this.manipulador = manipulador;
    }
    
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
    
    public Map<String, Double> gerarBalancoMensal(List<Conta> contasPeriodo){
        Map<String, Double> contasBalanco = new HashMap<>();
        
        for (Conta conta : contasPeriodo){
            if (contasBalanco.containsKey(conta.getNome())){
                Double quantidadeNova = contasBalanco.get(conta.getNome()) + conta.getValor();
                contasBalanco.put(conta.getNome(), quantidadeNova);
            }
            else{
                contasBalanco.put(conta.getNome(), conta.getValor());
            }
        }
        
        return contasBalanco;
    }
    
    public Map<String, double[]> emitirRelatorioVendas(List<Venda> vendasPeriodo){
        Map<String, double[]> vendas = new HashMap<>();
        ProdutoEstoqueController produtosController = Sistema.getManipuladorContrPorTipo(ProdutoEstoqueController.class);
        
        for (Venda venda : vendasPeriodo){ // Iterando as vendas
            for (int j = 0; j < venda.getIdProdutos().length; j++){ // Iterando os produtos de cada venda
                Produto produto = produtosController.buscarProduto(venda.getIdProdutos()[j]);
                String nomeProduto = produto.getNome();
                
                if (vendas.containsKey(nomeProduto) 
                        && vendas.get(nomeProduto)[2] == venda.getValoresUnit()[j]){ // Caso o produto estiver dento do map e tiver o mesmo valor de Venda, atualizar apenas
                    vendas.get(nomeProduto)[3] += venda.getQuantidades()[j]; // Atualizando Quantidade Vendida
                    vendas.get(nomeProduto)[4] += venda.getValoresUnit()[j] * venda.getQuantidades()[j]; // Atualizando Valor Vendido
                }
                
                else{ // Caso o produto não estiver dentro do Map, colocar ele la dentro
                    vendas.put(nomeProduto, new double[]{venda.getIdProdutos()[j], produto.getPreco(), 
                        venda.getValoresUnit()[j], venda.getQuantidades()[j], venda.getValoresUnit()[j] * venda.getQuantidades()[j]});
                }
            }
        }
        
        return vendas;
    }
    
    public List<Conta> buscarContasMes(int mes, int ano){
        ArrayList<Conta> contas = (ArrayList<Conta>)manipulador.getColecao();
        List<Conta> contasNoMes = new ArrayList<>();
        
        for (Conta ganho : contas){
            int mesGanho = ganho.getData().get(Calendar.MONTH);
            int anoGanho = ganho.getData().get(Calendar.YEAR);
            
            if (mesGanho + 1== mes && anoGanho == ano){
                contasNoMes.add(ganho);
            } 
        }
        
        return contasNoMes;
    }
    
    public List<Conta> buscarContasDia(int dia, int mes, int ano){
        ArrayList<Conta> contas = (ArrayList<Conta>)manipulador.getColecao();
        List<Conta> contasNoMes = new ArrayList<>();
        
        for (Conta gasto : contas){
            int diaGasto = gasto.getData().get(Calendar.DAY_OF_MONTH);
            int mesGasto = gasto.getData().get(Calendar.MONTH);
            int anoGasto = gasto.getData().get(Calendar.YEAR);
            
            if (diaGasto == dia && mesGasto + 1 == mes && anoGasto == ano){
                contasNoMes.add(gasto);
            } 
        }
        
        return contasNoMes;
    }
    
    public List<Venda> filtrarVendas(List<Conta> ganhos){
        List<Venda> vendas = new ArrayList<>();
        
        for (Conta ganho : ganhos){
            if (ganho instanceof Venda venda){
                vendas.add(venda);
            }
        }
        return vendas;
    }
    
    @Override
    public void salvar() throws IOException{
    
    }
    
    public void run(){
        
    }

    public Manipulator<Conta> getManipulador() {
        return manipulador;
    }

    public void setManipulador(Manipulator<Conta> manipulador) {
        this.manipulador = manipulador;
    }
}
