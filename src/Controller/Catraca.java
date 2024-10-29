/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Pessoa;
import View.TelaCatraca;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caio
 */
public class Catraca{
    private int numeroPessoasEntrantes = 0;
    private int numeroPessoasSaintes = 0;
    private List<Pessoa> pessoasAtuais;
    
    private final TelaCatraca telaCatraca = new TelaCatraca();
    
    public Catraca(){
        pessoasAtuais = new ArrayList<>();
    }
    
    public LocalTime entrar(Pessoa pessoa){
        pessoasAtuais.add(pessoa);
        numeroPessoasEntrantes++;
        
        return LocalTime.now();
    }
    
    public LocalTime sair(Pessoa pessoa){
        pessoasAtuais.remove(pessoa);
        numeroPessoasSaintes++;
        
        return LocalTime.now();
    }

    public int getNumeroPessoasAtuais() {
        return pessoasAtuais.size();
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
    
    public List<Pessoa> getPessoasAtuais(){
        return pessoasAtuais;
    }
    
    public void setPessoasAtuais(List<Pessoa> pessoasAtuais){
        this.pessoasAtuais = pessoasAtuais;
    }
    
    @Override
    public String toString(){
        return "[" + this.getNumeroPessoasAtuais() + ", " + this.numeroPessoasEntrantes + ", " + this.numeroPessoasSaintes + "]";
    }
    
    public void run(){
        telaCatraca.exibirPessoasEntrantes(numeroPessoasEntrantes);
        telaCatraca.exibirPessoasSaintes(numeroPessoasSaintes);
        
        String pessoasAtuaisStr = "";
        
        for (Pessoa pessoa : pessoasAtuais){
            pessoasAtuaisStr = pessoasAtuais + pessoa.toString() + "\n";
        }
        
        if (pessoasAtuaisStr.equals("")){
            telaCatraca.displayMsgAcademiaVazia();
        }
        else{
            telaCatraca.mostrarPessoasAtuais(pessoasAtuaisStr);
        }
    }
}
