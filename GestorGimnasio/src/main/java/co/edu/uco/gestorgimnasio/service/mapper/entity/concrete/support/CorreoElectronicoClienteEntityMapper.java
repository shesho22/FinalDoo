package co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.support;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.entity.support.CorreoElectronicoEntrenadorEntity;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.CorreoElectronicoClienteDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.EntityMapper;

public class CorreoElectronicoClienteEntityMapper implements EntityMapper<CorreoElectronicoEntrenadorEntity, CorreoElectronicoClienteDomain>{
	private static final EntityMapper<CorreoElectronicoEntrenadorEntity, CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoClienteEntityMapper();
	
	private CorreoElectronicoClienteEntityMapper() {
		super();
	}
	
	@Override
	public final CorreoElectronicoClienteDomain toDomain(final CorreoElectronicoEntrenadorEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return CorreoElectronicoClienteDomain.crear(entity.getCorreoElectronico(),entity.isCorreoElectronicoConfirmado());
	}
	
	@Override
	public final CorreoElectronicoEntrenadorEntity toEntity(final CorreoElectronicoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return CorreoElectronicoEntrenadorEntity.crear(domain.getCorreoElectronico(),domain.isCorreoElectronicoConfirmado());
	
	}
	
	public static final CorreoElectronicoClienteDomain convertToDomain(final CorreoElectronicoEntrenadorEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final CorreoElectronicoEntrenadorEntity convertToEntity(final CorreoElectronicoClienteDomain domain) {
		return instancia.toEntity(domain);
	}
	
}
