package co.edu.uco.gestorgimnasio.service.domain.ejercicio.rules;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;

public class RepeticionesEjercicioValidationRule implements ValidatorRule<String>{

	private static final ValidatorRule<String> instancia = new RepeticionesEjercicioValidationRule();

	  private RepeticionesEjercicioValidationRule() {
		  super();
	  }

	public static void ejecutarValidacion(String dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(String dato) {
		validarObligatoriedad(dato);
		validarFormato(dato);
	}

	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario="Las repeticiones del ejercicios es un dato que es obligatorio";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
	}

	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloNumeros(dato)) {
			var mensajeUsuario="El numero de repeticiones solo puede contener numeros";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
	}


}
