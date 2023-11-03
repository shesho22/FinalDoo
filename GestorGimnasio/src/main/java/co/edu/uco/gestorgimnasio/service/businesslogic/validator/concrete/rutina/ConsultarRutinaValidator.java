package co.edu.uco.gestorgimnasio.service.businesslogic.validator.concrete.rutina;


import co.edu.uco.gestorgimnasio.service.businesslogic.validator.Validator;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.EntrenadorDomain;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.rules.CorreoElectronicoValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.rules.FechaNacimientoValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.rules.EntrenadorValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.rules.IdentificacionValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.rules.NombreCompletoValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.rules.NumeroTelefonoMovilValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.rutina.RutinaDomain;
import co.edu.uco.gestorgimnasio.service.domain.rutina.rules.ListaEjerciciosValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.rutina.rules.NombreRutinaValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.rutina.rules.IdRutinaValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;


public final class ConsultarRutinaValidator implements Validator<RutinaDomain>{


	private static final Validator<RutinaDomain> instancia = new ConsultarRutinaValidator();

    private ConsultarRutinaValidator() {
        super();
    }

    public static final void ejecutar(final RutinaDomain data) {
        instancia.execute(data);
    }

    @Override
    public void execute(RutinaDomain data) {
        IdRutinaValidationRule.ejecutarValidacion(data.getId());
        NombreRutinaValidationRule.ejecutarValidacion(data.getNombre());
        ListaEjerciciosValidationRule.ejecutarValidacion(data.getEjercicios());
    }

}
