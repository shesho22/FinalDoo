package co.edu.uco.gestorgimnasio.data.entity.support;

public class NumeroTelefonoMovilEntrenadorEntity {
	private String numeroTelefonoMovil;
	private boolean numeroTelefonoMovilConfirmado;
	
	
	private NumeroTelefonoMovilEntrenadorEntity(final String numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setNumeroTelefonoMovilConfirmado(numeroTelefonoMovilConfirmado);
	}


	public static final NumeroTelefonoMovilEntrenadorEntity crear(final String numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		return new NumeroTelefonoMovilEntrenadorEntity(numeroTelefonoMovil, numeroTelefonoMovilConfirmado);
	}
	
	private final void setNumeroTelefonoMovil(final String numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}
	private final void setNumeroTelefonoMovilConfirmado(final boolean numeroTelefonoMovilConfirmado) {
		this.numeroTelefonoMovilConfirmado = numeroTelefonoMovilConfirmado;
	}




	public final String getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final boolean isNumeroTelefonoMovilConfirmado() {
		return numeroTelefonoMovilConfirmado;
	}

	public static NumeroTelefonoMovilEntrenadorEntity fromString(String string) {
	    if (string == null || string.isEmpty()) {
	        // Manejo de casos nulos o cadenas vacías
	        return null;
	    } else {
	        // Lógica para convertir la cadena en un objeto NumeroTelefonoMovilClienteEntity
	        // Supongamos que la cadena es una representación válida de NumeroTelefonoMovilClienteEntity con los valores separados por comas
	        String[] partes = string.split(",");
	        if (partes.length == 2) {
	            String numeroTelefonoMovil = partes[0];
	            boolean numeroTelefonoMovilConfirmado = Boolean.parseBoolean(partes[1]);

	            return new NumeroTelefonoMovilEntrenadorEntity(numeroTelefonoMovil, numeroTelefonoMovilConfirmado);
	        } else {
	            // En caso de que la cadena no coincida con el formato esperado
	            throw new IllegalArgumentException("Cadena no válida para NumeroTelefonoMovilClienteEntity: " + string);
	        }
	    }
	}

	
}
