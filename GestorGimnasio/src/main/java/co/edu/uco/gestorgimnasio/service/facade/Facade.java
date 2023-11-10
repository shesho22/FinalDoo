package co.edu.uco.gestorgimnasio.service.facade;

public interface Facade<T> {
	default void execute (T dto) {
	}

	default void execute() {

	}
}

