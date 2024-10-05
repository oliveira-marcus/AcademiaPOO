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
public class TelaFinanceira {
    
    public void exibirMenu(){
        int opcao = 0;
        
        while(opcao != 9){
            System.out.println("1 - Incluir Ganho");
            System.out.println("2 - Editar Ganho");
            System.out.println("3 - Remover Ganho");
            System.out.println("4 - Incluir Despesa");
            System.out.println("5 - Editar Despesa");
            System.out.println("6 - Remover Despesa");
            System.out.println("7 - Gerar Relatorio Vendas");
            System.out.println("8 - Gerar Balanço Mensal");
            System.out.println("9 - Sair");
            System.out.println();
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite a opcao: ");
            opcao = scanner.nextInt();
            
            switch (opcao){
                case 1 -> {
                }
                    
                case 2 -> {
                }
                    
                case 3 -> {
                }

                case 4 -> {
                }

                case 5 -> {
                }

                case 6 -> {
                }

                case 7 -> {
                }

                case 8 -> {
                }
            }
        }
    }
    
}
