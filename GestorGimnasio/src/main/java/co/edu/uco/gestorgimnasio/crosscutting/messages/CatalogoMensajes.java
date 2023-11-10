package co.edu.uco.gestorgimnasio.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.CrossCuttingGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CategoriaMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.TipoMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;

public final class CatalogoMensajes {
	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<>();

	static {
		cargarMensajes();
	}

	private CatalogoMensajes() {
		super();
	}

	private static final void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000001, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,"No se recibio el codigo del mensaje que se queria crear. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,"No se existe un mensaje con el codigo indicado. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000003, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,"No es posible obtener un mensaje con un codigo vacio o nulo. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000004, TipoMensaje.USUARIO, CategoriaMensaje.FATAL,"Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000005, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problrma tratando de validar si la conexion sql estaba abierta. Se presento una excepcion de tipo sqlexception."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000006, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de validar si la xonexion sql estaba abierta. se presento una excepcion completa del error presentado, por favor verifique la traza completa del error presentado."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000007, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000008, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000009, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000010, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000011, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000012, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000013, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000014, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000015, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000016, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000017, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000018, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000019, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000020, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000021, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000022, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000023, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000024, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000025, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000026, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000027, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000028, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000029, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000030, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000031, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000032, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000033, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000034, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000035, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000036, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000037, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000038, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000039, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000040, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000041, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000042, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000043, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000044, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000045, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000046, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000047, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000048, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000049, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000050, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000051, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000052, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000053, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000054, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000055, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000056, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000057, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000058, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000059, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));

	}

	private static final void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}

	public static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		if(UtilObjeto.esNulo(codigo)) {
			var mensajeUsuario= obtenerMensaje(CodigoMensaje.M0000000004).getContenido();
			var mensajeTecnico= obtenerMensaje(CodigoMensaje.M0000000003).getContenido();
			throw CrossCuttingGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		if(!MENSAJES.containsKey(codigo)) {
			var mensajeUsuario= obtenerMensaje(CodigoMensaje.M0000000004).getContenido();
			var mensajeTecnico= obtenerMensaje(CodigoMensaje.M0000000002).getContenido();
			throw CrossCuttingGestorGimnasioException.crear(mensajeUsuario,mensajeTecnico);
		}
		return MENSAJES.get(codigo);
	}

	public static final String obtenerContenidoMensaje(final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}
}
