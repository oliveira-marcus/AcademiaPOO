/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author caio
 */
public class Administrador extends Funcionario {
    
    
    public Administrador(String nome, String endereco, String telefone, String email, CPF cpf, double salario, String login, String senha) {
        super(nome, endereco, telefone, email, cpf, salario, login, senha, "Administrador");
    }
    
    @Override
    public String toString() {
        return this.getNome();
    }
}
