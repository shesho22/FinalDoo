package co.edu.uco.gestorgimnasio.service.domain.entrenador.support;

public class NumeroTelefonoMovilClienteDomain {
	private String numeroTelefonoMovil;
	private boolean numeroTelefonoMovilConfirmado;
	
	
	
	public NumeroTelefonoMovilClienteDomain(final String numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setNumeroTelefonoMovilConfirmado(numeroTelefonoMovilConfirmado);
	}


	public static final NumeroTelefonoMovilClienteDomain crear(final String numeroTelefonoMovil, final boolean numeroTelefonoMovilConfirmado) {
		return new NumeroTelefonoMovilClienteDomain(numeroTelefonoMovil, numeroTelefonoMovilConfirmado);
	}
	
	
	private final NumeroTelefonoMovilClienteDomain setNumeroTelefonoMovil(final String numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
		return this;
	}
	private final NumeroTelefonoMovilClienteDomain setNumeroTelefonoMovilConfirmado(final boolean numeroTelefonoMovilConfirmado) {
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
