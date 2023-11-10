package co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.support;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.entity.support.NombreCompletoEntrenadorEntity;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.NombreCompletoDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.EntityMapper;

public final class NombreCompletoEntityMapper implements EntityMapper<NombreCompletoEntrenadorEntity, NombreCompletoDomain>{
	private static final EntityMapper<NombreCompletoEntrenadorEntity, NombreCompletoDomain> instancia = new NombreCompletoEntityMapper();

	private NombreCompletoEntityMapper() {
		super();
	}

	@Override
	public final NombreCompletoDomain toDomain(final NombreCompletoEntrenadorEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NombreCompletoDomain.crear(entity.getPrimerNombre(),entity.getSegundoNombre(),entity.getPrimerApellido(),entity.getSegundoApellido());
	}

	@Override
	public final NombreCompletoEntrenadorEntity toEntity(final NombreCompletoDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NombreCompletoEntrenadorEntity.crear(domain.getPrimerNombre(),domain.getSegundoNombre(),domain.getPrimerApellido(),domain.getSegundoApellido());

	}

	public static final NombreCompletoDomain convertToDomain(final NombreCompletoEntrenadorEntity entity) {
		return instancia.toDomain(entity);
	}

	public static final NombreCompletoEntrenadorEntity convertToEntity(final NombreCompletoDomain domain) {
		return instancia.toEntity(domain);
	}
}
