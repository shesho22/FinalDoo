package co.edu.uco.gestorgimnasio.service.domain.rutina.rules;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;

public class NombreRutinaValidationRule implements ValidatorRule<String>{

	private static final ValidatorRule<String> instancia = new NombreRutinaValidationRule();

	  private NombreRutinaValidationRule() {
		  super();
	  }

	  public static final void ejecutarValidacion(final String dato) {
		  instancia.validar(dato);
	  }

	@Override
	public void validar(String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
	}

	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMaximaValida(dato, 50)) {
			var mensajeUsuario="La longitud del nombre de la rutina no es valida. la longitud maxim son 50 caracteres";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
	}

	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario="El nombre de la rutina es un dato que es obligatorio";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
	}

	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosEspacios(dato)) {
			var mensajeUsuario="El nombre de la rutina solo pude contener letras y numeros";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
	}

}
