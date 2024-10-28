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
    private Funcionario funcLogado;
    JsonListController<Funcionario> jsonController;
    
    public Login(String caminho) throws IOException{
        jsonController.init(Funcionario.class);
        
        usuarios = jsonController.read(caminho);
    }
//    
    public Funcionario autenticarUsuario(String login, String senha){
        for (Funcionario usuario : usuarios){
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
                this.funcLogado = usuario;
                return usuario;
            }
        }
        return null;
    }

    public Funcionario getFuncLogado() {
        return funcLogado;
    }

    public void setFuncLogado(Funcionario funcLogado) {
        this.funcLogado = funcLogado;
    }
}
