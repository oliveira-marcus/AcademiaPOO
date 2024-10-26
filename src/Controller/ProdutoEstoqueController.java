/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Manipulator.Manipulator;
import Controller.Manipulator.MapManipulator;
import Model.Produto;
import View.TelaClientes;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author caio
 */
public class ProdutoEstoqueController implements ManipulatorController{
    Manipulator<Produto> manipulador;
    MapManipulator<String, Integer> manipuladorMap;
    TelaClientes telaClientes = new TelaClientes();
    Scanner scanner = new Scanner(System.in);
    
    public ProdutoEstoqueController(Manipulator<Produto> manipulador, MapManipulator manipuladorMap) throws IOException{
        this.manipulador = manipulador;
        this.manipuladorMap = manipuladorMap;
        Sistema.setQuantProdutosCatalogo(this.manipulador.getColecao().size());
    }
    
    public void adicionar(String nome, double preco, int id){
        Produto novoProduto = validarProduto(nome, preco, id);
        
        manipulador.adicionar(novoProduto);
        manipuladorMap.colocar(novoProduto.getNome(), 0);
        Sistema.setQuantProdutosCatalogo(Sistema.getQuantProdutosCatalogo() + 1);
    }
    
    public Produto validarProduto(String nome, double preco, int id){
        return new Produto(nome, preco, id);
    }
    
    public void remover(Produto produto){
        if (manipuladorMap.getMap().get(produto.getNome()) == 0) {
            manipulador.remover(produto);
            manipuladorMap.remover(produto.getNome());
        }
        else{
            // jogar um erro throw
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
    
    public void alterarQuantidade(Produto produto, int quantidade){
        int quantidadeNova = manipuladorMap.getMap().get(produto.getNome()) + quantidade;
        
        if (quantidadeNova >= 0){
            manipuladorMap.colocar(produto.getNome(), quantidadeNova);
        }
        else{
            // jogar um erro throw aqui
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
        
    }
}

