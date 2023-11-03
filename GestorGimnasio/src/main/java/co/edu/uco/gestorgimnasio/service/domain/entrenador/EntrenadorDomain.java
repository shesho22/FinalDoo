package co.edu.uco.gestorgimnasio.service.domain.entrenador;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.CorreoElectronicoClienteDomain;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.NombreCompletoClienteDomain;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.support.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public class EntrenadorDomain {
	
	private UUID id; 
	private TipoIdentificacionDomain tipoidentificacion;
	private String identificacion;
	private NombreCompletoClienteDomain nombreCompleto;
	private CorreoElectronicoClienteDomain correoElectornico;
	private NumeroTelefonoMovilClienteDomain numeroTelefonoMovil;
	private LocalDate fechaNacimiento;
	
	
	public EntrenadorDomain(final UUID id,final TipoIdentificacionDomain tipoIdentificacion,final String identificacion,final NombreCompletoClienteDomain nombreCompleto,final CorreoElectronicoClienteDomain correoElectronico,final NumeroTelefonoMovilClienteDomain numeroTelefonoMovil,final LocalDate fechaNacimiento) {
		setId(id);
		setTipoidentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectornico(correoElectronico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public static final EntrenadorDomain crear(final UUID id,final TipoIdentificacionDomain tipoIdentificacion,final String identificacion,final NombreCompletoClienteDomain nombreCompleto,final CorreoElectronicoClienteDomain correoElectronico,final NumeroTelefonoMovilClienteDomain numeroTelefonoMovil,final LocalDate fechaNacimiento) {
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

	public final NombreCompletoClienteDomain getNombreCompleto() {
		return nombreCompleto;
	}

	public final EntrenadorDomain setNombreCompleto(final NombreCompletoClienteDomain nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}

	public final CorreoElectronicoClienteDomain getCorreoElectornico() {
		return correoElectornico;
	}

	public final EntrenadorDomain setCorreoElectornico(final CorreoElectronicoClienteDomain correoElectornico) {
		this.correoElectornico = correoElectornico;
		return this;
	}

	public final NumeroTelefonoMovilClienteDomain getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}

	public final EntrenadorDomain setNumeroTelefonoMovil(final NumeroTelefonoMovilClienteDomain numeroTelefonoMovil) {
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
