/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Comparator;

import java.util.Comparator;

/**
 *
 * @author caio
 */
public class CompContaTipo implements Comparator<String>{
    String[] tiposConta = {"Diaria", "Mensalidade", "Venda",
        "Salarios", "Fornecedores", "Despesa Geral", "Despesa Administrativa",
    "Imposto", "Saldo Final"};

    @Override
    public int compare(String c1, String c2){
        int c1Index = find(c1);
        int c2Index = find(c2);
        
        return c1Index - c2Index;
    }
    
    public int find(String c){
        for (int i = 0; i < tiposConta.length; i++){
            if (c.equals(tiposConta[i])){
                return i;
            }
        }
        return 10000;
    }
}
