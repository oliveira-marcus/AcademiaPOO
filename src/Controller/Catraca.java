package Controller;

import Model.Pessoa;
import View.TelaCatraca;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a catraca da academia e gerencia a entrada e saída de pessoas, além de monitorar o número atual de pessoas.
 */
public class Catraca{
    
    private int numeroPessoasEntrantes = 0;
    private int numeroPessoasSaintes = 0;
    private List<Pessoa> pessoasAtuais;
    
    private final TelaCatraca telaCatraca = new TelaCatraca();
    
    /**
     * Construtor da classe {@code Catraca}.
     * Inicializa a lista de pessoas atualmente presentes na academia.
     */
    public Catraca(){
        pessoasAtuais = new ArrayList<>();
    }
    
    /**
     * Registra a entrada de uma pessoa na academia e retorna o horário de entrada.
     *
     * @param pessoa Objeto {@code Pessoa} que está entrando.
     * @return Horário de entrada no formato {@code LocalTime}.
     */
    public LocalTime entrar(Pessoa pessoa){
        pessoasAtuais.add(pessoa);
        numeroPessoasEntrantes++;
        
        return LocalTime.now();
    }
    
    /**
     * Registra a saída de uma pessoa da academia e retorna o horário de saída.
     *
     * @param pessoa Objeto {@code Pessoa} que está saindo.
     * @return Horário de saída no formato {@code LocalTime}.
     */
    public LocalTime sair(Pessoa pessoa){
        pessoasAtuais.remove(pessoa);
        numeroPessoasSaintes++;
        
        return LocalTime.now();
    }
    
    /**
     * Executa a interação com a interface da catraca, exibindo o número de entradas, saídas e as pessoas atualmente presentes.
     */
    public void run(){
        telaCatraca.exibirPessoasEntrantes(numeroPessoasEntrantes);
        telaCatraca.exibirPessoasSaintes(numeroPessoasSaintes);
        
        String pessoasAtuaisStr = "";
        
        for (Pessoa pessoa : pessoasAtuais){
            pessoasAtuaisStr = pessoasAtuaisStr + pessoa.toString() + "\n";
        }
        
        if (pessoasAtuaisStr.equals("")){
            telaCatraca.displayMsgAcademiaVazia();
        }
        else{
            telaCatraca.mostrarPessoasAtuais(pessoasAtuaisStr);
        }
    }
    
    /**
     * Obtém o número atual de pessoas presentes na academia.
     *
     * @return Número de pessoas atualmente presentes.
     */
    public int getNumeroPessoasAtuais() {
        return pessoasAtuais.size();
    }
    
    /**
     * Obtém o número total de entradas registradas pela catraca.
     *
     * @return Número de pessoas que entraram na academia.
     */
    public int getNumeroPessoasEntrantes() {
        return numeroPessoasEntrantes;
    }

    /**
     * Define o número total de entradas registradas pela catraca.
     *
     * @param numeroPessoasEntrantes Novo valor para o número de pessoas que entraram.
     */
    public void setNumeroPessoasEntrantes(int numeroPessoasEntrantes) {
        this.numeroPessoasEntrantes = numeroPessoasEntrantes;
    }

    /**
     * Obtém o número total de saídas registradas pela catraca.
     *
     * @return Número de pessoas que saíram da academia.
     */
    public int getNumeroPessoasSaintes() {
        return numeroPessoasSaintes;
    }

    /**
     * Define o número total de saídas registradas pela catraca.
     *
     * @param numeroPessoasSaintes Novo valor para o número de pessoas que saíram.
     */
    public void setNumeroPessoasSaintes(int numeroPessoasSaintes) {
        this.numeroPessoasSaintes = numeroPessoasSaintes;
    }
    
    /**
     * Obtém a lista de pessoas atualmente presentes na academia.
     *
     * @return Lista de objetos {@code Pessoa} atualmente presentes.
     */
    public List<Pessoa> getPessoasAtuais(){
        return pessoasAtuais;
    }
    
    /**
     * Define a lista de pessoas atualmente presentes na academia.
     *
     * @param pessoasAtuais Nova lista de pessoas atualmente presentes.
     */
    public void setPessoasAtuais(List<Pessoa> pessoasAtuais){
        this.pessoasAtuais = pessoasAtuais;
    }

    /**
     * Retorna uma representação em string do estado atual da catraca.
     *
     * @return String contendo o número de pessoas atuais, entradas e saídas.
     */
    @Override
    public String toString(){
        return "[" + this.getNumeroPessoasAtuais() + ", " + this.numeroPessoasEntrantes + ", " + this.numeroPessoasSaintes + "]";
    }
}
