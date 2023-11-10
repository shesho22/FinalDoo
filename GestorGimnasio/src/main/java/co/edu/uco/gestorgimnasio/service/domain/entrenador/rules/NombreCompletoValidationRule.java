package co.edu.uco.gestorgimnasio.service.domain.entrenador.rules;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.NombreCompletoDomain;

public class NombreCompletoValidationRule implements ValidatorRule<NombreCompletoDomain> {

    private static final ValidatorRule<NombreCompletoDomain> instancia = new NombreCompletoValidationRule();

    private NombreCompletoValidationRule() {
        super();
    }

    public static void ejecutarValidacion(NombreCompletoDomain nombreCompleto) {
        instancia.validar(nombreCompleto);
    }

    @Override
    public void validar(NombreCompletoDomain dato) {
    	if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "No es posible llevar a cabo la operacion deseada con el Nombre completo, debido a que no existe datos para llevar a cabo...";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
    }

}


