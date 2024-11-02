package Model;

/**
 * Representa um funcionário, que é uma pessoa com informações adicionais de trabalho,
 * como salário, login, senha e cargo.
 * Esta classe herda as propriedades básicas da classe {@code Pessoa}.
 */
public class Funcionario extends Pessoa {
    
    private double salario;
    private String login;
    private String senha;
    private String cargo;

    /**
     * Construtor da classe {@code Funcionario}.
     * Inicializa um novo funcionário com as informações básicas de uma pessoa e dados específicos de emprego.
     *
     * @param nome     Nome do funcionário.
     * @param endereco Endereço do funcionário.
     * @param telefone Telefone do funcionário.
     * @param email    Email do funcionário.
     * @param cpf      CPF do funcionário.
     * @param salario  Salário do funcionário.
     * @param login    Login do funcionário.
     * @param senha    Senha do funcionário.
     * @param cargo    Cargo do funcionário.
     */
    public Funcionario(String nome, String endereco, String telefone, String email, Cpf cpf, double salario, String login, String senha, String cargo) {
        super(nome, endereco, telefone, email, cpf);
        this.salario = salario;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }
    
    /**
     * Obtém o salário do funcionário.
     * 
     * @return Salário do funcionário.
     */
    public double getSalario() {
        return salario;
    }
    
    /**
     * Define o salário do funcionário.
     * 
     * @param salario Novo salário do funcionário.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    /**
     * Obtém o login do funcionário.
     * 
     * @return Login do funcionário.
     */
    public String getLogin() {
        return login;
    }
    
    /**
     * Define o login do funcionário.
     * 
     * @param login Novo login do funcionário.
     */
    public void setLogin(String login) {
        this.login = login;
    }
    
    /**
     * Obtém a senha do funcionário.
     * 
     * @return Senha do funcionário.
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Define a senha do funcionário.
     * 
     * @param senha Nova senha do funcionário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Obtém o cargo do funcionário.
     * 
     * @return Cargo do funcionário.
     */
    public String getCargo() {
        return cargo;
    }
    
    /**
     * Define o cargo do funcionário.
     * 
     * @param cargo Novo cargo do funcionário.
     */
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    /**
     * Sobrescreve o método toString para retornar o nome do funcionário.
     *
     * @return Nome do funcionário.
     */
    @Override
    public String toString() {
        return this.getNome();
    }
}
