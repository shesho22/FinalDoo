package co.edu.uco.gestorgimnasio.data.entity.support;

public class CorreoElectronicoEntrenadorEntity {
	private String correoElectronico;
	private boolean correoElectronicoConfirmado;


	private CorreoElectronicoEntrenadorEntity(final String correoElectronico,final boolean correoElectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
	}

	public static final CorreoElectronicoEntrenadorEntity crear (final String correoElectronico,final boolean correoElectronicoConfirmado) {
		return new CorreoElectronicoEntrenadorEntity(correoElectronico, correoElectronicoConfirmado);
	}


	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}



	private final void setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}



	public final String getCorreoElectronico() {
		return correoElectronico;
	}
	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}

	public static CorreoElectronicoEntrenadorEntity fromString(String string) {
	    if (string == null || string.isEmpty()) {
	        // Manejo de casos nulos o cadenas vacías
	        return null;
	    } else {
	        // Lógica para convertir la cadena en un objeto CorreoElectronicoClienteEntity
	        // Supongamos que la cadena es una representación válida de CorreoElectronicoClienteEntity con los valores separados por comas
	        String[] partes = string.split(",");
	        if (partes.length == 2) {
	            String correoElectronico = partes[0];
	            boolean correoElectronicoConfirmado = Boolean.parseBoolean(partes[1]);

	            return new CorreoElectronicoEntrenadorEntity(correoElectronico, correoElectronicoConfirmado);
	        } else {
	            // En caso de que la cadena no coincida con el formato esperado
	            throw new IllegalArgumentException("Cadena no válida para CorreoElectronicoClienteEntity: " + string);
	        }
	    }
	}



}
