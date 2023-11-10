package co.edu.uco.gestorgimnasio.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.CrossCuttingGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.DataGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.gestorgimnasio.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilSQL;
import co.edu.uco.gestorgimnasio.data.dao.EjercicioDAO;
import co.edu.uco.gestorgimnasio.data.dao.EntrenadorDAO;
import co.edu.uco.gestorgimnasio.data.dao.RutinaDAO;
import co.edu.uco.gestorgimnasio.data.dao.TipoIdentificacionDAO;
import co.edu.uco.gestorgimnasio.data.dao.concrete.sqlserver.EjercicioSQLServerDAO;
import co.edu.uco.gestorgimnasio.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.concrete.sqlserver.EntrenadorSQLServerDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.concrete.sqlserver.RutinaSQLServerDAO;

public final class SQLServerDAOFactory extends DAOFactory {

	private Connection conexion;

	public SQLServerDAOFactory() {
		abrirConexion();
	}

	@Override
	protected final void abrirConexion() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexion = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-HOC0KMM:1433;databaseName=GestorGimnasio;trustServerCertificate=true;encrypt=true;","sa","12345");
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000027);
			throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000028);
			throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public final void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}

	@Override
	public final void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	@Override
	public final void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	@Override
	public final void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
	}

	@Override
	public final EntrenadorDAO obtenerEntrenadorDAO() {

		if (!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000033);
			throw CrossCuttingGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
		}

		return new EntrenadorSQLServerDAO(conexion);
	}

	@Override
	public final TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {

		if (!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000034);
			throw CrossCuttingGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
		}

		return new TipoIdentificacionSQLServerDAO(conexion);
	}

	@Override
	public EjercicioDAO obtenerEjercicioDAO() {
		if (!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000033);
			throw CrossCuttingGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
		}

		return new EjercicioSQLServerDAO(conexion);
	}

	@Override
	public RutinaDAO obtenerRutinaDAO() {
		if (!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000000034);
			throw CrossCuttingGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
		}

		return new RutinaSQLServerDAO(conexion);
	}
}
