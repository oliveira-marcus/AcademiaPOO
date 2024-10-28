/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Login;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caio
 */
public class Sistema {
    private final static List<ManipulatorController> manipuladoresController = new ArrayList<>();
    private static int quantClientesPriv = 0;
    protected static int quantClientesProtec = 0;
    private static int quantProdutosCatalogo = 0;
    private Catraca catraca = new Catraca();
    private Login login;
    
    public static void adicionarManipuladorContr(ManipulatorController manipulador){
        manipuladoresController.add(manipulador);
    }
    
    public static <T extends ManipulatorController> T getManipuladorContrPorTipo(Class<T> tipo){
        for (ManipulatorController manipuladorController : manipuladoresController){
            if (tipo.isInstance(manipuladorController)){
                return tipo.cast(manipuladorController);
            }
        }
        return null;
    }
    
    public static void salvarDados() throws IOException{
        for (ManipulatorController manipuladorController : manipuladoresController){
            manipuladorController.salvar();
        }
    }

    public static int getQuantClientesPriv() {
        return quantClientesPriv;
    }

    public static void setQuantClientesPriv(int quantClientesPriv) {
        Sistema.quantClientesPriv = quantClientesPriv;
    }

    public static int getQuantProdutosCatalogo() {
        return quantProdutosCatalogo;
    }

    public static void setQuantProdutosCatalogo(int quantProdutosCatalogo) {
        Sistema.quantProdutosCatalogo = quantProdutosCatalogo;
    }

    public Sistema(String caminhoLogin) throws IOException {
        this.login = new Login(caminhoLogin);
    }

    public Catraca getCatraca() {
        return catraca;
    }

    public void setCatraca(Catraca catraca) {
        this.catraca = catraca;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public void run(){
        login.run();
    }
}
