/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Controller.AreaEstoque;

/**
 *
 * @author caio
 */
public class AcademiaPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AreaEstoque areaEstoque = new AreaEstoque();
        
        areaEstoque.adicionarProduto("Halteres (par)", 100.0, 100);
        areaEstoque.adicionarProduto("Corda", 20.0, 101);
        areaEstoque.adicionarProduto("Barrinha", 10, 102);
        areaEstoque.adicionarProduto("Whey", 100.0, 103);
        areaEstoque.adicionarProduto("Creatina", 50.0, 104);
        
        areaEstoque.alterarQuantidade(101, 20);
        areaEstoque.alterarQuantidade(102, 50);
        areaEstoque.alterarQuantidade(103, 15);
        areaEstoque.alterarQuantidade(104, 20);
        
        areaEstoque.editarProduto(103, "Whey Protein");
        areaEstoque.editarProduto(103, 105);
        
        areaEstoque.removerProduto(100);
        
        System.out.println(areaEstoque.getEstoque());
        
        System.out.println(areaEstoque.getProdutos());
        
    }
    
}
