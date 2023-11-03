package co.edu.uco.gestorgimnasio.service.domain;

public interface ValidatorRule<T> {
	void validar(T dato);
}
