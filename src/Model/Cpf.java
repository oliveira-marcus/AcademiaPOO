package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representa um CPF e fornece métodos para validação do código e identificação de estados (UF) a partir do CPF.
 */
public class Cpf {
    
    private String codigoCpf;
    
    /**
     * Construtor da classe {@code Cpf}.
     * Inicializa o CPF com o código especificado.
     *
     * @param codigoCpf Código do CPF no formato "XXX.XXX.XXX-XX".
     */
    public Cpf(String codigoCpf){
        this.codigoCpf = codigoCpf;
    }
    
    /**
     * Verifica se um código de CPF é válido.
     * Utiliza o cálculo de dígitos verificadores para validar o CPF.
     *
     * @param codigo Código do CPF a ser validado.
     * @return true se o CPF for válido, false caso contrário.
     */
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
    
    /**
     * Obtém os estados (UF) associados ao dígito de origem do CPF.
     * Baseado no dígito de origem do CPF, que indica o estado de emissão.
     *
     * @return Array de strings contendo os estados associados ao CPF.
     */
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
    
    /**
     * Define o código do CPF.
     * 
     * @param codigoCpf Novo código do CPF.
     */
    public void setCodigoCpf(String codigoCpf) {
        this.codigoCpf = codigoCpf;
    }
    
    /**
     * Retorna uma representação mascarada do CPF no formato "***.XXX.XXX-**".
     * 
     * @return CPF com os primeiros e últimos dígitos ocultos.
     */
    @Override
    public String toString(){
        String[] codigoSplitted = codigoCpf.split("[.-]");
        
        return "***." + codigoSplitted[1] + "." + codigoSplitted[2] + "-**";
    }
}
