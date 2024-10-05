/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author caio
 */
public class Funcionario extends Pessoa {
    
    private double salario;
    private String login;
    private String senha;
    private String cargo;

    public Funcionario(String nome, String endereco, String telefone, String email, CPF cpf, double salario, String login, String senha, String cargo) {
        super(nome, endereco, telefone, email, cpf);
        this.salario = salario;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    @Override
    public String toString() {
        return this.getNome();
    }
    
}
