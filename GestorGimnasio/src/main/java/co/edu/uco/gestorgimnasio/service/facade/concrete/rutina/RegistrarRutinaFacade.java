package co.edu.uco.gestorgimnasio.service.facade.concrete.rutina;


import co.edu.uco.gestorgimnasio.crosscutting.exception.GestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
<<<<<<< HEAD
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.concrete.rutina.RegistrarRutinaUseCase;
import co.edu.uco.gestorgimnasio.service.businesslogic.validator.concrete.rutina.RegistrarRutinaValidator;
import co.edu.uco.gestorgimnasio.service.domain.rutina.RutinaDomain;
import co.edu.uco.gestorgimnasio.service.dto.RutinaDTO;
import co.edu.uco.gestorgimnasio.service.facade.Facade;
=======

import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.TipoDAOFactory;

import co.edu.uco.gestorgimnasio.service.businesslogic.concrete.rutina.RegistrarRutinaUseCase;

import co.edu.uco.gestorgimnasio.service.businesslogic.validator.concrete.rutina.RegistrarRutinaValidator;

import co.edu.uco.gestorgimnasio.service.domain.rutina.RutinaDomain;

import co.edu.uco.gestorgimnasio.service.dto.RutinaDTO;
import co.edu.uco.gestorgimnasio.service.facade.Facade;

>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b
import co.edu.uco.gestorgimnasio.service.mapper.dto.concrete.RutinaDTOMapper;

public final class RegistrarRutinaFacade implements Facade<RutinaDTO>{

	@Override
	public final void execute(RutinaDTO rutinaDTO) {
	    final RutinaDomain domain = RutinaDTOMapper.convertirToDomain(rutinaDTO);
	    RegistrarRutinaValidator.ejecutar(domain);

	    final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);

	    try {
	        daoFactory.iniciarTransaccion();

<<<<<<< HEAD
	        var useCase = new RegistrarRutinaUseCase(daoFactory);
	        useCase.execute(domain);
=======
           final var useCase = new RegistrarRutinaUseCase(daoFactory);
            useCase.execute(domain);
>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b

	        daoFactory.confirmarTransaccion();

<<<<<<< HEAD
	    } catch (final GestorGimnasioException excepcion) {
	        daoFactory.cancelarTransaccion();
	        throw excepcion;
	    } catch (Exception exception) {
	        daoFactory.cancelarTransaccion();
	        var mensajeUsuario = "Se ha presentado un error inesperado tratando de registrar una nueva rutina";
	        var mensajeTecnico = "Se ha presentado un error inesperado tratando de registrar una nueva rutina. Verifique la traza completa.";
	        throw ServiceGestorGimnasioException.crear(exception, mensajeUsuario, mensajeTecnico);
	    } finally {
	        daoFactory.cerrarConexion();
	    }
=======
        } catch (final GestorGimnasioException excepcion) {
            daoFactory.cancelarTransaccion();
            throw excepcion;
        } catch (Exception exception) {
            daoFactory.cancelarTransaccion();

            throw ServiceGestorGimnasioException.crear(exception, "Se ha presentado un error inesperado tratando de registrar una nueva rutina", "Se ha presentado un error inesperado tratando de registrar una nueva rutina. Verifique la traza completa.");
        } finally {
            daoFactory.cerrarConexion();
        }	
>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b
	}

}
