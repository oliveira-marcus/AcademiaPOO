/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Comparator;

import Model.Agendamento;
import java.util.Calendar;
import java.util.Comparator;

/**
 *
 * @author caio
 */
public class CompAgendamDataHorarioDecresc implements Comparator<Agendamento>{
    @Override
    public int compare(Agendamento a1, Agendamento a2){
        Calendar a1DataHorario = a1.getDataHorario();
        Calendar a2DataHorario = a2.getDataHorario();
        
        int a1Ano = a1DataHorario.get(Calendar.YEAR);
        int a2Ano = a2DataHorario.get(Calendar.YEAR);
        
        int a1Mes = a1DataHorario.get(Calendar.MONTH);
        int a2Mes = a2DataHorario.get(Calendar.MONTH);
        
        int a1Dia = a1DataHorario.get(Calendar.DAY_OF_MONTH);
        int a2Dia = a2DataHorario.get(Calendar.DAY_OF_MONTH);
        
        int a1Hora = a1DataHorario.get(Calendar.HOUR);
        int a2Hora = a2DataHorario.get(Calendar.HOUR);
        
        int a1Minuto = a1DataHorario.get(Calendar.MINUTE);
        int a2Minuto = a2DataHorario.get(Calendar.MINUTE);
        
        if (a1Ano != a2Ano){
            return a2Ano - a1Ano;
        }
        
        else if (a1Mes != a2Mes){
            return a2Mes - a1Mes;
        }
        
        else if (a1Dia != a2Dia){
            return a2Dia - a1Dia;
        }
        
        else if (a1Hora != a2Hora){
            return a2Hora - a1Hora;
        }
        
        else if (a1Minuto != a2Minuto){
            return a2Minuto - a1Minuto;
        }
        
        return 0;
    }
}
