package co.edu.uco.gestorgimnasio.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.data.entity.EjercicioEntity;


public interface EjercicioDAO {

	void crear(EjercicioEntity entity);
	void modificar(EjercicioEntity entity);
	void eliminar(UUID id);
	Optional<EjercicioEntity> consultarPorId(UUID id);
	List<EjercicioEntity> consultar(EjercicioEntity entity);
	List<EjercicioEntity> consultar();
}
