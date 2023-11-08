package co.edu.uco.gestorgimnasio.service.businesslogic.concrete.rutina;


import java.util.Optional;
import java.util.UUID;

import co.edu.uco.gestorgimnasio.crosscutting.exception.concrete.ServiceGestorGimnasioException;
import co.edu.uco.gestorgimnasio.crosscutting.util.UtilObjeto;
<<<<<<< HEAD
=======

>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b
import co.edu.uco.gestorgimnasio.data.dao.RutinaDAO;
import co.edu.uco.gestorgimnasio.data.dao.daofactory.DAOFactory;
import co.edu.uco.gestorgimnasio.data.entity.RutinaEntity;
import co.edu.uco.gestorgimnasio.service.businesslogic.UseCase;
import co.edu.uco.gestorgimnasio.service.businesslogic.validator.concrete.rutina.RegistrarRutinaValidator;
import co.edu.uco.gestorgimnasio.service.domain.rutina.RutinaDomain;
<<<<<<< HEAD
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.RutinaEntityMapper;
=======

import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.EjercicioEntityMapper;
import co.edu.uco.gestorgimnasio.service.mapper.entity.concrete.RutinaEntityMapper;


>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b


public final class RegistrarRutinaUseCase implements UseCase<RutinaDomain> {
    private DAOFactory factoria;

    public RegistrarRutinaUseCase(final DAOFactory factoria) {
        setFactoria(factoria);
    }

    @Override
    public final void execute(RutinaDomain domain) {
        RegistrarRutinaValidator.ejecutar(domain);
        validarNoExistenciaRutinaConMismoNombre(domain.getNombre());
        domain = obtenerIdentificadorRutina(domain);
        registrarNuevaRutina(domain);
    }

    private void registrarNuevaRutina(final RutinaDomain domain) {
<<<<<<< HEAD
        var entity = RutinaEntityMapper.convertToEntity(domain);
        getRutinaDAO().crear(entity, null);
=======
    	final RutinaEntity entity = RutinaEntityMapper.convertToEntity(domain);
    	final List<EjercicioEntity> ejercicios = obtenerListaDeEjercicios(domain); // Debes implementar este método
    	final RutinaDAO rutinaDAO = getRutinaDAO();
        rutinaDAO.crear(entity, ejercicios);
>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b
    }

    private final void validarNoExistenciaRutinaConMismoNombre(final String nombre) {
        var domain = RutinaDomain.crear(null, nombre, null,null);
        var entity = RutinaEntityMapper.convertToEntity(domain);
        var resultados = getRutinaDAO().consultar(entity);

<<<<<<< HEAD
        if (!resultados.isEmpty()) {
            var mensajeUsuario = "Ya existe una rutina con el nombre " + nombre;
            throw ServiceGestorGimnasioException.crear(mensajeUsuario);
        }
    }

=======
    private List<EjercicioEntity> obtenerListaDeEjercicios(RutinaDomain domain) {
        // Supongamos que en tu modelo de dominio, hay una lista de ejercicios asociada a la rutina.
    	final List<EjercicioDomain> ejerciciosDomain = domain.getEjercicios();

        if (ejerciciosDomain != null) {
            // Si tienes una lista de ejercicios en el objeto RutinaDomain, convierte y devuelve la lista.
        	
            return convertirListaDeEjercicios(ejerciciosDomain);
        } else {
            // Si no tienes una lista de ejercicios en el objeto RutinaDomain, crea y devuelve una lista vacía.
            return new ArrayList<>();
        }
    }

    private List<EjercicioEntity> convertirListaDeEjercicios(List<EjercicioDomain> ejerciciosDomain) {
    	final  List<EjercicioEntity> ejerciciosEntity = new ArrayList<>();
        // Debes implementar esta conversión
		ejerciciosDomain.stream().map(EjercicioEntityMapper::convertToEntity).forEach(ejerciciosEntity::add);
        return ejerciciosEntity;
    }


 


	private final void validarNoExistenciaRutinaConMismoNombreYEntrenador(final String nombre,final EntrenadorDomain entrenador) {
		final 	var domain = RutinaDomain.crear(null, nombre, entrenador, null);
		final 	var entity=RutinaEntityMapper.convertToEntity(domain);
		final 	var resultados = getRutinaDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {

			throw ServiceGestorGimnasioException.crear("Ya existe una rutina de este entrenador con el mismo nombre, por favor asigne otro nombre");
		}
    }

>>>>>>> 784dbb69a567a984b06ed007b280480266169f0b
    private final RutinaDomain obtenerIdentificadorRutina(final RutinaDomain domain) {
        Optional<RutinaEntity> optional;
        UUID uuid;

        do {
            uuid = UUID.randomUUID();
            optional = getRutinaDAO().consultarPorId(uuid);
        } while (optional.isPresent());

        return RutinaDomain.crear(uuid, domain.getNombre(), domain.getEntrenador(), domain.getEjercicios());
    }


    private final DAOFactory getFactoria() {
        return factoria;
    }

    private final void setFactoria(final DAOFactory factoria) {
        if (UtilObjeto.esNulo(factoria)) {

            throw ServiceGestorGimnasioException.crear("Se ha presentado un problema tratando de llevar a cabo el resultado", "Se ha presentado un problema en setFactoria");
        }
        this.factoria = factoria;
    }

    private final RutinaDAO getRutinaDAO() {
        return getFactoria().obtenerRutinaDAO();
    }
}


