package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.rutina;


import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
import co.edu.uco.gestorgimnasio.data.dao.RutinaDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;
import co.edu.uco.gestorgimnasio.service.domain.rutina.RutinaDomain;
<<<<<<< HEAD
=======
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.EjercicioEntityMapper;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.RutinaEntityMapper;


>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b

public final class EliminarRutinaUseCase implements UseCase<RutinaDomain> {

    private DAOFactory factoria;

    public EliminarRutinaUseCase(final DAOFactory factoria) {
        setFactoria(factoria);
    }

    @Override
    public final void execute(RutinaDomain domain) {
        validarExistenciaRutina(domain.getId());
        eliminarRutina(domain);
    }

<<<<<<< HEAD
    private void eliminarRutina(final RutinaDomain domain) {
        RutinaDAO rutinaDAO = getRutinaDAO();
        rutinaDAO.eliminar(domain.getId());
    }

    private final void validarExistenciaRutina(final UUID id) {
        var resultado = getRutinaDAO().consultarPorId(id);
        if (resultado.isEmpty()) {
            var mensajeUsuario = "No existe una rutina con el ID " + id;
            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
        }
    }

=======
    private void registrarNuevaRutina(final RutinaDomain domain) {
       final RutinaEntity entity = RutinaEntityMapper.convertToEntity(domain);
       final List<EjercicioEntity> ejercicios = obtenerListaDeEjercicios(domain); // Debes implementar este método
       final RutinaDAO rutinaDAO = getRutinaDAO();
        rutinaDAO.crear(entity, ejercicios);
    }


    private List<EjercicioEntity> obtenerListaDeEjercicios(RutinaDomain domain) {
        // Supongamos que en tu modelo de dominio, hay una lista de ejercicios asociada a la rutina.
    	final List<EjercicioDomain> ejerciciosDomain = domain.getEjercicios();

        if (ejerciciosDomain != null) {
            // Si tienes una lista de ejercicios en el objeto RutinaDomain, convierte y devuelve la lista.
            final List<EjercicioEntity> ejerciciosEntity = convertirListaDeEjercicios(ejerciciosDomain);
            return ejerciciosEntity;
        } else {
            // Si no tienes una lista de ejercicios en el objeto RutinaDomain, crea y devuelve una lista vacía.
            return new ArrayList<>();
        }
    }

    private List<EjercicioEntity> convertirListaDeEjercicios(List<EjercicioDomain> ejerciciosDomain) {
        final List<EjercicioEntity> ejerciciosEntity = new ArrayList<>();
        // Debes implementar esta conversión
		ejerciciosDomain.stream().map(EjercicioEntityMapper::convertToEntity).forEach(ejerciciosEntity::add);
        return ejerciciosEntity;
    }


 


	private final void validarNoExistenciaRutinaConMismoNombreYEntrenador(final String nombre,final EntrenadorDomain entrenador) {
		final var domain = RutinaDomain.crear(null, nombre, entrenador, null);
		final var entity=RutinaEntityMapper.convertToEntity(domain);
		final var resultados = getRutinaDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
	
			throw ServiceGestorGimnasioException.crear("Ya existe una rutina de este entrenador con el mismo nombre, por favor asigne otro nombre");
		}
    }

    private final RutinaDomain obtenerIdentificadorRutina(final RutinaDomain domain) {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while (getRutinaDAO().consultarPorId(uuid).isPresent());
        return RutinaDomain.crear(uuid, domain.getNombre(), domain.getEntrenador(), domain.getEjercicios());
    }

>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b
    private final DAOFactory getFactoria() {
        return factoria;
    }

    private final void setFactoria(final DAOFactory factoria) {
        if (UtilObjeto.esNulo(factoria)) {
<<<<<<< HEAD
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la eliminación de la rutina";
            var mensajeTecnico = "Se ha presentado un problema en setFactoria";
            throw ServiceGestorGimnasioException.crear(mensajeUsuario, mensajeTecnico);
=======
        
            throw ServiceGestorGimnasioException.crear("Se ha presentado un problema tratando de llevar a cabo el resultado", "Se ha presentado un problema en setFactoria");
>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b
        }
        this.factoria = factoria;
    }

    private final RutinaDAO getRutinaDAO() {
        return getFactoria().obtenerRutinaDAO();
    }
}

