package co.edu.uco.gestorgimnasio.data.dao.daofactory.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.DataGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;
import co.edu.uco.gestorgimnasio.data.dao.EjercicioDAO;
import co.edu.uco.gestorgimnasio.data.dao.base.SQLDAO;
import co.edu.uco.gestorgimnasio.data.entity.EjercicioEntity;


public final class EjercicioSQLServerDAO extends SQLDAO implements EjercicioDAO {

	public EjercicioSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final EjercicioEntity entity) {
		final var sentencia = new StringBuilder();

		sentencia.append("INSERT INTO ejercicio (id, nombre, descripcion, series, repeticiones)");
		sentencia.append("VALUES (?, ?, ?, ?,?)");

		try (final var sentenciaPreparada =getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1,entity.getId());
			sentenciaPreparada.setObject(2,entity.getNombre());
			sentenciaPreparada.setObject(3,entity.getDescripcion());
			sentenciaPreparada.setObject(4,entity.getSeries());
			sentenciaPreparada.setObject(5,entity.getRepeticiones());
			sentenciaPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			var mensajeUsuario ="Se ha presentado un problema tratando de registrar la informacion del nuevo ejercicio...";
			var mensajeTecnico ="Se ha presentado un problema de tipo SQLException en el metodo crear de la clase EjercicioSQLServerDAO tratando de llevar a cabo el registro del nuevo ejercicio. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario ="Se ha presentado un problema tratando de registrar la informacion del  nuevo ejercicio...";
			var mensajeTecnico ="Se ha presentado un problema inesperado de tipo Exception en el metodo crear de la clase EjercicioSQLServerDAO tratando de llevar a cabo el registro del nuevo ejercicio. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}

	@Override
	public final void modificar(final EjercicioEntity entity) {
	    final var sentencia = new StringBuilder();
	    sentencia.append("UPDATE ejercicio SET codigo = ?, nombre = ?, descripcion = ?, series =?, repeticiones =?  WHERE id = ?");

	    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1,entity.getId());
			sentenciaPreparada.setObject(2,entity.getNombre());
			sentenciaPreparada.setObject(3,entity.getDescripcion());
			sentenciaPreparada.setObject(4,entity.getSeries());
			sentenciaPreparada.setObject(5,entity.getRepeticiones());

	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del ejercicio...";
	        var mensajeTécnico = "Se ha presentado un problema de tipo SQLException en el método modificar de la clase EjercicioSQLServerDAO tratando de llevar a cabo la modificación el ejercicio. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del tipo de identificación...";
	        var mensajeTécnico = "Se ha presentado un problema inesperado de tipo Exception en el método modificar de la clase EjercicioSQLServerDAO tratando de llevar a cabo la modificación el ejercicio. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    }
	}

	@Override
	public final void eliminar(final UUID id) {
	    final var sentencia = new StringBuilder();
	    sentencia.append("DELETE FROM ejercicio WHERE id = ?");

	    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
	        sentenciaPreparada.setObject(1, id);
	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del ejercicio...";
	        var mensajeTécnico = "Se ha presentado un problema de tipo SQLException en el método eliminar de la clase EjercicioSQLServerDAO tratando de eliminar el ejercicio. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del tipo de identificación...";
	        var mensajeTécnico = "Se ha presentado un problema inesperado de tipo Exception en el método eliminar de la clase EjercicioSQLServerDAO tratando de eliminar el ejercicio. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    }
	}

	@Override
	public final Optional<EjercicioEntity> consultarPorId(final UUID id) {

		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id, nombre, descripcion, series, repeticiones ");
		sentencia.append("FROM ejercicio ");
		sentencia.append("WHERE id = ? ");

		Optional<EjercicioEntity> resultado = Optional.empty();

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){

			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
		}catch (final DataGestorGimnasioException exception) {
			throw exception;
		}catch(final SQLException excepcion) {
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del ejercicio por el identificador deceado...";
			var mensajeTecnico ="Se ha presentado un problema de tipo SQLException en el metodo consultarPorId de la clase EjercicioSQLServerDAO tratando de preparar la sentencia SQL de la consulta del ejercicio deseado. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deceado...";
			var mensajeTecnico ="Se ha presentado un problema inesperado de tipo Exception en el metodo consultarPorId de la clase EjercicioSQLServerDAO tratando de preparar la sentencia SQL de la consulta del ejercicio deseado. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		return resultado;
	}



	private Optional<EjercicioEntity>  ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada) {
		Optional<EjercicioEntity> resultado = Optional.empty();

		try (final var resultados = sentenciaPreparada.executeQuery()){
			if (resultados.next()) {
				var tipoIdentificacionEntity = EjercicioEntity.crear(UUID.fromString(resultados.getObject("id").toString()), resultados.getString("nombre"), resultados.getString("descripcion"), resultados.getString("series"), resultados.getString("repeticiones"));
				resultado = Optional.of(tipoIdentificacionEntity);
			}
		}catch (final SQLException excepcion){
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deceado...";
			var mensajeTecnico ="Se ha presentado un problema de tipo SQLException en el metodo consultarPorId de la clase EjercicioSQLServer tratando de recuperar los datos de la consulta del tipo identificacion deseado. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch (final Exception excepcion){
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deceado...";
			var mensajeTecnico ="Se ha presentado un problema inesperado de tipo Exception en el metodo consultarPorId de la clase EjercicioSQLServer tratando de recuperar los datos de la consulta del tipo identificacion deseado. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		return resultado;
	}

	private final String formarSentenciaConsulta(final EjercicioEntity entity, final List<Object> parametros) {

		final StringBuilder sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";

		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM TipoIdentificacion ");
		if(!UtilObjeto.esNulo(entity)) {
			if(!UtilObjeto.esNulo(entity.getId())) {
				sentencia.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getId());
			}
			if(!UtilTexto.estaVacio(entity.getNombre())) {
				sentencia.append(operadorCondicional).append(" nombre = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getNombre());
			}
			if(!UtilTexto.estaVacio(entity.getDescripcion())) {
				sentencia.append(operadorCondicional).append(" descripcion = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getDescripcion());
			}
			if(!UtilTexto.estaVacio(entity.getSeries())) {
				sentencia.append(operadorCondicional).append(" series = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getSeries());
			}
			if(!UtilTexto.estaVacio(entity.getRepeticiones())) {
				sentencia.append(operadorCondicional).append(" repeticiones = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getRepeticiones());
			}
		}
		sentencia.append("ORDER BY codigo ASC ");
		return sentencia.toString();
	}

	@Override
	public final List<EjercicioEntity> consultar (final EjercicioEntity entity) {
		final var parametros = new ArrayList<>();

		final String sentencia = formarSentenciaConsulta(entity, parametros);

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia)){
			colocarParametrosConsulta(sentenciaPreparada,parametros);
			return ejecutarConaulta(sentenciaPreparada);

		}catch (final DataGestorGimnasioException excepcion) {
			throw excepcion;
		}
		catch (final SQLException excepcion) {
			var mensajeUsuario ="Se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de identificacion...";
			var mensajeTecnico ="Se ha presentado un problema  en el metodo colocar parametros consulta en la clase EjercicioSQLServer tratando de preparar la sentencia sql. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario ="Se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de identificacion...";
			var mensajeTecnico ="Se ha presentado un problema inesperado de tipo exception tratando de preparar la sentencia sql. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}

	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
		try {
			for (int  indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
			}catch (final SQLException excepcion) {
				var mensajeUsuario ="Se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de identificacion...";
				var mensajeTecnico ="Se ha presentado un problema  en el metodo colocar parametros consulta en la clase EjercicioSQLServer. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
				throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
			}catch (final Exception excepcion) {
				var mensajeUsuario ="Se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de identificacion...";
				var mensajeTecnico ="Se ha presentado un inesperado  en el metodo colocar parametros consulta en la clase EjercicioSQLServer. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
				throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
			}
		}

	private final List<EjercicioEntity>ejecutarConaulta(final PreparedStatement sentenciaPreparada){
		final var listaResultados = new ArrayList<EjercicioEntity>();

		try (final var resultados = sentenciaPreparada.executeQuery()){
			while (resultados.next()) {
				var ejercicioEntity = EjercicioEntity.crear(UUID.fromString(resultados.getObject("id").toString()), resultados.getString("nombre"), resultados.getString("descripcion"), resultados.getString("series"), resultados.getString("repeticiones"));
				listaResultados.add(ejercicioEntity);
			}
		}catch (final SQLException excepcion){
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del ejercicio por el identificador deceado...";
			var mensajeTecnico ="Se ha presentado un problema de tipo SQLException en el metodo consultarPorId de la clase EjercicioSQLServer tratando de recuperar los datos de la consulta del tipo identificacion deseado. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch (final Exception excepcion){
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deceado...";
			var mensajeTecnico ="Se ha presentado un problema inesperado de tipo Exception en el metodo consultarPorId de la clase EjercicioSQLServer tratando de recuperar los datos de la consulta del tipo identificacion deseado. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		return listaResultados;
	}
}



