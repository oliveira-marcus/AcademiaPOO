/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Controller.Manipulator.Manipulator;
import Model.Conta;
import Model.Diaria;
import Model.Funcionario;
import Model.Produto;
import Model.Venda;
import View.TelaFinanceira;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author caio
 */
public class ContasController implements ManipulatorController{
    Manipulator<Conta> manipulador;
    TelaFinanceira telaFinanceira = new TelaFinanceira();
    
    public ContasController(Manipulator<Conta> manipulador) throws IOException{
        this.manipulador = manipulador;
    }
    
    public void vender(){
        List<Integer> idsProduto = new ArrayList<>();
        List<Integer> quantidadesProduto = new ArrayList<>();
        List<String> nomesProduto = new ArrayList<>();
        ProdutoEstoqueController produtosController = Sistema.getManipuladorContrPorTipo(ProdutoEstoqueController.class);
        
        int idVenda = telaFinanceira.getIdConta();
        int idCliente = telaFinanceira.getIdClienteComprador();
        int idProduto = -1;
        
        while (idProduto != 0){
            idProduto = telaFinanceira.getIdProdutoVendido();
            
            if (idProduto != 0){
                idsProduto.add(idProduto);
                String nomeProduto = produtosController.buscarProduto(idProduto).getNome();
                nomesProduto.add(nomeProduto);
                
                int quantidadeProduto = telaFinanceira.getQuantidadeProdutoVendido();
                quantidadesProduto.add(quantidadeProduto);
            }
        }
        
        int[] idsProdutoArray = idsProduto.stream().mapToInt(i -> i).toArray();
        int[] quantidadesProdutoArray = quantidadesProduto.stream().mapToInt(i -> i).toArray();
        
        String[] nomesProdutoArray = new String[nomesProduto.size()];
        nomesProduto.toArray(nomesProdutoArray);
        
        Venda novaVenda = construirVenda(Calendar.getInstance(),
                idVenda, idCliente, idsProdutoArray, quantidadesProdutoArray);
        
        manipulador.adicionar(novaVenda);
        
        telaFinanceira.exibirExtrato(nomesProdutoArray, quantidadesProdutoArray, 
                novaVenda.getValoresUnit(), novaVenda.getValor());
    }
    
    
    public void adicionarConta(){
        String nome = telaFinanceira.getNomeConta();
        String tipo = telaFinanceira.getTipoConta();
        double valor = telaFinanceira.getValorConta();
        String dataStr = telaFinanceira.getDataConta();
        int id = telaFinanceira.getIdConta();
        
        Calendar data = AgendamentosController.formatarHorario(dataStr);
        Conta novaConta = new Conta(nome, tipo, valor, data, id);
        manipulador.adicionar(novaConta);
    }
    
    public void removerConta(){
        int id = telaFinanceira.getIdConta();
        Conta conta = buscarConta(id);
        telaFinanceira.mostrarConta(conta);
        String opcaoConfirmacao = telaFinanceira.removeConfirmation();
        
        if (opcaoConfirmacao.equals("S")){
            manipulador.remover(conta);
        }
    }
    
    public void editarConta(){
        int id = telaFinanceira.getIdConta();
        Conta conta = buscarConta(id);
        telaFinanceira.mostrarConta(conta);
        System.out.println();
        int opcaoModificacao = telaFinanceira.modificarConta();
        
        switch(opcaoModificacao){
            case 1 -> {
                String novoNome = telaFinanceira.getNomeConta();
                editarNome(conta, novoNome);
            }
            case 2 -> {
                String novoTipo = telaFinanceira.getTipoConta();
                editarTipo(conta, novoTipo);
            }
            case 3 -> {
                double novoValor = telaFinanceira.getValorConta();
                editarValor(conta, novoValor);
            }
            case 4 -> {
                String novaData = telaFinanceira.getDataConta();
                editarData(conta, 
                        AgendamentosController.formatarHorario(novaData));
            }
        }
    }
    
    public void editarNome(Conta conta, String nomeNovo){
        conta.setNome(nomeNovo);
    }
    
    public void editarTipo(Conta conta, String tipoNovo){
        conta.setTipo(tipoNovo);
    }
    
    public void editarValor(Conta conta, double valorNovo){
        conta.setValor(valorNovo);
    }
    
    public void editarData(Conta conta, Calendar dataNova){
        conta.setData(dataNova);
    }
    
