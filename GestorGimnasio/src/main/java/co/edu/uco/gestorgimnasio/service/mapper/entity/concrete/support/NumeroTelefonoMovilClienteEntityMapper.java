package co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.support;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.entity.support.NumeroTelefonoMovilEntrenadorEntity;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.EntityMapper;

public class NumeroTelefonoMovilClienteEntityMapper implements EntityMapper<NumeroTelefonoMovilEntrenadorEntity, NumeroTelefonoMovilClienteDomain>{
	private static final EntityMapper<NumeroTelefonoMovilEntrenadorEntity, NumeroTelefonoMovilClienteDomain> instancia = new NumeroTelefonoMovilClienteEntityMapper();
	
	private NumeroTelefonoMovilClienteEntityMapper() {
		super();
	}
	
	@Override
	public final NumeroTelefonoMovilClienteDomain toDomain(final NumeroTelefonoMovilEntrenadorEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NumeroTelefonoMovilClienteDomain.crear(entity.getNumeroTelefonoMovil(),entity.isNumeroTelefonoMovilConfirmado());
	}
	
	@Override
	public final NumeroTelefonoMovilEntrenadorEntity toEntity(final NumeroTelefonoMovilClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un tipo de identificacion diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NumeroTelefonoMovilEntrenadorEntity.crear(domain.getNumeroTelefonoMovil(),domain.isNumeroTelefonoMovilConfirmado());
	
	}
	
	public static final NumeroTelefonoMovilClienteDomain convertToDomain(final NumeroTelefonoMovilEntrenadorEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final NumeroTelefonoMovilEntrenadorEntity convertToEntity(final NumeroTelefonoMovilClienteDomain domain) {
		return instancia.toEntity(domain);
	}
	
}
