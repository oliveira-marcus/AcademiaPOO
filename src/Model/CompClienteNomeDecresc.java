/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Comparator;

/**
 *
 * @author caio
 */
public class CompClienteNomeDecresc implements Comparator<Cliente>{
    @Override
    public int compare(Cliente c1, Cliente c2){
        return c2.getNome().compareTo(c1.getNome());
    }
}

