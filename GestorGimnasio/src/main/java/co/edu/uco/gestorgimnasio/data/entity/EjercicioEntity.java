package co.edu.uco.gestorgimnasio.data.entity;

import java.util.UUID;

public class EjercicioEntity {
    private UUID id;
    private String nombre;
    private String descripcion;
    private String series;
    private String repeticiones;

    public EjercicioEntity(UUID id, String nombre, String descripcion, String series, String repeticiones) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setSeries(series);
        setRepeticiones(repeticiones);
    }

    public static final EjercicioEntity crear(UUID id, String nombre, String descripcion, String series, String repeticiones) {
        return new EjercicioEntity(id, nombre, descripcion, series, repeticiones);
    }

    private final void setId(UUID id) {
        this.id = id;
    }

    private final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private final void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private final void setSeries(String series) {
        this.series = series;
    }

    private final void setRepeticiones(String repeticiones) {
        this.repeticiones = repeticiones;
    }

    public final UUID getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final String getSeries() {
        return series;
    }

    public final String getRepeticiones() {
        return repeticiones;
    }
}

