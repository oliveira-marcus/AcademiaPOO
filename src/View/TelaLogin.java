package View;

import java.util.Scanner;

public class TelaLogin {
    
    Scanner scanner = new Scanner(System.in);
    
    public String getUserLogin(){
        System.out.println("Digite o Login: ");
        return scanner.nextLine();
    }
    
    public String getUserSenha(){
        System.out.println("Digite a Senha");
        return scanner.nextLine();
    }
    
    public void displayErroLogin(){
        System.out.println("Erro ao fazer o Login. Tente Novamente!");
    }
    
    public void displayLoginSuccess(){
        System.out.println("LOGIN CONCLUIDO!");
    }
}
