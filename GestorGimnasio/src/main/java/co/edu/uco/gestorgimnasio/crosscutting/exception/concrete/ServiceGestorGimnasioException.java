package co.edu.uco.gestorgimnasio.crosscutting.exception.concrete;

import co.edu.uco.gestorgimnasio.crosscutting.exception.GestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.exception.enumerator.LugarException;

public class ServiceGestorGimnasioException extends GestorGimnasioException{

	private static final long serialVersionUID = -9177484194126685659L;

	protected ServiceGestorGimnasioException(Throwable excepcionRaiz, String mensajeUsuario,
			String mensajeTecnico) {
		super(LugarException.SERVICE, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

	public static final GestorGimnasioException crear(final String mensajeUsuario) {
		return new ServiceGestorGimnasioException(null,mensajeUsuario,mensajeUsuario);
	}

	public static final GestorGimnasioException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new ServiceGestorGimnasioException(null,mensajeUsuario,mensajeTecnico);
	}

	public static final GestorGimnasioException crear(final Throwable exepcionRaiz ,final String mensajeUsuario,final String mensajeTecnico) {
		return new ServiceGestorGimnasioException(exepcionRaiz,mensajeUsuario,mensajeTecnico);
	}



}
