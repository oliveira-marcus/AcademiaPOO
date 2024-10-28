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
    
    public ColaboradoresController(Manipulator<Funcionario> manipulador) throws IOException{
        this.manipulador = manipulador;
    }
    
    public void adicionarColaborador(){
        String nome = telaColaboradores.getNomeColaborador();
        String endereco = telaColaboradores.getEnderecoColaborador();
        String telefone = telaColaboradores.getFoneColaborador();
        String email = telaColaboradores.getEmailColaborador();
        String cpf = telaColaboradores.getCpfColaborador();
        double salario = telaColaboradores.getSalarioColaborador();
        String login = telaColaboradores.getLoginColaborador();
        String senha = telaColaboradores.getSenhaColaborador();
        String cargo = telaColaboradores.getCargoColaborador();
        
        Funcionario novoFuncionario = new Funcionario(nome, endereco, telefone, email, cpf, salario, login, senha, cargo);
        manipulador.adicionar(novoFuncionario);
    }
    
    public void removerColaborador(){
        String nome = telaColaboradores.getNomeColaborador();
        Funcionario funcionario = buscarColaborador(nome);
        telaColaboradores.mostrarColaborador(funcionario);
        String opcaoConfirmacao = telaColaboradores.removeConfirmation();

        if (opcaoConfirmacao.equals("S")){
            manipulador.remover(funcionario);
        }
    }
    
    public void editarColaborador(){
        String nome = telaColaboradores.getNomeColaborador();
        Funcionario funcionario = buscarColaborador(nome);
        telaColaboradores.mostrarColaborador(funcionario);
        System.out.println();
        int opcaoModificacao = telaColaboradores.modificarColaborador();

        switch(opcaoModificacao){
            case 1 -> {
                String novoEndereco = telaColaboradores.getEnderecoColaborador();
                editarEndereco(funcionario, novoEndereco);

            }
            case 2 -> {
                String novoFone = telaColaboradores.getFoneColaborador();
                editarTelefone(funcionario, novoFone);
            }
            case 3 -> {
                String novoEmail = telaColaboradores.getEmailColaborador();
                editarEmail(funcionario, novoEmail);
            }
            case 4 -> {
                String novoLogin = telaColaboradores.getLoginColaborador();
                editarLogin(funcionario, novoLogin);
            }
            case 5 -> {
                String novaSenha = telaColaboradores.getSenhaColaborador();
                editarSenha(funcionario, novaSenha);
            }
        }
    }
    
    public void editarEndereco(Funcionario funcionario, String novoEndereco){
        funcionario.setEndereco(novoEndereco);
    }
    public void editarTelefone(Funcionario funcionario, String novoTelefone){
        funcionario.setTelefone(novoTelefone);
    }
    public void editarEmail(Funcionario funcionario, String novoEmail){
        funcionario.setEmail(novoEmail);
    }
    public void editarLogin(Funcionario funcionario, String novoLogin){
        funcionario.setLogin(novoLogin);
    }
    public void editarSenha(Funcionario funcionario, String novaSenha){
        funcionario.setSenha(novaSenha);
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
        int opcao = 0;
        
        while (opcao != 4){
            opcao = telaColaboradores.exibirMenu();
            
            switch(opcao){
                case 1 -> {
                    adicionarColaborador();
                }
                case 2 -> {
                    editarColaborador();
                }
                case 3 -> {
                    removerColaborador();
                }
            }
        }
    }
}
