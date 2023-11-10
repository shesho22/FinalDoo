package co.edu.uco.gestorgimnasio.service.facade;

import java.util.Optional;

public interface Facade<T> {
	void execute (T dto);
}

