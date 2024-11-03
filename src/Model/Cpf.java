/*
 * Click nbfs,//nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author caio
 */
public class Cpf {
    public String codigoCpf;
    
    public Cpf(String codigoCpf){
        this.codigoCpf = codigoCpf;
    }
    
    public static boolean isValid(String codigo){
        List<Integer> digitos = new ArrayList<>();
        
        String[] codigoSplitted = codigo.split("[.-]");
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int digito = codigoSplitted[i].charAt(j) - '0';
                digitos.add(digito);
            }
        }
        
        int[] ultimosDigitos = {codigoSplitted[3].charAt(0) - '0',
                                codigoSplitted[3].charAt(1) - '0'};
        
        int soma;
        int j;
        for(int teste = 0; teste < 2; teste++){
            soma = 0;
            j = 0;
            for (int i = 10+teste; i > 1; i--){
                soma = soma + digitos.get(j) * i;
                j++;
            }

            int restoDivOnze = soma % 11;

            if (restoDivOnze < 2 && ultimosDigitos[teste] != 0){
                return false;
            }

            else {
                if (ultimosDigitos[teste] != 11 - restoDivOnze){
                    return false;
                }
            }

            digitos.add(11 - restoDivOnze);
        }
        
        return true;
    }
    
    public String[] getUF(){
      Map<Integer, String> ufs = Map.of(
              0, "Rio Grande do Sul",
              1, "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul, Tocantins",
              2, "Amazonas, Pará, Roraima, Amapá, Acre, Rondônia",
              3, "Ceará, Maranhão, Piauí",
              4, "Paraíba, Pernambuco, Alagoas, Rio Grande do Norte",
              5, "Bahia, Sergipe",
              6, "Minas Gerais",
              7, "Rio de Janeiro, Espírito Santo",
              8, "São Paulo",
              9, "Paraná, Santa Catarina");
      
      String uf = ufs.get(codigoCpf.charAt(11)-'0');
      
      return uf.split(",");
    }
    
    public void setCodigoCpf(String codigoCpf) {
        this.codigoCpf = codigoCpf;
    }
    
    @Override
    public String toString(){
        String[] codigoSplitted = codigoCpf.split("[.-]");
        
        return "***." + codigoSplitted[1] + "." + codigoSplitted[2] + "-**";
    }
}
