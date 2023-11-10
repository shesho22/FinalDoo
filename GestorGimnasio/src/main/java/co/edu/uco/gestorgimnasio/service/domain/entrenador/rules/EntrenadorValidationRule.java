package co.edu.uco.gestorgimnasio.service.domain.entrenador.rules;


import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.EntrenadorDomain;

public class EntrenadorValidationRule implements ValidatorRule<EntrenadorDomain>{

	private static final ValidatorRule<EntrenadorDomain> instancia = new EntrenadorValidationRule();

	private EntrenadorValidationRule() {
		super();
	}

	public static final void ejecutarValidacion(final EntrenadorDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final EntrenadorDomain dato) {
		validarObligatoriedad(dato);
	}

	private void validarObligatoriedad(final EntrenadorDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "El id del cliente es obligatorio...";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
	}

}
