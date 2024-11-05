package Controller;

import Controller.Manipulator.Manipulator;
import Controller.Manipulator.MapManipulator;
import Model.Produto;
import View.TelaEstoque;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável pelo gerenciamento do estoque de produtos, incluindo operações de
 * adição, remoção, verificação, edição e controle de quantidade em estoque.
 */
public class ProdutoEstoqueController implements ManipulatorController{
    
    private Manipulator<Produto> manipulador;
    private MapManipulator<String, Integer> manipuladorMap;
    private TelaEstoque telaEstoque = new TelaEstoque();
    private int idMaximo;
    
    /**
     * Construtor da classe {@code ProdutoEstoqueController}.
     * 
     * @param manipulador Manipulador responsável pela coleção de produtos.
     * @param manipuladorMap Manipulador responsável pelo controle de quantidade de cada produto.
     * @throws IOException Se ocorrer um erro de entrada/saída ao inicializar.
     */
    public ProdutoEstoqueController(Manipulator<Produto> manipulador, MapManipulator manipuladorMap) throws IOException{
        this.manipulador = manipulador;
        this.manipuladorMap = manipuladorMap;
        Sistema.setQuantProdutosCatalogo(this.manipulador.getColecao().size());
        
        List<Integer> ids = this.manipulador.getColecao().stream().map(produto -> produto.getId()).collect(Collectors.toList());
        this.idMaximo = Collections.max(ids);
    }
    
    /**
     * Adiciona um novo produto ao estoque com base nas informações fornecidas pela tela de estoque.
     */
    public void adicionarProduto(){
        String nome = telaEstoque.getNomeProduto();
        double preco = telaEstoque.getPrecoProduto();
        idMaximo++;
        int id = idMaximo;
        int quantidade = telaEstoque.getQuantidade();
        
        Produto novoProduto  = new Produto(nome, preco, id);
        
        manipulador.adicionar(novoProduto);
        manipuladorMap.colocar(novoProduto.getNome(), quantidade);
        telaEstoque.displayMsgProdutoCriado(id);
        Sistema.setQuantProdutosCatalogo(Sistema.getQuantProdutosCatalogo() + 1);
    }
    
    /**
     * Remove um produto do estoque, caso sua quantidade seja zero, após confirmação do usuário.
     */
    public void removerProduto(){
        int id = telaEstoque.getIdProduto();
        Produto produto = buscarProduto(id);
        
        if (manipuladorMap.getMap().get(produto.getNome()) == 0) {
            String resposta = telaEstoque.removeConfirmation();
            
            if (resposta.equals("S")){
                manipulador.remover(produto);
                manipuladorMap.remover(produto.getNome());
            }
            else{
                telaEstoque.displayMsgCancelRemoval();
            }
        }
        else{
            telaEstoque.displayProdutoNaoZeradoError();
        }
    }
    
    /**
     * Verifica as informações de um produto no estoque e exibe sua quantidade disponível.
     */
    public void verificarProduto(){
        int id = telaEstoque.getIdProduto();
        Produto produto = buscarProduto(id);
        
        telaEstoque.mostrarProduto(produto);
        int quantidade = manipuladorMap.getMap().get(produto.getNome());
        telaEstoque.mostrarQuantidadeEstoque(produto.getNome(), quantidade);
    }
    
    /**
     * Edita as informações de um produto no estoque, permitindo modificar seu nome ou preço.
     */
    public void editarProduto(){
        int id = telaEstoque.getIdProduto();
        Produto produto = buscarProduto(id);
        telaEstoque.mostrarProduto(produto);
        System.out.println();
        int opcaoModificacao = telaEstoque.modificarProduto();
        
        switch(opcaoModificacao){
            case 1 -> {
                String novoNome = telaEstoque.getNomeProduto();
                editarNome(produto, novoNome);
            }
            case 2-> {
                double novoPreco = telaEstoque.getPrecoProduto();
                editarPreco(produto, novoPreco);
            }
        }
    }
    
    /**
     * Edita o nome de um produto.
     * 
     * @param produto Produto cujo nome será alterado.
     * @param nomeNovo Novo nome para o produto.
     */
    public void editarNome(Produto produto, String nomeNovo){
        String nomeAntigo = produto.getNome();
        manipuladorMap.colocar(nomeNovo, manipuladorMap.getMap().get(nomeAntigo));
        manipuladorMap.remover(nomeAntigo);
        produto.setNome(nomeNovo);
    }
    
