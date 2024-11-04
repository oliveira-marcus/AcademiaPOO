package View;

import java.util.Scanner;

/**
* Classe responsável pela interface de autenticação do sistema.
* Fornece métodos para coletar credenciais de login do usuário
* e exibir mensagens relacionadas ao processo de autenticação.
*/
public class TelaLogin {
    
    /** Scanner para leitura de entrada do usuário */
    Scanner scanner = new Scanner(System.in);
    
    /**
    * Solicita e retorna o login do usuário.
    * 
    * @return String contendo o login informado pelo usuário
    */
    public String getUserLogin(){
        System.out.println("Digite o Login: ");
        return scanner.nextLine();
    }
    
    /**
    * Solicita e retorna a senha do usuário.
    * 
    * @return String contendo a senha informada pelo usuário
    */
    public String getUserSenha(){
        System.out.println("Digite a Senha");
        return scanner.nextLine();
    }
    
    /**
    * Exibe mensagem de erro quando a autenticação falha.
    */
    public void displayErroLogin(){
        System.out.println("Erro ao fazer o Login. Tente Novamente!");
    }
    
    /**
    * Exibe mensagem de sucesso quando a autenticação é bem-sucedida.
    */
    public void displayLoginSuccess(){
        System.out.println("LOGIN CONCLUIDO!");
    }
}
