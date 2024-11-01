package Model;

/**
 * Representa um produto com informações básicas como nome, preço e identificador único.
 */
public class Produto {
    
    private String nome;
    private double preco;
    private int id;
    
    /**
     * Construtor da classe {@code Produto{.
     * Inicializa um novo produto com nome, preço e ID.
     *
     * @param nome  Nome do produto.
     * @param preco Preço do produto.
     * @param id    Identificador único do produto.
     */
    public Produto(String nome, double preco, int id) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
    }
    
    /**
     * Obtém o nome do produto.
     * 
     * @return Nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     * 
     * @param nome Novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o preço do produto.
     * 
     * @return Preço do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     * 
     * @param preco Novo preço do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Obtém o identificador do produto.
     * 
     * @return Identificador do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do produto.
     * 
     * @param id Novo identificador do produto.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Sobrescreve o método toString para retornar uma representação do produto no formato "ID: Nome".
     *
     * @return Representação textual do produto.
     */
    @Override
    public String toString() {
        return this.id + ": " + this.nome;
    }
}
