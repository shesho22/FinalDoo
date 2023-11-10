package co.edu.uco.gestorgimnasio.crosscutting.exception.concrete;

import co.edu.uco.gestorgimnasio.crosscutting.exception.GestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.exception.enumerator.LugarException;

public final class DataGestorGimnasioException extends GestorGimnasioException{

	private static final long serialVersionUID = -9177484194126685659L;

	protected DataGestorGimnasioException(Throwable excepcionRaiz, String mensajeUsuario,
			String mensajeTecnico) {
		super(LugarException.DATA, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

	public static final GestorGimnasioException crear(final String mensajeUsuario) {
		return new DataGestorGimnasioException(null,mensajeUsuario,mensajeUsuario);
	}

	public static final GestorGimnasioException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new DataGestorGimnasioException(null,mensajeUsuario,mensajeTecnico);
	}

	public static final GestorGimnasioException crear(final Throwable exepcionRaiz ,final String mensajeUsuario,final String mensajeTecnico) {
		return new DataGestorGimnasioException(exepcionRaiz,mensajeUsuario,mensajeTecnico);
	}

}
