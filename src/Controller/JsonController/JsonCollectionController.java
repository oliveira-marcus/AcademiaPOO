/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller.JsonController;

import com.google.gson.JsonDeserializer;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author caio
 * @param <T>
 */
public interface JsonCollectionController<T> {
    
    public void init(Class<T> tipoClasse);
    
    public void init(Class<T> tipoClasse, JsonDeserializer deserializer);
    
    public Collection<T> read(String caminhoArquivo) throws IOException;
    
    public void write(Collection<T> colecao, String caminhoArquivo) throws IOException;
}
