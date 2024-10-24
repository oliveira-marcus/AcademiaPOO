/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.JsonController.JsonListController;
import Model.Funcionario;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author caio
 */
public class Login {
    private final List<Funcionario> usuarios;
    
    public Login() throws IOException{
        JsonListController<Funcionario> jsonController = new JsonListController(Funcionario.class);
        
        usuarios = jsonController.readJsonToList("src/data/colaboradores.json");
    }
    
    public Funcionario autenticarUsuario(String login, String senha){
        for (Funcionario usuario : usuarios){
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
                return usuario;
            }
        }
        
        return null;
    }
}
