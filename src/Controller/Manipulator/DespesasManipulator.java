/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import Model.Despesa;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author caio
 */
public class DespesasManipulator extends ListManipulator<Despesa, Integer> {
    public DespesasManipulator(String caminho, Class<Despesa> classe) throws IOException{
        super(caminho, classe);
    }
    
    @Override
    public void adicionar(Despesa novaDespesa){
        super.adicionar(novaDespesa);
    }
    
    public void editarNome(Despesa despesa, String novoNome){
        despesa.setNome(novoNome);
    }
    
    public void editarTipo(Despesa despesa, String novoTipo){
        despesa.setTipo(novoTipo);
    }
    
    public void editarValor(Despesa despesa, double novoValor){
        despesa.setValor(novoValor);
    }
    
    public void editarData(Despesa despesa, Calendar novaData){
        despesa.setData(novaData);
    }
    
    @Override
    public void remover(Despesa despesa){
        super.remover(despesa);
    }
    
    @Override
    public Despesa buscar(Integer id){
        for(Despesa despesa :this.getLista()){
            if (despesa.getId() == id){
                return despesa;
            }
        }
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        
    }
}
