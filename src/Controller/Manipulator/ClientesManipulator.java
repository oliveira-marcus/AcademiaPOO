package Controller.Manipulator;

import Model.Cliente;
import java.io.IOException;

/**
 *
 * @author caio
 */
public final class ClientesManipulator extends ListManipulator<Cliente, Integer> {  
    public ClientesManipulator(String caminho, Class<Cliente> classe) throws IOException{
        super(caminho, classe);
    }
    
    @Override
    public void adicionar(Cliente novoCliente){
        super.adicionar(novoCliente);
    }
    
    @Override
    public void remover(Cliente cliente){
        super.remover(cliente);
    }
    
    public void editarEndereco(int id, String enderecoNovo){
        Cliente resultado = buscar(id);
        
        resultado.setEndereco(enderecoNovo);
    }
    
    public void editarEmail(int id, String emailNovo){
        Cliente resultado = buscar(id);
        
        resultado.setEmail(emailNovo);
    }
    
    public void editarTelefone(int id, String telefoneNovo){
        Cliente resultado = buscar(id);
        
        resultado.setTelefone(telefoneNovo);
    }
    
    public void editarCartao(int id, String cartaoNovo){
        Cliente resultado = buscar(id);
        
        resultado.setCartaoCredito(cartaoNovo);
    }
    
    @Override
    public Cliente buscar(Integer id){
        for (Cliente cliente : this.getLista()){
            if (cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        super.salvar();
    }

}
