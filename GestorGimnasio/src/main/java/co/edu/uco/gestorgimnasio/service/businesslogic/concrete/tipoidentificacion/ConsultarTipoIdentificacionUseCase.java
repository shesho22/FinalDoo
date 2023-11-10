package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.tipoidentificacion;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.data.dao.TipoIdentificacionDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.entity.TipoIdentificacionEntity;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public final class ConsultarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain, String> {

    private final DAOFactory factoria;

    public ConsultarTipoIdentificacionUseCase(final DAOFactory factoria) {
        this.factoria = factoria;
    }

    @Override
    public List<TipoIdentificacionDomain> obtenerTodos() {
        List<TipoIdentificacionEntity> entities = getTipoIdentificacionDAO().consultar();

        if (entities.isEmpty()) {
            var mensajeUsuario = "No se encuentran tipos de identificación";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
        }

        List<TipoIdentificacionDomain> domainList = new ArrayList<>();
        for (TipoIdentificacionEntity entity : entities) {
            TipoIdentificacionDomain domain = TipoIdentificacionEntityMapper.convertToDomain(entity);
            domainList.add(domain);
        }

        return domainList;
    }

    private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
        return getFactoria().obtenerTipoIdentificacionDAO();
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

