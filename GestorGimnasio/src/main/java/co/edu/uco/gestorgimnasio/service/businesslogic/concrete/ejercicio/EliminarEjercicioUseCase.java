package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.ejercicio;

import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.dao.EjercicioDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;

public final class EliminarEjercicioUseCase implements UseCase<UUID,String> {

    private DAOFactory factoria;

    public EliminarEjercicioUseCase(final DAOFactory factoria) {
        setFactoria(factoria);
    }

    @Override
    public final void eliminar(UUID id) {
    	validarExistencia(id);
    	eliminarPorId(id);
    }


    private void eliminarPorId(final UUID id) {
        getEjercicioDAO().eliminar(id);
    }

    private final void validarExistencia(final UUID id) {
        var resultado = getEjercicioDAO().consultarPorId(id);
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
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la eliminación del ejercicio";
            var mensajeTecnico = "Se ha presentado un problema en setFactoria";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        this.factoria = factoria;
    }

    private final EjercicioDAO getEjercicioDAO() {
        return getFactoria().obtenerEjercicioDAO();
    }
}



