package co.edu.uco.gestorgimnasio.service.businesslogic;

import java.util.List;
import java.util.UUID;

public interface UseCase<T,D> {
	default void crear(T entidad) {
	}
	default T leer(UUID id) {
		return null;
	}
	default  List<T> obtenerTodos() {
		return null;
	}
	default void actualizar(T entidad) {
	}
	default void eliminar(UUID id) {
	}
}

