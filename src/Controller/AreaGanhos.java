/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author caio
 */
public class AreaGanhos implements ListManipulator {
    private final Path caminhoGanhos = Paths.get("src/data/ganhos.json");
    
    @Override
    public void salvar() throws IOException{
        
    }
}
