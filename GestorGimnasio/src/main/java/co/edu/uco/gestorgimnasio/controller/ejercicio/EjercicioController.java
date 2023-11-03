package co.edu.uco.gestorgimnasio.controller.ejercicio;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.gestorgimnasio.controller.support.response.Respuesta;
import co.edu.uco.gestorgimnasio.crosscutting.exception.GestorGimnasioException;
import co.edu.uco.gestorgimnasio.data.dao.EjercicioDAO;
import co.edu.uco.gestorgimnasio.data.dao.EntrenadorDAO;
import co.edu.uco.gestorgimnasio.service.dto.EjercicioDTO;
import co.edu.uco.gestorgimnasio.service.dto.EntrenadorDTO;
import co.edu.uco.gestorgimnasio.service.dto.TipoIdentificacionDTO;
import co.edu.uco.gestorgimnasio.service.facade.concrete.ejercicio.RegistrarEjercicioFacade;
import co.edu.uco.gestorgimnasio.service.facade.concrete.entrenador.RegistrarEntrenadorFacade;

@RestController
@RequestMapping("/api/v1/ejercicio")
public final class EjercicioController {
	
	
	@GetMapping("/dummy")
	public final EjercicioDTO obtenerDummy() {
		return EjercicioDTO.crear();
	}
	
	@GetMapping
	public final EjercicioDAO consultar(@RequestBody EjercicioDTO dto) {
		return (EjercicioDAO) dto;
	}
	@GetMapping("/{id}")
	public final UUID consiltarPorId(@PathVariable("id")UUID id) {
		return id;
	}
	
	
	@PostMapping
	public final EjercicioDTO registrar(@RequestBody EjercicioDTO dto) {
		Respuesta<EjercicioDTO> respuesta =new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		try {
			RegistrarEjercicioFacade facade = new RegistrarEjercicioFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El ejercicio fue registrado existosamente...");
		} catch (final GestorGimnasioException exception) {
			respuesta.getMensajes().add(exception.getMensajeUsuario());
			System.err.println(exception.getMensajeTecnico());
			System.err.println(exception.getLugar());
			exception.getExcepcionRaiz().printStackTrace();
			// TODO: handle exception
		}catch (final Exception exception) {
			respuesta.getMensajes().add("Se ha presentado un problema inesperado tratando de registrar el ejercicio");
			exception.printStackTrace();
			// TODO: handle exception
		}
		
		return dto;
	}
	
	@PutMapping
	public final EjercicioDTO modificar(@PathVariable("id") UUID id,@RequestBody EjercicioDTO dto) {
		dto.setId(id);
		return dto;
	}
	

	@DeleteMapping ("/{id}")
	public final UUID eliminar(@PathVariable("id")UUID id) {
		return id;
	}
	
}
