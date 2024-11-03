package Controller.Manipulator;

import Controller.JsonController.JsonCollectionController;
import java.io.IOException;
import java.util.Comparator;

/**
 * Classe abstrata que estende Manipulator para fornecer funcionalidades de ordenação.
 * Permite ordenar os elementos da coleção usando um comparador.
 *
 * @param <T> Tipo dos elementos da coleção.
 */
public abstract class SortManipulator<T> extends Manipulator<T>{
    
    /**
     * Construtor que inicializa o manipulador de ordenação.
     *
     * @param jsonController Controlador JSON para operações de serialização.
     * @param caminho Caminho do arquivo JSON.
     * @param classe Classe dos elementos da coleção.
     * @throws IOException Se ocorrer erro na leitura do arquivo.
     */
    public SortManipulator(JsonCollectionController jsonController, String caminho, Class<T> classe) throws IOException {
        super(jsonController, caminho, classe);
    }
    
    /**
     * Método abstrato para ordenar os elementos da coleção.
     *
     * @param comparator Comparador que define a ordem dos elementos.
     */
    public abstract void sort(Comparator<T> comparator);
}
