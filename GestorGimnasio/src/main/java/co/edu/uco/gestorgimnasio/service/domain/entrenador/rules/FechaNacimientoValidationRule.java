package co.edu.uco.gestorgimnasio.service.domain.entrenador.rules;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.service.domain.ValidatorRule;


public class FechaNacimientoValidationRule implements ValidatorRule<LocalDate> {

    private static final ValidatorRule<LocalDate> instancia = new FechaNacimientoValidationRule();

    private FechaNacimientoValidationRule() {
        super();
    }

    public static void ejecutarValidacion(LocalDate fechaNacimiento) {
        instancia.validar(fechaNacimiento);
    }

    @Override
    public void validar(LocalDate fechaNacimiento) {
        validarObligatoriedad(fechaNacimiento);
        validarFormato(fechaNacimiento);
        validarRango(fechaNacimiento);
    }

    private void validarObligatoriedad(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            var mensajeUsuario = "La fecha de nacimiento es un dato obligatorio.";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
        }
    }

    private void validarFormato(LocalDate fechaNacimiento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            fechaNacimiento.format(formatter); // Intentar formatear la fecha
        } catch (DateTimeParseException e) {
            var mensajeUsuario = "El formato de la fecha de nacimiento no es válido. Debe estar en el formato 'año-mes-día' (por ejemplo, '1990-12-31').";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
        }
    }

    private void validarRango(LocalDate fechaNacimiento) {
        LocalDate fechaMinima = LocalDate.of(1900, 1, 1); // Cambia la fecha mínima según tus requisitos
        LocalDate fechaMaxima = LocalDate.now();

        if (fechaNacimiento.isBefore(fechaMinima) || fechaNacimiento.isAfter(fechaMaxima)) {
            var mensajeUsuario = "La fecha de nacimiento debe estar en un rango válido (desde 1900 hasta la fecha actual).";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
        }
    }
}


