package co.edu.uco.gestorgimnasio.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.data.entity.EjercicioEntity;
import co.edu.uco.gestorgimnasio.data.entity.RutinaEntity;
import co.edu.uco.gestorgimnasio.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.mapper.entity.EntityMapper;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.EjercicioDomain;
import co.edu.uco.gestorgimnasio.service.domain.rutina.RutinaDomain;

public final class RutinaEntityMapper implements EntityMapper<RutinaEntity, RutinaDomain>{

	private static final EntityMapper<RutinaEntity, RutinaDomain> instancia = new RutinaEntityMapper();
	
	private RutinaEntityMapper() {
		super();
	}
	
	@Override
	public final RutinaDomain toDomain(final RutinaEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toDomain .No es posible mapear un cliente diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return RutinaDomain.crear(entity.getId(),entity.getNombre(),EntrenadorEntityMapper.convertToDomain(entity.getEntrenador()), RutinaEntityMapper.convertToDomainList(entity.getEjercicios()));
	}
	
	

	@Override
	public final RutinaEntity toEntity(final RutinaDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = "Se ha presentado un problena en el metodo toEntity .No es posible mapear un cliente diminio a partir de un tipo de identificacion entity nula";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return RutinaEntity.crear(domain.getId(),domain.getNombre(),EntrenadorEntityMapper.convertToEntity(domain.getEntrenador()),RutinaEntityMapper.convertToEntityList(domain.getEjercicios()));
	
	}
	
	public static final RutinaDomain convertToDomain(final RutinaEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final RutinaEntity convertToEntity(final RutinaDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static List<EjercicioDomain> convertToDomainList(List<EjercicioEntity> ejercicioEntities) {
        List<EjercicioDomain> ejercicioDomains = new ArrayList<>();

        for (EjercicioEntity entity : ejercicioEntities) {
            EjercicioDomain domain = new EjercicioDomain(
                entity.getId(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getSeries(),
                entity.getRepeticiones()
            );

            ejercicioDomains.add(domain);
        }

        return ejercicioDomains;
    }
	
	public static List<EjercicioEntity> convertToEntityList(List<EjercicioDomain> ejercicioDomains) {
        List<EjercicioEntity> ejercicioEntities = new ArrayList<>();

        for (EjercicioDomain domain : ejercicioDomains) {
            EjercicioEntity entity = new EjercicioEntity(
                domain.getId(),
                domain.getNombre(),
                domain.getDescripcion(),
                domain.getSeries(),
                domain.getRepeticiones()
            );

            ejercicioEntities.add(entity);
        }

        return ejercicioEntities;
    }

}
