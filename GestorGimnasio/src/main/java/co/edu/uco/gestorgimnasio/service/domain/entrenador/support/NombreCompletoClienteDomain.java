package co.edu.uco.gestorgimnasio.service.domain.entrenador.support;


public class NombreCompletoClienteDomain {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	

	public NombreCompletoClienteDomain(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
	}
	
	public static final NombreCompletoClienteDomain crear(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoClienteDomain(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}
	
	
	
	private final NombreCompletoClienteDomain setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
		return this;
	}
	private final NombreCompletoClienteDomain setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
		return this;
	}
	private final NombreCompletoClienteDomain setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
		return this;
	}
	private final NombreCompletoClienteDomain setSegundoApellido(String segundoApellido) {
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
