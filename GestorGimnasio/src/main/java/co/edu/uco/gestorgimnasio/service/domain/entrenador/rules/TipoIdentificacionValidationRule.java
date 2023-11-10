package co.edu.uco.gestorgimnasio.service.domain.entrenador.rules;


import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public final class TipoIdentificacionValidationRule implements ValidatorRule<TipoIdentificacionDomain>{

	private static final ValidatorRule<TipoIdentificacionDomain> instancia = new TipoIdentificacionValidationRule();

	private TipoIdentificacionValidationRule() {
		super();
	}

	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final TipoIdentificacionDomain dato) {
		validarObligatoriedad(dato);
		validarFormato(dato);
	}

	private void validarFormato(TipoIdentificacionDomain dato) {
		// TODO Auto-generated method stub

	}

	private void validarObligatoriedad(final TipoIdentificacionDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "El id del tipo de identificacion es obligatorio...";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
	}

}
