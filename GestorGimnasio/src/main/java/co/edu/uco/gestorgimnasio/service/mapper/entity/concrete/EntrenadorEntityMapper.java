package co.edu.uco.gestorgimnasio.service.mapper.entity.concrete;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.entity.EntrenadorEntity;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.EntrenadorDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.EntityMapper;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.support.CorreoElectronicoClienteEntityMapper;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.support.NombreCompletoClienteEntityMapper;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.support.NumeroTelefonoMovilClienteEntityMapper;

public final class EntrenadorEntityMapper implements EntityMapper<EntrenadorEntity, EntrenadorDomain>{

	private static final EntityMapper<EntrenadorEntity, EntrenadorDomain> instancia = new EntrenadorEntityMapper();
	
	private EntrenadorEntityMapper() {
		super();
	}
	
	@Override
	public final EntrenadorDomain toDomain(final EntrenadorEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un cliente diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return EntrenadorDomain.crear(entity.getId(),TipoIdentificacionEntityMapper.convertToDomain(entity.getTipoidentificacion()),entity.getIdentificacion(),NombreCompletoClienteEntityMapper.convertToDomain(entity.getNombreCompleto()),CorreoElectronicoClienteEntityMapper.convertToDomain(entity.getCorreoElectornico()),NumeroTelefonoMovilClienteEntityMapper.convertToDomain(entity.getNumeroTelefonoMovil()),entity.getFechaNacimiento());
	}
	
	@Override
	public final EntrenadorEntity toEntity(final EntrenadorDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un cliente diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return EntrenadorEntity.crear(domain.getId(),TipoIdentificacionEntityMapper.convertToEntity(domain.getTipoidentificacion()),domain.getIdentificacion(),NombreCompletoClienteEntityMapper.convertToEntity(domain.getNombreCompleto()),CorreoElectronicoClienteEntityMapper.convertToEntity(domain.getCorreoElectornico()),NumeroTelefonoMovilClienteEntityMapper.convertToEntity(domain.getNumeroTelefonoMovil()),domain.getFechaNacimiento());
	
	}
	
	public static final EntrenadorDomain convertToDomain(final EntrenadorEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final EntrenadorEntity convertToEntity(final EntrenadorDomain domain) {
		return instancia.toEntity(domain);
	}

}