    public Venda construirVenda(Calendar data, int id, int idCliente, int[] idProdutos, int[] quantidades){
        // Parte do código para obter os valores unitários de cada produto
        double[] valoresUnit = new double[idProdutos.length];
        ProdutoEstoqueController produtosController = Sistema.getManipuladorContrPorTipo(ProdutoEstoqueController.class);
        
        for (int i = 0; i < idProdutos.length; i++){
            Produto produto = produtosController.buscarProduto(idProdutos[i]);
            valoresUnit[i] = produto.getPreco();
        }
        
        // Parte do código para calcular o Valor total
        double valor = 0;
        
        for (int i = 0; i < valoresUnit.length; i++){
            valor += valoresUnit[i] * quantidades[i];
        }
        
        return new Venda(valor, data, id, idCliente, idProdutos, quantidades, valoresUnit);
    }
    
    public void emitirBalanco(){
        int mes = telaFinanceira.getMes();
        int ano = telaFinanceira.getAno();
        
        Map<String, Double> balanco = gerarBalanco(buscarContasMes(mes, ano));
        
//        telaFinanceira.mostrarBalanco(balanco);
    }
    
    public void emitirRelatorio(){
        int opcaoPeriodo = telaFinanceira.getPeriodo();
        
        if (opcaoPeriodo == 1){
            int dia = telaFinanceira.getDia();
            int mes = telaFinanceira.getMes();
            int ano = telaFinanceira.getAno();
            
            List<Venda> vendas = filtrarVendas(buscarContasDia(dia, mes, ano));
            
//            telaFinanceira.mostrarRelatorio(vendas);
        }
        
        else if (opcaoPeriodo == 2){
            int mes = telaFinanceira.getMes();
            int ano = telaFinanceira.getAno();
            
            List<Venda> vendas = filtrarVendas(buscarContasMes(mes, ano));
            
//            telaFinanceira.mostrarRelatorio(vendas);
        }
    }
    
    public Map<String, Double> gerarBalanco(List<Conta> contasPeriodo){
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
    
    public Map<String, double[]> gerarRelatorioVendas(List<Venda> vendasPeriodo){
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
    
    public Conta buscarConta(int id){
        for(Conta conta : this.manipulador.getColecao()){
            if (conta.getId() == id){
                return conta;
            }
        }
        return null;
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
        List<Conta> contasNoDia = new ArrayList<>();
        
        for (Conta gasto : contas){
            int diaGasto = gasto.getData().get(Calendar.DAY_OF_MONTH);
            int mesGasto = gasto.getData().get(Calendar.MONTH);
            int anoGasto = gasto.getData().get(Calendar.YEAR);
            
            if (diaGasto == dia && mesGasto + 1 == mes && anoGasto == ano){
                contasNoDia.add(gasto);
            } 
        }
        
        return contasNoDia;
    }
    
    public List<Venda> filtrarVendas(List<Conta> contas){
        List<Venda> vendas = new ArrayList<>();
        
        for (Conta conta : contas){
            if (conta instanceof Venda venda){
                vendas.add(venda);
            }
        }
        return vendas;
    }
    
    public void criarDiaria(double valor, Calendar data, int id, int idAgendamento){
        manipulador.adicionar(new Diaria(valor, data, id, idAgendamento));
    }
    
    public void cortarValorDiariaMetade(int idAgendamento){
        ArrayList<Conta> contas = (ArrayList<Conta>)manipulador.getColecao();
        
        for (Conta conta : contas){
            if (conta instanceof Diaria diaria){
                if(diaria.getIdAgendamento() == idAgendamento){
                    diaria.setValor(diaria.getValor()/2);
                }
            }
        }
    }
    
    @Override
    public void salvar() throws IOException{
        manipulador.salvar();
    }
    
    public void run(){
        Funcionario funcionarioLogado = Sistema.getLogin().getFuncLogado();
        
        int opcao;
        if (funcionarioLogado.getCargo().equals("Administrador")){
            opcao = telaFinanceira.exibirMenuAdmin();
            
            switch(opcao){
                case 2 ->{
                    adicionarConta();
                }
                
                case 3 ->{
                    removerConta();
                }
                
                case 4 ->{
                    editarConta();
                }
                
                case 5 ->{
                    emitirBalanco();
                }
                
                case 6 ->{
                    emitirRelatorio();
                }
            }
        }
        
        else{
            opcao = telaFinanceira.exibirMenuFunc();
        }
        
        if (opcao == 1){
            vender();
        }
        
    }

    public Manipulator<Conta> getManipulador() {
        return manipulador;
    }

    public void setManipulador(Manipulator<Conta> manipulador) {
        this.manipulador = manipulador;
    }
}
