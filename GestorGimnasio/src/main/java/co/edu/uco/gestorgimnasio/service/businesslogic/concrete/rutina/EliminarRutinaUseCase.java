package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.rutina;


import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.dao.RutinaDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;
import co.edu.uco.gestorgimnasio.service.domain.rutina.RutinaDomain;

public final class EliminarRutinaUseCase implements UseCase<RutinaDomain> {

    private DAOFactory factoria;

    public EliminarRutinaUseCase(final DAOFactory factoria) {
        setFactoria(factoria);
    }

    @Override
    public final void execute(RutinaDomain domain) {
        validarExistenciaRutina(domain.getId());
        eliminarRutina(domain);
    }

    private void eliminarRutina(final RutinaDomain domain) {
        RutinaDAO rutinaDAO = getRutinaDAO();
        rutinaDAO.eliminar(domain.getId());
    }

    private final void validarExistenciaRutina(final UUID id) {
        var resultado = getRutinaDAO().consultarPorId(id);
        if (resultado.isEmpty()) {
            var mensajeUsuario = "No existe una rutina con el ID " + id;
            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
        }
    }

    private final DAOFactory getFactoria() {
        return factoria;
    }

    private final void setFactoria(final DAOFactory factoria) {
        if (UtilObjeto.esNulo(factoria)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la eliminación de la rutina";
            var mensajeTecnico = "Se ha presentado un problema en setFactoria";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        this.factoria = factoria;
    }

    private final RutinaDAO getRutinaDAO() {
        return getFactoria().obtenerRutinaDAO();
    }
}

