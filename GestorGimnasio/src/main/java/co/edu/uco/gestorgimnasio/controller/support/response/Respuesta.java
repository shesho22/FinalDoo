package co.edu.uco.gestorgimnasio.controller.support.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;

public final class Respuesta<T> {
	private List<T> datos;
	private List<String> mensajes;
	
	public Respuesta() {
		super();
		setDatos(new ArrayList<>());
		setMensaje(new ArrayList<>());
	}
	
	public Respuesta(final List<T> dato, final List<String> mensaje) {
		super();
		setDatos(dato);
		setMensaje(mensaje);
	}
	
	public final List<T> getDatos() {
		return datos;
	}
	private final void setDatos(List<T> datos) {
		this.datos = UtilObjeto.obtenerValorDefecto(datos, new ArrayList<>());
	}
	public final List<String> getMensajes() {
		return mensajes;
	}
	private final void setMensaje(List<String> mensaje) {
		this.mensajes = UtilObjeto.obtenerValorDefecto(mensaje, new ArrayList<>());
	} 
}
