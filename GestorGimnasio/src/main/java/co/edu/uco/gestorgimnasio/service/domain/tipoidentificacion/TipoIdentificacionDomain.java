package co.edu.uco.gestorgimnasio.service.domain.tipoidentificacion;

import java.util.UUID;

public class TipoIdentificacionDomain {

	private UUID id;
	private String codigo;
	private String nombre;
	private boolean estado;


	public TipoIdentificacionDomain(final UUID id,final String codigo,final String nombre,final boolean estado) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setEstado(estado);
	}

	public static final TipoIdentificacionDomain crear(final UUID id,final String codigo,final String nombre,final boolean estado ) {
		return new TipoIdentificacionDomain(id,codigo,nombre,estado);
	}

	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionDomain setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final String getCodigo() {
		return codigo;
	}
	public final TipoIdentificacionDomain setCodigo(final String codigo) {
		this.codigo = codigo;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final TipoIdentificacionDomain setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}
	public final boolean isEstado() {
		return estado;
	}
	public final TipoIdentificacionDomain setEstado(final boolean estado) {
		this.estado = estado;
		return this;
	}
}
