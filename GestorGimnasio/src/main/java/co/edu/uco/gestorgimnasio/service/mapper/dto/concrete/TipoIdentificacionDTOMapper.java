package co.edu.uco.gestorgimnasio.service.mapper.dto.concrete;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.gestorgimnasio.service.dto.TipoIdentificacionDTO;
import co.edu.uco.gestorgimnasio.service.mapper.dto.DTOMapper;

public final class TipoIdentificacionDTOMapper implements DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> {

    private static final DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> instancia = new TipoIdentificacionDTOMapper();

    private TipoIdentificacionDTOMapper() {
        super();
    }

    @Override
    public TipoIdentificacionDomain toDomain(TipoIdentificacionDTO dto) {
        if (UtilObjeto.esNulo(dto)) {
            var mensajeUsuario = "";
            var mensajeTecnico = "Se ha presentado un problema en el método toDomain";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        return TipoIdentificacionDomain.crear(dto.getId(), dto.getCodigo(), dto.getNombre(), dto.isEstado());
    }

    @Override
    public TipoIdentificacionDTO toDTO(TipoIdentificacionDomain domain) {
        if (UtilObjeto.esNulo(domain)) {
            var mensajeUsuario = "";
            var mensajeTecnico = "Se ha presentado un problema en el método toDTO";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        return TipoIdentificacionDTO.crear(domain.getId(), domain.getCodigo(), domain.getNombre(), domain.isEstado());
    }

    public static final TipoIdentificacionDomain convertirToDomain(final TipoIdentificacionDTO dto) {
        return instancia.toDomain(dto);
    }

    public static final TipoIdentificacionDTO convertirToDTO(final TipoIdentificacionDomain domain) {
        return instancia.toDTO(domain);
    }

}

