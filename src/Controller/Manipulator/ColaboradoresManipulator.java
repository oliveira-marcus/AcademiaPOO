package Controller.Manipulator;

import Model.Funcionario;
import java.io.IOException;

/**
 *
 * @author caio
 */
public class ColaboradoresManipulator extends ListManipulator<Funcionario, String> {
    public ColaboradoresManipulator(String caminho, Class<Funcionario> classe) throws IOException{
        super(caminho, classe);
    }
    
    @Override
    public void adicionar(Funcionario novoFuncionario){
        super.adicionar(novoFuncionario);
    }
    
    @Override
    public void remover(Funcionario funcionario){
        super.remover(funcionario);
    }
    
    public void editarColaborador(){
   
    }
    
    @Override
    public Funcionario buscar(String nome){
        for (Funcionario colaborador : this.getLista()){
            if (colaborador.getNome().equals(nome)){
                return colaborador;
            }
        }
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        super.salvar();
    }
}
