package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.rutina;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.data.dao.RutinaDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.entity.RutinaEntity;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;
import co.edu.uco.gestorgimnasio.service.domain.rutina.RutinaDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.RutinaEntityMapper;

public final class ConsultarRutinaUseCase implements UseCase<RutinaDomain,String> {

	   private final DAOFactory factoria;

	    public ConsultarRutinaUseCase(final DAOFactory factoria) {
	        this.factoria = factoria;
	    }

	    @Override
	    public List<RutinaDomain> obtenerTodos() {
	        List<RutinaEntity> entities = getRutinaDAO().consultar();

	        if (entities.isEmpty()) {
	            var mensajeUsuario = "No se encuentran rutinas";
	            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
	        }

	        List<RutinaDomain> domainList = new ArrayList<>();
	        for (RutinaEntity entity : entities) {
	        	RutinaDomain domain = RutinaEntityMapper.convertToDomain(entity);
	            domainList.add(domain);
	        }

	        return domainList;
	    }

	    private final RutinaDAO getRutinaDAO() {
	        return getFactoria().obtenerRutinaDAO();
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
