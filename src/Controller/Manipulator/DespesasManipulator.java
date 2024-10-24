/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author caio
 */
public class DespesasManipulator extends Manipulator {
    private final Path caminhoDespesas = Paths.get("src/data/despesas.json");
    
    public void adicionarDespesa(String nome, String tipo, double valor, String data){
        
    }
    
    @Override
    public void salvar() throws IOException{
        
    }
}
