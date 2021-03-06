/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.mocks;

import java.util.*;
import java.util.logging.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import edu.uniandes.lospropios.resources.dtos.*;
import edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException;

/**
 *
 * @author jg.murillo10
 */
/**
 * Mock del recurso Itinerarios (Mock del servicio REST)
 */
@Named
@ApplicationScoped
public class ItinerarioLogicMock {
// objeto para presentar logs de las operaciones

    private final static Logger LOGGER = Logger.getLogger(ItinerarioLogicMock.class.getName());
    private final static String ERROR = "No existe un itinerario con ese id";

    // listado de itinerarios
    private static ArrayList<ItinerarioDTO> itinerarios;
    // listado de perfiles
    private static ArrayList<PerfilDTO> perfiles;
    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public ItinerarioLogicMock() {

        if (itinerarios == null) {
            //Inicializa la lista de itinerarios
            itinerarios = new ArrayList<>();
            //Crea paradas para asociales a los itinerarios
            ParadaDTO p1 = new ParadaDTO();
            ParadaDTO p2 = new ParadaDTO();
            ParadaDTO p3 = new ParadaDTO();
        }

        // indica que se muestren todos los mensajes
        LOGGER.setLevel(Level.INFO);

        // muestra información
        LOGGER.info("Inicializa la lista de itinerarios");
        LOGGER.log(Level.INFO, "itinerarios{0}", itinerarios);
    }

    /**
     * Obtiene el listado de itinerarios.
     *
     * @return lista de itinerarios
     * @throws ItinerarioLogicException cuando no existe la lista en memoria
     */
    public List<ItinerarioDTO> getItinerarios() throws ItinerarioLogicException {
        if (itinerarios == null) {
            LOGGER.severe("Error interno: lista de itinerarios no existe.");
            throw new ItinerarioLogicException("Error interno: lista de itinerarios no existe.");
        }

        LOGGER.info("retornando todas las itinerarios");
        return itinerarios;
    }

