/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Calendar;

/**
 *
 * @author caio
 */
public class Conta {
    private String nome; // Ganho: Salarios, Fornecedores, Despesa Geral, Despesa Administrativa, Imposto; Ganho: Diaria, Mensalidade, Venda
    private String tipo; // Ganho ou Gasto
    private double valor;
    private Calendar data;
    private int id;
    
    public Conta(String nome, String tipo, double valor, Calendar data, int id){
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
