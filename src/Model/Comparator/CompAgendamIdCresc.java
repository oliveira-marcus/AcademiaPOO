/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Comparator;

import Model.Agendamento;
import java.util.Comparator;

/**
 *
 * @author caio
 */
public class CompAgendamIdCresc implements Comparator<Agendamento> {
    
    @Override
    public int compare(Agendamento a1, Agendamento a2){
        return a1.getId() - a2.getId();
    }
}
