package co.edu.uco.gestorgimnasio.service.mapper.dto.concrete;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EjercicioDTO toDTO(EjercicioDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static final EjercicioDomain convertirToDomain(final EjercicioDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final EjercicioDTO convertirToDTO(final EjercicioDomain domain) {
		return instancia.toDTO(domain);
	}

}
