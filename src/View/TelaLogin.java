/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.Scanner;

/**
 *
 * @author caio
 */
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
}
