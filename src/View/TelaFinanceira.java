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
    Scanner scanner = new Scanner(System.in);
    
    public int exibirMenuAdmin(){
        System.out.println("1 - Vender");
        System.out.println("2 - Adicionar Conta");
        System.out.println("3 - Remover Conta");
        System.out.println("4 - Editar Conta");
        System.out.println("5 - Gerar Relatório Vendas");
        System.out.println("6 - Gerar Balanço Mensal");
        System.out.println("7 - Sair");
            
        System.out.println("Digite a opcao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        return opcao;
            
    }
    
    public int exibirMenuFunc(){
        System.out.println("1 - Vender");
        System.out.println("2 - Sair");
        
        System.out.println("Digite a opcao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        return opcao;
    }
    
    public int getIdVenda(){
        System.out.println("Digite o ID da Venda");
        
        int idVenda = scanner.nextInt();
        scanner.nextLine();
        
        return idVenda;
    }
    
    public int getIdClienteComprador(){
        System.out.println("Digite o ID do cliente comprando o Produto");
        
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        
        return idCliente;
    }
    
    public int getIdProdutoVendido(){
        System.out.println("Digite o ID do produto a ser vendido: [0 para parar]");
        
        int idProduto = scanner.nextInt();
        scanner.nextLine();
        
        return idProduto;
    }
    
    public int getQuantidadeProdutoVendido(){
        System.out.println("Digite a quantidade vendida: ");
        
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        
        return quantidade;
    }
    
    public void exibirExtrato(String[] nomeProdutos, int[] quantidadeProdutos, double[] valoresUnitarios , double valorTotal){
        System.out.println("EXTRATO:");
        for(int i = 0; i < nomeProdutos.length; i++){
            System.out.printf("Produto: %s%nQuantidade: %s%nValor Unitario: %s%n",
                    nomeProdutos[i], quantidadeProdutos[i], valoresUnitarios[i]);
            System.out.println();
        }
        
        System.out.printf("VALOR TOTAL: %s%n%n", valorTotal);
    }
}