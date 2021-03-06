/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.api;

/**
 *
 * @author jg.murillo10
 */
import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
//Tener en cuenta exception tipo ItinerarioLogicException que arrojan los metodos
import java.util.List;

public interface IItinerarioLogic {

    /**
     * Metodo que retorna la lista de los itinerarios
     *
     * @return - Lista de los itinerarios
     */
    public List<ItinerarioEntity> getItinerarios(Long id);

    /**
     * Metodo que crea un itinerario
     *
     * @param itinerario - El nuevo itinerario
     * @return - El itinerario creado con un id asignado
     * @throws ItinerarioLogicException
     */
    public ItinerarioEntity createItinerario(Long idUsuario, ItinerarioEntity itinerario) throws BusinessLogicException;

    /**
     * Metodo para obtener el itinerario de un usuario dado el id del usuario y
     * el id del itinerario
     *
     * @param idPerfil - id del viajero
     * @param idItinerario - id del itinerario asociado al id del viajero
     * @return - ItineararioDTO con toda la informacion del itinerario
     * @throws ItinerarioLogicException
     */
    public ItinerarioEntity getItinerario(Long idUsuario, Long idItinerario);

    /**
     * Metodo para actualizar la informacion de un itinerario
     *
     * @param idItinerario - id del itinerario a actualizar
     * @param itinerario - ItinerarioDTO a cambiar
     * @return - ItinerarioDTO nuevo
     * @throws ItinerarioLogicException
     */
    public ItinerarioEntity updateItinerario(Long idUsuario, ItinerarioEntity itinerario) throws BusinessLogicException;

    /**
     * Metodo para eliminar un itineario dado su id
     *
     * @param idItinerario - id del itinerario que se desea eliminar
     * @throws ItinerarioLogicException
     */
    public void deleteItinerario(Long idUsuario, Long idItinerario);
}
