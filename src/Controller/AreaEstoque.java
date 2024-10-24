/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Produto;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author caio
 */

public class AreaEstoque extends Manipulator{
    private final String caminhoEstoque = "src/data/estoque.json";
    private final Map<String, Integer> estoque;
    
    public AreaEstoque() throws IOException{
        JsonMapController<String, Integer> jsonMapController = new JsonMapController(String.class, Integer.class);
        estoque = jsonMapController.readJsonToMap(caminhoEstoque);
    }
    
    public void alterarQuantidade(int id, int quantidade){
        AreaProduto areaProduto = Sistema.getSubsistemaPorTipo(AreaProduto.class);
        Produto resultado = areaProduto.buscaCatalogo(id);
        int quantidadeNova = estoque.get(resultado.getNome()) + quantidade;
        estoque.put(resultado.getNome(), quantidadeNova);
    }
    
    public void adicionarProduto(String nome, int quantidade){
        estoque.put(nome, quantidade);
    }
    
    public void removerProduto(String nome){
        estoque.remove(nome);
    }
    
    public void editarProduto(String nomeAntigo, String nomeNovo){
        estoque.put(nomeNovo, estoque.get(nomeAntigo));
        estoque.remove(nomeAntigo);
    }
    
    @Override
    public void salvar() throws IOException{
        JsonMapController<String, Integer> jsonMapController = new JsonMapController(String.class, Integer.class);
        jsonMapController.writeMapToJson(estoque, caminhoEstoque);
    }
    
    public int getQuantidadeEstoque(String nome){
        return estoque.get(nome);
    }
    
    public String getCaminhoEstoque() {
        return caminhoEstoque;
    }

    public Map<String, Integer> getEstoque() {
        return estoque;
    }
}