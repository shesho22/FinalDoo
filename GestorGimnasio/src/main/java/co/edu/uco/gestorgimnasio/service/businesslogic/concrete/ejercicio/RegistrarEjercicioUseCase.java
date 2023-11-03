package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.ejercicio;

import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.dao.EjercicioDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;
import co.edu.uco.gestorgimnasio.service.businesslogic.validator.concrete.ejercicio.RegistrarEjercicioValidator;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.EjercicioDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.EjercicioEntityMapper;


public final class RegistrarEjercicioUseCase implements UseCase<EjercicioDomain> {

    private DAOFactory factoria;

    public RegistrarEjercicioUseCase(final DAOFactory factoria) {
        setFactoria(factoria);
    }

    @Override
    public final void execute(EjercicioDomain domain) {
        RegistrarEjercicioValidator.ejecutar(domain);
        validarNoExistenciaEjercicioConMismoNombreDescripciom(domain.getNombre(),domain.getDescripcion());
        domain = obtenerIdentificadorEjercicio(domain);
        registrarNuevoEjercicio(domain);
    }

    private void registrarNuevoEjercicio(final EjercicioDomain domain) {
        var entity = EjercicioEntityMapper.convertToEntity(domain);
        getEjercicioDAO().crear(entity);
    }

    private final void validarNoExistenciaEjercicioConMismoNombreDescripciom(final String nombre, final String descripcion) {
    			var domain = EjercicioDomain.crear(null, descripcion, descripcion, null, null);
    			var entity=EjercicioEntityMapper.convertToEntity(domain);
    			var resultados = getEjercicioDAO().consultar(entity);
    			
    			if(!resultados.isEmpty()) {
    				var mensajeUsuario = "Ya existe un ejercicio con el mismo nombre y descripcion";
    				throw ServiceGestorGimnasioException.crear(mensajeUsuario);
    			}
    }



    private final EjercicioDomain obtenerIdentificadorEjercicio(final EjercicioDomain domain) {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while (getEjercicioDAO().consultarPorId(uuid).isPresent());
        return EjercicioDomain.crear(uuid, domain.getNombre(), domain.getDescripcion(), domain.getSeries(), domain.getRepeticiones());
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

    private final EjercicioDAO getEjercicioDAO() {
        return getFactoria().obtenerEjercicioDAO();
    }
}

