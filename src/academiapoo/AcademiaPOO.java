/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Controller.AreaColaboradores;
import Controller.JsonController;
import Model.Funcionario;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author caio
 */
public class AcademiaPOO {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        JsonController<Funcionario> jsonController = new JsonController<>(Funcionario.class);
        
        AreaColaboradores areaColaboradores = new AreaColaboradores();
        
        System.out.println(areaColaboradores.getColaboradores());
    }
    
}
