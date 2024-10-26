/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author caio
 */
public class Venda extends Conta{
    public int idCliente;
    public HashMap<Produto, ArrayList<Double>> produtos;
    
    public Venda(double valor, Calendar data, int id, int idCliente, HashMap<Produto, ArrayList<Double>> produtos){
        super("Venda", "Ganho", valor, data, id);
        this.idCliente = idCliente;
        this.produtos = produtos;
        
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public HashMap<Produto, ArrayList<Double>> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<Produto, ArrayList<Double>> produtos) {
        this.produtos = produtos;
    }
}
