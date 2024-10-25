/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import Controller.Sistema;
import Model.Produto;
import java.io.IOException;

/**
 *
 * @author caio
 */
public class ProdutosManipulator extends ListManipulator<Produto, Integer>{
    private final EstoqueManipulator areaEstoque = Sistema.getManipuladorMapPorTipo(EstoqueManipulator.class);
    
    public ProdutosManipulator(String caminho, Class<Produto> classe) throws IOException{
        super(caminho, classe);
        Sistema.setQuantProdutosCatalogo(this.getLista().size());
    }
    
    @Override
    public void adicionar(Produto novoProduto){
        super.adicionar(novoProduto);
        areaEstoque.adicionar(novoProduto.getNome());
        Sistema.setQuantProdutosCatalogo(Sistema.getQuantProdutosCatalogo() + 1);
    }
    
    @Override
    public void remover(Produto produto){
        if (areaEstoque.getQuantidadeEstoque(produto.getNome()) == 0) {
            super.remover(produto);
            areaEstoque.remover(produto.getNome());
        }
        
    }
    
    public void editarProduto(int id, String nomeNovo){
        Produto resultado = buscar(id);
        String nomeAntigo = resultado.getNome();
        areaEstoque.editarProduto(nomeAntigo, nomeNovo);
        resultado.setNome(nomeNovo);
    }
    
    public void editarProduto(int id, double precoNovo){
        Produto resultado = buscar(id);
        resultado.setPreco(precoNovo);
    }
    
    public void editarProduto(int id, int idNovo){
        Produto resultado = buscar(id);        
        resultado.setId(idNovo);
    }  
    
    @Override
    public Produto buscar(Integer id){
        for (Produto produto : this.getLista()){
            if (produto.getId() == id){
                return produto;
            }
        }
        
        return null;
    }
}

