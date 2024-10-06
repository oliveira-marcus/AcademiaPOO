/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Administrador;
import Model.CPF;
import Model.Funcionario;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caio
 */
public class AreaColaboradores extends Subsistema {
    private final Path caminhoColaboradores = Paths.get("src/data/colaboradores.json");
    private List<Funcionario> colaboradores = new ArrayList<>();
    
 
    public void adicionarColaborador(String nome, String endereco, String telefone, String email, String cpf, double salario, String login, String senha, String cargo){
        CPF cpfColaborador = new CPF(cpf);
        Funcionario novoFuncionario;
        
        if (cargo.equals("Administrador")){
            novoFuncionario = new Administrador(nome, endereco, telefone, email, cpfColaborador, salario, login, senha);
        }
        
        else{
            novoFuncionario = new Funcionario(nome, endereco, telefone, email, cpfColaborador, salario, login, senha, cargo);
        }
        
        colaboradores.add(novoFuncionario);
    }
    
    public void removerColaborador(String nome){
        Funcionario resultado = buscarColaborador(nome);
        
        if (resultado != null){
            colaboradores.remove(resultado);
        }
    }
    
    public void editarColaborador(){}
    
    public Funcionario buscarColaborador(String nome){
        for (Funcionario colaborador : colaboradores){
            if (colaborador.getNome().equals(nome)){
                return colaborador;
            }
        }
        return null;
    }
}
