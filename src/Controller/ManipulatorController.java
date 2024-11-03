package Controller;

import java.io.IOException;

/**
 * Interface para controladores que manipulam dados e precisam realizar operações 
 * de salvamento em um repositório persistente.
 */
public interface ManipulatorController {
    
    /**
     * Salva as informações manipuladas no repositório persistente.
     * 
     * @throws IOException Se ocorrer um erro de entrada/saída durante o salvamento.
     */
    public void salvar() throws IOException;
}
