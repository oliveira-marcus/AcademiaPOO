/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller.JsonController;

import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author caio
 * @param <T>
 */
public interface JsonCollectionController<T> {
    
    public Collection<T> read(String caminhoArquivo) throws IOException;
    
    public void write(Collection<T> colecao, String caminhoArquivo) throws IOException;
}
