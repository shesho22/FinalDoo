package co.edu.uco.gestorgimnasio.service.mapper.dto.concrete.support;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.NumeroTelefonoMovilDomain;
import co.edu.uco.gestorgimnasio.service.dto.support.NumeroTelefonoMovilDTO;
import co.edu.uco.gestorgimnasio.service.mapper.dto.DTOMapper;

public class NumeroTelefonoMovilDTOMapper implements DTOMapper<NumeroTelefonoMovilDTO, NumeroTelefonoMovilDomain>{
	private static final DTOMapper<NumeroTelefonoMovilDTO, NumeroTelefonoMovilDomain> instancia = new NumeroTelefonoMovilDTOMapper();

	private NumeroTelefonoMovilDTOMapper() {
		super();
	}

	@Override
	public final NumeroTelefonoMovilDomain toDomain(final NumeroTelefonoMovilDTO entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NumeroTelefonoMovilDomain.crear(entity.getNumeroTelefonoMovil(),entity.isNumeroTelefonoMovilConfirmado());
	}

	@Override
	public final NumeroTelefonoMovilDTO toDTO(final NumeroTelefonoMovilDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NumeroTelefonoMovilDTO.crear(domain.getNumeroTelefonoMovil(),domain.isNumeroTelefonoMovilConfirmado());

	}

	public static final NumeroTelefonoMovilDomain convertToDomain(final NumeroTelefonoMovilDTO entity) {
		return instancia.toDomain(entity);
	}

	public static final NumeroTelefonoMovilDTO convertToDTO(final NumeroTelefonoMovilDomain domain) {
		return instancia.toDTO(domain);
	}

}
