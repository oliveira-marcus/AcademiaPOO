package View;

import Model.Produto;
import java.util.Scanner;

/**
 * Classe responsável pela interface de usuário para operações relacionadas ao estoque.
 * Fornece métodos para exibir menus, coletar inputs do usuário e mostrar informações
 * sobre produtos e operações do estoque.
 */
public class TelaEstoque {
    
    /** Scanner para leitura de entrada do usuário */
    Scanner scanner = new Scanner(System.in);
    
    /**
     * Exibe o menu principal de operações do estoque e retorna a opção escolhida pelo usuário.
     * 
     * @return Número inteiro representando a opção selecionada
     */
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
    
    /**
     * Solicita e retorna o nome de um produto.
     * 
     * @return String contendo o nome do produto informado pelo usuário
     */
    public String getNomeProduto(){
        System.out.println("Digite o nome do produto: ");
        return scanner.nextLine();
    }
    
    /**
     * Solicita e retorna o preço de um produto.
     * 
     * @return Valor double representando o preço do produto
     */
    public double getPrecoProduto(){
        System.out.println("Digite o preco do produto: ");
        
        double preco = scanner.nextDouble();
        scanner.nextLine();
        return preco;
    }
    
    /**
     * Solicita e retorna o ID de um produto.
     * 
     * @return Número inteiro representando o ID do produto
     */
    public int getIdProduto(){
        System.out.println("Digite o ID do produto");
        
        int idProduto = scanner.nextInt();
        scanner.nextLine();
        return idProduto;
    }
    
    /**
     * Solicita e retorna uma quantidade.
     * 
     * @return Número inteiro representando a quantidade informada
     */
    public int getQuantidade(){
        System.out.println("Digite a quantidade");
        
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        return quantidade;
    }
    
    /**
     * Exibe menu de opções para modificação de um produto e retorna a escolha do usuário.
     * 
     * @return Número inteiro representando o atributo a ser modificado (1 para nome, 2 para preço)
     */
    public int modificarProduto(){
        System.out.println("1 - Nome");
        System.out.println("2 - Preco");
        
        System.out.println("Digite o que deseja alterar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    /**
     * Exibe menu de opções para alteração de quantidade e retorna a escolha do usuário.
     * 
     * @return Número inteiro representando a operação (1 para aumentar, 2 para diminuir)
     */
    public int alterarQuantidadeProduto(){
        System.out.println("1 - Aumentar");
        System.out.println("2 - Diminuir");
        
        System.out.println("O que deseja fazer com a quantidade? ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    /**
     * Solicita confirmação para remoção de um produto.
     * 
     * @return String contendo a resposta do usuário
     */
    public String removeConfirmation(){
        System.out.println("Tem certeza que deseja remover o Produto?");
        
        return scanner.nextLine();
    }
    
    /**
     * Exibe todas as informações de um produto.
     * 
     * @param produto Objeto Produto cujas informações serão exibidas
     */
    public void mostrarProduto(Produto produto){
        System.out.printf("Nome: %s%nPreco %s%nId: %s%n",
                produto.getNome(), produto.getPreco(), produto.getId());
    }
    
    /**
     * Exibe a quantidade disponível de um determinado produto no estoque.
     * 
     * @param nome Nome do produto
     * @param quantidade Quantidade disponível no estoque
     */
    public void mostrarQuantidadeEstoque(String nome, int quantidade){
        System.out.printf("Quantidade Disponivel de %s: %s%n", nome, quantidade);
    }
    
    /**
     * Exibe mensagem de confirmação de criação de produto.
     * 
     * @param id ID do produto criado
     */
    public void displayMsgProdutoCriado(int id){
        System.out.printf("Novo produto criado com o ID %s%n", id);
    }
    
    /**
     * Exibe mensagem informando que a remoção foi cancelada.
     */
    public void displayMsgCancelRemoval(){
        System.out.println("Remocao cancelada");
    }
    
    /**
     * Exibe mensagem de erro quando se tenta remover um produto com quantidade em estoque.
     */
    public void displayProdutoNaoZeradoError(){
        System.out.println("Para remover um produto, ele deve estar zerado no Estoque!");
    }
    
    /**
     * Exibe mensagem de erro quando se tenta diminuir uma quantidade maior do que a disponível em estoque.
     */
    public void displayQuantidadeDoProdutoMenorDiminuicaoError(){
        System.out.println("A quantidade do Produto e menor do que o que se deseja diminuir");
    }
}
