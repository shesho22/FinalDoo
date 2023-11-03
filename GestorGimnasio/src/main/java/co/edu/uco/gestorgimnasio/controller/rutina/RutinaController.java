package co.edu.uco.gestorgimnasio.controller.rutina;

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
import co.edu.uco.gestorgimnasio.data.dao.RutinaDAO;
import co.edu.uco.gestorgimnasio.service.dto.RutinaDTO;
import co.edu.uco.gestorgimnasio.service.facade.concrete.rutina.RegistrarRutinaFacade;

@RestController
@RequestMapping("/api/v1/rutina")
public final class RutinaController {
	
	
	@GetMapping("/dummy")
	public final RutinaDTO obtenerDummy() {
		return RutinaDTO.crear();
	}
	
	@GetMapping
	public final RutinaDAO consultar(@RequestBody RutinaDTO dto) {
		return (RutinaDAO) dto;
	}
	@GetMapping("/{id}")
	public final UUID consiltarPorId(@PathVariable("id")UUID id) {
		return id;
	}
	
	
	@PostMapping
	public final RutinaDTO registrar(@RequestBody RutinaDTO dto) {
		Respuesta<RutinaDTO> respuesta =new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		try {
			RegistrarRutinaFacade facade = new RegistrarRutinaFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("La rutina fue registrado existosamente...");
		} catch (final GestorGimnasioException exception) {
			respuesta.getMensajes().add(exception.getMensajeUsuario());
			System.err.println(exception.getMensajeTecnico());
			System.err.println(exception.getLugar());
			exception.getExcepcionRaiz().printStackTrace();
			// TODO: handle exception
		}catch (final Exception exception) {
			respuesta.getMensajes().add("Se ha presentado un problema inesperado tratando de registrar la rutina");
			exception.printStackTrace();
			// TODO: handle exception
		}
		
		return dto;
	}
	
	@PutMapping
	public final RutinaDTO modificar(@PathVariable("id") UUID id,@RequestBody RutinaDTO dto) {
		dto.setId(id);
		return dto;
	}
	

	@DeleteMapping ("/{id}")
	public final UUID eliminar(@PathVariable("id")UUID id) {
		return id;
	}
	
}
