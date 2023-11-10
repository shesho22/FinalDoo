package co.edu.uco.gestorgimnasio.data.dao.daofactory.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.DataGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;
import co.edu.uco.gestorgimnasio.data.dao.EntrenadorDAO;
import co.edu.uco.gestorgimnasio.data.dao.base.SQLDAO;
import co.edu.uco.gestorgimnasio.data.entity.EntrenadorEntity;
import co.edu.uco.gestorgimnasio.data.entity.TipoIdentificacionEntity;
import co.edu.uco.gestorgimnasio.data.entity.support.CorreoElectronicoEntrenadorEntity;
import co.edu.uco.gestorgimnasio.data.entity.support.NombreCompletoEntrenadorEntity;
import co.edu.uco.gestorgimnasio.data.entity.support.NumeroTelefonoMovilEntrenadorEntity;

public final class EntrenadorSQLServerDAO extends SQLDAO implements EntrenadorDAO {

	public EntrenadorSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final EntrenadorEntity entity) {
		final var sentencia = new StringBuilder();

		sentencia.append("INSERT INTO entrenador (id, tipodoc_id, identificacion, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, correo_electronico, correo_validado, numero_telefono, telefono_validado, fecha_nacimiento)\r\n"
				+ "");
		sentencia.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		try (final var sentenciaPreparada =getConexion().prepareStatement(sentencia.toString())){
			sentenciaPreparada.setObject(1,entity.getId());
			sentenciaPreparada.setObject(2,entity.getTipoidentificacion());
			sentenciaPreparada.setObject(3,entity.getIdentificacion());
			sentenciaPreparada.setObject(4,entity.getNombreCompleto().getSegundoNombre());
			sentenciaPreparada.setObject(5,entity.getNombreCompleto().getSegundoNombre());
			sentenciaPreparada.setObject(6,entity.getNombreCompleto().getPrimerApellido());
			sentenciaPreparada.setObject(7,entity.getNombreCompleto().getSegundoApellido());
			sentenciaPreparada.setObject(8,entity.getCorreoElectornico().getCorreoElectronico());
			sentenciaPreparada.setObject(9,entity.getCorreoElectornico().isCorreoElectronicoConfirmado());
			sentenciaPreparada.setObject(10,entity.getNumeroTelefonoMovil().getNumeroTelefonoMovil());
			sentenciaPreparada.setObject(11,entity.getNumeroTelefonoMovil().isNumeroTelefonoMovilConfirmado());
			sentenciaPreparada.setObject(12,entity.getFechaNacimiento());
			sentenciaPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			var mensajeUsuario ="Se ha presentado un problema tratando de registrar la informacion del nuevo tipo de identificacion...";
			var mensajeTecnico ="Se ha presentado un problema de tipo SQLException en el metodo crear de la clase TipoIdentificacionSQLServer tratando de llevar a cabo el registro del nuevo tipo de identificacion. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario ="Se ha presentado un problema tratando de registrar la informacion del nuevo tipo de identificacion...";
			var mensajeTecnico ="Se ha presentado un problema inesperado de tipo Exception en el metodo crear de la clase TipoIdentificacionSQLServer tratando de llevar a cabo el registro del nuevo tipo de identificacion. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}

	@Override
	public final void modificar(final EntrenadorEntity entity) {
	    final var sentencia = new StringBuilder();
	    sentencia.append("UPDATE entrenador SET tipodoc_id = ?, identificacion = ?, primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, correo_electronico = ?, correo_validado = ?, numero_telefono = ?, telefono_validado = ?, fecha_nacimiento = ? WHERE id = ?");


	    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1,entity.getTipoidentificacion());
			sentenciaPreparada.setObject(2,entity.getIdentificacion());
			sentenciaPreparada.setObject(3,entity.getNombreCompleto().getSegundoNombre());
			sentenciaPreparada.setObject(4,entity.getNombreCompleto().getSegundoNombre());
			sentenciaPreparada.setObject(5,entity.getNombreCompleto().getPrimerApellido());
			sentenciaPreparada.setObject(6,entity.getNombreCompleto().getSegundoApellido());
			sentenciaPreparada.setObject(7,entity.getCorreoElectornico().getCorreoElectronico());
			sentenciaPreparada.setObject(8,entity.getCorreoElectornico().isCorreoElectronicoConfirmado());
			sentenciaPreparada.setObject(9,entity.getNumeroTelefonoMovil().getNumeroTelefonoMovil());
			sentenciaPreparada.setObject(10,entity.getNumeroTelefonoMovil().isNumeroTelefonoMovilConfirmado());
			sentenciaPreparada.setObject(11,entity.getFechaNacimiento());
	        sentenciaPreparada.setObject(12, entity.getId());

	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del tipo de identificación...";
	        var mensajeTécnico = "Se ha presentado un problema de tipo SQLException en el método modificar de la clase TipoIdentificacionSQLServer tratando de llevar a cabo la modificación del tipo de identificación. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del tipo de identificación...";
	        var mensajeTécnico = "Se ha presentado un problema inesperado de tipo Exception en el método modificar de la clase TipoIdentificacionSQLServer tratando de llevar a cabo la modificación del tipo de identificación. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    }
	}

	@Override
	public final void eliminar(final UUID id) {
	    final var sentencia = new StringBuilder();
	    sentencia.append("DELETE FROM TipoIdentificacion WHERE id = ?");

	    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
	        sentenciaPreparada.setObject(1, id);
	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del tipo de identificación...";
	        var mensajeTécnico = "Se ha presentado un problema de tipo SQLException en el método eliminar de la clase TipoIdentificacionSQLServer tratando de eliminar el tipo de identificación. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del tipo de identificación...";
	        var mensajeTécnico = "Se ha presentado un problema inesperado de tipo Exception en el método eliminar de la clase TipoIdentificacionSQLServer tratando de eliminar el tipo de identificación. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    }
	}

	@Override
	public final Optional<EntrenadorEntity> consultarPorId(final UUID id) {

		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM TipoIdentificacion ");
		sentencia.append("WHERE id = ? ");

		Optional<EntrenadorEntity> resultado = Optional.empty();

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){

			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
		}catch (final DataGestorGimnasioException exception) {
			throw exception;
		}catch(final SQLException excepcion) {
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deceado...";
			var mensajeTecnico ="Se ha presentado un problema de tipo SQLException en el metodo consultarPorId de la clase TipoIdentificacionSQLServer tratando de preparar la sentencia SQL de la consulta del tipo identificacion deseado. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deceado...";
			var mensajeTecnico ="Se ha presentado un problema inesperado de tipo Exception en el metodo consultarPorId de la clase TipoIdentificacionSQLServer tratando de preparar la sentencia SQL de la consulta del tipo identificacion deseado. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		return resultado;
	}


	private Optional<EntrenadorEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada) {
	    Optional<EntrenadorEntity> resultado = Optional.empty();

	    try (final var resultados = sentenciaPreparada.executeQuery()) {
	        if (resultados.next()) {
	            Date sqlDate = resultados.getDate("fecha_nacimiento");
	            Instant instant = sqlDate.toInstant();
	            LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

	            EntrenadorEntity entrenadorEntity = EntrenadorEntity.crear(
	                UUID.fromString(resultados.getObject("id").toString()),
	                TipoIdentificacionEntity.fromString(resultados.getString("tipodoc_id")),
	                resultados.getString("identificacion"),
	                NombreCompletoEntrenadorEntity.fromString(resultados.getString("primer_nombre") + "," + resultados.getString("segundo_nombre") + "," + resultados.getString("primer_apellido") + "," + resultados.getString("segundo_apellido")),
	                CorreoElectronicoEntrenadorEntity.fromString(resultados.getString("correo_electronico") + "," + resultados.getBoolean("correo_validado")),
	                NumeroTelefonoMovilEntrenadorEntity.fromString(resultados.getString("numero_telefono") + "," + resultados.getBoolean("telefono_validado")),
	                localDate);
	            resultado = Optional.of(entrenadorEntity);
	        }
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información del entrenador por el identificador deseado...";
	        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método consultarPorId de la clase TipoIdentificacionSQLServer tratando de recuperar los datos de la consulta del entrenador deseado. Por favor, revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información del entrenador por el identificador deseado...";
	        var mensajeTecnico = "Se ha presentado un problema inesperado de tipo Exception en el método consultarPorId de la clase TipoIdentificacionSQLServer tratando de recuperar los datos de la consulta del entrenador deseado. Por favor, revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }
	    return resultado;
	}




	private final String formarSentenciaConsulta(final EntrenadorEntity entity, final List<Object> parametros) {
	    final StringBuilder sentencia = new StringBuilder();
	    String operadorCondicional = "WHERE";

	    sentencia.append("SELECT id, tipodoc_id, identificacion, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, correo_electronico, correo_validado, numero_telefono, telefono_validado, fecha_nacimiento ");
	    sentencia.append("FROM entrenador ");

	    if (!UtilObjeto.esNulo(entity)) {
	        if (!UtilObjeto.esNulo(entity.getId())) {
	            sentencia.append(operadorCondicional).append("id = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getId());
	        }
	        if (!UtilObjeto.esNulo(entity.getId())) {
	            sentencia.append(operadorCondicional).append("tipodoc_id = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getTipoidentificacion());
	        }
	        if (!UtilTexto.estaVacio(entity.getIdentificacion())) {
	            sentencia.append(operadorCondicional).append("identificacion = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getIdentificacion());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompleto().getPrimerNombre())) {
	            sentencia.append(operadorCondicional).append("primer_nombre = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompleto().getPrimerNombre());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompleto().getSegundoNombre())) {
	            sentencia.append(operadorCondicional).append("segundo_nombre = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompleto().getSegundoNombre());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompleto().getPrimerApellido())) {
	            sentencia.append(operadorCondicional).append("primer_apellido = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompleto().getPrimerApellido());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompleto().getSegundoApellido())) {
	            sentencia.append(operadorCondicional).append("segundo_apellido = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompleto().getSegundoApellido());
	        }
	        if (!UtilTexto.estaVacio(entity.getCorreoElectornico().getCorreoElectronico())) {
	            sentencia.append(operadorCondicional).append("correo_electronico = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getCorreoElectornico().getCorreoElectronico());
	        }
	        if (!UtilObjeto.esNulo(entity.getCorreoElectornico())) {
	            sentencia.append(operadorCondicional).append("correo_validado = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getCorreoElectornico().isCorreoElectronicoConfirmado());
	        }
	        if (!UtilTexto.estaVacio(entity.getNumeroTelefonoMovil().getNumeroTelefonoMovil())) {
	            sentencia.append(operadorCondicional).append("numero_telefono = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNumeroTelefonoMovil().getNumeroTelefonoMovil());
	        }
	        if (!UtilObjeto.esNulo(entity.getCorreoElectornico())) {
	            sentencia.append(operadorCondicional).append("telefono_validado = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNumeroTelefonoMovil().isNumeroTelefonoMovilConfirmado());
	        }
	        if (!UtilObjeto.esNulo(entity.getFechaNacimiento())) {
	            sentencia.append(operadorCondicional).append("fecha_nacimiento = ? ");
	            parametros.add(entity.getFechaNacimiento());
	        }
	    }
	    sentencia.append("ORDER BY id ASC ");
	    return sentencia.toString();
	}


	@Override
	public final List<EntrenadorEntity> consultar (final EntrenadorEntity entity) {
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
			var mensajeTecnico ="Se ha presentado un problema  en el metodo colocar parametros consulta en la clase TipoIdentificacionSQLServerDAO tratando de preparar la sentencia sql. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
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
				var mensajeTecnico ="Se ha presentado un problema  en el metodo colocar parametros consulta en la clase TipoIdentificacionSQLServerDAO. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
				throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
			}catch (final Exception excepcion) {
				var mensajeUsuario ="Se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de identificacion...";
				var mensajeTecnico ="Se ha presentado un inesperado  en el metodo colocar parametros consulta en la clase TipoIdentificacionSQLServerDAO. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
				throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
			}
		}

	private final List<EntrenadorEntity>ejecutarConaulta(final PreparedStatement sentenciaPreparada){
		final var listaResultados = new ArrayList<EntrenadorEntity>();

		try (final var resultados = sentenciaPreparada.executeQuery()){
			while (resultados.next()) {
	            Date sqlDate = resultados.getDate("fecha_nacimiento");
	            Instant instant = sqlDate.toInstant();
	            LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
	            EntrenadorEntity entrenadorEntity = EntrenadorEntity.crear(
		                UUID.fromString(resultados.getObject("id").toString()),
		                TipoIdentificacionEntity.fromString(resultados.getString("tipodoc_id")),
		                resultados.getString("identificacion"),
		                NombreCompletoEntrenadorEntity.fromString(resultados.getString("primer_nombre") + "," + resultados.getString("segundo_nombre") + "," + resultados.getString("primer_apellido") + "," + resultados.getString("segundo_apellido")),
		                CorreoElectronicoEntrenadorEntity.fromString(resultados.getString("correo_electronico") + "," + resultados.getBoolean("correo_validado")),
		                NumeroTelefonoMovilEntrenadorEntity.fromString(resultados.getString("numero_telefono") + "," + resultados.getBoolean("telefono_validado")),
		                localDate);
				listaResultados.add(entrenadorEntity);
			}
		}catch (final SQLException excepcion){
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deceado...";
			var mensajeTecnico ="Se ha presentado un problema de tipo SQLException en el metodo consultarPorId de la clase TipoIdentificacionSQLServer tratando de recuperar los datos de la consulta del tipo identificacion deseado. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch (final Exception excepcion){
			var mensajeUsuario ="Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deceado...";
			var mensajeTecnico ="Se ha presentado un problema inesperado de tipo Exception en el metodo consultarPorId de la clase TipoIdentificacionSQLServer tratando de recuperar los datos de la consulta del tipo identificacion deseado. por favor revise la trasa completa del problema presentado para asi poder identificar que sucedio...";
			throw DataGestorGimnasioException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		return listaResultados;
	}
}

