package Model;

import java.util.Calendar;

/**
 * Representa uma conta financeira, que pode ser um ganho ou um gasto, com informações sobre o nome, tipo, valor e data.
 */
public class Conta {
    
    private String nome;
    private String tipo;
    private double valor;
    private Calendar data;
    private int id;
    private String type = "Conta";
    
    /**
     * Construtor da classe {@code Conta}.
     * Inicializa uma nova conta com nome, tipo (ganho ou gasto), valor, data e identificador.
     *
     * @param nome   Nome da conta (ex: salário, despesa geral).
     * @param tipo   Tipo da conta (ex: Ganho ou Gasto).
     * @param valor  Valor monetário da conta.
     * @param data   Data de criação ou transação da conta.
     * @param id     Identificador único da conta.
     */
    public Conta(String nome, String tipo, double valor, Calendar data, int id){
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.id = id;
    }
    
    /**
     * Obtém o nome da conta.
     * 
     * @return Nome da conta.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Define o nome da conta.
     * 
     * @param nome Novo nome da conta.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Obtém o tipo da conta (Ganho ou Gasto).
     * 
     * @return Tipo da conta.
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Define o tipo da conta (Ganho ou Gasto).
     * 
     * @param tipo Novo tipo da conta.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Obtém o valor da conta.
     * 
     * @return Valor da conta.
     */
    public double getValor() {
        return valor;
    }
    
    /**
     * Define o valor da conta.
     * 
     * @param valor Novo valor da conta.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    /**
     * Obtém a data da conta.
     * 
     * @return Data da conta.
     */
    public Calendar getData() {
        return data;
    }
    
    /**
     * Define a data da conta.
     * 
     * @param data Nova data da conta.
     */
    public void setData(Calendar data) {
        this.data = data;
    }
    
    /**
     * Obtém o identificador único da conta.
     * 
     * @return ID da conta.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Define o identificador único da conta.
     * 
     * @param id Novo ID da conta.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtém o tipo fixo desta classe, que é "Conta".
     * 
     * @return Tipo da classe.
     */
    public String getType() {
        return type;
    }
    
    /**
     * Define o tipo fixo desta classe.
     * 
     * @param type Novo valor do tipo (padrão é "Conta").
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Sobrescreve o método toString para retornar o nome da conta.
     *
     * @return Nome do conta.
     */
    @Override
    public String toString(){
        return this.getNome();
    }
}
