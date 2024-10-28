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
public class TelaInicial {
    Scanner scanner = new Scanner(System.in);
    
    public int exibirMenu(){
        System.out.println("1 - Clientes");
        System.out.println("2 - Colaboradores");
        System.out.println("3 - Catalogo/Estoque");
        System.out.println("4 - Agendamentos");
        System.out.println("5 - Financeiro");
        System.out.println("6 - Sair");
        System.out.println("Digite a area que deseja acessar: ");
        
        return scanner.nextInt(); 
    }
}