    /**
     * Edita o preço de um produto.
     * 
     * @param produto Produto cujo preço será alterado.
     * @param precoNovo Novo preço para o produto.
     */
    public void editarPreco(Produto produto, double precoNovo){
        produto.setPreco(precoNovo);
    }
    
    /**
     * Altera a quantidade de um produto no estoque, podendo incrementar ou decrementar.
     */
    public void alterarQuantidade(){
        int id = telaEstoque.getIdProduto();
        Produto produto = buscarProduto(id);
        
        int opcao = telaEstoque.alterarQuantidadeProduto();
        int quantidade = telaEstoque.getQuantidade();
        
        int quantidadeNova = 0;
        
        if (opcao == 1){    
            quantidadeNova = manipuladorMap.getMap().get(produto.getNome()) + quantidade;
        }
        else if (opcao == 2){
            quantidadeNova = manipuladorMap.getMap().get(produto.getNome()) - quantidade;
        }
        
        if (quantidadeNova >= 0){
            manipuladorMap.colocar(produto.getNome(), quantidadeNova);
        }
        else{
            telaEstoque.displayQuantidadeDoProdutoMenorDiminuicaoError();
        }
        
    }
    
    /**
     * Busca um produto pelo seu ID.
     * 
     * @param id ID do produto a ser buscado.
     * @return O produto com o ID especificado ou null, caso não seja encontrado.
     */
    public Produto buscarProduto(Integer id){
        for (Produto produto : this.manipulador.getColecao()){
            if (produto.getId() == id){
                return produto;
            }
        }
        
        return null;
    }
    
    /**
     * Salva o estado atual dos produtos e suas quantidades no repositório persistente.
     * 
     * @throws IOException Se ocorrer um erro de entrada/saída durante o salvamento.
     */
    @Override
    public void salvar() throws IOException{
        manipulador.salvar();
        manipuladorMap.salvar();
    }
    
    /**
     * Executa o menu principal para gerenciamento de estoque de produtos.
     */
    public void run(){
        int opcao = 0;
        
        while(opcao != 6){
            opcao = telaEstoque.exibirMenu();
            
            switch  (opcao){
                case 1 -> {
                    adicionarProduto();
                }
                case 2 -> {
                    editarProduto();
                }
                case 3 -> {
                    removerProduto();
                }
                case 4 -> {
                    alterarQuantidade();
                }
                case 5 -> {
                    verificarProduto();
                }
            }
        }
    }
    
    /**
     * Retorna o manipulador de Produtos.
     * 
     * @return Manipulador de Produtos.
     */
    public Manipulator<Produto> getManipulador() {
        return manipulador;
    }
    
    /**
     * Define o manipulador de Produtos.
     * 
     * @param manipulador Manipulador de Produtos.
     */
    public void setManipulador(Manipulator<Produto> manipulador) {
        this.manipulador = manipulador;
    }
    
    /**
     * Retorna o manipulador do Estoque.
     * 
     * @return Manipulador do Estoque.
     */
    public MapManipulator<String, Integer> getManipuladorMap() {
        return manipuladorMap;
    }
    
    /**
     * Define o manipulador do Estoque.
     * 
     * @param manipuladorMap Manipulador do Estoque
     */
    public void setManipuladorMap(MapManipulator<String, Integer> manipuladorMap) {
        this.manipuladorMap = manipuladorMap;
    }

    /**
     * Retorna a tela da seção Produtos/Estoque.
     * 
     * @return tela da seção Produtos/Estoque.
     */
    public TelaEstoque getTelaEstoque() {
        return telaEstoque;
    }

    /**
     * Define a tela da seção Produtos/Estoque.
     * 
     * @param telaEstoque tela da seção Produtos/Estoque
     */
    public void setTelaEstoque(TelaEstoque telaEstoque) {
        this.telaEstoque = telaEstoque;
    }
    
    /**
     * Retorna o maior Id dos produtos
     * @return Maior id dos produtos
     */
    public int getIdMaximo() {
        return idMaximo;
    }

    /**
     * Define o id máximo dos produtos
     * @param idMaximo id máximo dos produtos
     */
    public void setIdMaximo(int idMaximo) {
        this.idMaximo = idMaximo;
    }
    
    /**
     * Método que sobrescreve o toString para exibir informações sobre o Controller
     * @return Informações sobre o Controller
     */
    @Override
    public String toString(){
        return "Controller referente a área de Estoque/Produtos da Academia";
    }
}

