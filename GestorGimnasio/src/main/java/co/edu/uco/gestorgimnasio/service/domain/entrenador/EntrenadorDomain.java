package co.edu.uco.gestorgimnasio.service.domain.entrenador;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.CorreoElectronicoDomain;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.NombreCompletoDomain;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.NumeroTelefonoMovilDomain;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public class EntrenadorDomain {

	private UUID id;
	private TipoIdentificacionDomain tipoidentificacion;
	private String identificacion;
	private NombreCompletoDomain nombreCompleto;
	private CorreoElectronicoDomain correoElectornico;
	private NumeroTelefonoMovilDomain numeroTelefonoMovil;
	private LocalDate fechaNacimiento;


	public EntrenadorDomain(final UUID id,final TipoIdentificacionDomain tipoIdentificacion,final String identificacion,final NombreCompletoDomain nombreCompleto,final CorreoElectronicoDomain correoElectronico,final NumeroTelefonoMovilDomain numeroTelefonoMovil,final LocalDate fechaNacimiento) {
		setId(id);
		setTipoidentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectornico(correoElectronico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(fechaNacimiento);
	}

	public static final EntrenadorDomain crear(final UUID id,final TipoIdentificacionDomain tipoIdentificacion,final String identificacion,final NombreCompletoDomain nombreCompleto,final CorreoElectronicoDomain correoElectronico,final NumeroTelefonoMovilDomain numeroTelefonoMovil,final LocalDate fechaNacimiento) {
		return new EntrenadorDomain(id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroTelefonoMovil, fechaNacimiento);
	}

	public final UUID getId() {
		return id;
	}
	public final EntrenadorDomain setId(final UUID id) {
		this.id = id;
		return this;
	}

	public final TipoIdentificacionDomain getTipoidentificacion() {
		return tipoidentificacion;
	}

	public final EntrenadorDomain setTipoidentificacion(final TipoIdentificacionDomain tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
		return this;
	}

	public final String getIdentificacion() {
		return identificacion;
	}

	public final EntrenadorDomain setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	public final NombreCompletoDomain getNombreCompleto() {
		return nombreCompleto;
	}

	public final EntrenadorDomain setNombreCompleto(final NombreCompletoDomain nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}

	public final CorreoElectronicoDomain getCorreoElectornico() {
		return correoElectornico;
	}

	public final EntrenadorDomain setCorreoElectornico(final CorreoElectronicoDomain correoElectornico) {
		this.correoElectornico = correoElectornico;
		return this;
	}

	public final NumeroTelefonoMovilDomain getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}

	public final EntrenadorDomain setNumeroTelefonoMovil(final NumeroTelefonoMovilDomain numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
		return this;
	}

	public final LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final EntrenadorDomain setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}



}
