package co.edu.uco.gestorgimnasio.service.domain.rutina.rules;

import java.util.List;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.EjercicioDomain;

public final class ListaEjerciciosValidationRule implements ValidatorRule<List<EjercicioDomain>> {

    private static final ValidatorRule<List<EjercicioDomain>> instancia = new ListaEjerciciosValidationRule();

    private ListaEjerciciosValidationRule() {
        super();
    }

    public static void ejecutarValidacion(List<EjercicioDomain> dato) {
        instancia.validar(dato);
    }

    @Override
    public void validar(List<EjercicioDomain> dato) {
        validarListaNoNula(dato);
        validarEjerciciosNoNulos(dato);
        validarCamposObligatorios(dato);

    }

    private void validarListaNoNula(List<EjercicioDomain> dato) {
        if (UtilObjeto.esNulo(dato)) {
            throw ServiceGestorGimnasioException.crear("La lista de ejercicios no puede estar vacía.");
        }
    }

    private void validarEjerciciosNoNulos(List<EjercicioDomain> dato) {
        for (EjercicioDomain ejercicio : dato) {
            if (UtilObjeto.esNulo(ejercicio)) {
                throw ServiceGestorGimnasioException.crear("La lista no puede contener ejercicios nulos.");
            }
        }
    }

    private void validarCamposObligatorios(List<EjercicioDomain> dato) {
        for (EjercicioDomain ejercicio : dato) {
            if (UtilObjeto.esNulo(ejercicio.getNombre())) {
                throw ServiceGestorGimnasioException.crear("El campo 'nombre' del ejercicio no puede ser nulo.");
            }
            if (UtilObjeto.esNulo(ejercicio.getDescripcion())) {
                throw ServiceGestorGimnasioException.crear("El campo 'descripcion' del ejercicio no puede ser nulo.");
            }
            if (UtilObjeto.esNulo(ejercicio.getSeries())) {
                throw ServiceGestorGimnasioException.crear("El campo 'series' del ejercicio no puede ser nulo.");
            }
            if (UtilObjeto.esNulo(ejercicio.getRepeticiones())) {
                throw ServiceGestorGimnasioException.crear("El campo 'repeticiones' del ejercicio no puede ser nulo.");
            }
        }
    }
}


