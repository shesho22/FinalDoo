package co.edu.uco.gestorgimnasio.data.dao.daofactory.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.DataGestorGimnasioException;
import co.edu.uco.gestorgimnasio.data.dao.RutinaDAO;
import co.edu.uco.gestorgimnasio.data.dao.base.SQLDAO;
import co.edu.uco.gestorgimnasio.data.entity.EjercicioEntity;
import co.edu.uco.gestorgimnasio.data.entity.EntrenadorEntity;
import co.edu.uco.gestorgimnasio.data.entity.RutinaEntity;
import co.edu.uco.gestorgimnasio.data.entity.TipoIdentificacionEntity;
import co.edu.uco.gestorgimnasio.data.entity.support.CorreoElectronicoEntrenadorEntity;
import co.edu.uco.gestorgimnasio.data.entity.support.NombreCompletoEntrenadorEntity;
import co.edu.uco.gestorgimnasio.data.entity.support.NumeroTelefonoMovilEntrenadorEntity;




public final class RutinaSQLServerDAO extends SQLDAO implements RutinaDAO {

	public RutinaSQLServerDAO(final Connection conexion) {
		super(conexion);
	}


	@Override
	public void crear(RutinaEntity rutina, List<EjercicioEntity> ejercicios) {
	    try {
	        // Iniciar una transacción para garantizar la consistencia de la base de datos
	        getConexion().setAutoCommit(false);

	        // Crear la rutina
	        String insertRutinaSQL = "INSERT INTO rutina (id, nombre, entrenador_id) VALUES (?, ?, ?)";
	        try (PreparedStatement insertRutinaStmt = getConexion().prepareStatement(insertRutinaSQL)) {
	            insertRutinaStmt.setObject(1, rutina.getId());
	            insertRutinaStmt.setString(2, rutina.getNombre());
	            insertRutinaStmt.setObject(3, rutina.getEntrenador().getId());
	            insertRutinaStmt.executeUpdate();
	        }

	        // Asociar los ejercicios con la rutina
	        String insertRutinaEjercicioSQL = "INSERT INTO rutina_ejercicio (rutina_id, ejercicio_id) VALUES (?, ?)";
	        try (PreparedStatement insertRutinaEjercicioStmt = getConexion().prepareStatement(insertRutinaEjercicioSQL)) {
	            for (EjercicioEntity ejercicio : ejercicios) {
	                insertRutinaEjercicioStmt.setObject(1, rutina.getId());
	                insertRutinaEjercicioStmt.setObject(2, ejercicio.getId());
	                insertRutinaEjercicioStmt.executeUpdate();
	            }
	        }

	        // Confirmar la transacción
	        getConexion().commit();
	    } catch (SQLException excepcion) {
	        try {
	            // Deshacer la transacción en caso de error
	            getConexion().rollback();
	        } catch (SQLException rollbackExcepcion) {
	            rollbackExcepcion.printStackTrace();
	        }

	        String mensajeUsuario = "Se ha producido un error al crear la rutina y asociar los ejercicios.";
	        String mensajeTecnico = "Se ha producido un error de tipo SQLException al crear la rutina y asociar los ejercicios en la base de datos SQL Server. Revise el registro completo del error para identificar la causa.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (Exception excepcion) {
	        String mensajeUsuario = "Se ha producido un error inesperado al crear la rutina y asociar los ejercicios.";
	        String mensajeTecnico = "Se ha producido un error inesperado al crear la rutina y asociar los ejercicios en la base de datos SQL Server. Revise el registro completo del error para identificar la causa.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } finally {
	        try {
	            // Restaurar la configuración de autocommit a su valor original
	            getConexion().setAutoCommit(true);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	@Override
	public void modificar(RutinaEntity rutina, List<EjercicioEntity> ejercicios) {
	    try {
	        // Iniciar una transacción para garantizar la consistencia de la base de datos
	        getConexion().setAutoCommit(false);

	        // Actualizar la rutina
	        String updateRutinaSQL = "UPDATE rutina SET nombre = ? WHERE id = ?";
	        try (PreparedStatement updateRutinaStmt = getConexion().prepareStatement(updateRutinaSQL)) {
	            updateRutinaStmt.setString(1, rutina.getNombre());
	            updateRutinaStmt.setObject(2, rutina.getId());
	            updateRutinaStmt.executeUpdate();
	        }

	        // Eliminar todas las asociaciones previas de ejercicios con la rutina
	        String deleteRutinaEjercicioSQL = "DELETE FROM rutina_ejercicio WHERE rutina_id = ?";
	        try (PreparedStatement deleteRutinaEjercicioStmt = getConexion().prepareStatement(deleteRutinaEjercicioSQL)) {
	            deleteRutinaEjercicioStmt.setObject(1, rutina.getId());
	            deleteRutinaEjercicioStmt.executeUpdate();
	        }

	        // Asociar los ejercicios actualizados con la rutina
	        String insertRutinaEjercicioSQL = "INSERT INTO rutina_ejercicio (rutina_id, ejercicio_id) VALUES (?, ?)";
	        try (PreparedStatement insertRutinaEjercicioStmt = getConexion().prepareStatement(insertRutinaEjercicioSQL)) {
	            for (EjercicioEntity ejercicio : ejercicios) {
	                insertRutinaEjercicioStmt.setObject(1, rutina.getId());
	                insertRutinaEjercicioStmt.setObject(2, ejercicio.getId());
	                insertRutinaEjercicioStmt.executeUpdate();
	            }
	        }

	        // Confirmar la transacción
	        getConexion().commit();
	    } catch (SQLException excepcion) {
	        try {
	            // Deshacer la transacción en caso de error
	            getConexion().rollback();
	        } catch (SQLException rollbackExcepcion) {
	            rollbackExcepcion.printStackTrace();
	        }

	        String mensajeUsuario = "Se ha producido un error al modificar la rutina y sus asociaciones con ejercicios.";
	        String mensajeTecnico = "Se ha producido un error de tipo SQLException al modificar la rutina y sus asociaciones con ejercicios en la base de datos SQL Server. Revise el registro completo del error para identificar la causa.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (Exception excepcion) {
	        String mensajeUsuario = "Se ha producido un error inesperado al modificar la rutina y sus asociaciones con ejercicios.";
	        String mensajeTecnico = "Se ha producido un error inesperado al modificar la rutina y sus asociaciones con ejercicios en la base de datos SQL Server. Revise el registro completo del error para identificar la causa.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } finally {
	        try {
	            // Restaurar la configuración de autocommit a su valor original
	            getConexion().setAutoCommit(true);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	@Override
	public void eliminar(UUID rutinaId) {
	    final var sentencia = new StringBuilder();
	    sentencia.append("DELETE FROM rutina_ejercicio WHERE rutina_id = ?");

	    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
	        sentenciaPreparada.setObject(1, rutinaId);
	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha producido un error al eliminar la rutina y sus asociaciones con ejercicios.";
	        var mensajeTécnico = "Se ha producido un error de tipo SQLException al eliminar las asociaciones de ejercicios con la rutina en la base de datos SQL Server. Revise el registro completo del error para identificar la causa.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha producido un error inesperado al eliminar la rutina y sus asociaciones con ejercicios.";
	        var mensajeTécnico = "Se ha producido un error inesperado al eliminar las asociaciones de ejercicios con la rutina en la base de datos SQL Server. Revise el registro completo del error para identificar la causa.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    }
	    sentencia.setLength(0);
	    sentencia.append("DELETE FROM rutina WHERE id = ?");

	    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
	        sentenciaPreparada.setObject(1, rutinaId);
	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha producido un error al eliminar la rutina.";
	        var mensajeTécnico = "Se ha producido un error de tipo SQLException al eliminar la rutina en la base de datos SQL Server. Revise el registro completo del error para identificar la causa.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha producido un error inesperado al eliminar la rutina.";
	        var mensajeTécnico = "Se ha producido un error inesperado al eliminar la rutina en la base de datos SQL Server. Revise el registro completo del error para identificar la causa.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    }
	}


	@Override
	public Optional<RutinaEntity> consultarPorId(UUID id) {
	    final StringBuilder sentencia = new StringBuilder();
	    sentencia.append("SELECT id, nombre, entrenador_id FROM rutina WHERE id = ?");

	    Optional<RutinaEntity> resultado = Optional.empty();

	    try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
	        sentenciaPreparada.setObject(1, id);
	        resultado = ejecutarConsultaPorId(sentenciaPreparada);
	    } catch (DataGestorGimnasioException exception) {
	        throw exception;
	    } catch (SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de la rutina por el identificador deseado...";
	        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método consultarPorId de la clase RutinaSQLServerDAO tratando de preparar la sentencia SQL de la consulta de la rutina deseada. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de la rutina por el identificador deseado...";
	        var mensajeTecnico = "Se ha presentado un problema inesperado de tipo Exception en el método consultarPorId de la clase RutinaSQLServerDAO tratando de preparar la sentencia SQL de la consulta de la rutina deseada. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }

	    return resultado;
	}


	private Optional<RutinaEntity> ejecutarConsultaPorId(PreparedStatement sentenciaPreparada) {
	    Optional<RutinaEntity> resultado = Optional.empty();

	    try (final ResultSet resultados = sentenciaPreparada.executeQuery()) {
	        if (resultados.next()) {
	            UUID rutinaId = UUID.fromString(resultados.getObject("id").toString());
	            String nombre = resultados.getString("nombre");
	            EntrenadorEntity entrenador = obtenerEntrenadorPorRutina(UUID.fromString(resultados.getObject("id").toString()));
	            List<EjercicioEntity> listaDeEjercicios = obtenerEjerciciosPorRutina(UUID.fromString(resultados.getObject("id").toString()));
	            RutinaEntity rutina = RutinaEntity.crear(rutinaId, nombre, entrenador, listaDeEjercicios);
	            resultado = Optional.of(rutina);
	        }
	    } catch (SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de la rutina por el identificador deseado...";
	        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método consultarPorId de la clase RutinaSQLServerDAO tratando de recuperar los datos de la consulta de la rutina deseada. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de la rutina por el identificador deseado...";
	        var mensajeTecnico = "Se ha presentado un problema inesperado de tipo Exception en el método consultarPorId de la clase RutinaSQLServerDAO tratando de recuperar los datos de la consulta de la rutina deseada. Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió...";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }

	    return resultado;
	}






	private String formarSentenciaConsulta(RutinaEntity entity, List<Object> parametros) {
	    StringBuilder sentencia = new StringBuilder();
	    String operadorCondicional = "WHERE ";

	    sentencia.append("SELECT id, nombre, entrenador_id FROM rutina ");
	    if (entity != null) {
	        if (entity.getId() != null) {
	            sentencia.append(operadorCondicional).append(" id = ?");
	            operadorCondicional = "AND ";
	            parametros.add(entity.getId());
	        }
	        if (entity.getNombre() != null) {
	            sentencia.append(operadorCondicional).append(" nombre = ?");
	            operadorCondicional = "AND ";
	            parametros.add(entity.getNombre());
	        }
	    }
	    sentencia.append(" ORDER BY nombre ASC");

	    return sentencia.toString();
	}

	@Override
	public List<RutinaEntity> consultar(RutinaEntity entity) {
	    List<RutinaEntity> rutinas = new ArrayList<>();
	    final var parametros = new ArrayList<>();

	    final String sentencia = formarSentenciaConsulta(entity, parametros);

	    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
	        colocarParametrosConsulta(sentenciaPreparada, parametros);
	        rutinas = ejecutarConsulta(sentenciaPreparada);
	    } catch (DataGestorGimnasioException excepcion) {
	        throw excepcion;
	    } catch (SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de las rutinas.";
	        var mensajeTecnico = "Se ha presentado un problema en el método consultar de la clase RutinaSQLServerDAO tratando de preparar la sentencia SQL. Por favor revise la traza completa del problema presentado para identificar qué sucedió.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de las rutinas.";
	        var mensajeTecnico = "Se ha presentado un problema inesperado de tipo Exception en el método consultar de la clase RutinaSQLServerDAO tratando de preparar la sentencia SQL. Por favor revise la traza completa del problema presentado para identificar qué sucedió.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }

	    return rutinas;
	}

	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) throws SQLException {
	    int indice = 1;
	    for (Object parametro : parametros) {
	        if (parametro instanceof UUID) {
	            sentenciaPreparada.setObject(indice, parametro);
	        } else if (parametro instanceof String) {
	            sentenciaPreparada.setString(indice, (String) parametro);
	        }
	        indice++;
	    }
	}

	private final List<RutinaEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada) {
	    List<RutinaEntity> rutinas = new ArrayList<>();

	    try (ResultSet resultSet = sentenciaPreparada.executeQuery()) {
	        while (resultSet.next()) {
	            UUID rutinaId = UUID.fromString(resultSet.getObject("id").toString());
	            String nombre = resultSet.getString("nombre");
	            EntrenadorEntity entrenador = obtenerEntrenadorPorRutina(UUID.fromString(resultSet.getObject("id").toString()));
	            List<EjercicioEntity> listaDeEjercicios = obtenerEjerciciosPorRutina(UUID.fromString(resultSet.getObject("id").toString()));
	            RutinaEntity rutina = RutinaEntity.crear(rutinaId, nombre, entrenador, listaDeEjercicios);
	            rutinas.add(rutina);
	        }
	    } catch (SQLException excepcion) {
	        String mensajeUsuario = "Se ha producido un error al ejecutar la consulta de rutinas.";
	        String mensajeTécnico = "Se ha producido un error de tipo SQLException al ejecutar la consulta de rutinas en la base de datos SQL Server. Revise el registro completo del error para identificar la causa.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    } catch (Exception excepcion) {
	        String mensajeUsuario = "Se ha producido un error inesperado al ejecutar la consulta de rutinas.";
	        String mensajeTécnico = "Se ha producido un error inesperado al ejecutar la consulta de rutinas en la base de datos SQL Server. Revise el registro completo del error para identificar la causa.";
	        throw DataGestorGimnasioException.crear(excepcion, mensajeUsuario, mensajeTécnico);
	    }

	    return rutinas;
	}

	private List<EjercicioEntity> obtenerEjerciciosPorRutina(UUID rutinaId) {
	    List<EjercicioEntity> ejercicios = new ArrayList<>();

	    // Realiza una consulta SQL para obtener la lista de ejercicios asociados a una rutina
	    String selectEjerciciosSQL = "SELECT id, nombre, descripcion, series, repeticiones FROM ejercicio WHERE id IN (SELECT ejercicio_id FROM rutina_ejercicio WHERE rutina_id = ?)";
	    try (PreparedStatement selectEjerciciosStmt = getConexion().prepareStatement(selectEjerciciosSQL)) {
	        selectEjerciciosStmt.setObject(1, rutinaId);
	        ResultSet resultSet = selectEjerciciosStmt.executeQuery();

	        while (resultSet.next()) {
	            UUID ejercicioId = UUID.fromString(resultSet.getObject("id").toString());
	            String nombre = resultSet.getString("nombre");
	            String descripcion = resultSet.getString("descripcion");
	            String series = resultSet.getString("series");
	            String repeticiones = resultSet.getString("repeticiones");

	            // Crea una instancia de EjercicioEntity para cada ejercicio y agrégala a la lista de ejercicios
	            EjercicioEntity ejercicio = new EjercicioEntity(ejercicioId, nombre, descripcion, series, repeticiones);
	            ejercicios.add(ejercicio);
	        }
	    } catch (SQLException excepcion) {
	        // Manejo de excepciones
	    }

	    return ejercicios;
	}



	private EntrenadorEntity obtenerEntrenadorPorRutina(UUID rutinaId) {
	    EntrenadorEntity entrenador = null;

	    // Realiza una consulta SQL para obtener el entrenador asociado a una rutina
	    String selectEntrenadorSQL = "SELECT entrenador_id FROM rutina WHERE id = ?";
	    try (PreparedStatement selectEntrenadorStmt = getConexion().prepareStatement(selectEntrenadorSQL)) {
	        selectEntrenadorStmt.setObject(1, rutinaId);
	        ResultSet resultSet = selectEntrenadorStmt.executeQuery();

	        if (resultSet.next()) {
	            UUID entrenadorId = UUID.fromString(resultSet.getObject("entrenador_id").toString());

	            // Llama al método para obtener un EntrenadorEntity por su ID
	            entrenador = obtenerEntrenadorPorId(entrenadorId);
	        }
	    } catch (SQLException excepcion) {
	        // Manejo de excepciones
	    }

	    return entrenador;
	}


	private EntrenadorEntity obtenerEntrenadorPorId(UUID entrenadorId) {
	    EntrenadorEntity entrenador = null;

	    // Realiza una consulta SQL para obtener los detalles del entrenador según su ID (entrenadorId)
	    String selectEntrenadorSQL = "SELECT tipoidentificacion, identificacion, nombrecompleto, correoelectronico, numerotelefonomovil, fechanacimiento FROM entrenador WHERE id = ?";
	    try (PreparedStatement selectEntrenadorStmt = getConexion().prepareStatement(selectEntrenadorSQL)) {
	        selectEntrenadorStmt.setObject(1, entrenadorId);
	        ResultSet resultSet = selectEntrenadorStmt.executeQuery();

	        if (resultSet.next()) {
	            // Recupera los datos del entrenador desde la base de datos
	            TipoIdentificacionEntity tipoIdentificacion = TipoIdentificacionEntity.fromString(resultSet.getString("tipoidentificacion"));
	            String identificacion = resultSet.getString("identificacion");
	            NombreCompletoEntrenadorEntity nombreCompleto = NombreCompletoEntrenadorEntity.fromString(resultSet.getString("nombrecompleto"));
	            CorreoElectronicoEntrenadorEntity correoElectronico = CorreoElectronicoEntrenadorEntity.fromString(resultSet.getString("correoelectronico"));
	            NumeroTelefonoMovilEntrenadorEntity numeroTelefonoMovil = NumeroTelefonoMovilEntrenadorEntity.fromString(resultSet.getString("numerotelefonomovil"));
	            LocalDate fechaNacimiento = resultSet.getDate("fechanacimiento").toLocalDate();

	            // Utiliza el método de fábrica público para crear una instancia de EntrenadorEntity
	            entrenador = EntrenadorEntity.crear(entrenadorId, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroTelefonoMovil, fechaNacimiento);
	        }
	    } catch (SQLException excepcion) {
	        // Manejo de excepciones
	    }

	    return entrenador;
	}



}
