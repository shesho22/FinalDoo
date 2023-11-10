package co.edu.uco.gestorgimnasio.service.domain.entrenador.support;

public class NumeroTelefonoMovilDomain {
	private String numeroTelefonoMovil;
	private boolean numeroTelefonoMovilConfirmado;



	public NumeroTelefonoMovilDomain(final String numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setNumeroTelefonoMovilConfirmado(numeroTelefonoMovilConfirmado);
	}


	public static final NumeroTelefonoMovilDomain crear(final String numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		return new NumeroTelefonoMovilDomain(numeroTelefonoMovil, numeroTelefonoMovilConfirmado);
	}


	private final NumeroTelefonoMovilDomain setNumeroTelefonoMovil(final String numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
		return this;
	}
	private final NumeroTelefonoMovilDomain setNumeroTelefonoMovilConfirmado(final boolean numeroTelefonoMovilConfirmado) {
		this.numeroTelefonoMovilConfirmado = numeroTelefonoMovilConfirmado;
		return this;
	}

	public final String getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final boolean isNumeroTelefonoMovilConfirmado() {
		return numeroTelefonoMovilConfirmado;
	}

}
