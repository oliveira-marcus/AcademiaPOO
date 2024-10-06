/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Reserva;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caio
 */
public class Agenda extends Subsistema {
    private final Path caminhoAgendamentos = Paths.get("src/data/agendamentos.json");
    private List<Reserva> agendamentos = new ArrayList<>();
    
}
