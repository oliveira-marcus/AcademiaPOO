package Model.Comparator;

import java.util.Comparator;

/**
 * Classe que implementa um comparador para ordenar tipos de conta em uma ordem predefinida.
 * A ordem é definida por um array fixo que estabelece a prioridade de cada tipo de conta.
 */
public class CompContaTipo implements Comparator<String>{
    
    /**
     * Array que define a ordem de prioridade dos tipos de conta.
     * A posição no array determina a ordem de classificação.
     */
    String[] tiposConta = {"Diaria", "Mensalidade", "Venda",
        "Salarios", "Fornecedores", "Despesa Geral", "Despesa Administrativa",
    "Imposto", "Saldo Final"};

    /**
     * Compara dois tipos de conta com base em suas posições no array tiposConta.
     * 
     * @param c1 Primeiro tipo de conta a ser comparado
     * @param c2 Segundo tipo de conta a ser comparado
     * @return Um valor negativo se c1 vem antes de c2 no array,
     *         um valor positivo se c1 vem depois de c2 no array,
     *         ou zero se ambos têm a mesma posição
     */
    @Override
    public int compare(String c1, String c2){
        int c1Index = find(c1);
        int c2Index = find(c2);
        
        return c1Index - c2Index;
    }
    
    /**
     * Localiza a posição de um tipo de conta no array tiposConta.
     * 
     * @param c O tipo de conta a ser localizado
     * @return O índice do tipo de conta no array se encontrado,
     *         ou 10000 se o tipo de conta não estiver no array (valor arbitrário alto
     *         para posicionar tipos não reconhecidos ao final da ordenação)
     */
    public int find(String c){
        for (int i = 0; i < tiposConta.length; i++){
            if (c.equals(tiposConta[i])){
                return i;
            }
        }
        return 10000;
    }
}
