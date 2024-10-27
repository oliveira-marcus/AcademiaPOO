/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author caio
 */
public class ContaDeserializer implements JsonDeserializer<Conta>{
    private final String contaTypeElementName;
    private final Gson gson;
    private final Map<String, Class<? extends Conta>> contaTypeRegistry;
    
    public ContaDeserializer(String ContaTypeElementName) {
        this.contaTypeElementName = ContaTypeElementName;
        this.gson = new Gson();
        this.contaTypeRegistry = new HashMap<>();
    }
    
    public void registerContaType(String contaTypeName, Class<? extends Conta> contaType) {
        contaTypeRegistry.put(contaTypeName, contaType);
    }
    
    @Override
    public Conta deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context){
        JsonObject contaObject = json.getAsJsonObject();
        JsonElement contaTypeElement = contaObject.get(contaTypeElementName);

        Class<? extends Conta> contaType = contaTypeRegistry.get(contaTypeElement.getAsString());
        return gson.fromJson(contaObject, contaType);
    }
}
