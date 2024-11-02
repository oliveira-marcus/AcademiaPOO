package Model;

/**
 * Classe abstrata que representa uma pessoa com informações básicas como nome, endereço, telefone, email e CPF.
 * Esta classe serve como base para classes que representam tipos específicos de pessoas.
 */
public abstract class Pessoa {
    
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private Cpf cpf;
    
    /**
     * Construtor da classe {@code Pessoa}.
     * Inicializa uma nova pessoa com informações de contato e identificação.
     *
     * @param nome      Nome da pessoa.
     * @param endereco  Endereço da pessoa.
     * @param telefone  Telefone da pessoa.
     * @param email     Email da pessoa.
     * @param cpf       CPF da pessoa.
     */
    public Pessoa(String nome, String endereco, String telefone, String email, Cpf cpf){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }
    
    /**
     * Obtém o nome da pessoa.
     * 
     * @return Nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     * 
     * @param nome Novo nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Obtém o endereço da pessoa.
     * 
     * @return Endereço da pessoa.
     */
    public String getEndereco() {
        return endereco;
    }
    
    /**
     * Define o endereço da pessoa.
     * 
     * @param endereco Novo endereço da pessoa.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    /**
     * Obtém o telefone da pessoa.
     * 
     * @return Telefone da pessoa.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone da pessoa.
     * 
     * @param telefone Novo telefone da pessoa.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém o email da pessoa.
     * 
     * @return Email da pessoa.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email da pessoa.
     * 
     * @param email Novo email da pessoa.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o CPF da pessoa.
     * 
     * @return CPF da pessoa.
     */
    public Cpf getCpf() {
        return cpf;
    }

    /**
     * Define o CPF da pessoa.
     * 
     * @param cpf Novo CPF da pessoa.
     */
    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }
    
    /**
     * Sobrescreve o método toString para retornar o nome da pessoa.
     *
     * @return Nome da pessoa.
     */
    @Override
    public String toString(){
        return nome;
    }
}
