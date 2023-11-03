package co.edu.uco.gestorgimnasio.service.domain.entrenador.rules;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.NumeroTelefonoMovilClienteDomain;

public class NumeroTelefonoMovilValidationRule implements ValidatorRule<NumeroTelefonoMovilClienteDomain>{

	   private static final ValidatorRule<NumeroTelefonoMovilClienteDomain> instancia = new NumeroTelefonoMovilValidationRule();

	    private NumeroTelefonoMovilValidationRule() {
	        super();
	    }

	    public static void ejecutarValidacion(NumeroTelefonoMovilClienteDomain nombreCompleto) {
	        instancia.validar(nombreCompleto);
	    }

	    @Override
	    public void validar(NumeroTelefonoMovilClienteDomain dato) {
	    	if(UtilObjeto.esNulo(dato)) {
				var mensajeUsuario = "No es posible llevar a cabo la operacion deseada con el numero telefono, debido a que no existe datos para llevar a cabo...";
				throw ServiceGestorGimnasioException.crear(mensajeUsuario);
			}
	    }
}
