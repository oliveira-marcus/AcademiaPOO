package Model.Comparator;

import Model.Cliente;
import java.util.Comparator;

/**
 * Classe que implementa um comparador para ordenar clientes em ordem decrescente
 * com base em seus IDs.
 */
public class CompClienteIdDecresc implements Comparator<Cliente> {
    
    /**
     * Compara dois clientes com base em seus IDs em ordem decrescente.
     * 
     * @param c1 Primeiro cliente a ser comparado
     * @param c2 Segundo cliente a ser comparado
     * @return Um valor positivo se o ID de c1 é menor que o ID de c2,
     *         um valor negativo se o ID de c1 é maior que o ID de c2,
     *         ou zero se ambos têm o mesmo ID
     */
    @Override
    public int compare(Cliente c1, Cliente c2){
        return c2.getId() - c1.getId();
    }
}
