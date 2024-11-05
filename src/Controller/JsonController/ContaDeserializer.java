package Controller.JsonController;

import Model.Conta;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que implementa a deserialização de objetos Conta do formato JSON.
 * Permite o registro de diferentes tipos de conta e sua correta deserialização.
 */
public class ContaDeserializer implements JsonDeserializer<Conta>{
    
    private final String contaTypeElementName;
    private final Gson gson;
    private final Map<String, Class<? extends Conta>> contaTypeRegistry;
    
    /**
     * Construtor da classe {@code ContaDeserializer} que inicializa o deserializador com o nome do elemento que identifica o tipo de conta.
     *
     * @param ContaTypeElementName Nome do elemento que identifica o tipo de conta no JSON.
     */
    public ContaDeserializer(String ContaTypeElementName) {
        this.contaTypeElementName = ContaTypeElementName;
        this.gson = new Gson();
        this.contaTypeRegistry = new HashMap<>();
    }
    
    /**
     * Registra um tipo de conta para ser usado na deserialização.
     *
     * @param contaTypeName Nome do tipo de conta no JSON.
     * @param contaType Classe correspondente ao tipo de conta.
     */
    public void registerContaType(String contaTypeName, Class<? extends Conta> contaType) {
        contaTypeRegistry.put(contaTypeName, contaType);
    }
    
    /**
     * Realiza a deserialização de um objeto Conta a partir de um elemento JSON.
     *
     * @param json Elemento JSON a ser deserializado.
     * @param typeOfT Tipo do objeto a ser deserializado.
     * @param context Contexto da deserialização.
     * @return Objeto {@code Conta} deserializado.
     */
    @Override
    public Conta deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context){
        JsonObject contaObject = json.getAsJsonObject();
        JsonElement contaTypeElement = contaObject.get(contaTypeElementName);

        Class<? extends Conta> contaType = contaTypeRegistry.get(contaTypeElement.getAsString());
        return gson.fromJson(contaObject, contaType);
    }

    /**
     * Obtem o nome do atributo usado para diferenciar contas
     * 
     * @return nome do atributo
     */
    public String getContaTypeElementName() {
        return contaTypeElementName;
    }

    /**
     * Obtem a instancia Gson usada para manipular arquivos Json
     * 
     * @return instancia Gson
     */
    public Gson getGson() {
        return gson;
    }

    /**
     * Obtem um dicionário com os possíveis tipos de Conta
     * 
     * @return Dicionário com os possíveis tipos de Conta
     */
    public Map<String, Class<? extends Conta>> getContaTypeRegistry() {
        return contaTypeRegistry;
    }
    
    /**
     * Método que sobrescreve o toString para exibir informações sobre o Deserializer
     * @return Informações sobre o Deserializer
     */
    @Override 
    public String toString(){
        return "Classe que serve para deserializar objetos da classe Conta de maneira polimorfica no formato json";
    }
}
