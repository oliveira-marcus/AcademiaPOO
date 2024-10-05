/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author caio
 */
public class Cliente extends Pessoa {
    
    /**
     * O número do cartão de crédito do cliente.
     */
    private String cartaoCredito;
    
    /**
     * O identificador único (ID) do cliente.
     */
    private int id;
    
    /**
     * Construtor da classe {@code Cliente}.
     * Inicializa um novo cliente com os detalhes fornecidos, incluindo as informações
     * pessoais e os detalhes específicos do cliente, como o cartão de crédito e o ID.
     * 
     * @param nome          O nome do cliente.
     * @param endereco      O endereço do cliente.
     * @param telefone      O telefone do cliente.
     * @param email         O email do cliente.
     * @param cpf           O CPF do cliente.
     * @param cartaoCredito O número do cartão de crédito do cliente.
     * @param id            O identificador único (ID) do cliente.
     */
    public Cliente(String nome, String endereco, String telefone, String email, CPF cpf, String cartaoCredito, int id) {
        super(nome, endereco, telefone, email, cpf);
        this.cartaoCredito = cartaoCredito;
        this.id = id;
    }

    /**
     * Retorna o número do cartão de crédito do cliente.
     * 
     * @return O número do cartão de crédito do cliente.
     */
    public String getCartaoCredito() {
        return cartaoCredito;
    }

    /**
     * Define o número do cartão de crédito do cliente.
     * 
     * @param cartaoCredito O novo número do cartão de crédito do cliente.
     */
    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    /**
     * Retorna o identificador único (ID) do cliente.
     * 
     * @return O ID do cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único (ID) do cliente.
     * 
     * @param id O novo ID do cliente.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retorna a representação textual do objeto {@code Cliente}, que é o nome do cliente.
     * 
     * @return O nome do cliente como string.
     */
    @Override
    public String toString() {
        return this.getNome();
    }
}
