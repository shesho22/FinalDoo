package co.edu.uco.gestorgimnasio.service.domain.ejercicio;

import java.util.UUID;


public class EjercicioDomain {
    private UUID id;
    private String nombre;
    private String descripcion;
    private String series;
    private String repeticiones;

    public EjercicioDomain(final UUID id,final String nombre,final String descripcion,final String series,final String repeticiones) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setSeries(series);
        setRepeticiones(repeticiones);
    }

    public static final EjercicioDomain crear(final UUID id,final String nombre,final String descripcion,final String series,final String repeticiones) {
        return new EjercicioDomain(id, nombre, descripcion, series, repeticiones);
    }

    public final UUID getId() {
        return id;
    }

    public final EjercicioDomain setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final EjercicioDomain setNombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final EjercicioDomain setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public final String getSeries() {
        return series;
    }

    public final EjercicioDomain setSeries(final String series) {
        this.series = series;
        return this;
    }

    public final String getRepeticiones() {
        return repeticiones;
    }

    public final EjercicioDomain setRepeticiones(final String repeticiones) {
        this.repeticiones = repeticiones;
        return this;
    }
}
