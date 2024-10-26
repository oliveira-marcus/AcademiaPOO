package Controller;

import Controller.Manipulator.Manipulator;
import Controller.Sistema;
import Model.Cliente;
import View.TelaClientes;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author caio
 */
public final class ClientesController implements ManipulatorController{  
    Manipulator<Cliente> manipulador;
    TelaClientes telaClientes = new TelaClientes();
    Scanner scanner = new Scanner(System.in);
    
    public ClientesController(Manipulator<Cliente> manipulador) throws IOException{
        this.manipulador = manipulador;
        Sistema.setQuantClientesPriv(this.manipulador.getColecao().size());
    }
    
    
    public void adicionarCliente(String nome, String endereco, String fone, String email, String cpf, String cartao, int id ){
        
        // Posso colocar alguma validação de dados antes de construir o objeto. Exemplo: verificar se o Nome é válido
        Cliente novoCliente = validarCliente(nome, endereco, fone, email, cpf, cartao, id);
        manipulador.adicionar(novoCliente);
        Sistema.setQuantClientesPriv(Sistema.getQuantClientesPriv() + 1);
    }
    
    public Cliente validarCliente(String nome, String endereco, String fone, String email, String cpf, String cartao, int id){
        return new Cliente(nome, endereco, fone, email, cpf, cartao, id);
    }
    
    public void removerCliente(Cliente cliente){
        manipulador.remover(cliente);
    }
    
    public void editarEndereco(Cliente cliente, String enderecoNovo){
        cliente.setEndereco(enderecoNovo);
    }
    
    public void editarEmail(Cliente cliente, String emailNovo){       
        cliente.setEmail(emailNovo);
    }
    
    public void editarTelefone(Cliente cliente, String telefoneNovo){
        cliente.setTelefone(telefoneNovo);
    }
    
    public void editarCartao(Cliente cliente, String cartaoNovo){
        cliente.setCartaoCredito(cartaoNovo);
    }
    
    public Cliente buscarCliente(Integer id){
        for (Cliente cliente : this.manipulador.getColecao()){
            if (cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        manipulador.salvar();
    }
    
    public Manipulator<Cliente> getManipulador() {
        return manipulador;
    }

    public void setManipulador(Manipulator<Cliente> manipulador) {
        this.manipulador = manipulador;
    }
    
    public void run(){
        int opcao = 0; 
        
        while(opcao != 4){
            opcao = telaClientes.exibirMenu();
            scanner.nextLine();
        
            switch (opcao){
                case 1 -> {
                    String nome = telaClientes.getNomeCliente();
                    String endereco = telaClientes.getEnderecoCliente();
                    String fone = telaClientes.getFoneCliente();
                    String email = telaClientes.getEmailCliente();
                    String cpf = telaClientes.getCpfCliente();
                    String cartao = telaClientes.getCartaoCliente();
                    int id = telaClientes.getIdCliente();

                    adicionarCliente(nome, endereco, fone, email, cpf, cartao,id);
                }
                case 2 -> {
                    int id = telaClientes.getIdCliente();
                    Cliente cliente = buscarCliente(id);
                    telaClientes.mostrarCliente(cliente);
                    System.out.println();
                    int opcaoModificacao = telaClientes.modificarCliente();
                }
                case 3 -> {
                    int id = telaClientes.getIdCliente();
                    Cliente cliente = buscarCliente(id);
                    telaClientes.mostrarCliente(cliente);
                    String opcaoConfirmacao = telaClientes.removeConfirmation();
                    
                    if (opcaoConfirmacao.equals("S")){
                        removerCliente(cliente);
                    }
                }
            }
        }
    }
}
