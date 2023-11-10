package co.edu.uco.gestorgimnasio.service.facade.concrete.entrenador;


import java.util.List;

import co.edu.uco.gestorgimnasio.crosscutting.exception.GestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.data.dao.EntrenadorDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.concrete.entrenador.ConsultarEntrenadorUseCase;
import co.edu.uco.gestorgimnasio.service.facade.Facade;

public final class ConsultarEntrenadorFacade implements Facade<List<EntrenadorDAO>> {

    @Override
    public void execute() {
        final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);

        try {
            daoFactory.iniciarTransaccion();
            final var useCase = new ConsultarEntrenadorUseCase(daoFactory);
            useCase.obtenerTodos();
            daoFactory.confirmarTransaccion();
        } catch (final GestorGimnasioException excepcion) {
            daoFactory.cancelarTransaccion();
            throw excepcion;
        } catch (Exception exception) {
            daoFactory.cancelarTransaccion();
            throw ServiceGestorGimnasioException.crear(exception,
                    "Se ha presentado un error inesperado tratando de consultar una rutina",
                    "Se ha presentado un error inesperado tratando de consultar una rutina. Verifique la traza completa ");
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}

