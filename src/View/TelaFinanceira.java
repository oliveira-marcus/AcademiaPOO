package View;

import Controller.AgendamentosController;
import Model.Conta;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe responsável pela interface de usuário para operações financeiras.
 * Fornece métodos para exibir menus, coletar inputs do usuário e mostrar informações
 * sobre vendas, contas e relatórios financeiros.
 */
public class TelaFinanceira {
    
    /** Scanner para leitura de entrada do usuário */
    Scanner scanner = new Scanner(System.in);
    
    /**
     * Exibe o menu de operações para administradores.
     * 
     * @return Número inteiro representando a opção selecionada
     */
    public int exibirMenuAdmin(){
        System.out.println("1 - Vender");
        System.out.println("2 - Adicionar Conta");
        System.out.println("3 - Remover Conta");
        System.out.println("4 - Editar Conta");
        System.out.println("5 - Mostar dados de uma Conta");
        System.out.println("6 - Gerar Relatorio Vendas");
        System.out.println("7 - Gerar Balanco Mensal");
        System.out.println("8 - Sair");
            
        System.out.println("Digite a opcao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        return opcao; 
    }
    
    /**
     * Exibe o menu de operações para funcionários.
     * 
     * @return Número inteiro representando a opção selecionada
     */
    public int exibirMenuFunc(){
        System.out.println("1 - Vender");
        System.out.println("2 - Sair");
        
        System.out.println("Digite a opcao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        return opcao;
    }
    
    /**
     * Solicita e retorna o nome de uma conta, exibindo os tipos possíveis.
     * 
     * @return String contendo o nome da conta
     */
    public String getNomeConta(){
        System.out.println("Ganho - Nomes Possíveis: Salarios, Fornecedores, Despesa Geral, Despesa Administrativa, Imposto");
        System.out.println("Ganho Nomes Possíveis: Mensalidade");
        System.out.println("Digite o nome da Conta: ");
        return scanner.nextLine();
    }
    
    /**
     * Solicita e retorna o tipo de conta (Ganho ou Gasto).
     * 
     * @return String indicando o tipo da conta
     */
    public String getTipoConta(){
        System.out.println("Digite o tipo da Conta: [Ganho ou Gasto]");
        return scanner.nextLine();
    }
    
    /**
     * Solicita e retorna o valor de uma conta.
     * 
     * @return Valor double representando o montante da conta
     */
    public double getValorConta(){
        System.out.println("Digite o valor da Conta:");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
    
    /**
     * Solicita e retorna a data de uma conta no formato [DD MM AAAA HH MM].
     * 
     * @return String contendo a data da conta
     */
    public String getDataConta(){
        System.out.println("Digite o Horario: [DD MM AAAA HH MM]");
        return scanner.nextLine();
    }
    
    /**
     * Solicita e retorna o ID de uma conta.
     * 
     * @return Número inteiro representando o ID da conta
     */
    public int getIdConta(){
        System.out.println("Digite o ID da Conta");
        
        int idVenda = scanner.nextInt();
        scanner.nextLine();
        
        return idVenda;
    }
    
    /**
     * Solicita e retorna o ID do cliente comprador.
     * 
     * @return Número inteiro representando o ID do cliente
     */
    public int getIdClienteComprador(){
        System.out.println("Digite o ID do cliente comprando o Produto");
        
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        
        return idCliente;
    }
    
    /**
     * Solicita e retorna o ID do produto a ser vendido.
     * 
     * @return Número inteiro representando o ID do produto (0 para parar)
     */
    public int getIdProdutoVendido(){
        System.out.println("Digite o ID do produto a ser vendido: [0 para parar]");
        
        int idProduto = scanner.nextInt();
        scanner.nextLine();
        
        return idProduto;
    }
    
    /**
     * Solicita e retorna a quantidade de produto vendido.
     * 
     * @return Número inteiro representando a quantidade vendida
     */
    public int getQuantidadeProdutoVendido(){
        System.out.println("Digite a quantidade vendida: ");
        
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        
        return quantidade;
    }
    
    /**
     * Solicita e retorna o mês numericamente.
     * 
     * @return Número inteiro representando o mês
     */
    public int getMes(){
        System.out.println("Digite o mes numericamente: ");
        
        int mes = scanner.nextInt();
        scanner.nextLine();
        
        return mes;
    }
    
    /**
     * Solicita e retorna o ano.
     * 
     * @return Número inteiro representando o ano
     */
    public int getAno(){
        System.out.println("Digite o ano: ");
        
        int ano = scanner.nextInt();
        scanner.nextLine();
        
        return ano;
    }
    
    /**
     * Solicita e retorna o dia.
     * 
     * @return Número inteiro representando o dia
     */
    public int getDia(){
        System.out.println("Digite o dia: ");
        
        int dia = scanner.nextInt();
        scanner.nextLine();
        
        return dia;
    }
    
    /**
     * Solicita e retorna o período (Diário ou Mensal).
     * 
     * @return Número inteiro representando o período escolhido (1 para Diário, 2 para Mensal)
     */
    public int getPeriodo(){
        System.out.println("1 - Diario");
        System.out.println("2 - Mensal");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        return opcao;
    }
    
    /**
     * Exibe o extrato detalhado de uma venda.
     * 
     * @param nomeProdutos Array com os nomes dos produtos
     * @param quantidadeProdutos Array com as quantidades de cada produto
     * @param valoresUnitarios Array com os valores unitários de cada produto
     * @param valorTotal Valor total da venda
     */
    public void exibirExtrato(String[] nomeProdutos, int[] quantidadeProdutos, double[] valoresUnitarios , double valorTotal){
        System.out.println("EXTRATO:");
        for(int i = 0; i < nomeProdutos.length; i++){
            System.out.printf("Produto: %s%nQuantidade: %s%nValor Unitario: %s%n",
                    nomeProdutos[i], quantidadeProdutos[i], valoresUnitarios[i]);
            System.out.println();
        }
        
        System.out.printf("VALOR TOTAL: %s%n%n", valorTotal);
    }
    
    /**
     * Exibe menu de opções para modificação de uma conta.
     * 
     * @return Número inteiro representando o campo a ser modificado
     */
    public int modificarConta(){
        System.out.println("1 - Nome");
        System.out.println("2 - Tipo");
        System.out.println("3 - Valor");
        System.out.println("4 - Data");
        
        System.out.println("Digite o que deseja Editar: ");
        int opcao = scanner.nextInt();
        return opcao;
    }
    
    /**
     * Solicita confirmação para remoção de uma conta.
     * 
     * @return String contendo a resposta do usuário (S/N)
     */
    public String removeConfirmation(){
        System.out.println("Tem certeza que quer remover a Conta? [S, N] ");
        return scanner.nextLine();
    }
    
    /**
     * Exibe todas as informações de uma conta.
     * 
     * @param conta Objeto Conta cujas informações serão exibidas
     */
    public void mostrarConta(Conta conta){
        System.out.printf("Nome: %s%nTipo: %s%nValor: %s%nData: %s%nId: %s%n",
                conta.getNome(), conta.getTipo(), conta.getValor(), AgendamentosController.converterCalendarString(conta.getData()),
                conta.getId());
    }
    
    /**
     * Exibe o balanço mensal organizado por categorias.
     * 
     * @param chavesOrdenadas Lista com os nomes das categorias ordenadas
     * @param valoresOrdenados Lista com os valores correspondentes às categorias
     */
    public void mostrarBalanco(List<String> chavesOrdenadas, List<Double> valoresOrdenados){
        System.out.println("BALANCO MENSAL");
        for (int i = 0; i < chavesOrdenadas.size(); i++){
            System.out.printf("%s: %s%n", chavesOrdenadas.get(i), valoresOrdenados.get(i));
        }
        System.out.println();
    }
    
    /**
     * Exibe relatório detalhado de vendas.
     * 
     * @param produtos Map contendo produtos e seus respectivos dados de venda
     */
    public void mostrarRelatorio(Map<String, double[]> produtos){
        System.out.println("RELATORIO DE VENDAS\n");
        System.out.printf("%-25s %-10s %-15s %-15s %-15s %-15s%n", 
                "Nome", "ID", "Preco Atual", "Preco Venda", "Quantidade", "Valor Total");

        // Linha de separação
        System.out.println("----------------------------------------------------------------------------------------------------");

        // Impressão dos dados
        for (Map.Entry<String, double[]> entry : produtos.entrySet()) {
            String nome = entry.getKey();
            double[] valores = entry.getValue();

            // Imprime cada linha de forma formatada
            System.out.printf("%-25s %-10.0f %-15.2f %-15.2f %-15.0f %-15.2f%n", 
                    nome, valores[0], valores[1], valores[2], valores[3], valores[4]);
        }
        System.out.println();
    }
    
    /**
     * Exibe mensagem de confirmação de criação de venda.
     * 
     * @param id ID da venda criada
     */
    public void displayMsgVendaCriada(int id){
        System.out.printf("Nova Venda criada com o ID %s%n", id);
    }
    
    /**
     * Exibe mensagem de confirmação de criação de conta.
     * 
     * @param id ID da conta criada
     */
    public void displayContaCriada(int id){
        System.out.printf("Nova Conta criada com o ID %s%n", id);
    }
}