/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author caio
 */
public class Sala {
    
    private String nome;
    private String descricao;
    private double precoDiaria;
    private double precoMensalidade;
    private int capacidade;
    
    public Sala(String tipo, String descricao, double precoDiaria, double precoMensalidade, int capacidade) {
        this.nome = tipo;
        this.descricao = descricao;
        this.precoDiaria = precoDiaria;
        this.precoMensalidade = precoMensalidade;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public double getPrecoMensalidade() {
        return precoMensalidade;
    }

    public void setPrecoMensalidade(double precoMensalidade) {
        this.precoMensalidade = precoMensalidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    @Override
    public String toString(){
        return this.nome + "\n" + this.descricao;
    }
}
