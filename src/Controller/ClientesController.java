package Controller;

import Controller.Manipulator.Manipulator;
import Model.Cliente;
import Model.Cpf;
import View.TelaClientes;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador responsável pelo gerenciamento de clientes, incluindo operações de adição, remoção, edição e busca de clientes.
 */
public final class ClientesController implements ManipulatorController{
    
    private Manipulator<Cliente> manipulador;
    private TelaClientes telaClientes = new TelaClientes();
    private int idMaximo;
    
    /**
     * Construtor da classe {@code ClientesController}.
     * Inicializa o controlador com o manipulador de clientes e ajusta a quantidade de clientes no sistema.
     *
     * @param manipulador Objeto {@code Manipulator} para manipular os dados de clientes.
     * @throws IOException se ocorrer um erro ao acessar dados de clientes.
     */
    public ClientesController(Manipulator<Cliente> manipulador) throws IOException{
        this.manipulador = manipulador;
        Sistema.setQuantClientesPriv(this.manipulador.getColecao().size());
        Sistema.quantClientesProtec = this.manipulador.getColecao().size();
        
        List<Integer> ids = this.manipulador.getColecao().stream().map(cliente -> cliente.getId()).collect(Collectors.toList());
        this.idMaximo = Collections.max(ids);
    }
    
    /**
     * Adiciona um novo cliente ao sistema.
     * Os dados do cliente são coletados a partir da interface {@code TelaClientes}.
     */
    public void adicionarCliente(){
        String nome = telaClientes.getNomeCliente();
        String endereco = telaClientes.getEnderecoCliente();
        String fone = telaClientes.getFoneCliente();
        String email = telaClientes.getEmailCliente();
        String cpf = telaClientes.getCpfCliente();
        String cartao = telaClientes.getCartaoCliente();
        idMaximo++;
        int id = idMaximo;
        
        Cliente novoCliente = new Cliente(nome, endereco, fone, email, new Cpf(cpf), cartao, id);
        manipulador.adicionar(novoCliente);
        telaClientes.displayMsgClienteCriado(id);
        Sistema.setQuantClientesPriv(Sistema.getQuantClientesPriv() + 1);
        Sistema.quantClientesProtec++;
    }
    
    /**
     * Remove um cliente do sistema, após confirmação.
     * O cliente é identificado pelo seu ID.
     */
    public void removerCliente(){
        int id = telaClientes.getIdCliente();
        Cliente cliente = buscarCliente(id);
        telaClientes.mostrarCliente(cliente);
        String opcaoConfirmacao = telaClientes.removeConfirmation();

        if (opcaoConfirmacao.equals("S")){
            manipulador.remover(cliente);
        }
    }
    
    /**
     * Edita as informações de um cliente específico.
     * O cliente é identificado pelo seu ID e é possível alterar endereço, telefone, e-mail e cartão de crédito.
     */
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
    
    /**
     * Atualiza o endereço de um cliente.
     *
     * @param cliente Cliente cujo endereço será atualizado.
     * @param enderecoNovo Novo endereço do cliente.
     */
    public void editarEndereco(Cliente cliente, String enderecoNovo){
        cliente.setEndereco(enderecoNovo);
    }
    
    /**
     * Atualiza o e-mail de um cliente.
     *
     * @param cliente Cliente cujo e-mail será atualizado.
     * @param emailNovo Novo e-mail do cliente.
     */
    public void editarEmail(Cliente cliente, String emailNovo){       
        cliente.setEmail(emailNovo);
    }
    
    /**
     * Atualiza o telefone de um cliente.
     *
     * @param cliente Cliente cujo telefone será atualizado.
     * @param telefoneNovo Novo telefone do cliente.
     */
    public void editarTelefone(Cliente cliente, String telefoneNovo){
        cliente.setTelefone(telefoneNovo);
    }
    
    /**
     * Atualiza o cartão de crédito de um cliente.
     *
     * @param cliente Cliente cujo cartão de crédito será atualizado.
     * @param cartaoNovo Novo cartão de crédito do cliente.
     */
    public void editarCartao(Cliente cliente, String cartaoNovo){
        cliente.setCartaoCredito(cartaoNovo);
    }
    
    /**
     * Mostra as informações de um cliente, com CPF anonimizado
     */
    public void mostrarDadosCliente(){
        int id = telaClientes.getIdCliente();
        Cliente cliente = buscarCliente(id);
        telaClientes.mostrarCliente(cliente);
    }
    
    /**
     * Busca um cliente pelo seu ID.
     *
     * @param id ID do cliente a ser buscado.
     * @return Objeto {@code Cliente} correspondente ao ID, ou {@code null} se não for encontrado.
     */
    public Cliente buscarCliente(Integer id){
        for (Cliente cliente : this.manipulador.getColecao()){
            if (cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }
    
    /**
     * Busca um cliente com base em um critério de comparação.
     *
     * @param alvo Cliente alvo a ser comparado.
     * @param comparator Comparador utilizado para buscar o cliente.
     * @return Objeto {@code Cliente} que corresponde ao critério, ou {@code null} se não encontrado.
     */
    public Cliente find(Cliente alvo, Comparator<Cliente> comparator) {
        Iterator<Cliente> iterator = this.manipulador.getColecao().iterator();
        
        while (iterator.hasNext()) {
            Cliente elemento = iterator.next();
            if (comparator.compare(elemento, alvo) == 0) {
                return elemento; // Elemento encontrado
            }
        }

        return null; // Element não encontrado
    }
    
    /**
     * Salva as informações atuais dos clientes.
     *
     * @throws IOException se ocorrer um erro ao salvar os dados.
     */
    @Override
    public void salvar() throws IOException{
        manipulador.salvar();
    }
    
    /**
     * Executa o menu principal de operações do controlador de clientes.
     * As opções incluem adicionar, editar, remover e mostrar clientes.
     */
    public void run(){
        int opcao = 0; 
        
        while(opcao != 5){
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
                case 4 -> {
                    mostrarDadosCliente();
                }
            }
        }
    }
    
    /**
     * Obtém o manipulador de clientes.
     *
     * @return Objeto {@code Manipulator} de clientes.
     */
    public Manipulator<Cliente> getManipulador() {
        return manipulador;
    }

    /**
     * Define o manipulador de clientes.
     *
     * @param manipulador Novo manipulador de clientes.
     */
    public void setManipulador(Manipulator<Cliente> manipulador) {
        this.manipulador = manipulador;
    }

    /**
     * Retorna a tela da seção Clientes.
     * 
     * @return tela da seção Clientes.
     */
    public TelaClientes getTelaClientes() {
        return telaClientes;
    }

    /**
     * Define a tela da seção Clientes.
     * 
     * @param telaClientes tela da seção Clientes
     */
    public void setTelaClientes(TelaClientes telaClientes) {
        this.telaClientes = telaClientes;
    }
    
    /**
     * Retorna o maior Id dos clientes
     * @return Maior id dos clientes
     */
    public int getIdMaximo() {
        return idMaximo;
    }
    
    /**
     * Define o id máximo dos clientes
     * @param idMaximo id máximo dos clientes
     */
    public void setIdMaximo(int idMaximo) {
        this.idMaximo = idMaximo;
    }
    
    /**
     * Método que sobrescreve o toString para exibir informações sobre o Controller
     * @return Informações sobre o Controller
     */
    @Override
    public String toString(){
        return "Controller referente a área de Clientes da Academia";
    }
}
