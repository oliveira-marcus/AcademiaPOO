/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.TelaInicial;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private final TelaInicial telaInicial = new TelaInicial();
    
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
    
    public void run() throws IOException{
        login.run();
        int opcao = 0;
        
        while(opcao != 7){
            opcao = telaInicial.exibirMenu();
        
            switch(opcao){
                case 1 -> {
                    getManipuladorContrPorTipo(ClientesController.class).run();
                }
                case 2 -> {
                    getManipuladorContrPorTipo(ColaboradoresController.class).run();
                }
                case 3 -> {
                    getManipuladorContrPorTipo(ProdutoEstoqueController.class).run();
                }
                case 4 -> {
                    getManipuladorContrPorTipo(AgendamentosController.class).run();
                }
                case 5 -> {
                    getManipuladorContrPorTipo(ContasController.class).run();
                }
                case 6 -> {
                    catraca.run();
                }
            }
        }
        Sistema.salvarDados();
    }
}
