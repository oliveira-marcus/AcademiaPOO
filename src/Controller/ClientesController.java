package Controller;

import Controller.Manipulator.Manipulator;
import Model.Cliente;
import Model.Cpf;
import View.TelaClientes;
import java.io.IOException;

/**
 *
 * @author caio
 */
public final class ClientesController implements ManipulatorController{  
    Manipulator<Cliente> manipulador;
    TelaClientes telaClientes = new TelaClientes();
    
    public ClientesController(Manipulator<Cliente> manipulador) throws IOException{
        this.manipulador = manipulador;
        Sistema.setQuantClientesPriv(this.manipulador.getColecao().size());
    }
    
    
    public void adicionarCliente(){
        String nome = telaClientes.getNomeCliente();
        String endereco = telaClientes.getEnderecoCliente();
        String fone = telaClientes.getFoneCliente();
        String email = telaClientes.getEmailCliente();
        String cpf = telaClientes.getCpfCliente();
        String cartao = telaClientes.getCartaoCliente();
        int id = manipulador.getColecao().size() + 1;
        
        Cliente novoCliente = new Cliente(nome, endereco, fone, email, new Cpf(cpf), cartao, id);
        manipulador.adicionar(novoCliente);
        telaClientes.displayMsgClienteCriado(id);
        Sistema.setQuantClientesPriv(Sistema.getQuantClientesPriv() + 1);
    }
    
    public void removerCliente(){
        int id = telaClientes.getIdCliente();
        Cliente cliente = buscarCliente(id);
        telaClientes.mostrarCliente(cliente);
        String opcaoConfirmacao = telaClientes.removeConfirmation();

        if (opcaoConfirmacao.equals("S")){
            manipulador.remover(cliente);
        }
    }
    
    public void editarCliente(){
        int id = telaClientes.getIdCliente();
        Cliente cliente = buscarCliente(id);
        telaClientes.mostrarCliente(cliente);
        System.out.println();
        int opcaoModificacao = telaClientes.modificarCliente();

        switch(opcaoModificacao){
            case 1 -> {
                String novoEndereco = telaClientes.getEnderecoCliente();
                editarEndereco(cliente, novoEndereco);

            }
            case 2 -> {
                String novoFone = telaClientes.getFoneCliente();
                editarTelefone(cliente, novoFone);
            }
            case 3 -> {
                String novoEmail = telaClientes.getEmailCliente();
                editarEmail(cliente, novoEmail);
            }
            case 4 -> {
                String novoCartao = telaClientes.getCartaoCliente();
                editarCartao(cliente, novoCartao);
            }
        }
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
            
            switch (opcao){
                case 1 -> {
                    adicionarCliente();
                }
                case 2 -> {
                    editarCliente();
                }
                case 3 -> {
                    removerCliente();
                }
            }
        }
    }
}
