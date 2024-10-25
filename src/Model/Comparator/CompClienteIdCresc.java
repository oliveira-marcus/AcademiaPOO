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
public class CompClienteIdCresc implements Comparator<Cliente> {
    @Override
    public int compare(Cliente c1, Cliente c2){
        return c1.getId() - c2.getId();
    }
}
