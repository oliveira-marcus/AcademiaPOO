/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import Model.Despesa;
import java.io.IOException;

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
        
    }
    
    @Override
    public void remover(Despesa despesa){
        
    }
    
    @Override
    public Despesa buscar(Integer id){
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        
    }
}
