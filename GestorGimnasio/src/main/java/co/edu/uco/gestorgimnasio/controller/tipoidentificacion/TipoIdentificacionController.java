package co.edu.uco.gestorgimnasio.controller.tipoidentificacion;

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
import co.edu.uco.gestorgimnasio.service.dto.TipoIdentificacionDTO;
import co.edu.uco.gestorgimnasio.service.facade.concrete.tipoidentificacion.RegistrarTipoIdentificacionFacade;

@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public final class TipoIdentificacionController {
	
	
	@GetMapping("/saludo")
	public String saludo() {
		return "hola";
	}
	
	@GetMapping("/dummy")
	public final TipoIdentificacionDTO obtenerDummy() {
		return TipoIdentificacionDTO.crear();
	}
	
	@GetMapping
	public final TipoIdentificacionDTO consultar(@RequestBody TipoIdentificacionDTO dto) {
		return dto;
	}
	
	@GetMapping("/{id}")
	public final UUID consiltarPorId(@PathVariable("id")UUID id) {
		return id;
	}
	
	
	@PostMapping
	public final TipoIdentificacionDTO registrar(@RequestBody TipoIdentificacionDTO dto) {
		Respuesta<TipoIdentificacionDTO> respuesta =new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		try {
			RegistrarTipoIdentificacionFacade facade = new RegistrarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El tipo de identificacion fue registrado existosamente...");
		} catch (final GestorGimnasioException exception) {
			respuesta.getMensajes().add(exception.getMensajeUsuario());
			System.err.println(exception.getMensajeTecnico());
			System.err.println(exception.getLugar());
			exception.getExcepcionRaiz().printStackTrace();
			// TODO: handle exception
		}catch (final Exception exception) {
			respuesta.getMensajes().add("Se ha presentado un problema inesperado tratando de registrar el tipo identificacion");
			exception.printStackTrace();
			// TODO: handle exception
		}
		
		return dto;
	}
	
	@PutMapping
	public final TipoIdentificacionDTO modificar(@PathVariable("id") UUID id,@RequestBody TipoIdentificacionDTO dto) {
		dto.setId(id);
		return dto;
	}
	

	@DeleteMapping ("/{id}")
	public final UUID eliminar(@PathVariable("id")UUID id) {
		return id;
	}
	
}
