package co.edu.uco.gestorgimnasio.service.dto;

import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilUUID;
import co.edu.uco.gestorgimnasio.service.domain.ejercicio.EjercicioDomain;

import java.util.ArrayList;
import java.util.List;

public class RutinaDTO {
    private UUID id;
    private String nombre;
    private EntrenadorDTO entrenador; 
    private List<EjercicioDomain> ejercicios;

    public RutinaDTO() {
        setId(UtilUUID.getDefaultUUID(id));
        setNombre(UtilTexto.VACIO);
        setEntrenador(new EntrenadorDTO()); 
        setEjercicios(new ArrayList<EjercicioDomain>());
    }
    
    public RutinaDTO(UUID id, String nombre, EntrenadorDTO entrenador, List<EjercicioDomain> ejercicios) { // Modificamos el constructor
        setId(id);
        setNombre(nombre);
        setEntrenador(entrenador);
        setEjercicios(ejercicios);
    }
	
    public static final RutinaDTO crear() {
        return new RutinaDTO();
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EjercicioDomain> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<EjercicioDomain> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public EntrenadorDTO getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(EntrenadorDTO entrenador) {
        this.entrenador = entrenador;
    }
}

