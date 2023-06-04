package com.uv.Intermediario;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import mx.uv.AddRegistroRequest;
import mx.uv.AddRegistroResponse;
import mx.uv.BuscarRegistroRequest;
import mx.uv.BuscarRegistroResponse;
import mx.uv.EliminarRegistroRequest;
import mx.uv.EliminarRegistroResponse;
import mx.uv.MostrarRegistrosResponse;

public class RegistroCliente extends WebServiceGatewaySupport{
    //Definición de la url del servicio a consumir (REGISTROS SOAP)
    private final String API_URL = "https://soapregistro-production.up.railway.app/ws/";

    /*Método para recibir una respuesta del servidor SOAP Solicitar todos los registros*/
    public MostrarRegistrosResponse leerTodos(){
        JAXBElement<MostrarRegistrosRequest> requestElement = new JAXBElement<>(new QName("https://registro.uv.mx/registro", "MostrarRegistrosRequest"), MostrarRegistrosRequest.class,null);
        return (MostrarRegistrosResponse) getWebServiceTemplate().marshalSendAndReceive(API_URL, requestElement);
    }

    /*Método para recibir una respuesta del servidor SOAP al solicitar un registro por aula  */
    public BuscarRegistroResponse leerAula(String aula){
        BuscarRegistroRequest req = new BuscarRegistroRequest();
        req.setAula(aula);
        return (BuscarRegistroResponse) getWebServiceTemplate().marshalSendAndReceive(API_URL, req);
    }
    
    /*Método para recibir una respuesta del servidor SOAP al agregar un registro
    */
    public AddRegistroResponse agregar(Registro registro){
        AddRegistroRequest agregarRequest = new AddRegistroRequest();
        agregarRequest.setAula(registro.getAula());
        agregarRequest.setNombre(registro.getNombre());
        agregarRequest.setFecha(registro.getFecha());
        agregarRequest.setHora(registro.getHora());
        
        return (AddRegistroResponse) getWebServiceTemplate().marshalSendAndReceive(API_URL, agregarRequest);
    }
    
    // Eliminar un registro por id
    public EliminarRegistroResponse eliminar(Integer id){
        EliminarRegistroRequest eliminarRequest = new EliminarRegistroRequest();
        eliminarRequest.setId(id);

        return (EliminarRegistroResponse) getWebServiceTemplate().marshalSendAndReceive(API_URL, eliminarRequest);
    }
}