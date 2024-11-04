/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Comparator;

import Model.Cliente;
import java.util.Comparator;

/**
 *
 * @author caio
 */
public class CompClienteNomeCresc implements Comparator<Cliente>{
    @Override
    public int compare(Cliente c1, Cliente c2){
        CompStringsCresc comparadorStrings = new CompStringsCresc();
        
        return comparadorStrings.compare(c1.getNome(), c2.getNome());
    }
}
