package co.edu.uco.gestorgimnasio.service.domain.ejercicio.rules;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;



public class DescripcionEjercicioValidationRule implements ValidatorRule<String>{

	private static final ValidatorRule<String> instancia = new DescripcionEjercicioValidationRule();

	  private DescripcionEjercicioValidationRule() {
		  super();
	  }

	public static void ejecutarValidacion(String dato) {
		instancia.validar(dato);
	}


	@Override
	public void validar(String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
	}

	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMaximaValida(dato, 200)) {
			var mensajeUsuario="La longitud de la descripcion del ejercicio no es valida. la longitud maxim son 200 caracteres";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
	}

	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario="El nombre del ejercicio es un dato que es obligatorio";
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
