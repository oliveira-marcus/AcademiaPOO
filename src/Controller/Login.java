package Controller;

import Controller.JsonController.JsonListController;
import Model.Funcionario;
import View.TelaLogin;
import java.io.IOException;
import java.util.List;

/**
 * Controlador responsável pela autenticação de funcionários no sistema. 
 * Gerencia o login dos funcionários, verifica credenciais e armazena o 
 * funcionário atualmente logado.
 */
public class Login {
    
    private final TelaLogin telaLogin = new TelaLogin();
    private final List<Funcionario> usuarios;
    private Funcionario funcLogado;
    private JsonListController<Funcionario> jsonController;
    
    /**
     * Construtor da classe {@code Login}.
     * Inicializa o controlador JSON e carrega a lista de funcionários 
     * a partir do arquivo especificado.
     * 
     * @param caminho Caminho do arquivo JSON com a lista de funcionários.
     * @throws IOException Se ocorrer um erro ao ler o arquivo JSON.
     */
    public Login(String caminho) throws IOException{
        jsonController = new JsonListController();
        jsonController.init(Funcionario.class);
        
        usuarios = jsonController.read(caminho);
    }
    
    /**
     * Autentica um funcionário com base nas credenciais fornecidas.
     * Se as credenciais estiverem corretas, define o funcionário como 
     * logado no sistema.
     * 
     * @param login Nome de usuário do funcionário.
     * @param senha Senha do funcionário.
     * @return O funcionário autenticado, ou null se as credenciais forem inválidas.
     */
    public Funcionario autenticarUsuario(String login, String senha){
        for (Funcionario usuario : usuarios){
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
                this.funcLogado = usuario;
                return usuario;
            }
        }
        return null;
    }

    /**
     * Retorna o funcionário atualmente logado.
     * 
     * @return O funcionário logado, ou null se ninguém estiver logado.
     */
    public Funcionario getFuncLogado() {
        return funcLogado;
    }

    /**
     * Define o funcionário atualmente logado.
     * 
     * @param funcLogado Funcionário a ser definido como logado.
     */
    public void setFuncLogado(Funcionario funcLogado) {
        this.funcLogado = funcLogado;
    }
    
    /**
     * Executa o processo de login do funcionário.
     * Solicita as credenciais ao usuário e verifica a autenticação até que
     * um login válido seja realizado.
     */
    public void run(){
        boolean canExit = false;
        while (!canExit){
            String login = telaLogin.getUserLogin();
            String senha = telaLogin.getUserSenha();
        
            autenticarUsuario(login, senha);
            
            if (funcLogado != null){
                canExit = true;
                telaLogin.displayLoginSuccess();
            }
            else{
                telaLogin.displayErroLogin();
            }
        }
    }
}
