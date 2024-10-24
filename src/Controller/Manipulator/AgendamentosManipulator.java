package Controller.Manipulator;

import Controller.JsonController.JsonListController;
import Controller.Sistema;
import Model.Agendamento;
import Model.Cliente;
import Model.Funcionario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author caio
 */
public class AgendamentosManipulator extends Manipulator {
    private final String caminhoAgendamentos = "src/data/agendamentos.json";
    private List<Agendamento> agendamentos = new ArrayList<>();
    
    public AgendamentosManipulator() throws IOException{
        JsonListController<Agendamento> jsonController = new JsonListController<>(Agendamento.class);
        
        agendamentos = jsonController.readJsonToList(caminhoAgendamentos);
    }
    
    public void adicionarAgendamento(int id, int idCliente, String tipoAula, double precoAula, String nomeInstrutor, String dataHorarioStr){
        // faz a busca do Cliente
        ClientesManipulator areaClientes = Sistema.getSubsistemaPorTipo(ClientesManipulator.class);
        Cliente cliente = areaClientes.buscarCliente(idCliente);
        
        // faz a busca do Colaborador
        ColaboradoresManipulator areaColaboradores = Sistema.getSubsistemaPorTipo(ColaboradoresManipulator.class);
        Funcionario instrutor = areaColaboradores.buscarColaborador(nomeInstrutor);
        
        Calendar dataHorario = formatarHorario(dataHorarioStr);
        
        Agendamento novoAgendamento = new Agendamento(id, "FEITA", cliente, tipoAula, precoAula, instrutor, dataHorario);
        
        agendamentos.add(novoAgendamento);
    }
    
    public Calendar formatarHorario(String dataHorarioString){
        int dia = Integer.parseInt(dataHorarioString.split(" ")[0]);
        int mes = Integer.parseInt(dataHorarioString.split(" ")[1]);
        int ano = Integer.parseInt(dataHorarioString.split(" ")[2]);
        int hora = Integer.parseInt(dataHorarioString.split(" ")[3]);
        int minuto = Integer.parseInt(dataHorarioString.split(" ")[4]);
        
        Calendar dataHorario = Calendar.getInstance();
        dataHorario.set(Calendar.YEAR, ano);
        dataHorario.set(Calendar.MONTH, mes);
        dataHorario.set(Calendar.DAY_OF_MONTH, dia);
        dataHorario.set(Calendar.HOUR, hora);
        dataHorario.set(Calendar.MINUTE, minuto);
        
        return dataHorario;
    }
    
    public void editarAgendamento(int id, int idNovo){
        
    }
    
    public void editarAgendamento(int id, String estadoReserva){
        
    }
    
    public void editarAgendamento(int id, String nome, String endereco, String telefone, String email, String cpf, String cartaoCredito){
        
    }
    
    public void editarAgendamento(int id, double precoAula){
        
    }
    
    public void removerAgendamento(int id){
        Agendamento resultado = buscarAgendamento(id);
        
        agendamentos.remove(resultado);
    }
    
    public Agendamento buscarAgendamento(int id){
        for (Agendamento agendamento : agendamentos){
            if (agendamento.getId() == id){
                return agendamento;
            }
        }
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        JsonListController<Agendamento> jsonController = new JsonListController<>(Agendamento.class);
        jsonController.writeListToJsonFile(agendamentos, caminhoAgendamentos);
    }
    
    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }
}