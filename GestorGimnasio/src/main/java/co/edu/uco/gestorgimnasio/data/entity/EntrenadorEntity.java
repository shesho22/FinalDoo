package co.edu.uco.gestorgimnasio.data.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.data.entity.support.CorreoElectronicoEntrenadorEntity;
import co.edu.uco.gestorgimnasio.data.entity.support.NombreCompletoEntrenadorEntity;
import co.edu.uco.gestorgimnasio.data.entity.support.NumeroTelefonoMovilEntrenadorEntity;


public final  class EntrenadorEntity {
	private UUID id; 
	private TipoIdentificacionEntity tipoidentificacion;
	private String identificacion;
	private NombreCompletoEntrenadorEntity nombreCompleto;
	private CorreoElectronicoEntrenadorEntity correoElectornico;
	private NumeroTelefonoMovilEntrenadorEntity numeroTelefonoMovil;
	private LocalDate fechaNacimiento;
	
	
	private EntrenadorEntity(final UUID id, final TipoIdentificacionEntity tipoidentificacion, final String identificacion, final NombreCompletoEntrenadorEntity nombreCompleto, final CorreoElectronicoEntrenadorEntity correoElectornico,
			final NumeroTelefonoMovilEntrenadorEntity numeroTelefonoMovil,final LocalDate fechaNacimiento) {
		setId(id);
		setTipoidentificacion(tipoidentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectornico(correoElectornico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public static final EntrenadorEntity crear(final UUID id, final TipoIdentificacionEntity tipoidentificacion, final String identificacion, final NombreCompletoEntrenadorEntity nombreCompleto, final CorreoElectronicoEntrenadorEntity correoElectornico,
			final NumeroTelefonoMovilEntrenadorEntity numeroTelefonoMovil,final LocalDate fechaNacimiento) {
		return new EntrenadorEntity(id, tipoidentificacion, identificacion, nombreCompleto, correoElectornico, numeroTelefonoMovil,fechaNacimiento);
	}
	

	private final void setId(final UUID id) {
		this.id = id;
	}
	private final void setTipoidentificacion(final TipoIdentificacionEntity tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}
	private final void setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
	}
	private final void setNombreCompleto(final NombreCompletoEntrenadorEntity nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	private final void setCorreoElectornico(final CorreoElectronicoEntrenadorEntity correoElectornico) {
		this.correoElectornico = correoElectornico;
	}

	private final void setNumeroTelefonoMovil(final NumeroTelefonoMovilEntrenadorEntity numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}

	private final void setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionEntity getTipoidentificacion() {
		return tipoidentificacion;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final NombreCompletoEntrenadorEntity getNombreCompleto() {
		return nombreCompleto;
	}

	public final CorreoElectronicoEntrenadorEntity getCorreoElectornico() {
		return correoElectornico;
	}

	public final NumeroTelefonoMovilEntrenadorEntity getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}

	public final LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
}
