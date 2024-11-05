package Controller;

import Controller.Manipulator.Manipulator;
import Model.Cpf;
import Model.Funcionario;
import View.TelaColaboradores;
import java.io.IOException;

/**
 * Controlador para gerenciar colaboradores (funcionários) da aplicação.
 */
public class ColaboradoresController implements ManipulatorController{
    
    private Manipulator<Funcionario> manipulador;
    private TelaColaboradores telaColaboradores = new TelaColaboradores();
    
    /**
     * Construtor da classe {@code ColaboradoresController}.
     * Inicializa o controlador com o manipulador fornecido.
     *
     * @param manipulador Manipulador de funcionários.
     * @throws IOException Se ocorrer um erro ao inicializar o manipulador.
     */
    public ColaboradoresController(Manipulator<Funcionario> manipulador) throws IOException{
        this.manipulador = manipulador;
    }
    
    /**
     * Adiciona um novo colaborador à coleção.
     * Coleta as informações do colaborador através da interface de tela.
     */
    public void adicionarColaborador(){
        String nome = telaColaboradores.getNomeColaborador();
        String endereco = telaColaboradores.getEnderecoColaborador();
        String telefone = telaColaboradores.getFoneColaborador();
        String email = telaColaboradores.getEmailColaborador();
        String cpf = telaColaboradores.getCpfColaborador();
        double salario = telaColaboradores.getSalarioColaborador();
        String login = telaColaboradores.getLoginColaborador();
        String senha = telaColaboradores.getSenhaColaborador();
        String cargo = telaColaboradores.getCargoColaborador();
        
        Funcionario novoFuncionario = new Funcionario(nome, endereco, telefone, email, new Cpf(cpf), salario, login, senha, cargo);
        manipulador.adicionar(novoFuncionario);
    }
    
    /**
     * Remove um colaborador da coleção.
     * Solicita a confirmação do usuário antes de remover.
     */
    public void removerColaborador(){
        String nome = telaColaboradores.getNomeColaborador();
        Funcionario funcionario = buscarColaborador(nome);
        telaColaboradores.mostrarColaborador(funcionario);
        String opcaoConfirmacao = telaColaboradores.removeConfirmation();

        if (opcaoConfirmacao.equals("S")){
            manipulador.remover(funcionario);
        }
    }
    
    /**
     * Edita as informações de um colaborador existente.
     * Apresenta as opções de modificação disponíveis ao usuário.
     */
    public void editarColaborador(){
        String nome = telaColaboradores.getNomeColaborador();
        Funcionario funcionario = buscarColaborador(nome);
        telaColaboradores.mostrarColaborador(funcionario);
        System.out.println();
        int opcaoModificacao = telaColaboradores.modificarColaborador();

        switch(opcaoModificacao){
            case 1 -> {
                String novoEndereco = telaColaboradores.getEnderecoColaborador();
                editarEndereco(funcionario, novoEndereco);

            }
            case 2 -> {
                String novoFone = telaColaboradores.getFoneColaborador();
                editarTelefone(funcionario, novoFone);
            }
            case 3 -> {
                String novoEmail = telaColaboradores.getEmailColaborador();
                editarEmail(funcionario, novoEmail);
            }
            case 4 -> {
                String novoLogin = telaColaboradores.getLoginColaborador();
                editarLogin(funcionario, novoLogin);
            }
            case 5 -> {
                String novaSenha = telaColaboradores.getSenhaColaborador();
                editarSenha(funcionario, novaSenha);
            }
        }
    }
    
    /**
     * Edita o endereço de um colaborador.
     *
     * @param funcionario O colaborador cujo endereço será editado.
     * @param novoEndereco O novo endereço a ser definido.
     */
    public void editarEndereco(Funcionario funcionario, String novoEndereco){
        funcionario.setEndereco(novoEndereco);
    }
    
    /**
     * Edita o telefone de um colaborador.
     *
     * @param funcionario O colaborador cujo telefone será editado.
     * @param novoTelefone O novo telefone a ser definido.
     */
    public void editarTelefone(Funcionario funcionario, String novoTelefone){
        funcionario.setTelefone(novoTelefone);
    }
    
    /**
     * Edita o e-mail de um colaborador.
     *
     * @param funcionario O colaborador cujo e-mail será editado.
     * @param novoEmail O novo e-mail a ser definido.
     */
    public void editarEmail(Funcionario funcionario, String novoEmail){
        funcionario.setEmail(novoEmail);
    }
    
    /**
     * Edita o login de um colaborador.
     *
     * @param funcionario O colaborador cujo login será editado.
     * @param novoLogin O novo login a ser definido.
     */
    public void editarLogin(Funcionario funcionario, String novoLogin){
        funcionario.setLogin(novoLogin);
    }
    
    /**
     * Edita a senha de um colaborador.
     *
     * @param funcionario O colaborador cuja senha será editada.
     * @param novaSenha A nova senha a ser definida.
     */
    public void editarSenha(Funcionario funcionario, String novaSenha){
        funcionario.setSenha(novaSenha);
    }
    
    /**
     * Busca um colaborador pelo nome.
     *
     * @param nome O nome do colaborador a ser buscado.
     * @return O colaborador encontrado ou {@code null} se não encontrado.
     */
    public Funcionario buscarColaborador(String nome){
        for (Funcionario colaborador : this.manipulador.getColecao()){
            if (colaborador.getNome().equals(nome)){
                return colaborador;
            }
        }
        return null;
    }
    
    /**
     * Salva as alterações feitas no manipulador.
     * 
     * @throws IOException Se ocorrer um erro ao salvar.
     */
    @Override
    public void salvar() throws IOException{
        manipulador.salvar();
    }
    
    /**
     * Executa o menu principal de operações do controlador de colaboradores.
     * As opções incluem adicionar, editar e remover colaboradores.
     */
    public void run(){
        int opcao = 0;
        
        while (opcao != 4){
            opcao = telaColaboradores.exibirMenu();
            
            switch(opcao){
                case 1 -> {
                    adicionarColaborador();
                }
                case 2 -> {
                    editarColaborador();
                }
                case 3 -> {
                    removerColaborador();
                }
            }
        }
    }

    /**
     * Obtém o manipulador de colaboradores.
     *
     * @return Objeto {@code Manipulator} de colaboradores.
     */
    public Manipulator<Funcionario> getManipulador() {
        return manipulador;
    }

    /**
     * Define o manipulador de colaboradores.
     *
     * @param manipulador Novo manipulador de colaboradores.
     */
    public void setManipulador(Manipulator<Funcionario> manipulador) {
        this.manipulador = manipulador;
    }

    /**
     * Retorna a tela da seção Colaboradores.
     * 
     * @return tela da seção Colaboradores.
     */
    public TelaColaboradores getTelaColaboradores() {
        return telaColaboradores;
    }

    /**
     * Define a tela da seção Colaboradores.
     * 
     * @param telaColaboradores tela da seção Colaboradores
     */
    public void setTelaColaboradores(TelaColaboradores telaColaboradores) {
        this.telaColaboradores = telaColaboradores;
    }
}
