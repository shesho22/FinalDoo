package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.entrenador;

import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.dao.EntrenadorDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;
import co.edu.uco.gestorgimnasio.service.businesslogic.validator.concrete.entrenador.RegistrarEntrenadorValidator;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.EntrenadorDomain;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.EntrenadorEntityMapper;

public final class EliminarEntrenadorUseCase implements UseCase<EntrenadorDomain> {

    private DAOFactory factoria;

    public EliminarEntrenadorUseCase(final DAOFactory factoria) {
        setFactoria(factoria);
    }

    @Override
    public final void execute(EntrenadorDomain domain) {
        RegistrarEntrenadorValidator.ejecutar(domain);
        validarNoExistenciaEntrenadorConMismoDocumentoIdentificacion(domain.getTipoidentificacion(),domain.getIdentificacion());
        domain = obtenerIdentificadorEntrenador(domain);
        registrarNuevoEntrenador(domain);
    }

    private void registrarNuevoEntrenador(final EntrenadorDomain domain) {
        var entity = EntrenadorEntityMapper.convertToEntity(domain);
        getEntrenadorDAO().crear(entity);
    }

    private final void validarNoExistenciaEntrenadorConMismoDocumentoIdentificacion(final TipoIdentificacionDomain tipoIdentificacion, final String identificacion) {
    	var domain = EntrenadorDomain.crear(null, tipoIdentificacion, identificacion, null, null, null, null);
		var entity=EntrenadorEntityMapper.convertToEntity(domain);
		var resultados = getEntrenadorDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe un entrenador con el mismo tipo de documento y documento";
			throw ServiceGestorGimnasioException.crear(mensajeUsuario);
		}
    }

    private final EntrenadorDomain obtenerIdentificadorEntrenador(final EntrenadorDomain domain) {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while (getEntrenadorDAO().consultarPorId(uuid).isPresent());
        return EntrenadorDomain.crear(uuid, domain.getTipoidentificacion(), domain.getIdentificacion(), domain.getNombreCompleto(), domain.getCorreoElectornico(), domain.getNumeroTelefonoMovil(), domain.getFechaNacimiento());
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

    private final EntrenadorDAO getEntrenadorDAO() {
        return getFactoria().obtenerEntrenadorDAO();
    }
}

