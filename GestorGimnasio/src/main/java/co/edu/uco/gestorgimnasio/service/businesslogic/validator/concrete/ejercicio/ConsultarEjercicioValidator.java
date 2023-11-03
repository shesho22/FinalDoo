package co.edu.uco.gestorgimnasio.service.businesslogic.validator.concrete.ejercicio;


import co.edu.uco.gestorgimnasio.service.businesslogic.validator.Validator;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.EjercicioDomain;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.rules.DescripcionEjercicioValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.rules.IdEjercicioValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.rules.NombreEjercicioValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.rules.RepeticionesEjercicioValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.rules.SeriesEjercicioValidationRule;


public final class ConsultarEjercicioValidator implements Validator<EjercicioDomain>{
    private static final Validator<EjercicioDomain> instancia = new ConsultarEjercicioValidator();

    private ConsultarEjercicioValidator() {
        super();
    }

    public static final void ejecutar(final EjercicioDomain data) {
        instancia.execute(data);
    }

    @Override
    public void execute(EjercicioDomain data) {
        IdEjercicioValidationRule.ejecutarValidacion(data.getId());
        NombreEjercicioValidationRule.ejecutarValidacion(data.getNombre());
        DescripcionEjercicioValidationRule.ejecutarValidacion(data.getDescripcion());
        SeriesEjercicioValidationRule.ejecutarValidacion(data.getSeries());
        RepeticionesEjercicioValidationRule.ejecutarValidacion(data.getRepeticiones());
    }
}