    /**
     * Obtiene un itinerario
     *
     * @param idItinerario identificador de el itinerario
     * @return itinerario encontrada
     * @throws ItinerarioLogicException cuando el itinerario no existe
     */
//    public ItinerarioDTO getItinerario(Long idItinerario) throws ItinerarioLogicException {
//        LOGGER.log(Level.INFO, "{0}recibiendo solicitud de itinerario con id ", idItinerario);
//
//        // busca el itinerario con el id suministrado
//        for (ItinerarioDTO itinerario : itinerarios) {
//            if (Objects.equals(itinerario.getIdItinerario(), idItinerario)) {
//                LOGGER.log(Level.INFO, "retornando itinerario {0}", itinerario);
//                return itinerario;
//            }
//        }
//
//        // si no encuentra el itinerario
//        LOGGER.severe(ERROR);
//        throw new ItinerarioLogicException(ERROR);
//    }
//
//     /**
//     * Obtiene una parada
//     * @param idItinerario identificador del itinerario
//     * @param idPerfilUsuario identificador del perfil usuario
//     * @return itinerario encontrado
//     * @throws ItinerarioLogicException cuando el itinerario no existe
//     */
//    public ItinerarioDTO getItinerarioUsuario(Long idPerfilUsuario, Long idItinerario) throws ItinerarioLogicException {
//        LOGGER.log(Level.INFO, "recibiendo solicitud de perifl usuario con Itinerario{0}", idPerfilUsuario);
//
//        // busca el paradero que le pertenece al id del viajero
//        for (PerfilDTO perfil: perfiles)
//        {
//            if (perfil.getId()==idPerfilUsuario)
//            {
//                for(ItinerarioDTO itinerario: itinerarios)
//                {
//                    if(itinerario.getIdItinerario()==idItinerario)
//                    {
//                             LOGGER.log(Level.INFO, "retornando parada {0}", itinerario);
//                             return itinerario;
//
//                    }
//                }
//            }
//        }
//
//
//        // si no encuentra el itinerario
//        LOGGER.severe(ERROR);
//        throw new ItinerarioLogicException(ERROR);
//    }
//
//    /**
//     * Agrega un itinerario a la lista.
//     *
//     * @param newItinerario itinerario a adicionar
//     * @throws ItinerarioLogicException cuando ya existe un itinerario con el id
//     * suministrado
//     * @return itinerario agregada
//     */
//    public ItinerarioDTO createItinerario(ItinerarioDTO newItinerario) throws ItinerarioLogicException {
//        LOGGER.log(Level.INFO, "recibiendo solicitud de agregar itinerario {0}", newItinerario);
//
//        // el nuevo itinerario tiene id ?
//        if (newItinerario.getIdItinerario()!= null) {
//            // busca el itinerario con el id suministrado
//            for (ItinerarioDTO itinerario : itinerarios) {
//                // si existe un itinerario con ese id
//                if (Objects.equals(itinerario.getIdItinerario(), newItinerario.getIdItinerario())) {
//                    LOGGER.severe("Ya existe un itinerario con ese id");
//                    throw new ItinerarioLogicException("Ya existe un itinerario con ese id");
//                }
//            }
//
//            // el nuevo itinerario no tiene id ?
//        } else {
//
//            // genera un id para el itinerario
//            LOGGER.info("Generando id paa el nuevo itinerario");
//            long newId = 1;
//            for (ItinerarioDTO itinerario : itinerarios) {
//                if (newId <= itinerario.getIdItinerario()) {
//                    newId = itinerario.getIdItinerario()+ 1;
//                }
//            }
//            newItinerario.setIdItinerario(newId);
//        }
//
//        // agrega el itinerario
//        LOGGER.log(Level.INFO, "agregando itinerario {0}", newItinerario);
//        itinerarios.add(newItinerario);
//        return newItinerario;
//    }
//
//    /**
//     * Actualiza los datos de un itinerario
//     *
//     * @param id identificador de el itinerario a modificar
//     * @param updatedItinerario
//     * @return datos de el itinerario modificada
//     * @throws ItinerarioLogicException cuando no existe un itinerario con el id
//     * suministrado
//     */
//    public ItinerarioDTO updateItinerario(Long id, ItinerarioDTO updatedItinerario) throws ItinerarioLogicException {
//        LOGGER.log(Level.INFO, "recibiendo solictud de modificar itinerario {0}", updatedItinerario);
//
//        // busca el itinerario con el id suministrado
//        for (ItinerarioDTO itinerario : itinerarios) {
//            if (Objects.equals(itinerario.getIdItinerario(), id)) {
//
//                // modifica el itinerario
//                itinerario.setIdItinerario(updatedItinerario.getIdItinerario());
//                itinerario.setFechaInicio(updatedItinerario.getFechaInicio());
//
//                // retorna el itinerario modificada
//                LOGGER.log(Level.INFO, "Modificando itinerario {0}", itinerario);
//                return itinerario;
//            }
//        }
//
//        // no encontró el itinerario con ese id ?
//        LOGGER.severe(ERROR);
//        throw new ItinerarioLogicException(ERROR);
//    }
//
//    /**
//     * Elimina los datos de un itinerario
//     *
//     * @param id identificador de el itinerario a eliminar
//     * @throws ItinerarioLogicException cuando no existe un itinerario con el id
//     * suministrado
//     */
//    public void deleteItinerario(Long id) throws ItinerarioLogicException {
//        LOGGER.log(Level.INFO, "recibiendo solictud de eliminar itinerario con id {0}", id);
//
//        // busca el itinerario con el id suministrado
//        for (ItinerarioDTO itinerario : itinerarios) {
//            if (Objects.equals(itinerario.getIdItinerario(), id)) {
//
//                // elimina el itinerario
//                LOGGER.log(Level.INFO, "eliminando itinerario {0}", itinerario);
//                itinerarios.remove(itinerario);
//                return;
//            }
//        }
//
//        // no encontró el itinerario con ese id ?
//        LOGGER.severe(ERROR);
//        throw new ItinerarioLogicException(ERROR);
//    }
}
