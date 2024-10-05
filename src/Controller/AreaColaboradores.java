/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CPF;
import Model.Funcionario;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author caio
 */
public class AreaColaboradores extends Subsistema {
    private final Path caminhoColaboradores = Paths.get("src/test/resources/colaboradores.json");
    
 
    public void adicionarBancoDados(String nome, String endereco, String telefone, String email, CPF cpf, double salario, String login, String senha, String cargo) throws IOException{
        
    }
    
    public void removerBancoDados(){
        
    }
    
    public void editarBancoDados(){
        
    }
    
    
    public void editarColaborador(){
        
    }
    
    public void removerColaborador(){

    }
    
    public void mudarSenhaAdmin(){
        
    }
}
