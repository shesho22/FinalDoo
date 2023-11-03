package co.edu.uco.gestorgimnasio.service.mapper.dto.concrete;

import co.edu.uco.gestorgimnasio.service.domain.rutina.RutinaDomain;
import co.edu.uco.gestorgimnasio.service.dto.RutinaDTO;
import co.edu.uco.gestorgimnasio.service.mapper.dto.DTOMapper;

public final class RutinaDTOMapper implements DTOMapper<RutinaDTO, RutinaDomain>{

private static final DTOMapper<RutinaDTO, RutinaDomain> instancia = new RutinaDTOMapper();
	
	private RutinaDTOMapper() {
		super();
	}
	
	@Override
	public RutinaDomain toDomain(RutinaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RutinaDTO toDTO(RutinaDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static final RutinaDomain convertirToDomain(final RutinaDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final RutinaDTO convertirToDTO(final RutinaDomain domain) {
		return instancia.toDTO(domain);
	}

}
