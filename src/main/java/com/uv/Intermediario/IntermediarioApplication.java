package com.uv.Intermediario;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.uv.BuscarRegistroResponse;
import mx.uv.MostrarRegistrosResponse;


//Anotación para permitir solicitudes de cualquier origen (CORS)
@CrossOrigin(origins = "*", maxAge = 3600)

//Clase RestController que define los recursos que el servicio va a ofrecer
@RestController
@SpringBootApplication
public class IntermediarioApplication {
	@Autowired
	private RegistroCliente registroCliente;

	public static void main(String[] args) {
		SpringApplication.run(IntermediarioApplication.class, args);
	}

	/*Recurso que recupera los datos de todos los registros
	*/
	@RequestMapping(value = "/registros", method = RequestMethod.GET)
	public String getRegistros() {
		JSONObject respuesta = new JSONObject();
		List<JSONObject> data = new ArrayList<>();
		try {
			MostrarRegistrosResponse registros = registroCliente.leerTodos();
			// respuesta.put("status", camiones.getStatus());
			for (MostrarRegistrosResponse.Registro lista : registros.getRegistro()) {
				JSONObject a = new JSONObject();
				a.put("id", lista.getId());
				a.put("aula", lista.getAula());
				a.put("nombre", lista.getNombre());
				a.put("fecha", lista.getFecha());
				a.put("hora", lista.getHora());
				data.add(a);
			}
			respuesta.put("data", data);
			// return respuesta.toString();
		} catch (Exception e) {
			// respuesta.put("status", "Failed");
		}
		return respuesta.toString();
	}
	
	/*Recurso que recupera los registros del aula
	*/
	@RequestMapping(value = "/registros/{aula}", method = RequestMethod.GET)
	public String getRegistrosAulas(@PathVariable String aula) {
		JSONObject respuesta = new JSONObject();
		List<JSONObject> data = new ArrayList<>();
		try {
			BuscarRegistroResponse registrosAula = registroCliente.leerAula(aula);
			// respuesta.put("status", sr.getStatus());
			for(BuscarRegistroResponse.Registro lista : registrosAula.getRegistro()) {
				JSONObject a = new JSONObject();
				a.put("id", lista.getId());
				a.put("aula", lista.getAula());
				a.put("nombre", lista.getNombre());
				a.put("fecha", lista.getFecha());
				a.put("hora", lista.getHora());
				data.add(a);
			}
			respuesta.put("data", data);
		} catch (Exception e) {
			// respuesta.put("status", "Failed");
		}
		return respuesta.toString();
	}
	
	/*Recurso que registra los datos de un registro
	*/
	@RequestMapping(value = "/registros", method = RequestMethod.POST)
	public String addRegistro(@RequestBody Registro registro) {
		JSONObject respuesta = new JSONObject();
		try {
			registroCliente.agregar(registro);
			// respuesta.put("status", "Success");
		} catch (Exception e) {
			// respuesta.put("status", "Failed");
		}
		return respuesta.toString();
	}

	/*Recurso que elimina los datos de un registro
	*/
	// @RequestMapping(value = "/registros/{id}", method = RequestMethod.DELETE)
	// public String deleteRegistro(@PathVariable Integer id) {
	// 	JSONObject respuesta = new JSONObject();
	// 	try {
	// 		MostrarRegistrosResponse sr = registroCliente.leerTodos();
	// 		if (sr.getRegistro().equals( != null)) {
	// 			camionesCliente.eliminar(id);

	// 		}
	// 		respuesta.put("status", "Success");
	// 	} catch (Exception e) {
	// 		respuesta.put("status", "Failed");
	// 	}
	// 	return respuesta.toString();
	// }
}