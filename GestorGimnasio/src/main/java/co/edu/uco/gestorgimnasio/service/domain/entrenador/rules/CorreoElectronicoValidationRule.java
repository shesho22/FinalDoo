package co.edu.uco.gestorgimnasio.service.domain.entrenador.rules;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.CorreoElectronicoClienteDomain;

public class CorreoElectronicoValidationRule implements ValidatorRule<CorreoElectronicoClienteDomain>{

	   private static final ValidatorRule<CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoValidationRule();

	    private CorreoElectronicoValidationRule() {
	        super();
	    }

	    public static void ejecutarValidacion(CorreoElectronicoClienteDomain nombreCompleto) {
	        instancia.validar(nombreCompleto);
	    }

	    @Override
	    public void validar(CorreoElectronicoClienteDomain dato) {
	    	if(UtilObjeto.esNulo(dato)) {
				var mensajeUsuario = "No es posible llevar a cabo la operacion deseada con el Correo electornico, debido a que no existe datos para llevar a cabo...";
				throw ServiceGestorGimnasioException.crear(mensajeUsuario);
			}
	    }
}
