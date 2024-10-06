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
public class AreaFinanceira extends Subsistema {
    private final Path caminhoGanhos = Paths.get("src/data/ganhos.json");
    private final Path caminhoDespesas = Paths.get("src/data/despesas.json");
    
}
