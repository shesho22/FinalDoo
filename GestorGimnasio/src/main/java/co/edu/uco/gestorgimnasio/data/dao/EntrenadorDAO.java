package co.edu.uco.gestorgimnasio.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.data.entity.EntrenadorEntity;

public interface EntrenadorDAO {

	void crear(EntrenadorEntity entity);
	void modificar(EntrenadorEntity entity);
	void eliminar(UUID id);
	Optional<EntrenadorEntity> consultarPorId(UUID id);
	List<EntrenadorEntity> consultar(EntrenadorEntity entity);
}
