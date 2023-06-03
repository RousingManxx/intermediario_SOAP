package com.uv.Intermediario;

import org.json.JSONObject;

//Clase Camion que sirve de apoyo para guardar los datos de las entidades que se registrarán.
public class Registro{

        public Registro(){}
        public Registro(String nombre, String fecha, String hora, String aula) {
            this.nombre = nombre;
            this.fecha = fecha;
            this.hora = hora;
            this.aula = aula;
        }
        
        private Integer id;
    
        public Integer getId() {
            return id;
        }
    
        public void setId(Integer id) {
            this.id = id;
        }
    
        private String nombre;
    
        public String getNombre() {
            return nombre;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        private String fecha;
    
        public String getFecha() {
            return fecha;
        }
    
        public void setFecha(String fecha) {
            this.fecha = fecha;
        }
    
        private String hora;
        
        public String getHora() {
            return hora;
        }
    
        public void setHora(String hora) {
            this.hora = hora;
        }
    
        private String aula;
    
        public String getAula() {
            return aula;
        }
    
        public void setAula(String aula) {
            this.aula = aula;
        }
    

    public String toString(){
        JSONObject respuesta = new JSONObject();
        respuesta.put("id", this.getId());
        respuesta.put("aula", this.getAula());
        respuesta.put("nombre", this.getNombre());
        respuesta.put("fecha", this.getFecha());
        respuesta.put("hora", this.getHora());
        return respuesta.toString();
    }
}