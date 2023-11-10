package co.edu.uco.gestorgimnasio.crosscutting.util;

import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.CrossCuttingGestorGimnasioException;

public class UtilUUID {

	private static final String DEFAULT_UUID_STRING = "00000000-0000-0000-0000-000000000000";
	private static final UUID DEFAULT_UUID = UUID.fromString(DEFAULT_UUID_STRING);

	private UtilUUID() {
		super();
	}

	public static final UUID getDefaultUUID(final UUID uuid) {
		return UtilObjeto.obtenerValorDefecto(uuid, DEFAULT_UUID);
	}

	public static  final boolean isEqual(final UUID uuidOne, final UUID uuidTwo) {
		return getDefaultUUID(uuidOne).equals(getDefaultUUID(uuidTwo));
	}

	public static final UUID getNewUUID() {
		UUID uuid;
		do {
			uuid = UUID.randomUUID();
		}while(isEqual(uuid, DEFAULT_UUID));
		return uuid;
	}

	public static final UUID getUUIDFromString(final String uuidString) {
		UUID uuid = DEFAULT_UUID;
		if(UtilTexto.estaVacio(uuidString)){
			var mensajeUsuario = "";
			var mensajeTecnico = "";
			throw CrossCuttingGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			uuid = UUID.fromString(uuidString);
		}catch (final IllegalArgumentException exception) {
			var mensajeUsuario = "";
			var mensajeTecnico = "";
			throw CrossCuttingGestorGimnasioException.crear(exception,mensajeUsuario,mensajeTecnico);

		}catch (Exception exception) {
			var mensajeUsuario = "";
			var mensajeTecnico = "";
			throw CrossCuttingGestorGimnasioException.crear(exception,mensajeUsuario,mensajeTecnico);
		}
		return uuid;
	}

	public static final String getStringFormUUID(final UUID uuid) {
		String uuidString = DEFAULT_UUID_STRING;
		if(!UtilObjeto.esNulo(uuid)) {
			uuidString=uuidString.toString();
		}
		return uuidString;
	}

	public static final boolean esUuidPorDefecto(final UUID uuid) {
		return isEqual(uuid, DEFAULT_UUID);
	}
}
