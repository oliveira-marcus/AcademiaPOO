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
public class Agenda implements ListManipulator {
    private final Path caminhoAgendamentos = Paths.get("src/data/agendamentos.json");
    private List<Reserva> agendamentos = new ArrayList<>();
    
}
