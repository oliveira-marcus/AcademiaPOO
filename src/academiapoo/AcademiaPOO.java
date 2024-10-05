/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academiapoo;

import Model.Produto;
import com.google.gson.Gson;

/**
 *
 * @author caio
 */
public class AcademiaPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gson gson = new Gson();

        // Criando um objeto simples
        Produto produto1 = new Produto("Halteres (par)", 150.00, 101, 20);

        // Convertendo objeto para JSON
        String json = gson.toJson(produto1);
        System.out.println("Objeto em JSON: " + json);

        // Convertendo JSON de volta para objeto
        Produto produtoFromJson = gson.fromJson(json, Produto.class);
        
        System.out.println(produtoFromJson);
    }
    
}
