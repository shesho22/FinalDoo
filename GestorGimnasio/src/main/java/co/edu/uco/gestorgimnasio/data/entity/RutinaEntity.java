package co.edu.uco.gestorgimnasio.data.entity;

import java.util.List;
import java.util.UUID;

public class RutinaEntity {
    private UUID id;
    private String nombre;
    private EntrenadorEntity entrenador;
    private List<EjercicioEntity> ejercicios;

    private RutinaEntity(UUID id, String nombre, EntrenadorEntity entrenador, List<EjercicioEntity> ejercicios) {
        setId(id);
        setNombre(nombre);
        setEntrenador(entrenador);
        setEjercicios(ejercicios);
    }

    public static final RutinaEntity crear(UUID id, String nombre, EntrenadorEntity entrenador, List<EjercicioEntity> ejercicios) {
        return new RutinaEntity(id, nombre, entrenador, ejercicios);
    }

    private final void setId(UUID id) {
        this.id = id;
    }

    private final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private final void setEntrenador(EntrenadorEntity entrenador) {
        this.entrenador = entrenador;
    }

    private final void setEjercicios(List<EjercicioEntity> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public final UUID getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final EntrenadorEntity getEntrenador() {
        return entrenador;
    }

    public final List<EjercicioEntity> getEjercicios() {
        return ejercicios;
    }
}
