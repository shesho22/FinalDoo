package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.tipoidentificacion;



import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.dao.TipoIdentificacionDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;
import co.edu.uco.gestorgimnasio.service.businesslogic.validator.concrete.tipoidentificacion.RegistrarTipoIdentificacionValidator;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public final class ModificarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain, String> {

    private DAOFactory factoria;

    public ModificarTipoIdentificacionUseCase(final DAOFactory factoria) {
        setFactoria(factoria);
    }

    @Override
    public final void actualizar(TipoIdentificacionDomain domain) {
        // Validar el objeto TipoIdentificacionDomain
        RegistrarTipoIdentificacionValidator.ejecutar(domain);
        
        // Validar la existencia del nombre del tipo de identificación
        validarExistenciaTipoIdentificacion(domain.getCodigo());
        
        // Modificar el tipo de identificación
        modificarTipoIdentificacion(domain);
    }

    private void modificarTipoIdentificacion(final TipoIdentificacionDomain domain) {
        // Convierte el dominio en una entidad y llama al método de modificación
        var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
        getTipoIdentificacionDAO().modificar(entity);
    }

    private final void validarExistenciaTipoIdentificacion(final String nombre) {
        // Crea un dominio temporal para buscar duplicados
        var domain = TipoIdentificacionDomain.crear(null, null, nombre, false);
        
        // Convierte el dominio en una entidad y consulta la base de datos
        var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
        var resultados = getTipoIdentificacionDAO().consultar(entity);

        // Verifica si ya existe un tipo de identificación con el mismo nombre
        if (resultados.size() > 1 || (resultados.size() == 1 && !resultados.get(0).getId().equals(domain.getId()))) {
            var mensajeUsuario = "Ya existe un tipo de identificación con el nombre " + nombre;
            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
        }
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

    private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
        return getFactoria().obtenerTipoIdentificacionDAO();
    }
}

