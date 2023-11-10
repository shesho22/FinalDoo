package co.edu.uco.gestorgimnasio.service.facade.concrete.tipoidentificacion;


import co.edu.uco.gestorgimnasio.crosscutting.exception.GestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.concrete.tipoidentificacion.ConsultarTipoIdentificacionUseCase;
import co.edu.uco.gestorgimnasio.service.dto.TipoIdentificacionDTO;
import co.edu.uco.gestorgimnasio.service.facade.Facade;

public final class ConsultarTipoIdentificacionFacade implements Facade<TipoIdentificacionDTO> {

    @Override
    public void execute() {
        final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);

        try {
            daoFactory.iniciarTransaccion();
            final var useCase = new ConsultarTipoIdentificacionUseCase(daoFactory);
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

