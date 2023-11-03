package co.edu.uco.gestorgimnasio.data.dao.daofactory;


import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.CrossCuttingGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.gestorgimnasio.data.dao.EjercicioDAO;
import co.edu.uco.gestorgimnasio.data.dao.EntrenadorDAO;
import co.edu.uco.gestorgimnasio.data.dao.RutinaDAO;
import co.edu.uco.gestorgimnasio.data.dao.TipoIdentificacionDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.concrete.SQLServerDAOFactory;

public abstract class DAOFactory {

	public static final DAOFactory obtenerDAOFactory(final TipoDAOFactory factoria) {

		switch (factoria) {
		case SQLSERVER: {
			return new SQLServerDAOFactory();
		}
		case POSTGRESQL: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000029);
			throw CrossCuttingGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
		}
		case MYSQL: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000030);
			throw CrossCuttingGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
		}
		case ORACLE: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000031);
			throw CrossCuttingGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
		}
		default:
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000032);
			throw CrossCuttingGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
		}
	}

	protected abstract void abrirConexion();

	public abstract void cerrarConexion();

	public abstract void iniciarTransaccion();

	public abstract void confirmarTransaccion();

	public abstract void cancelarTransaccion();

	public abstract EntrenadorDAO obtenerEntrenadorDAO();

	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDAO();
	
	public abstract EjercicioDAO obtenerEjercicioDAO();
	
	public abstract RutinaDAO obtenerRutinaDAO();
}