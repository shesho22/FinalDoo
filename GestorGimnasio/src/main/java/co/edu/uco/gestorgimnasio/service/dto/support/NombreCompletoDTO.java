package co.edu.uco.gestorgimnasio.service.dto.support;

import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;

public class NombreCompletoDTO {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;


	public NombreCompletoDTO() {
		setPrimerNombre(UtilTexto.VACIO);
		setSegundoNombre(UtilTexto.VACIO);
		setPrimerApellido(UtilTexto.VACIO);
		setSegundoApellido(UtilTexto.VACIO);
	}

	public NombreCompletoDTO(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
	}

	public static final NombreCompletoDTO crear(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoDTO(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}



	private final void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	private final void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	private final void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	private final void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
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
