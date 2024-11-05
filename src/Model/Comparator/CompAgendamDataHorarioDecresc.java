package Model.Comparator;

import Model.Agendamento;
import java.util.Calendar;
import java.util.Comparator;

/**
 * Classe que implementa um comparador para ordenar agendamentos em ordem decrescente
 * de data e horário. A comparação é feita hierarquicamente considerando ano, mês,
 * dia, hora e minuto.
 */
public class CompAgendamDataHorarioDecresc implements Comparator<Agendamento>{
    
    /**
     * Compara dois agendamentos com base em sua data e horário em ordem decrescente.
     * A comparação é feita na seguinte ordem hierárquica:
     * 1. Ano
     * 2. Mês
     * 3. Dia
     * 4. Hora
     * 5. Minuto
     *
     * @param a1 Primeiro agendamento a ser comparado
     * @param a2 Segundo agendamento a ser comparado
     * @return Um valor positivo se a1 é anterior a a2,
     *         um valor negativo se a1 é posterior a a2,
     *         ou zero se ambos representam o mesmo momento
     */
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
