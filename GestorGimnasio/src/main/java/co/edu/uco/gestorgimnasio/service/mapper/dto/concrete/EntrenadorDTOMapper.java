package co.edu.uco.gestorgimnasio.service.mapper.dto.concrete;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.EntrenadorDomain;
import co.edu.uco.gestorgimnasio.service.dto.EntrenadorDTO;
import co.edu.uco.gestorgimnasio.service.mapper.dto.DTOMapper;
import co.edu.uco.gestorgimnasio.service.mapper.dto.concrete.support.CorreoElectronicoDTOMapper;
import co.edu.uco.gestorgimnasio.service.mapper.dto.concrete.support.NombreCompletoDTOMapper;
import co.edu.uco.gestorgimnasio.service.mapper.dto.concrete.support.NumeroTelefonoMovilDTOMapper;

public final class EntrenadorDTOMapper implements DTOMapper<EntrenadorDTO, EntrenadorDomain>{

private static final DTOMapper<EntrenadorDTO, EntrenadorDomain> instancia = new EntrenadorDTOMapper();

	private EntrenadorDTOMapper() {
		super();
	}

    @Override
    public EntrenadorDomain toDomain(EntrenadorDTO dto) {
        if (UtilObjeto.esNulo(dto)) {
            var mensajeUsuario = "";
            var mensajeTecnico = "Se ha presentado un problema en el método toDomain";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        return EntrenadorDomain.crear(dto.getId(),TipoIdentificacionDTOMapper.convertirToDomain(dto.getTipoidentificacion()),dto.getIdentificacion(),NombreCompletoDTOMapper.convertToDomain(dto.getNombreCompleto()),CorreoElectronicoDTOMapper.convertToDomain(dto.getCorreoElectornico()),NumeroTelefonoMovilDTOMapper.convertToDomain(dto.getNumeroTelefonoMovil()),dto.getFechaNacimiento());
    }

    @Override
    public EntrenadorDTO toDTO(EntrenadorDomain domain) {
        if (UtilObjeto.esNulo(domain)) {
            var mensajeUsuario = "";
            var mensajeTecnico = "Se ha presentado un problema en el método toDTO";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        return EntrenadorDTO.crear(domain.getId(),TipoIdentificacionDTOMapper.convertirToDTO(domain.getTipoidentificacion()),domain.getIdentificacion(),NombreCompletoDTOMapper.convertToDTO(domain.getNombreCompleto()),CorreoElectronicoDTOMapper.convertToDTO(domain.getCorreoElectornico()),NumeroTelefonoMovilDTOMapper.convertToDTO(domain.getNumeroTelefonoMovil()),domain.getFechaNacimiento());
    }

	public static final EntrenadorDomain convertirToDomain(final EntrenadorDTO dto) {
		return instancia.toDomain(dto);
	}

	public static final EntrenadorDTO convertirToDTO(final EntrenadorDomain domain) {
		return instancia.toDTO(domain);
	}

}
