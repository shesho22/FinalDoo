package co.edu.uco.gestorgimnasio.service.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilUUID;
import co.edu.uco.gestorgimnasio.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.gestorgimnasio.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.gestorgimnasio.service.dto.support.NumeroTelefonoMovilClienteDTO;

public class EntrenadorDTO {
	private UUID id; 
	private TipoIdentificacionDTO tipoidentificacion;
	private String identificacion;
	private NombreCompletoClienteDTO nombreCompleto;
	private CorreoElectronicoClienteDTO correoElectornico;
	private NumeroTelefonoMovilClienteDTO numeroTelefonoMovil;
	private LocalDate fechaNacimiento;
	
	
	public EntrenadorDTO() {
		setId(UtilUUID.getDefaultUUID(id));
		setTipoidentificacion(new TipoIdentificacionDTO());
		setIdentificacion(UtilTexto.VACIO);
		setNombreCompleto(new NombreCompletoClienteDTO());
		setCorreoElectornico(new CorreoElectronicoClienteDTO());
		setNumeroTelefonoMovil(new NumeroTelefonoMovilClienteDTO());
		setFechaNacimiento(LocalDate.of(2050, 1, 1));
	}
	
	public EntrenadorDTO(final UUID id,final TipoIdentificacionDTO tipoidentificacion,final String identificacion,
			final NombreCompletoClienteDTO nombreCompleto,final CorreoElectronicoClienteDTO correoElectornico,
			final NumeroTelefonoMovilClienteDTO numeroTelefonoMovil,final LocalDate fechaNacimiento) {
		setId(id);
		setTipoidentificacion(tipoidentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectornico(correoElectornico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(fechaNacimiento);
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
	public final NombreCompletoClienteDTO getNombreCompleto() {
		return nombreCompleto;
	}
	public final EntrenadorDTO setNombreCompleto(final NombreCompletoClienteDTO nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}
	public final CorreoElectronicoClienteDTO getCorreoElectornico() {
		return correoElectornico;
	}
	public final EntrenadorDTO setCorreoElectornico(final CorreoElectronicoClienteDTO correoElectornico) {
		this.correoElectornico = correoElectornico;
		return this;
	}
	public final NumeroTelefonoMovilClienteDTO getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final EntrenadorDTO setNumeroTelefonoMovil(final NumeroTelefonoMovilClienteDTO numeroTelefonoMovil) {
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
