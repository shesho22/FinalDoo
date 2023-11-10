package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.rutina;

import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.dao.RutinaDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;

public final class EliminarRutinaUseCase implements UseCase<UUID,String> {

    private DAOFactory factoria;

    public EliminarRutinaUseCase(final DAOFactory factoria) {
        setFactoria(factoria);
    }

    @Override
    public final void eliminar(UUID id) {
    	validarExistencia(id);
    	eliminarPorId(id);
    }

    private void eliminarPorId(final UUID id) {
        getRutinaDAO().eliminar(id);
    }

    private final void validarExistencia(final UUID id) {
        var resultado = getRutinaDAO().consultarPorId(id);
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
            throw ServiceGestorGimnasioException.crear("Se ha presentado un problema tratando de llevar a cabo el resultado", "Se ha presentado un problema en setFactoria");
        }
        this.factoria = factoria;
    }

    private final RutinaDAO getRutinaDAO() {
        return getFactoria().obtenerRutinaDAO();
    }
}
