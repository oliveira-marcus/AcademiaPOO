package Controller;

import Model.Administrador;
import Model.Funcionario;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author caio
 */
public class AreaColaboradores implements ListManipulator {
    private final String caminhoColaboradores ="src/data/colaboradores.json";
    private final List<Funcionario> colaboradores;
    
    public AreaColaboradores() throws IOException{
        JsonListController<Funcionario> jsonController = new JsonListController<>(Funcionario.class);
        
        colaboradores = jsonController.readJsonToList(caminhoColaboradores);
    }
    
    public void adicionarColaborador(String nome, String endereco, String telefone, String email, String cpf, double salario, String login, String senha, String cargo){
        Funcionario novoFuncionario;
        
        if (cargo.equals("Administrador")){
            novoFuncionario = new Administrador(nome, endereco, telefone, email, cpf, salario, login, senha);
        }
        
        else{
            novoFuncionario = new Funcionario(nome, endereco, telefone, email, cpf, salario, login, senha, cargo);
        }
        
        colaboradores.add(novoFuncionario);
    }
    
    public void removerColaborador(String nome){
        Funcionario resultado = buscarColaborador(nome);
        
        if (resultado != null){
            colaboradores.remove(resultado);
        }
    }
    
    public void editarColaborador(){
   
    }
    
    public Funcionario buscarColaborador(String nome){
        for (Funcionario colaborador : colaboradores){
            if (colaborador.getNome().equals(nome)){
                return colaborador;
            }
        }
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        JsonListController<Funcionario> jsonController = new JsonListController<>(Funcionario.class);
        jsonController.writeListToJsonFile(colaboradores, caminhoColaboradores);
    }

    public List<Funcionario> getColaboradores() {
        return colaboradores;
    }
}
