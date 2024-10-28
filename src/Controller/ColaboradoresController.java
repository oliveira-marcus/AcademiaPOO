package Controller;

import Controller.Manipulator.Manipulator;
import Model.Funcionario;
import View.TelaColaboradores;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author caio
 */
public class ColaboradoresController implements ManipulatorController{
    Manipulator<Funcionario> manipulador;
    TelaColaboradores telaColaboradores = new TelaColaboradores();
    Scanner scanner = new Scanner(System.in);
    
    public ColaboradoresController(Manipulator<Funcionario> manipulador) throws IOException{
        this.manipulador = manipulador;
    }
    
    public void adicionar(String nome, String endereco, String telefone, String email, String cpf, double salario, String login, String senha, String cargo){
        Funcionario novoFuncionario = validarFuncionario(nome, endereco, telefone, email, cpf, salario, login, senha, cargo);
        manipulador.adicionar(novoFuncionario);
    }
    
    public Funcionario validarFuncionario(String nome, String endereco, String telefone, String email, String cpf, double salario, String login, String senha, String cargo){
        return new Funcionario(nome, endereco, telefone, email, cpf, salario, login, senha, cargo);
    }
    
    public void remover(Funcionario funcionario){
        manipulador.remover(funcionario);
    }
    
    public void editarColaborador(){
   
    }
    
    public Funcionario buscarColaborador(String nome){
        for (Funcionario colaborador : this.manipulador.getColecao()){
            if (colaborador.getNome().equals(nome)){
                return colaborador;
            }
        }
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        manipulador.salvar();
    }
    
    public void run(){
        
    }
}
