/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Manipulator.Manipulator;
import Controller.Manipulator.MapManipulator;
import Model.Produto;
import View.TelaEstoque;
import java.io.IOException;

/**
 *
 * @author caio
 */
public class ProdutoEstoqueController implements ManipulatorController{
    Manipulator<Produto> manipulador;
    MapManipulator<String, Integer> manipuladorMap;
    TelaEstoque telaEstoque = new TelaEstoque();
    
    public ProdutoEstoqueController(Manipulator<Produto> manipulador, MapManipulator manipuladorMap) throws IOException{
        this.manipulador = manipulador;
        this.manipuladorMap = manipuladorMap;
        Sistema.setQuantProdutosCatalogo(this.manipulador.getColecao().size());
    }
    
    public void adicionarProduto(){
        String nome = telaEstoque.getNomeProduto();
        double preco = telaEstoque.getPrecoProduto();
        int id = telaEstoque.getIdProduto();
        int quantidade = telaEstoque.getQuantidade();
        
        Produto novoProduto  = new Produto(nome, preco, id);
        
        manipulador.adicionar(novoProduto);
        manipuladorMap.colocar(novoProduto.getNome(), quantidade);
        Sistema.setQuantProdutosCatalogo(Sistema.getQuantProdutosCatalogo() + 1);
    }
    
    public void removerProduto(){
        int id = telaEstoque.getIdProduto();
        Produto produto = buscarProduto(id);
        
        if (manipuladorMap.getMap().get(produto.getNome()) == 0) {
            String resposta = telaEstoque.removeConfirmation();
            
            if (resposta.equals("S")){
                manipulador.remover(produto);
                manipuladorMap.remover(produto.getNome());
            }
            else{
                telaEstoque.displayMsgCancelRemoval();
            }
        }
        else{
            telaEstoque.displayProdutoNaoZeradoError();
        }
    }
    
    public void verificarProduto(){
        int id = telaEstoque.getIdProduto();
        Produto produto = buscarProduto(id);
        
        telaEstoque.mostrarProduto(produto);
        int quantidade = manipuladorMap.getMap().get(produto.getNome());
        telaEstoque.mostrarQuantidadeEstoque(produto.getNome(), quantidade);
    }
    
    public void editarProduto(){
        int id = telaEstoque.getIdProduto();
        Produto produto = buscarProduto(id);
        telaEstoque.mostrarProduto(produto);
        System.out.println();
        int opcaoModificacao = telaEstoque.modificarProduto();
        
        switch(opcaoModificacao){
            case 1 -> {
                String novoNome = telaEstoque.getNomeProduto();
                editarNome(produto, novoNome);
            }
            case 2-> {
                double novoPreco = telaEstoque.getPrecoProduto();
                editarPreco(produto, novoPreco);
            }
        }
    }
    
    public void editarNome(Produto produto, String nomeNovo){
        String nomeAntigo = produto.getNome();
        manipuladorMap.colocar(nomeNovo, manipuladorMap.getMap().get(nomeAntigo));
        manipuladorMap.remover(nomeAntigo);
        produto.setNome(nomeNovo);
    }
    
    public void editarPreco(Produto produto, double precoNovo){
        produto.setPreco(precoNovo);
    }
    
    public void alterarQuantidade(){
        int id = telaEstoque.getIdProduto();
        Produto produto = buscarProduto(id);
        
        int opcao = telaEstoque.alterarQuantidadeProduto();
        int quantidade = telaEstoque.getQuantidade();
        
        int quantidadeNova = 0;
        
        if (opcao == 1){    
            quantidadeNova = manipuladorMap.getMap().get(produto.getNome()) + quantidade;
        }
        else if (opcao == 2){
            quantidadeNova = manipuladorMap.getMap().get(produto.getNome()) - quantidade;
        }
        
        if (quantidadeNova >= 0){
            manipuladorMap.colocar(produto.getNome(), quantidadeNova);
        }
        else{
            telaEstoque.displayQuantidadeDoProdutoMenorDiminuicaoError();
        }
        
    }
    
    public Produto buscarProduto(Integer id){
        for (Produto produto : this.manipulador.getColecao()){
            if (produto.getId() == id){
                return produto;
            }
        }
        
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        manipulador.salvar();
        manipuladorMap.salvar();
    }
    
    public void run(){
        int opcao = 0;
        
        while(opcao != 6){
            opcao = telaEstoque.exibirMenu();
            
            switch  (opcao){
                case 1 -> {
                    adicionarProduto();
                }
                case 2 -> {
                    editarProduto();
                }
                case 3 -> {
                    removerProduto();
                }
                case 4 -> {
                    alterarQuantidade();
                }
                case 5 -> {
                    verificarProduto();
                }
            }
        }
    }
}

