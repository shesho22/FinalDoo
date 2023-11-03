package co.edu.uco.gestorgimnasio.data.entity.support;

public final class NombreCompletoEntrenadorEntity {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	
	
	private NombreCompletoEntrenadorEntity(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
	}
	
	public static final NombreCompletoEntrenadorEntity crear(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoEntrenadorEntity(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}
	
	
	
	private final void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	private final void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	private final void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	private final void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	
	public final String getPrimerNombre() {
		return primerNombre;
	}
	public final String getSegundoNombre() {
		return segundoNombre;
	}
	public final String getPrimerApellido() {
		return primerApellido;
	}
	public final String getSegundoApellido() {
		return segundoApellido;
	}

	public static NombreCompletoEntrenadorEntity fromString(String string) {
	    if (string == null || string.isEmpty()) {
	        // Manejo de casos nulos o cadenas vacías
	        return null;
	    } else {
	        // Lógica para convertir la cadena en un objeto NombreCompletoClienteEntity
	        // Supongamos que la cadena es una representación válida de NombreCompletoClienteEntity con los valores separados por comas
	        String[] partes = string.split(",");
	        if (partes.length == 4) {
	            String primerNombre = partes[0];
	            String segundoNombre = partes[1];
	            String primerApellido = partes[2];
	            String segundoApellido = partes[3];

	            return new NombreCompletoEntrenadorEntity(primerNombre, segundoNombre, primerApellido, segundoApellido);
	        } else {
	            // En caso de que la cadena no coincida con el formato esperado
	            throw new IllegalArgumentException("Cadena no válida para NombreCompletoClienteEntity: " + string);
	        }
	    }
	}

	
	

}
