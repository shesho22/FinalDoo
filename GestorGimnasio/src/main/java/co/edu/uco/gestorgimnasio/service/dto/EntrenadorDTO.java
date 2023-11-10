package co.edu.uco.gestorgimnasio.service.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilUUID;
import co.edu.uco.gestorgimnasio.service.dto.support.CorreoElectronicoDTO;
import co.edu.uco.gestorgimnasio.service.dto.support.NombreCompletoDTO;
import co.edu.uco.gestorgimnasio.service.dto.support.NumeroTelefonoMovilDTO;

public class EntrenadorDTO {
	private UUID id;
	private TipoIdentificacionDTO tipoidentificacion;
	private String identificacion;
	private NombreCompletoDTO nombreCompleto;
	private CorreoElectronicoDTO correoElectornico;
	private NumeroTelefonoMovilDTO numeroTelefonoMovil;
	private LocalDate fechaNacimiento;


	public EntrenadorDTO() {
		setId(UtilUUID.getDefaultUUID(id));
		setTipoidentificacion(new TipoIdentificacionDTO());
		setIdentificacion(UtilTexto.VACIO);
		setNombreCompleto(new NombreCompletoDTO());
		setCorreoElectornico(new CorreoElectronicoDTO());
		setNumeroTelefonoMovil(new NumeroTelefonoMovilDTO());
		setFechaNacimiento(LocalDate.of(2050, 1, 1));
	}

	public EntrenadorDTO(final UUID id,final TipoIdentificacionDTO tipoidentificacion,final String identificacion,
			final NombreCompletoDTO nombreCompleto,final CorreoElectronicoDTO correoElectornico,
			final NumeroTelefonoMovilDTO numeroTelefonoMovil,final LocalDate fechaNacimiento) {
		setId(id);
		setTipoidentificacion(tipoidentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectornico(correoElectornico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(fechaNacimiento);
	}


	public static final EntrenadorDTO crear(UUID uuid, TipoIdentificacionDTO tipoIdentificacionDTO, String string, NombreCompletoDTO nombreCompletoDTO, CorreoElectronicoDTO correoElectronicoDTO, NumeroTelefonoMovilDTO numeroTelefonoMovilDTO, LocalDate localDate) {
		return new EntrenadorDTO(uuid,tipoIdentificacionDTO,string,nombreCompletoDTO,correoElectronicoDTO,numeroTelefonoMovilDTO,localDate);
	}

	public static final EntrenadorDTO crear() {
		return new EntrenadorDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	public final EntrenadorDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final TipoIdentificacionDTO getTipoidentificacion() {
		return tipoidentificacion;
	}
	public final EntrenadorDTO setTipoidentificacion(final TipoIdentificacionDTO tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
		return this;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final EntrenadorDTO setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
		return this;
	}
	public final NombreCompletoDTO getNombreCompleto() {
		return nombreCompleto;
	}
	public final EntrenadorDTO setNombreCompleto(final NombreCompletoDTO nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}
	public final CorreoElectronicoDTO getCorreoElectornico() {
		return correoElectornico;
	}
	public final EntrenadorDTO setCorreoElectornico(final CorreoElectronicoDTO correoElectornico) {
		this.correoElectornico = correoElectornico;
		return this;
	}
	public final NumeroTelefonoMovilDTO getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final EntrenadorDTO setNumeroTelefonoMovil(final NumeroTelefonoMovilDTO numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
		return this;
	}
	public final LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public final EntrenadorDTO setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}


}
