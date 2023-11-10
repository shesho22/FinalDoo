package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.ejercicio;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.data.dao.EjercicioDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.entity.EjercicioEntity;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.EjercicioDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.EjercicioEntityMapper;

public final class ConsultarEjercicioUseCase implements UseCase<EjercicioDomain,String> {

	   private final DAOFactory factoria;

	    public ConsultarEjercicioUseCase(final DAOFactory factoria) {
	        this.factoria = factoria;
	    }

	    @Override
	    public List<EjercicioDomain> obtenerTodos() {
	        List<EjercicioEntity> entities = getEjercicioDAO().consultar();

	        if (entities.isEmpty()) {
	            var mensajeUsuario = "No se encuentran ejercicios";
	            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
	        }

	        List<EjercicioDomain> domainList = new ArrayList<>();
	        for (EjercicioEntity entity : entities) {
	        	EjercicioDomain domain = EjercicioEntityMapper.convertToDomain(entity);
	            domainList.add(domain);
	        }

	        return domainList;
	    }

	    private final EjercicioDAO getEjercicioDAO () {
	        return getFactoria().obtenerEjercicioDAO();
	    }

	    private final DAOFactory getFactoria() {
	        if (factoria == null) {
	            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la operación";
	            var mensajeTecnico = "El atributo factoria no ha sido inicializado correctamente.";
	            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
	        }
	        return factoria;
	    }
}


