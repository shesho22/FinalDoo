package co.edu.uco.gestorgimnasio.service.domain.rutina;

import java.util.List;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.service.domain.ejercicio.EjercicioDomain;
import co.edu.uco.gestorgimnasio.service.domain.entrenador.EntrenadorDomain;



public class RutinaDomain {
    private UUID id;
    private String nombre;
    private EntrenadorDomain entrenador;
    private List<EjercicioDomain> ejercicios;

    public RutinaDomain(UUID id, String nombre, EntrenadorDomain entrenador, List<EjercicioDomain> ejercicios) { // Modificamos el constructor
        setId(id);
        setNombre(nombre);
        setEntrenador(entrenador);
        setEjercicios(ejercicios);
    }

    public static final RutinaDomain crear(UUID id, String nombre, EntrenadorDomain entrenador, List<EjercicioDomain> ejercicios) {
        return new RutinaDomain(id, nombre, entrenador, ejercicios);
    }

    public final UUID getId() {
        return id;
    }

    public final RutinaDomain setId(UUID id) {
        this.id = id;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final RutinaDomain setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public final EntrenadorDomain getEntrenador() {
        return entrenador;
    }

    public final RutinaDomain setEntrenador(EntrenadorDomain entrenador) {
        this.entrenador = entrenador;
        return this;
    }

    public final List<EjercicioDomain> getEjercicios() {
        return ejercicios;
    }

    public final RutinaDomain setEjercicios(List<EjercicioDomain> ejercicios) {
        this.ejercicios = ejercicios;
        return this;
    }
}


