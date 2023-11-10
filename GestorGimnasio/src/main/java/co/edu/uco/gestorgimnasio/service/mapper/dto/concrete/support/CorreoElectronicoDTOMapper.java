package co.edu.uco.gestorgimnasio.service.mapper.dto.concrete.support;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.CorreoElectronicoDomain;
import co.edu.uco.gestorgimnasio.service.dto.support.CorreoElectronicoDTO;
import co.edu.uco.gestorgimnasio.service.mapper.dto.DTOMapper;

public class CorreoElectronicoDTOMapper implements DTOMapper<CorreoElectronicoDTO, CorreoElectronicoDomain>{
	private static final DTOMapper<CorreoElectronicoDTO, CorreoElectronicoDomain> instancia = new CorreoElectronicoDTOMapper();

	private CorreoElectronicoDTOMapper() {
		super();
	}

	@Override
	public final CorreoElectronicoDomain toDomain(final CorreoElectronicoDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return CorreoElectronicoDomain.crear(dto.getCorreoElectronico(),dto.isCorreoElectronicoConfirmado());
	}

	@Override
	public final CorreoElectronicoDTO toDTO(CorreoElectronicoDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return CorreoElectronicoDTO.crear(domain.getCorreoElectronico(),domain.isCorreoElectronicoConfirmado());

	}

	public static final CorreoElectronicoDomain convertToDomain(final CorreoElectronicoDTO entity) {
		return instancia.toDomain(entity);
	}

	public static final CorreoElectronicoDTO convertToDTO(final CorreoElectronicoDomain domain) {
		return instancia.toDTO(domain);
	}

}
