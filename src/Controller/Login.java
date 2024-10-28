/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.JsonController.JsonListController;
import Model.Funcionario;
import View.TelaLogin;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author caio
 */
public class Login {
    private final TelaLogin telaLogin = new TelaLogin();
    private final List<Funcionario> usuarios;
    private Funcionario funcLogado;
    private JsonListController<Funcionario> jsonController;
    
    public Login(String caminho) throws IOException{
        jsonController = new JsonListController();
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
    
    public void run(){
        boolean canExit = false;
        while (!canExit){
            String login = telaLogin.getUserLogin();
            String senha = telaLogin.getUserSenha();
        
            autenticarUsuario(login, senha);
            
            if (funcLogado != null){
                canExit = true;
            }
            else{
                telaLogin.displayErroLogin();
            }
        }
    }
}
