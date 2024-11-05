package Model;

import java.util.Calendar;

/**
 * Representa uma venda, que é um tipo de conta que gera receita.
 * A venda inclui informações sobre o cliente, produtos vendidos, quantidades e valores unitários.
 */
public class Venda extends Conta{
    
    private int idCliente;
    private int[] idProdutos;
    private int[] quantidades;
    private double[] valoresUnit;
    
    /**
     * Construtor da classe Venda.
     * Inicializa uma nova venda com informações relevantes como valor total, data,
     * identificador, cliente e detalhes dos produtos vendidos.
     *
     * @param valor         Valor total da venda.
     * @param data          Data da venda.
     * @param id            Identificador único da venda.
     * @param idCliente     Identificador do cliente que realizou a compra.
     * @param idProdutos    Array de identificadores dos produtos vendidos.
     * @param quantidades   Array de quantidades de cada produto vendido.
     * @param valoresUnit   Array de valores unitários de cada produto vendido.
     */
    public Venda(double valor, Calendar data, int id, int idCliente, int[] idProdutos, int[] quantidades, double[] valoresUnit){
        super("Venda", "Ganho", valor, data, id);
        this.idCliente = idCliente;
        this.idProdutos = idProdutos;
        this.quantidades = quantidades;
        this.valoresUnit = valoresUnit;
        setType("Venda");
    }
    
    /**
     * Obtém o identificador do cliente que realizou a compra.
     * 
     * @return Identificador do cliente.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Define o identificador do cliente que realizou a compra.
     * 
     * @param idCliente Novo identificador do cliente.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtém o array de identificadores dos produtos vendidos.
     * 
     * @return Array de identificadores dos produtos.
     */
    public int[] getIdProdutos() {
        return idProdutos;
    }

    /**
     * Define o array de identificadores dos produtos vendidos.
     * 
     * @param idProdutos Novo array de identificadores dos produtos.
     */
    public void setIdProdutos(int[] idProdutos) {
        this.idProdutos = idProdutos;
    }

    /**
     * Obtém o array de quantidades de cada produto vendido.
     * 
     * @return Array de quantidades dos produtos.
     */
    public int[] getQuantidades() {
        return quantidades;
    }

    /**
     * Define o array de quantidades de cada produto vendido.
     * 
     * @param quantidades Novo array de quantidades dos produtos.
     */
    public void setQuantidades(int[] quantidades) {
        this.quantidades = quantidades;
    }

    /**
     * Obtém o array de valores unitários de cada produto vendido.
     * 
     * @return Array de valores unitários dos produtos.
     */
    public double[] getValoresUnit() {
        return valoresUnit;
    }

    /**
     * Define o array de valores unitários de cada produto vendido.
     * 
     * @param valoresUnit Novo array de valores unitários dos produtos.
     */
    public void setValoresUnit(double[] valoresUnit) {
        this.valoresUnit = valoresUnit;
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
