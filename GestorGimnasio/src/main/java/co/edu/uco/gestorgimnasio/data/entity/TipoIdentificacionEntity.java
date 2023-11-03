package co.edu.uco.gestorgimnasio.data.entity;

import java.util.UUID;

public class TipoIdentificacionEntity {
	private UUID id;
	private String codigo;
	private String nombre;
	private boolean estado;
	
	
	private TipoIdentificacionEntity(final UUID id, final String codigo, final String nombre,final  boolean estado) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setEstado(estado);
	}


	
	public static final TipoIdentificacionEntity crear (final UUID id, final String codigo, final String nombre,final  boolean estado) {
		return new TipoIdentificacionEntity(id,codigo,nombre,estado);
	}
	
	public final UUID getId() {
		return id;
	}


	private final void setId(final UUID id) {
		this.id = id;
	}


	public final String getCodigo() {
		return codigo;
	}


	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}


	public final String getNombre() {
		return nombre;
	}


	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}


	public final boolean isEstado() {
		return estado;
	}


	private final void setEstado(final boolean estado) {
		this.estado = estado;
	}



	public static TipoIdentificacionEntity fromString(String string) {
	    if (string == null || string.isEmpty()) {
	        // Manejo de casos nulos o cadenas vacías
	        return null;
	    } else {
	        // Lógica para convertir la cadena en un objeto TipoIdentificacionEntity
	        // Supongamos que la cadena es una representación válida de TipoIdentificacionEntity con los valores separados por comas
	        String[] partes = string.split(",");
	        if (partes.length == 4) {
	            try {
	                UUID id = UUID.fromString(partes[0]);
	                String codigo = partes[1];
	                String nombre = partes[2];
	                boolean estado = Boolean.parseBoolean(partes[3]);

	                return new TipoIdentificacionEntity(id, codigo, nombre, estado);
	            } catch (IllegalArgumentException e) {
	                // Manejo de errores en la conversión
	                throw new IllegalArgumentException("Cadena no válida para TipoIdentificacionEntity: " + string, e);
	            }
	        } else {
	            // En caso de que la cadena no coincida con el formato esperado
	            throw new IllegalArgumentException("Cadena no válida para TipoIdentificacionEntity: " + string);
	        }
	    }
	}


}


