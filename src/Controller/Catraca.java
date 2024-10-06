/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Pessoa;
import java.time.LocalTime;

/**
 *
 * @author caio
 */
public class Catraca {
    private int numeroPessoasAtuais = 0;
    private int numeroPessoasEntrantes = 0;
    private int numeroPessoasSaintes = 0;
    private int indice = 0;
    
    private Pessoa[] pessoasAtuais;
    
    public Catraca(){
        pessoasAtuais = new Pessoa[10]; // Alocando espaço para 10 pessoas
    }

    public int getNumeroPessoasAtuais() {
        return this.numeroPessoasAtuais;
    }
    
    public void setNumeroPessoasAtuais(int numeroPessoasAtuais) {
        this.numeroPessoasAtuais = numeroPessoasAtuais;
    }

    public int getNumeroPessoasEntrantes() {
        return numeroPessoasEntrantes;
    }

    public void setNumeroPessoasEntrantes(int numeroPessoasEntrantes) {
        this.numeroPessoasEntrantes = numeroPessoasEntrantes;
    }

    public int getNumeroPessoasSaintes() {
        return numeroPessoasSaintes;
    }

    public void setNumeroPessoasSaintes(int numeroPessoasSaintes) {
        this.numeroPessoasSaintes = numeroPessoasSaintes;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public Pessoa[] getPessoasAtuais() {
        return pessoasAtuais;
    }

    public void setPessoasAtuais(Pessoa[] pessoasAtuais) {
        this.pessoasAtuais = pessoasAtuais;
    }
    
    public LocalTime entrar(Pessoa pessoa){
        this.numeroPessoasAtuais++;
        
        this.pessoasAtuais[indice] = pessoa;
        this.indice++;
        
        Pessoa[] temp;
        
        if (indice == pessoasAtuais.length){
            temp = new Pessoa[indice + 10];
            System.arraycopy(pessoasAtuais, 0, temp, 0, 10);
            this.pessoasAtuais = temp;
        }
        
        this.numeroPessoasEntrantes++;
        LocalTime time = LocalTime.now();
        return time;
    }
    
    public LocalTime sair(Pessoa pessoa){
        this.numeroPessoasAtuais--;
        
        int indiceRemocao = 0;
        this.indice--;
        
        // Busca Sequencial
        for(Pessoa p : pessoasAtuais){
            if (p.equals(pessoa)){
                break;
            }
            indiceRemocao++;
        }
        
        Pessoa[] temp = new Pessoa[pessoasAtuais.length];
        
        for (int i = 0; i < pessoasAtuais.length; i++){
            
            // Se um elemento vir antes do elemento removido, ele vai continuar onde está
            if (i < indiceRemocao){
                temp[i] = pessoasAtuais[i];
            }
            
            // Se um elemento vir depois do elemento removido, ele vai pular uma casa para trás
            else if (i > indiceRemocao){
                temp[i-1] = pessoasAtuais[i];
            }
            
        }
        
        this.pessoasAtuais = temp;
        
        this.numeroPessoasSaintes++;
        LocalTime time = LocalTime.now();
        return time;
    }
    
    @Override
    public String toString(){
        return "[" + this.getNumeroPessoasAtuais() + ", " + this.numeroPessoasEntrantes + ", " + this.numeroPessoasSaintes + "]";
    }
}
