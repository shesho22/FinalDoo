package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.entrenador;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.data.dao.EntrenadorDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.entity.EntrenadorEntity;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.EntrenadorDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.EntrenadorEntityMapper;

public final class ConsultarEntrenadorUseCase implements UseCase<EntrenadorDomain,String> {

	   private final DAOFactory factoria;

	    public ConsultarEntrenadorUseCase(final DAOFactory factoria) {
	        this.factoria = factoria;
	    }

	    @Override
	    public List<EntrenadorDomain> obtenerTodos() {
	        List<EntrenadorEntity> entities = getEntrenadorDAO().consultar();

	        if (entities.isEmpty()) {
	            var mensajeUsuario = "No se encuentran entrenadores";
	            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
	        }

	        List<EntrenadorDomain> domainList = new ArrayList<>();
	        for (EntrenadorEntity entity : entities) {
	        	EntrenadorDomain domain = EntrenadorEntityMapper.convertToDomain(entity);
	            domainList.add(domain);
	        }

	        return domainList;
	    }

	    private final EntrenadorDAO getEntrenadorDAO() {
	        return getFactoria().obtenerEntrenadorDAO();
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

