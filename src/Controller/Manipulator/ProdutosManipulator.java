/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import Controller.JsonController.JsonListController;
import Controller.Sistema;
import Model.Produto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author caio
 */
public class ProdutosManipulator extends Manipulator{
    private final EstoqueManipulator areaEstoque = Sistema.getSubsistemaPorTipo(EstoqueManipulator.class);
    private final String caminhoProdutos = "src/data/produtos.json";
    private final List<Produto> produtos;
    
    public ProdutosManipulator() throws IOException{
        JsonListController<Produto> jsonListController = new JsonListController<>(Produto.class);
        produtos = jsonListController.readJsonToList(caminhoProdutos);
    }
    
    public void adicionarProduto(String nome, double preco, int id){
        Produto novoProduto = new Produto(nome, preco, id);
        produtos.add(novoProduto);
        areaEstoque.adicionarProduto(nome, 0);
    }
    
    public void removerProduto(int id){
        Produto resultado = buscaCatalogo(id);
        if (areaEstoque.getQuantidadeEstoque(resultado.getNome()) == 0) {
            produtos.remove(resultado);
            areaEstoque.removerProduto(resultado.getNome());
        }
        
    }
    
    public void editarProduto(int id, String nomeNovo){
        Produto resultado = buscaCatalogo(id);
        String nomeAntigo = resultado.getNome();
        areaEstoque.editarProduto(nomeAntigo, nomeNovo);
        resultado.setNome(nomeNovo);
    }
    
    public void editarProduto(int id, double precoNovo){
        Produto resultado = buscaCatalogo(id);
        resultado.setPreco(precoNovo);
    }
    
    public void editarProduto(int id, int idNovo){
        Produto resultado = buscaCatalogo(id);        
        resultado.setId(idNovo);
    }  
    
    public Produto buscaCatalogo(int id){
        for (Produto produto : produtos){
            if (produto.getId() == id){
                return produto;
            }
        }
        
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        JsonListController<Produto> jsonListController = new JsonListController<>(Produto.class);
        jsonListController.writeListToJsonFile(produtos, caminhoProdutos);
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }
}

