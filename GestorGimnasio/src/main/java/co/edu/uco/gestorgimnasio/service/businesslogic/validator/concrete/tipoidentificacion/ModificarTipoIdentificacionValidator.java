package co.edu.uco.gestorgimnasio.service.businesslogic.validator.concrete.tipoidentificacion;

import co.edu.uco.gestorgimnasio.service.businesslogic.validator.Validator;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.rules.IdTipoIdentificacionValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.rules.NombreTipoIdentificacionValidationRule;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;

public class ModificarTipoIdentificacionValidator implements Validator<TipoIdentificacionDomain>{
	private static final Validator<TipoIdentificacionDomain> instancia = new ModificarTipoIdentificacionValidator();

	private ModificarTipoIdentificacionValidator() {
		super();
	}

	public static final void ejecutarValidacion(final TipoIdentificacionDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(TipoIdentificacionDomain dato) {
		TipoIdentificacionValidationRule.ejecutarValidacion(dato);
		IdTipoIdentificacionValidationRule.ejecutarValidacion(dato.getId());
		CodigoTipoIdentificacionValidationRule.ejecutarValidacion(dato.getCodigo());
		NombreTipoIdentificacionValidationRule.ejecutarValidacion(dato.getNombre());
	}

}
