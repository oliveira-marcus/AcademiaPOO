package Model.Comparator;

import Model.Cliente;
import java.util.Comparator;

/**
 * Classe que implementa um comparador para ordenar clientes em ordem alfabética decrescente
 * com base em seus nomes.
 */
public class CompClienteNomeDecresc implements Comparator<Cliente>{
    
    /**
     * Compara dois clientes com base em seus nomes em ordem alfabética decrescente.
     * Utiliza um comparador auxiliar {@link CompStringsCresc} para realizar
     * a comparação das strings dos nomes, invertendo a ordem dos parâmetros
     * para obter o resultado decrescente.
     * 
     * @param c1 Primeiro cliente a ser comparado
     * @param c2 Segundo cliente a ser comparado
     * @return Um valor negativo se o nome de c1 vem depois do nome de c2 alfabeticamente,
     *         um valor positivo se o nome de c1 vem antes do nome de c2 alfabeticamente,
     *         ou zero se os nomes são iguais
     */
    @Override
    public int compare(Cliente c1, Cliente c2){
        CompStringsCresc comparadorStrings = new CompStringsCresc();
        
        return comparadorStrings.compare(c2.getNome(), c1.getNome());
    }
}

