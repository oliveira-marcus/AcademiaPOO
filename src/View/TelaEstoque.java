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
public class TelaEstoque {
    
    public void exibirMenu(){
        int opcao = 0;
        
        while (opcao != 6) {
            System.out.println("1 - Incluir Produto no Catalogo");
            System.out.println("2 - Editar Produto no Catalogo");
            System.out.println("3 - Remover Produto no Catalogo");
            System.out.println("4 - Aumentar/Diminuir Quantidade de produto no Estoque");
            System.out.println("5 - Verificar Produto no Estoque");
            System.out.println("6 - Sair");
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

            } 
        }
    }  
}
