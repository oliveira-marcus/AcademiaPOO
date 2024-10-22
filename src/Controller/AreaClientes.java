package Controller;

import Model.Cliente;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author caio
 */
public class AreaClientes implements Manipulator {
    private final String caminhoClientes = "src/data/clientes.json";
    private final List<Cliente> clientes;
    
    public AreaClientes() throws IOException{
        JsonListController<Cliente> jsonController = new JsonListController<>(Cliente.class);
        
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
    
    public void editarEndereco(int id, String enderecoNovo){
        Cliente resultado = buscarCliente(id);
        
        resultado.setEndereco(enderecoNovo);
    }
    
    public void editarEmail(int id, String emailNovo){
        Cliente resultado = buscarCliente(id);
        
        resultado.setEmail(emailNovo);
    }
    
    public void editarTelefone(int id, String telefoneNovo){
        Cliente resultado = buscarCliente(id);
        
        resultado.setTelefone(telefoneNovo);
    }
    
    public void editarCartao(int id, String cartaoNovo){
        Cliente resultado = buscarCliente(id);
        
        resultado.setCartaoCredito(cartaoNovo);
    }
    
    public Cliente buscarCliente(int id){
        for (Cliente cliente : clientes){
            if (cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        JsonListController<Cliente> jsonController = new JsonListController<>(Cliente.class);
        jsonController.writeListToJsonFile(clientes, caminhoClientes);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }  
}
