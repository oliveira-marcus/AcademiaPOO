package Controller.Manipulator;

import Controller.Sistema;
import Model.Agendamento;
import Model.Cliente;
import Model.Funcionario;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author caio
 */
public class AgendamentosManipulator extends ListManipulator<Agendamento, Integer> {   
    public AgendamentosManipulator(String caminho, Class<Agendamento> classe) throws IOException{
        super(caminho, classe);
    }
    
    public Agendamento construirAgendamento(int id, int idCliente, String tipoAula, double precoAula, String nomeInstrutor, String dataHorarioStr){
        // faz a busca do Cliente
        ClientesManipulator areaClientes = Sistema.getSubsistemaPorTipo(ClientesManipulator.class);
        Cliente cliente = areaClientes.buscar(idCliente);
        
        // faz a busca do Colaborador
        ColaboradoresManipulator areaColaboradores = Sistema.getSubsistemaPorTipo(ColaboradoresManipulator.class);
        Funcionario instrutor = areaColaboradores.buscar(nomeInstrutor);
        
        Calendar dataHorario = formatarHorario(dataHorarioStr);
        
        return new Agendamento(id, "FEITA", cliente, tipoAula, precoAula, instrutor, dataHorario);
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
    
    @Override
    public void remover(Agendamento agendamento){
        super.remover(agendamento);
    }
    
    @Override
    public Agendamento buscar(Integer id){
        for (Agendamento agendamento : this.getLista()){
            if (agendamento.getId() == id){
                return agendamento;
            }
        }
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        super.salvar();
    }
}