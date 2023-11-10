package co.edu.uco.gestorgimnasio.service.mapper.dto.concrete;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.EjercicioDomain;
import co.edu.uco.gestorgimnasio.service.dto.EjercicioDTO;
import co.edu.uco.gestorgimnasio.service.mapper.dto.DTOMapper;

public final class EjercicioDTOMapper implements DTOMapper<EjercicioDTO, EjercicioDomain>{

private static final DTOMapper<EjercicioDTO, EjercicioDomain> instancia = new EjercicioDTOMapper();

	private EjercicioDTOMapper() {
		super();
	}

    @Override
    public EjercicioDomain toDomain(EjercicioDTO dto) {
        if (UtilObjeto.esNulo(dto)) {
            var mensajeUsuario = "";
            var mensajeTecnico = "Se ha presentado un problema en el método toDomain";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        return EjercicioDomain.crear(dto.getId(),dto.getNombre(),dto.getDescripcion(),dto.getRepeticiones(),dto.getSeries());
    }

    @Override
    public EjercicioDTO toDTO(EjercicioDomain domain) {
        if (UtilObjeto.esNulo(domain)) {
            var mensajeUsuario = "";
            var mensajeTecnico = "Se ha presentado un problema en el método toDTO";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        return EjercicioDTO.crear(domain.getId(),domain.getNombre(),domain.getDescripcion(),domain.getRepeticiones(),domain.getSeries());
    }

	public static final EjercicioDomain convertirToDomain(final EjercicioDTO dto) {
		return instancia.toDomain(dto);
	}

	public static final EjercicioDTO convertirToDTO(final EjercicioDomain domain) {
		return instancia.toDTO(domain);
	}

}
