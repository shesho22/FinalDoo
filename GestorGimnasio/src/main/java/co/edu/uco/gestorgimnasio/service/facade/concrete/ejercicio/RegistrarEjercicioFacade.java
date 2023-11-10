package co.edu.uco.gestorgimnasio.service.facade.concrete.ejercicio;


import co.edu.uco.gestorgimnasio.crosscutting.exception.GestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.concrete.ejercicio.RegistrarEjercicioUseCase;
import co.edu.uco.gestorgimnasio.service.businesslogic.validator.concrete.ejercicio.RegistrarEjercicioValidator;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.EjercicioDomain;
import co.edu.uco.gestorgimnasio.service.dto.EjercicioDTO;
import co.edu.uco.gestorgimnasio.service.facade.Facade;
import co.edu.uco.gestorgimnasio.service.mapper.dto.concrete.EjercicioDTOMapper;

public final class RegistrarEjercicioFacade implements Facade<EjercicioDTO>{

	@Override
	public final void execute(EjercicioDTO dto) {
		final EjercicioDomain domain = EjercicioDTOMapper.convertirToDomain(dto);
		RegistrarEjercicioValidator.ejecutar(domain);

		final DAOFactory daoFactory =DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);

		try {
			daoFactory.iniciarTransaccion();

			var useCase = new RegistrarEjercicioUseCase(daoFactory);
			useCase.crear(domain);

			daoFactory.confirmarTransaccion();

		}catch (final GestorGimnasioException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		}catch (Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario ="Se ha presentado un error inesperado tratando de registrar un nuevo ejercicio";
			var mensajeTecnico = "Se ha presentado un error inesperado tratando de registrar un nuevo ejercicio. verigue la trasa completa ";
			throw ServiceGestorGimnasioException.crear(exception,mensajeUsuario,mensajeTecnico);
		}
		finally {
			daoFactory.cerrarConexion();
		}
	}


}
