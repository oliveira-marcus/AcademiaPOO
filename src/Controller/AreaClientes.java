package Controller;

import Model.Cliente;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author caio
 */
public class AreaClientes implements ListManipulator {
    private final String caminhoClientes = "src/data/clientes.json";
    private final List<Cliente> clientes;
    
    public AreaClientes() throws IOException{
        JsonController<Cliente> jsonController = new JsonController<>(Cliente.class);
        
        clientes = jsonController.readJsonToList(caminhoClientes);
    }
    
    public void adicionarCliente(String nome, String endereco, String telefone, String email, String cpf, String cartaoCredito, int id){
        Cliente novoCliente = new Cliente(nome, endereco, telefone, email, cpf, cartaoCredito, id);
        clientes.add(novoCliente);
    }
    
    public void removerCliente(int id){
        Cliente resultado = buscarCliente(id);
        
        if (resultado != null){
            clientes.remove(resultado);
        }
    }
    
    public void editarCliente(int id, String nomeNovo){
        Cliente resultado = buscarCliente(id);
        
        if (resultado != null){
            resultado.setNome(nomeNovo);
        }
    }
    
    public void editarCliente(int id, int idNovo){
        Cliente resultado = buscarCliente(id);
        
        if (resultado != null){
            resultado.setId(idNovo);
        }
    }
    
    public Cliente buscarCliente(int id){
        for (Cliente cliente : clientes){
            if (cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }  
}
