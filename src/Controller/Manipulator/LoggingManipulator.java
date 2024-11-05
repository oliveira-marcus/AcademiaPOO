package Controller.Manipulator;

import Controller.JsonController.JsonCollectionController;
import java.io.IOException;

/**
 * Manipulador abstrato que adiciona capacidade de logging às operações básicas.
 * Registra mensagens de log para operações de leitura, adição, remoção e salvamento.
 *
 * @param <T> Tipo dos elementos da coleção.
 */
public abstract class LoggingManipulator<T> extends Manipulator<T>{
    
    /**
     * Construtor que inicializa o manipulador com logging.
     * Registra um log quando os dados são lidos do arquivo.
     *
     * @param jsonController Controlador JSON para operações de serialização.
     * @param caminho Caminho do arquivo JSON.
     * @param classe Classe dos elementos da coleção.
     * @throws IOException Se ocorrer erro na leitura do arquivo.
     */
    public LoggingManipulator(JsonCollectionController jsonController, String caminho, Class<T> classe) throws IOException {
        super(jsonController, caminho, classe);
        System.out.println("[LOG]: DADOS LIDOS");
    }
    
    /**
     * Adiciona um elemento à coleção e registra a operação no log.
     * Sobrescreve o método da classe pai para adicionar funcionalidade de logging.
     *
     * @param elem Elemento a ser adicionado.
     */
    @Override
    public void adicionar(T elem){
        System.out.println("[LOG]: ELEMENTO ADICIONADO");
        super.adicionar(elem);
    }
    
    /**
     * Remove um elemento da coleção e registra a operação no log.
     * Sobrescreve o método da classe pai para adicionar funcionalidade de logging.
     *
     * @param elem Elemento a ser removido.
     */
    @Override
    public void remover(T elem){
        System.out.println("[LOG]: ELEMENTO REMOVIDO");
        super.remover(elem);
    }
    
    /**
     * Salva a coleção no arquivo e registra a operação no log.
     * Sobrescreve o método da classe pai para adicionar funcionalidade de logging.
     *
     * @throws IOException Se ocorrer erro na escrita do arquivo.
     */
    @Override
    public void salvar() throws IOException{
        System.out.println("[LOG]: DADOS SALVOS");
    }
    
    /**
     * Método que sobrescreve o toString para exibir informações sobre o Manipulator
     * @return Informações sobre o Manipulator
     */
    @Override
    public String toString(){
        return "Manipulator que faz o log, ou seja, registra tudo o que faz";
    }
}
