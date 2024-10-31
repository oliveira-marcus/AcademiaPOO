/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Conta;
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
    
    public String getNomeConta(){
        System.out.println("Ganho - Nomes Possíveis: Salarios, Fornecedores, Despesa Geral, Despesa Administrativa, Imposto");
        System.out.println("Ganho Nomes Possíveis: Mensalidade");
        System.out.println("Digite o nome da Conta: ");
        return scanner.nextLine();
    }
    
    public String getTipoConta(){
        System.out.println("Digite o tipo da Conta: [Ganho ou Gasto]");
        return scanner.nextLine();
    }
    
    public double getValorConta(){
        System.out.println("Digite o valor da Conta:");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
    
    public String getDataConta(){
        System.out.println("Digite o Horario: [DD MM AAAA HH MM]");
        return scanner.nextLine();
    }
    
    public int getIdConta(){
        System.out.println("Digite o ID da Conta");
        
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
    
    public int getMes(){
        System.out.println("Digite o mes numericamente: ");
        
        int mes = scanner.nextInt();
        scanner.nextLine();
        
        return mes;
    }
    
    public int getAno(){
        System.out.println("Digite o ano: ");
        
        int ano = scanner.nextInt();
        scanner.nextLine();
        
        return ano;
    }
    
    public int getDia(){
        System.out.println("Digite o dia: ");
        
        int dia = scanner.nextInt();
        scanner.nextLine();
        
        return dia;
    }
    
    public int getPeriodo(){
        System.out.println("1 - Diário");
        System.out.println("2 - Mensal");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        return opcao;
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
    
    public int modificarConta(){
        System.out.println("1 - Nome");
        System.out.println("2 - Tipo");
        System.out.println("3 - Valor");
        System.out.println("4 - Data");
        
        System.out.println("Digite o que deseja Editar: ");
        int opcao = scanner.nextInt();
        return opcao;
    }
    
    public String removeConfirmation(){
        System.out.println("Tem certeza que quer remover a Conta? [S, N] ");
        return scanner.nextLine();
    }
    
    public void mostrarConta(Conta conta){
        System.out.printf("Nome: %s%nTipo: %s%n, Valor: %s%n, Data: %s%n, Id: %s%n",
                conta.getNome(), conta.getTipo(), conta.getValor(), conta.getData(),
                conta.getId());
    }
    
    public void mostrarBalanco(){
        
    }
}