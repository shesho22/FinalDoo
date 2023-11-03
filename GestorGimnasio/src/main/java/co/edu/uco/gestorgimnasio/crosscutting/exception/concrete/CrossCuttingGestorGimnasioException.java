package co.edu.uco.gestorgimnasio.crosscutting.exception.concrete;

import co.edu.uco.gestorgimnasio.crosscutting.exception.GestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.exception.enumerator.LugarException;

public final class CrossCuttingGestorGimnasioException extends GestorGimnasioException{

	private static final long serialVersionUID = -9177484194126685659L;
	
	protected CrossCuttingGestorGimnasioException(Throwable excepcionRaiz, String mensajeUsuario,
			String mensajeTecnico) {
		super(LugarException.CROSSCUTING, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

	public static final GestorGimnasioException crear(final String mensajeUsuario) {
		return new CrossCuttingGestorGimnasioException(null,mensajeUsuario,mensajeUsuario);
	}
	
	public static final GestorGimnasioException crear(final String mensajeUsuario,final String mensajeTecnico) {
		return new CrossCuttingGestorGimnasioException(null,mensajeUsuario,mensajeTecnico);
	}
	
	public static final GestorGimnasioException crear(final Throwable exepcionRaiz ,final String mensajeUsuario,final String mensajeTecnico) {
		return new CrossCuttingGestorGimnasioException(exepcionRaiz,mensajeUsuario,mensajeTecnico);
	}
}
