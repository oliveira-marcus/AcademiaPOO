/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Pessoa;
import java.util.List;

/**
 *
 * @author caio
 */
public class TelaCatraca {
    public void exibirPessoasEntrantes(int pessoasEntrantes){
        System.out.printf("%s pessoas entraram no estabelecimento%n", pessoasEntrantes);
    }
    
    public void exibirPessoasSaintes(int pessoasSaintes){
        System.out.printf("%s pessoas entraram no estabelecimento%n", pessoasSaintes);
    }
    
    public void mostrarPessoasAtuais(String pessoasAtuais){
        System.out.println("As pessoas que estao na academia sao: ");
        System.out.println(pessoasAtuais);
    }
    
    public void displayMsgAcademiaVazia(){
        System.out.println("Atualmente a academia esta vazia");
    }
}
