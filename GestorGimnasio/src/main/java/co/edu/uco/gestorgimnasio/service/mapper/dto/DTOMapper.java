package co.edu.uco.gestorgimnasio.service.mapper.dto;

public interface DTOMapper <T,D>{
	D toDomain(T dto);
	T toDTO(D domain);
}
