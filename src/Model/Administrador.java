package Model;

/**
 * Representa um Administrador que é um tipo de Funcionario.
 * Essa classe herda as propriedades e métodos da classe Funcionario e
 * define o perfil do administrador no sistema de gerenciamento.
 */
public class Administrador extends Funcionario {
    
    /**
     * Construtor da classe {@code Administrador}.
     * Inicializa um novo objeto de Administrador com as informações básicas 
     * de um funcionário e o define como "Administrador".
     *
     * @param nome     Nome do administrador.
     * @param endereco Endereço do administrador.
     * @param telefone Telefone do administrador.
     * @param email    Email do administrador.
     * @param cpf      CPF do administrador.
     * @param salario  Salário do administrador.
     * @param login    Login do administrador no sistema.
     * @param senha    Senha do administrador no sistema.
     */
    public Administrador(String nome, String endereco, String telefone, String email, String cpf, double salario, String login, String senha) {
        super(nome, endereco, telefone, email, cpf, salario, login, senha, "Administrador");
    }
    
    /**
     * Sobrescreve o método toString para retornar o nome do administrador.
     *
     * @return O nome do administrador.
     */
    @Override
    public String toString() {
        return this.getNome();
    }
}
