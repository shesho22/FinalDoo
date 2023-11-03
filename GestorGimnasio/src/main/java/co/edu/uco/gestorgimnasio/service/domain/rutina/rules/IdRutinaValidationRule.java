package co.edu.uco.gestorgimnasio.service.domain.rutina.rules;


import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilUUID;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;


public class IdRutinaValidationRule implements ValidatorRule<UUID>{

	private static final ValidatorRule<UUID> instancia = new IdRutinaValidationRule();
	
	private IdRutinaValidationRule() {	
		super();
	}
	
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validar(dato);
	}
	
	@Override
	public final void validar(final UUID dato) {
		validarObligatoriedad(dato);
		validarIdPorDefecto(dato);
	}

	private void validarObligatoriedad(final UUID dato) {
		if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "El id del tipo de identificacion es obligatorio...";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
	}

	private void validarIdPorDefecto(UUID dato) {
		if(UtilUUID.esUuidPorDefecto(dato)) {
			var mensajeUsuario = "El id del tipo identificacion no puede ser igual al id por defecto...";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
	}
}
