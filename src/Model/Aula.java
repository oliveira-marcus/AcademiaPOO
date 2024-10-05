/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author caio
 */
public class Aula {
    
    private String tipo;
    private Funcionario instrutor;
    private double preco;
    
    public Aula(String tipo, Funcionario instrutor, double preco) {
        this.tipo = tipo;
        this.instrutor = instrutor;
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Funcionario getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Funcionario instrutor) {
        this.instrutor = instrutor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Override
    public String toString(){
        return this.tipo + "\n" + this.instrutor + "\n" + this.preco;
    }
}
