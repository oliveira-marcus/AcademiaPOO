package Model;

/**
 * Representa uma sala com informações sobre o nome, descrição e capacidade.
 */
public class Sala {
    
    private String nome;
    private String descricao;
    private int capacidade;
    
    /**
     * Construtor da classe {@code Sala}.
     * Inicializa uma nova sala com nome, descrição e capacidade.
     *
     * @param nome       Nome da sala.
     * @param descricao  Descrição da sala.
     * @param capacidade Capacidade máxima da sala.
     */
    public Sala(String nome, String descricao, int capacidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.capacidade = capacidade;
    }

    /**
     * Obtém o nome da sala.
     * 
     * @return Nome da sala.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da sala.
     * 
     * @param nome Novo nome da sala.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a descrição da sala.
     * 
     * @return Descrição da sala.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da sala.
     * 
     * @param descricao Nova descrição da sala.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém a capacidade máxima da sala.
     * 
     * @return Capacidade da sala.
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Define a capacidade máxima da sala.
     * 
     * @param capacidade Nova capacidade da sala.
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    /**
     * Sobrescreve o método toString para retornar uma representação da sala no formato "Nome \n Descrição".
     *
     * @return Representação textual da sala.
     */
    @Override
    public String toString(){
        return this.nome + "\n" + this.descricao;
    }
}
