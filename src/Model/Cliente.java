package Model;

/**
 * Representa um cliente, que é uma pessoa com informações adicionais específicas,
 * como cartão de crédito e identificador único.
 * Esta classe herda as propriedades básicas da classe Pessoa.
 */
public class Cliente extends Pessoa {
    
    private String cartaoCredito;
    private int id;
    
    /**
     * Construtor da classe {@code Cliente}.
     * Inicializa um novo cliente com as informações básicas de uma pessoa e os dados específicos do cliente.
     *
     * @param nome          Nome do cliente.
     * @param endereco      Endereço do cliente.
     * @param telefone      Telefone do cliente.
     * @param email         Email do cliente.
     * @param cpf           CPF do cliente.
     * @param cartaoCredito Número do cartão de crédito do cliente.
     * @param id            Identificador único do cliente.
     */
    public Cliente(String nome, String endereco, String telefone, String email, Cpf cpf, String cartaoCredito, int id) {
        super(nome, endereco, telefone, email, cpf);
        this.cartaoCredito = cartaoCredito;
        this.id = id;
    }
    
    /**
     * Obtém o número do cartão de crédito do cliente.
     * 
     * @return Número do cartão de crédito.
     */
    public String getCartaoCredito() {
        return cartaoCredito;
    }
    
    /**
     * Define o número do cartão de crédito do cliente.
     * 
     * @param cartaoCredito Novo número do cartão de crédito.
     */
    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
    
    /**
     * Obtém o identificador único do cliente.
     * 
     * @return ID do cliente.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Define o identificador único do cliente.
     * 
     * @param id Novo ID do cliente.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Sobrescreve o método toString para retornar o nome do cliente.
     *
     * @return Nome do cliente.
     */
    @Override
    public String toString() {
        return this.getNome();
    }
}
