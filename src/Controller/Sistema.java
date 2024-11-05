package Controller;

import View.TelaInicial;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal do sistema, responsável pela inicialização e execução das operações 
 * de controle de acesso, gerenciamento de usuários e produtos, e interação com as 
 * demais funcionalidades da aplicação.
 */
public class Sistema {
    
    private final static List<ManipulatorController> manipuladoresController = new ArrayList<>();
    private static int quantClientesPriv = 0;
    protected static int quantClientesProtec = 0;
    private static int quantProdutosCatalogo = 0;
    private static Catraca catraca = new Catraca();
    private static Login login;
    private static TelaInicial telaInicial = new TelaInicial();
    
    /**
     * Construtor da classe {@code Sistema}.
     * 
     * @param caminhoLogin Caminho do arquivo de login, utilizado para inicializar o sistema de autenticação.
     * @throws IOException Se ocorrer um erro de entrada/saída ao carregar o login.
     */
    public Sistema(String caminhoLogin) throws IOException {
        login = new Login(caminhoLogin);
    }
    
    /**
     * Adiciona um manipulador de controle à lista de manipuladores do sistema.
     * 
     * @param manipulador Manipulador de controle a ser adicionado.
     */
    public static void adicionarManipuladorContr(ManipulatorController manipulador){
        manipuladoresController.add(manipulador);
    }
    
    /**
     * Retorna um manipulador de controle específico com base em seu tipo.
     * 
     * @param <T> Tipo de controlador desejado, que estende ManipulatorController.
     * @param tipo Classe do tipo do controlador desejado.
     * @return O manipulador correspondente ao tipo solicitado, ou null se não for encontrado.
     */
    public static <T extends ManipulatorController> T getManipuladorContrPorTipo(Class<T> tipo){
        for (ManipulatorController manipuladorController : manipuladoresController){
            if (tipo.isInstance(manipuladorController)){
                return tipo.cast(manipuladorController);
            }
        }
        return null;
    }
    
    /**
     * Salva os dados de todos os manipuladores de controle presentes no sistema.
     * 
     * @throws IOException Se ocorrer um erro de entrada/saída ao salvar os dados.
     */
    public static void salvarDados() throws IOException{
        for (ManipulatorController manipuladorController : manipuladoresController){
            manipuladorController.salvar();
        }
    }
    
    /**
     * Executa o sistema, exibindo o menu principal e gerenciando as opções selecionadas pelo usuário.
     * 
     * @throws IOException Se ocorrer um erro de entrada/saída durante a execução.
     */
    public void run() throws IOException{
        login.run();
        int opcao = 0;
        
        while(opcao != 8){
            opcao = telaInicial.exibirMenu();
        
            switch(opcao){
                case 1 -> {
                    getManipuladorContrPorTipo(ClientesController.class).run();
                }
                case 2 -> {
                    getManipuladorContrPorTipo(ColaboradoresController.class).run();
                }
                case 3 -> {
                    getManipuladorContrPorTipo(ProdutoEstoqueController.class).run();
                }
                case 4 -> {
                    getManipuladorContrPorTipo(AgendamentosController.class).run();
                }
                case 5 -> {
                    getManipuladorContrPorTipo(ContasController.class).run();
                }
                case 6 -> {
                    catraca.run();
                }
                case 7 -> {
                    salvarDados();
                    telaInicial.displayMsgDadosSalvos();
                }
            }
        }
        Sistema.salvarDados();
    }

    /**
     * Obtem a lista com os Controllers que tem manipuladores 
     * 
     * @return lista com os Controllers que tem manipuladores 
     */
    public static List<ManipulatorController> getManipuladoresController() {
        return manipuladoresController;
    }
    
    /**
     * Obtém a quantidade de clientes no sistema.
     * 
     * @return Quantidade de clientes privados.
     */
    public static int getQuantClientesPriv() {
        return quantClientesPriv;
    }

    /**
     * Define a quantidade de clientes no sistema.
     * 
     * @param quantClientesPriv Nova quantidade de clientes.
     */
    public static void setQuantClientesPriv(int quantClientesPriv) {
        Sistema.quantClientesPriv = quantClientesPriv;
    }
    
    /**
     * Obtém a quantidade de clientes no sistema.
     * 
     * @return Quantidade de clientes privados.
     */
    public static int getQuantClientesProtec() {
        return quantClientesProtec;
    }

    /**
     * Define a quantidade de clientes no sistema.
     * 
     * @param quantClientesProtec
     */
    public static void setQuantClientesProtec(int quantClientesProtec) {
        Sistema.quantClientesProtec = quantClientesProtec;
    }
    
    /**
     * Obtém a quantidade de produtos no catálogo.
     * 
     * @return Quantidade de produtos no catálogo.
     */
    public static int getQuantProdutosCatalogo() {
        return quantProdutosCatalogo;
    }

    /**
     * Define a quantidade de produtos no catálogo.
     * 
     * @param quantProdutosCatalogo Nova quantidade de produtos no catálogo.
     */
    public static void setQuantProdutosCatalogo(int quantProdutosCatalogo) {
        Sistema.quantProdutosCatalogo = quantProdutosCatalogo;
    }
    
    /**
     * Obtém a instância de controle de acesso do sistema.
     * 
     * @return A instância de Catraca.
     */
    public static Catraca getCatraca() {
        return catraca;
    }

    /**
     * Define a instancia de controle de acesso do sistema
     * 
     * @param catraca Instancia de Catraca
     */
    public static void setCatraca(Catraca catraca) {
        Sistema.catraca = catraca;
    }
    
    /**
     * Obtém a instância de login do sistema.
     * 
     * @return A instância de Login.
     */
    public static Login getLogin() {
        return login;
    }

    /**
     * Define a instancia login do sistema
     * 
     * @param login login do sistema
     */
    public static void setLogin(Login login) {
        Sistema.login = login;
    }

    /**
     * Retorna a tela inicial.
     * 
     * @return tela inicial.
     */
    public static TelaInicial getTelaInicial() {
        return telaInicial;
    }
    
    /**
     * Define a tela inicial
     * 
     * @param telaInicial 
     */
    public static void setTelaInicial(TelaInicial telaInicial) {
        Sistema.telaInicial = telaInicial;
    }
    
    
    /**
     * Método que sobrescreve o toString para exibir informações sobre o Sistema
     * @return Informações sobre a academia
     */
    @Override
    public String toString(){
        return "Sistema para a academia";
    }
}
