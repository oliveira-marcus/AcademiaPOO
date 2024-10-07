package Controller;

import Model.Administrador;
import Model.Funcionario;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caio
 */
public class AreaColaboradores extends Subsistema {
    private final Path caminhoColaboradores = Paths.get("src/data/colaboradores.json");
    private final List<Funcionario> colaboradores = new ArrayList<>();
    
 
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
}
