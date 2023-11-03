package co.edu.uco.gestorgimnasio.service.domain.rutina.rules;


import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.EntrenadorDomain;

public final class EntrenadorRutinaValidationRule implements ValidatorRule<EntrenadorDomain> {

    private static final ValidatorRule<EntrenadorDomain> instancia = new EntrenadorRutinaValidationRule();

    private EntrenadorRutinaValidationRule() {
        super();
    }

    public static void ejecutarValidacion(EntrenadorDomain dato) {
        instancia.validar(dato);
    }

    @Override
    public void validar(EntrenadorDomain dato) {
        validarEntrenadorNoNulo(dato);
        validarCamposObligatorios(dato);
    }

    private void validarEntrenadorNoNulo(EntrenadorDomain dato) {
        if (UtilObjeto.esNulo(dato)) {
            throw ServiceGestorGimnasioException.crear("No es posible llevar a cabo la operación deseada con el Entrenador, debido a que no existen datos para llevar a cabo...");
        }
    }

    private void validarCamposObligatorios(EntrenadorDomain dato) {
        if (UtilObjeto.esNulo(dato)) {
            throw ServiceGestorGimnasioException.crear("No es posible llevar a cabo la operación deseada con el Entrenador, debido a que no existen datos para llevar a cabo...");
        }
        if (UtilObjeto.esNulo(dato.getId())) {
            throw ServiceGestorGimnasioException.crear("El campo 'id' del Entrenador no puede ser nulo.");
        }
        if (UtilObjeto.esNulo(dato.getTipoidentificacion())) {
            throw ServiceGestorGimnasioException.crear("El campo 'tipoidentificacion' del Entrenador no puede ser nulo.");
        }
        if (UtilObjeto.esNulo(dato.getIdentificacion())) {
            throw ServiceGestorGimnasioException.crear("El campo 'identificacion' del Entrenador no puede ser nulo.");
        }
        if (UtilObjeto.esNulo(dato.getNombreCompleto())) {
            throw ServiceGestorGimnasioException.crear("El campo 'nombreCompleto' del Entrenador no puede ser nulo.");
        }
        if (UtilObjeto.esNulo(dato.getCorreoElectornico())) {
            throw ServiceGestorGimnasioException.crear("El campo 'correoElectronico' del Entrenador no puede ser nulo.");
        }
        if (UtilObjeto.esNulo(dato.getNumeroTelefonoMovil())) {
            throw ServiceGestorGimnasioException.crear("El campo 'numeroTelefonoMovil' del Entrenador no puede ser nulo.");
        }
        if (UtilObjeto.esNulo(dato.getFechaNacimiento())) {
            throw ServiceGestorGimnasioException.crear("El campo 'fechaNacimiento' del Entrenador no puede ser nulo.");
        }
    }
}
