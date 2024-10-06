/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Produto;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caio
 */
public class AreaEstoque extends Subsistema {
    private final Path caminhoEstoque = Paths.get("src/data/estoque.json");
    private final Path caminhoProdutos = Paths.get("src/data/produtos.json");
    private List<Produto> produtos = new ArrayList<>();
}
