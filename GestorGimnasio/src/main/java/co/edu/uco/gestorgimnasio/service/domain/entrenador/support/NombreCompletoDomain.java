package co.edu.uco.gestorgimnasio.service.domain.entrenador.support;


public class NombreCompletoDomain {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;


	public NombreCompletoDomain(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
	}

	public static final NombreCompletoDomain crear(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoDomain(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}



	private final NombreCompletoDomain setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
		return this;
	}
	private final NombreCompletoDomain setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
		return this;
	}
	private final NombreCompletoDomain setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
		return this;
	}
	private final NombreCompletoDomain setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
		return this;
	}

	public final String getPrimerNombre() {
		return primerNombre;
	}
	public final String getSegundoNombre() {
		return segundoNombre;
	}
	public final String getPrimerApellido() {
		return primerApellido;
	}
	public final String getSegundoApellido() {
		return segundoApellido;
	}



}
