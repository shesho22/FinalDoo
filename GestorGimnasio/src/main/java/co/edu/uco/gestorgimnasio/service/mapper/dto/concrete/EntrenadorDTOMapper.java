package co.edu.uco.gestorgimnasio.service.mapper.dto.concrete;

import co.edu.uco.gestorgimnasio.service.domain.entrenador.EntrenadorDomain;
import co.edu.uco.gestorgimnasio.service.dto.EntrenadorDTO;
import co.edu.uco.gestorgimnasio.service.mapper.dto.DTOMapper;

public final class EntrenadorDTOMapper implements DTOMapper<EntrenadorDTO, EntrenadorDomain>{

private static final DTOMapper<EntrenadorDTO, EntrenadorDomain> instancia = new EntrenadorDTOMapper();
	
	private EntrenadorDTOMapper() {
		super();
	}
	
	@Override
	public EntrenadorDomain toDomain(EntrenadorDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntrenadorDTO toDTO(EntrenadorDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static final EntrenadorDomain convertirToDomain(final EntrenadorDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final EntrenadorDTO convertirToDTO(final EntrenadorDomain domain) {
		return instancia.toDTO(domain);
	}

}
