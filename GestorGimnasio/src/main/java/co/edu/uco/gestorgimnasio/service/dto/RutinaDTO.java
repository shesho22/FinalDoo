package co.edu.uco.gestorgimnasio.service.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilUUID;

public class RutinaDTO {
    private UUID id;
    private String nombre;
    private EntrenadorDTO entrenador;
    private List<EjercicioDTO> ejercicios;

    public RutinaDTO() {
        setId(UtilUUID.getDefaultUUID(id));
        setNombre(UtilTexto.VACIO);
        setEntrenador(new EntrenadorDTO());
        setEjercicios(new ArrayList<>());
    }

    public RutinaDTO(UUID id, String nombre, EntrenadorDTO entrenador, List<EjercicioDTO> list) { // Modificamos el constructor
        setId(id);
        setNombre(nombre);
        setEntrenador(entrenador);
        setEjercicios(list);
    }

    public static final RutinaDTO crear(UUID id, String nombre, EntrenadorDTO entrenadorEntity, List<EjercicioDTO> list) {
        return new RutinaDTO(id,nombre,entrenadorEntity,list);
    }
    
    public static final RutinaDTO crear() {
        return new RutinaDTO();
    }

    public UUID getId() {
        return id;
    }

    public RutinaDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public RutinaDTO setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public List<EjercicioDTO> getEjercicios() {
        return ejercicios;
    }

    public final RutinaDTO setEjercicios(List<EjercicioDTO> ejercicios) {
        this.ejercicios = ejercicios;
        return this;
    }

    public EntrenadorDTO getEntrenador() {
        return entrenador;
    }

    public RutinaDTO setEntrenador(EntrenadorDTO entrenador) {
        this.entrenador = entrenador;
        return this;
    }
    

}

