/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Produto;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author caio
 */
public class AreaEstoque implements Manipulator{
    private final String caminhoEstoque = "src/data/estoque.json";
    private final String caminhoProdutos = "src/data/produtos.json";
    private final List<Produto> produtos;
    private final Map<String, Integer> estoque;
    
    public AreaEstoque() throws IOException{
        JsonListController<Produto> jsonListController = new JsonListController<>(Produto.class);
        produtos = jsonListController.readJsonToList(caminhoProdutos);
        
        JsonMapController<String, Integer> jsonMapController = new JsonMapController(String.class, Integer.class);
        estoque = jsonMapController.readJsonToMap(caminhoEstoque);
    }
    
    public void alterarQuantidade(int id, int quantidade){
        Produto resultado = buscaCatalogo(id);
        int quantidadeNova = estoque.get(resultado.getNome()) + quantidade;
        estoque.put(resultado.getNome(), quantidadeNova);
        
    }
    
    public void adicionarProduto(String nome, double preco, int id){
        Produto novoProduto = new Produto(nome, preco, id);
        produtos.add(novoProduto);
        estoque.put(novoProduto.getNome(), 0);
    }
    
    public void removerProduto(int id){
        Produto resultado = buscaCatalogo(id);
        if (estoque.get(resultado.getNome()) == 0) {
            produtos.remove(resultado);
            estoque.remove(resultado.getNome());
        }
        
    }
    
    public void editarProduto(int id, String nomeNovo){
        Produto resultado = buscaCatalogo(id);
        String nomeAntigo = resultado.getNome();
        
        estoque.put(nomeNovo, estoque.get(nomeAntigo));
        estoque.remove(nomeAntigo);
        
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
        
        JsonMapController<String, Integer> jsonMapController = new JsonMapController(String.class, Integer.class);
        jsonMapController.writeMapToJson(estoque, caminhoEstoque);
    }
    
    public int getQuantidadeEstoque(Produto produto){
        return estoque.get(produto.getNome());
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Map<String, Integer> getEstoque() {
        return estoque;
    }
}
