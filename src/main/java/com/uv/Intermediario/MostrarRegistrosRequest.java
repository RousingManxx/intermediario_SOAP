package com.uv.Intermediario;

import javax.xml.bind.annotation.XmlRootElement;

//Clase vacia necesaria para hacer la petición de todos los camiones. Generada manualmente ya que al ser una request nula las dependencias no la generan automáticamente.
@XmlRootElement(name="MostrarRegistrosRequest")
public class MostrarRegistrosRequest {

    @Override
    public String toString(){
        return "MostrarRegistrosRequest []";
    }
}
