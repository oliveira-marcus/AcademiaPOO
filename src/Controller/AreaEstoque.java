/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Produto;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author caio
 */
public class AreaEstoque extends Subsistema {
    private final Path caminhoEstoque = Paths.get("src/data/estoque.json");
    private final Path caminhoProdutos = Paths.get("src/data/produtos.json");
    private final List<Produto> produtos = new ArrayList<>();
    private final Map<String, Integer> estoque = new HashMap();
    
    
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
