package co.edu.uco.gestorgimnasio.crosscutting.exception.concrete;

import co.edu.uco.gestorgimnasio.crosscutting.exception.GestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.exception.enumerator.LugarException;

public final class ControllerGestorGimnasioException extends GestorGimnasioException{

	private static final long serialVersionUID = -9177484194126685659L;

	protected ControllerGestorGimnasioException(Throwable excepcionRaiz, String mensajeUsuario,
			String mensajeTecnico) {
		super(LugarException.CONTROLLER, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

	public static final GestorGimnasioException crear(final String mensajeUsuario) {
		return new ControllerGestorGimnasioException(null,mensajeUsuario,mensajeUsuario);
	}

	public static final GestorGimnasioException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new ControllerGestorGimnasioException(null,mensajeUsuario,mensajeTecnico);
	}

	public static final GestorGimnasioException crear(final Throwable exepcionRaiz ,final String mensajeUsuario,final String mensajeTecnico) {
		return new ControllerGestorGimnasioException(exepcionRaiz,mensajeUsuario,mensajeTecnico);
	}
}
