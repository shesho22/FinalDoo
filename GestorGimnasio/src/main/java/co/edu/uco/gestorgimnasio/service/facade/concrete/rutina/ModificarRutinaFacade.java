package co.edu.uco.gestorgimnasio.service.facade.concrete.rutina;


import co.edu.uco.gestorgimnasio.crosscutting.exception.GestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
<<<<<<< HEAD:GestorGimnasio/src/main/java/co/edu/uco/gestorgimnasio/service/facade/concrete/rutina/ModificarRutinaFacade.java
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.concrete.rutina.ModificarRutinaUseCase;
import co.edu.uco.gestorgimnasio.service.businesslogic.validator.concrete.rutina.ModificarRutinaValidator;
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

>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b:GestorGimnasio/src/main/java/co/edu/uco/gestorgimnasio/service/facade/concrete/rutina/EditarRutinaFacade.java
import co.edu.uco.gestorgimnasio.service.mapper.dto.concrete.RutinaDTOMapper;

public final class ModificarRutinaFacade implements Facade<RutinaDTO> {

    @Override
    public void execute(RutinaDTO dto) {
        final RutinaDomain domain = RutinaDTOMapper.convertirToDomain(dto);
        ModificarRutinaValidator.ejecutar(domain);

        final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);

        try {
            daoFactory.iniciarTransaccion();

<<<<<<< HEAD:GestorGimnasio/src/main/java/co/edu/uco/gestorgimnasio/service/facade/concrete/rutina/ModificarRutinaFacade.java
            var useCase = new ModificarRutinaUseCase(daoFactory);
=======
           final  var useCase = new RegistrarRutinaUseCase(daoFactory);
>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b:GestorGimnasio/src/main/java/co/edu/uco/gestorgimnasio/service/facade/concrete/rutina/EditarRutinaFacade.java
            useCase.execute(domain);

            daoFactory.confirmarTransaccion();

        } catch (final GestorGimnasioException excepcion) {
            daoFactory.cancelarTransaccion();
            throw excepcion;
        } catch (Exception exception) {
            daoFactory.cancelarTransaccion();
<<<<<<< HEAD:GestorGimnasio/src/main/java/co/edu/uco/gestorgimnasio/service/facade/concrete/rutina/ModificarRutinaFacade.java
            var mensajeUsuario = "Se ha presentado un error inesperado tratando de modificar una rutina";
            var mensajeTecnico = "Se ha presentado un error inesperado tratando de modificar una rutina. Verifique la trasa completa ";
            throw ServiceGestorGimnasioException.crear(exception, mensajeUsuario, mensajeTecnico);
=======

            throw ServiceGestorGimnasioException.crear(exception, "Se ha presentado un error inesperado tratando de registrar una nueva rutina", "Se ha presentado un error inesperado tratando de registrar una nueva rutina. Verifique la traza completa.");
>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b:GestorGimnasio/src/main/java/co/edu/uco/gestorgimnasio/service/facade/concrete/rutina/EditarRutinaFacade.java
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}

