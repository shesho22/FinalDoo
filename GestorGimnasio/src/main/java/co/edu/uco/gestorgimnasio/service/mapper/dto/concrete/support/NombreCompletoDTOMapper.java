package co.edu.uco.gestorgimnasio.service.mapper.dto.concrete.support;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.entity.support.NombreCompletoEntrenadorEntity;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.NombreCompletoDomain;
import co.edu.uco.gestorgimnasio.service.dto.support.NombreCompletoDTO;
import co.edu.uco.gestorgimnasio.service.mapper.dto.DTOMapper;
import co.edu.uco.gestorgimnasio.service.mapper.entity.EntityMapper;

public final class NombreCompletoDTOMapper implements DTOMapper<NombreCompletoDTO, NombreCompletoDomain>{
	private static final DTOMapper<NombreCompletoDTO, NombreCompletoDomain> instancia = new NombreCompletoDTOMapper();

	private NombreCompletoDTOMapper() {
		super();
	}

	@Override
	public final NombreCompletoDomain toDomain(final NombreCompletoDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NombreCompletoDomain.crear(dto.getPrimerNombre(),dto.getSegundoNombre(),dto.getPrimerApellido(),dto.getSegundoApellido());
	}

	@Override
	public final NombreCompletoDTO toDTO(final NombreCompletoDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NombreCompletoDTO.crear(domain.getPrimerNombre(),domain.getSegundoNombre(),domain.getPrimerApellido(),domain.getSegundoApellido());

	}

	public static final NombreCompletoDomain convertToDomain(final NombreCompletoDTO entity) {
		return instancia.toDomain(entity);
	}

	public static final NombreCompletoDTO convertToDTO(final NombreCompletoDomain domain) {
		return instancia.toDTO(domain);
	}
}
