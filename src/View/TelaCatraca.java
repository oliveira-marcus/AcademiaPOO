package View;

/**
 * Classe responsável pela interface de usuário da catraca da academia.
 * Fornece métodos para exibir informações sobre o fluxo de pessoas no estabelecimento.
 */
public class TelaCatraca {
    
    /**
     * Exibe a quantidade de pessoas que entraram no estabelecimento.
     *
     * @param pessoasEntrantes Número de pessoas que entraram.
     */
    public void exibirPessoasEntrantes(int pessoasEntrantes){
        System.out.printf("%s pessoas entraram no estabelecimento%n", pessoasEntrantes);
    }
    
    /**
     * Exibe a quantidade de pessoas que saíram do estabelecimento.
     *
     * @param pessoasSaintes Número de pessoas que saíram.
     */
    public void exibirPessoasSaintes(int pessoasSaintes){
        System.out.printf("%s pessoas sairam no estabelecimento%n", pessoasSaintes);
    }
    
    /**
     * Mostra a lista de pessoas atualmente presentes na academia.
     *
     * @param pessoasAtuais String contendo a lista de pessoas presentes.
     */
    public void mostrarPessoasAtuais(String pessoasAtuais){
        System.out.println("As pessoas que estao na academia sao: ");
        System.out.println(pessoasAtuais);
    }
    
    /**
     * Exibe mensagem informando que a academia está vazia.
     */
    public void displayMsgAcademiaVazia(){
        System.out.println("Atualmente a academia esta vazia");
    }
    
    /**
     * Sobrescreve o toString para retornar informações sobre a classe
     * 
     * @return informações sobre a tela
     */
    @Override
    public String toString(){
        return "Tela com metodos de interface para a Catraca";
    }
}
