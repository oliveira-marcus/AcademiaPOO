package View;

import Model.Produto;
import java.util.Scanner;


public class TelaEstoque {
    
    Scanner scanner = new Scanner(System.in);
    
    public int exibirMenu(){        
        System.out.println("1 - Incluir Produto no Catalogo");
        System.out.println("2 - Editar Produto no Catalogo");
        System.out.println("3 - Remover Produto no Catalogo");
        System.out.println("4 - Aumentar/Diminuir Quantidade de produto no Estoque");
        System.out.println("5 - Verificar Produto no Estoque");
        System.out.println("6 - Sair");
        System.out.println();
        
        System.out.println("Digite a opcao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        return opcao;
    }
    
    public String getNomeProduto(){
        System.out.println("Digite o nome do produto: ");
        return scanner.nextLine();
    }
    
    public double getPrecoProduto(){
        System.out.println("Digite o preco do produto: ");
        
        double preco = scanner.nextDouble();
        scanner.nextLine();
        return preco;
    }
    
    public int getIdProduto(){
        System.out.println("Digite o ID do produto");
        
        int idProduto = scanner.nextInt();
        scanner.nextLine();
        return idProduto;
    }
    
    public int getQuantidade(){
        System.out.println("Digite a quantidade");
        
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        return quantidade;
    }
    
    public int modificarProduto(){
        System.out.println("1 - Nome");
        System.out.println("2 - Preco");
        
        System.out.println("Digite o que deseja alterar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    public int alterarQuantidadeProduto(){
        System.out.println("1 - Aumentar");
        System.out.println("2 - Diminuir");
        
        System.out.println("O que deseja fazer com a quantidade? ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    public String removeConfirmation(){
        System.out.println("Tem certeza que deseja remover o Produto?");
        
        return scanner.nextLine();
    }
    
    public void mostrarProduto(Produto produto){
        System.out.printf("Nome: %s%nPreco %s%nId: %s%n",
                produto.getNome(), produto.getPreco(), produto.getId());
    }
    
    public void mostrarQuantidadeEstoque(String nome, int quantidade){
        System.out.printf("Quantidade Disponivel de %s: %s%n", nome, quantidade);
    }
    
    public void displayMsgProdutoCriado(int id){
        System.out.printf("Novo produto criado com o ID %s%n", id);
    }
    
    public void displayMsgCancelRemoval(){
        System.out.println("Remocao cancelada");
    }
    
    public void displayProdutoNaoZeradoError(){
        System.out.println("Para remover um produto, ele deve estar zerado no Estoque!");
    }
    
    public void displayQuantidadeDoProdutoMenorDiminuicaoError(){
        System.out.println("A quantidade do Produto e menor do que o que se deseja diminuir");
    }
}
