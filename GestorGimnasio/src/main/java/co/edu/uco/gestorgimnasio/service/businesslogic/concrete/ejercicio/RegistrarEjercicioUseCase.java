package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.ejercicio;


import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.dao.EjercicioDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.EjercicioDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.EjercicioEntityMapper;


public final class RegistrarEjercicioUseCase implements UseCase<EjercicioDomain,String> {

    private DAOFactory factoria;

    public RegistrarEjercicioUseCase(final DAOFactory factoria) {
        setFactoria(factoria);
    }

    @Override
    public final void crear(EjercicioDomain domain) {
        validarExistenciaEjercicioConMismoNombre(domain.getNombre());
        domain = registrarEjercicio(domain);
    }

    private EjercicioDomain registrarEjercicio(final EjercicioDomain domain) {
        var entity = EjercicioEntityMapper.convertToEntity(domain);
        getEjercicioDAO().crear(entity);
        return domain;
    }

    private void validarExistenciaEjercicioConMismoNombre(final String nombre) {
        var domain = EjercicioDomain.crear(null, nombre, null, null, null);
        var entity = EjercicioEntityMapper.convertToEntity(domain);
        var resultados = getEjercicioDAO().consultar(entity);

        if (!resultados.isEmpty()) {
            var mensajeUsuario = "Ya existe un ejercicio con el nombre " + nombre;
            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
        }
    }

    private final EjercicioDAO getEjercicioDAO() {
        return getFactoria().obtenerEjercicioDAO();
    }

    private final DAOFactory getFactoria() {
        return factoria;
    }

    private final void setFactoria(final DAOFactory factoria) {
        if (UtilObjeto.esNulo(factoria)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo el registro del ejercicio";
            var mensajeTecnico = "Se ha presentado un problema en setFactoria";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        this.factoria = factoria;
    }
}

