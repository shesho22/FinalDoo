package co.edu.uco.gestorgimnasio.service.domain.entrenador.rules;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.CorreoElectronicoDomain;

public class CorreoElectronicoValidationRule implements ValidatorRule<CorreoElectronicoDomain>{

	   private static final ValidatorRule<CorreoElectronicoDomain> instancia = new CorreoElectronicoValidationRule();

	    private CorreoElectronicoValidationRule() {
	        super();
	    }

	    public static void ejecutarValidacion(CorreoElectronicoDomain nombreCompleto) {
	        instancia.validar(nombreCompleto);
	    }

	    @Override
	    public void validar(CorreoElectronicoDomain dato) {
	    	if(UtilObjeto.esNulo(dato)) {
				var mensajeUsuario = "No es posible llevar a cabo la operacion deseada con el Correo electornico, debido a que no existe datos para llevar a cabo...";
				throw ServiceGestorGimnasioException.crear(mensajeUsuario);
			}
	    }
}
