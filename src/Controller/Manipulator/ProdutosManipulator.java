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
    
    public void editarNome(Produto produto, String nomeNovo){
        String nomeAntigo = produto.getNome();
        areaEstoque.editarNome(nomeAntigo, nomeNovo);
        produto.setNome(nomeNovo);
    }
    
    public void editarPreco(Produto produto, double precoNovo){
        produto.setPreco(precoNovo);
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

