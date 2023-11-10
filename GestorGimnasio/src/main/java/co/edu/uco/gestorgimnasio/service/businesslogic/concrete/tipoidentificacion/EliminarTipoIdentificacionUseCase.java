package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.tipoidentificacion;

import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.dao.TipoIdentificacionDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;

public final class EliminarTipoIdentificacionUseCase implements UseCase<UUID, String> {

    private DAOFactory factoria;

    public EliminarTipoIdentificacionUseCase(final DAOFactory factoria) {
        setFactoria(factoria);
    }

    @Override
    public final void eliminar(UUID id) {
        // Validar la existencia del tipo de identificación
        validarExistencia(id);

        // Eliminar el tipo de identificación
        eliminarPorId(id);
    }

    private void eliminarPorId(final UUID id) {
        getTipoIdentificacionDAO().eliminar(id);
    }

    private final void validarExistencia(final UUID id) {
        var resultado = getTipoIdentificacionDAO().consultarPorId(id);
        if (resultado.isEmpty()) {
            var mensajeUsuario = "No existe un tipo de identificación con el ID " + id;
            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
        }
    }

    private final DAOFactory getFactoria() {
        return factoria;
    }

    private final void setFactoria(final DAOFactory factoria) {
        if (UtilObjeto.esNulo(factoria)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo el resultado";
            var mensajeTecnico = "Se ha presentado un problema en setFactoria";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        this.factoria = factoria;
    }

    private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
        return getFactoria().obtenerTipoIdentificacionDAO();
    }
}


