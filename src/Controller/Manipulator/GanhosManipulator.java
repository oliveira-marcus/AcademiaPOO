/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Manipulator;

import Model.Ganho;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author caio
 */
public class GanhosManipulator extends ListManipulator<Ganho, Integer> {
    public GanhosManipulator(String caminho, Class<Ganho> classe) throws IOException{
        super(caminho, classe);
    }

    @Override
    public void adicionar(Ganho ganho){
        super.adicionar(ganho);
    }
    
    public void editarNome(Ganho ganho, String novoNome){
        ganho.setNome(novoNome);
    }
    
    public void editarTipo(Ganho ganho, String novoTipo){
        ganho.setTipo(novoTipo);
    }
    
    public void editarValor(Ganho ganho, double novoValor){
        ganho.setValor(novoValor);
    }
    
    public void editarData(Ganho ganho, Calendar novaData){
        ganho.setData(novaData);
    }

    @Override
    public void remover(Ganho ganho){
        super.remover(ganho);
    }
    
    @Override
    public Ganho buscar(Integer id){
        for (Ganho ganho : this.getLista()){
            if (ganho.getId() == id){
                return ganho;
            }
        }
        return null;
    }
    
    @Override
    public void salvar() throws IOException{
        
    }
}
