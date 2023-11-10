package co.edu.uco.gestorgimnasio.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.EjercicioDomain;
import co.edu.uco.gestorgimnasio.service.domain.rutina.RutinaDomain;
import co.edu.uco.gestorgimnasio.service.dto.EjercicioDTO;
import co.edu.uco.gestorgimnasio.service.dto.RutinaDTO;
import co.edu.uco.gestorgimnasio.service.mapper.dto.DTOMapper;

public final class RutinaDTOMapper implements DTOMapper<RutinaDTO, RutinaDomain>{

private static final DTOMapper<RutinaDTO, RutinaDomain> instancia = new RutinaDTOMapper();

	private RutinaDTOMapper() {
		super();
	}

    @Override
    public RutinaDomain toDomain(RutinaDTO dto) {
        if (UtilObjeto.esNulo(dto)) {
            var mensajeUsuario = "";
            var mensajeTecnico = "Se ha presentado un problema en el método toDomain";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        return RutinaDomain.crear(dto.getId(),dto.getNombre(),EntrenadorDTOMapper.convertirToDomain(dto.getEntrenador()),RutinaDTOMapper.convertToDomainList(dto.getEjercicios()));
    }

    @Override
    public RutinaDTO toDTO(RutinaDomain domain) {
        if (UtilObjeto.esNulo(domain)) {
            var mensajeUsuario = "";
            var mensajeTecnico = "Se ha presentado un problema en el método toDTO";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
        }
        return RutinaDTO.crear(domain.getId(),domain.getNombre(),EntrenadorDTOMapper.convertirToDTO(domain.getEntrenador()),RutinaDTOMapper.convertToDTOList(domain.getEjercicios()));
    }

	public static final RutinaDomain convertirToDomain(final RutinaDTO dto) {
		return instancia.toDomain(dto);
	}

	public static final RutinaDTO convertirToDTO(final RutinaDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static List<EjercicioDomain> convertToDomainList(List<EjercicioDTO> ejercicioDTO) {
        List<EjercicioDomain> ejercicioDomains = new ArrayList<>();

        for (EjercicioDTO dto : ejercicioDTO) {
            EjercicioDomain domain = new EjercicioDomain(
                dto.getId(),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getSeries(),
                dto.getRepeticiones()
            );

            ejercicioDomains.add(domain);
        }

        return ejercicioDomains;
    }

	public static List<EjercicioDTO> convertToDTOList(List<EjercicioDomain> ejercicioDomains) {
        List<EjercicioDTO> ejercicioEntities = new ArrayList<>();

        for (EjercicioDomain domain : ejercicioDomains) {
            EjercicioDTO dto = new EjercicioDTO(
                domain.getId(),
                domain.getNombre(),
                domain.getDescripcion(),
                domain.getSeries(),
                domain.getRepeticiones()
            );

            ejercicioEntities.add(dto);
        }

        return ejercicioEntities;
    }

}
