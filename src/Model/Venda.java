/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Calendar;

/**
 *
 * @author caio
 */
public class Venda extends Conta{
    public int idCliente;
    int[] idProdutos;
    int[] quantidades;
    double[] valoresUnit;
    
    public Venda(double valor, Calendar data, int id, int idCliente, int[] idProdutos, int[] quantidades, double[] valoresUnit){
        super("Venda", "Ganho", valor, data, id);
        this.idCliente = idCliente;
        this.idProdutos = idProdutos;
        this.quantidades = quantidades;
        this.valoresUnit = valoresUnit;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int[] getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int[] idProdutos) {
        this.idProdutos = idProdutos;
    }

    public int[] getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(int[] quantidades) {
        this.quantidades = quantidades;
    }

    public double[] getValoresUnit() {
        return valoresUnit;
    }

    public void setValoresUnit(double[] valoresUnit) {
        this.valoresUnit = valoresUnit;
    }
}
