package co.edu.uco.gestorgimnasio.service.dto;

import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilUUID;


public class EjercicioDTO {
    private UUID id;
    private String nombre;
    private String descripcion;
    private String series;
    private String repeticiones;

    public EjercicioDTO() {
        setId(UtilUUID.getDefaultUUID(id));
        setNombre(UtilTexto.VACIO);
        setDescripcion(UtilTexto.VACIO);
        setSeries(UtilTexto.VACIO);
        setRepeticiones(UtilTexto.VACIO);
    }

    public EjercicioDTO(UUID id, String nombre, String descripcion, String series, String repeticiones) {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setSeries(series);
        setRepeticiones(repeticiones);
    }


	public static final EjercicioDTO crear(UUID uuid, String string, String string2, String string3, String string4) {
		return new EjercicioDTO(uuid,string,string2,string3,string4);
	}
	
	public static final EjercicioDTO crear() {
		return new EjercicioDTO();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(String repeticiones) {
        this.repeticiones = repeticiones;
    }
}

