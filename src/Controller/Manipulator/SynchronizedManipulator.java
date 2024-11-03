package Controller.Manipulator;

import Controller.JsonController.JsonCollectionController;
import java.io.IOException;

/**
 * Classe abstrata que estende Manipulator para fornecer operações thread-safe.
 * Implementa métodos sincronizados para adicionar e remover elementos.
 *
 * @param <T> Tipo dos elementos da coleção.
 */
public abstract class SynchronizedManipulator<T> extends Manipulator<T> {
    
    /**
     * Construtor que inicializa o manipulador sincronizado.
     *
     * @param jsonController Controlador JSON para operações de serialização.
     * @param caminho Caminho do arquivo JSON.
     * @param classe Classe dos elementos da coleção.
     * @throws IOException Se ocorrer erro na leitura do arquivo.
     */
    public SynchronizedManipulator(JsonCollectionController jsonController, String caminho, Class<T> classe) throws IOException{
        super(jsonController, caminho, classe);
    }
    
    /**
     * Adiciona um elemento à coleção de forma sincronizada.
     * 
     * @param elem Elemento a ser adicionado.
     */
    @Override
    public synchronized void adicionar(T elem){
        super.adicionar(elem);
    }
    
    /**
     * Remove um elemento da coleção de forma sincronizada.
     *
     * @param elem Elemento a ser removido.
     */
    @Override
    public synchronized void remover(T elem){
        super.remover(elem);
    }
}
