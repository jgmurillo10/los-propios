/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

//import Source.Packages.edu.uniandes.lospropios.dtos.CityDTO;
//import edu.uniandes.lospropios.exceptions.CityLogicException;
//import edu.uniandes.lospropios.mocks.CityLogicMock;

import edu.uniandes.lospropios.resources.dtos.ItinerarioDTO;
import edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException;
import edu.uniandes.lospropios.resources.mocks.ItinerarioLogicMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


/**
 * Clase que implementa el recurso REST correspondiente a "itinerario".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "cities".
 * Al ejecutar la aplicación, el recurse será accesibe a través de la
 * ruta "/api/cities"
 *
 * @author Asistente
 */
@Path("itinerario")
@Produces("application/json")
@RequestScoped
public class ItinerarioResource {

	@Inject	
        ItinerarioLogicMock itinerarioLogic;

	/**
	 * Obtiene el listado de itineratios.
	 * @return lista de itinerarios
	 * @throws itinerarioLogicException excepción retornada por la lógica
	 */
    @GET
    public List<ItinerarioDTO> getItinerario()
    {
            try {
                return itinerarioLogic.getItinerarios();
            } catch (ItinerarioLogicException ex) {
                Logger.getLogger(ItinerarioResource.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }

    /**
     * Obtiene un itinerario
     * @param id identificador del itinerario
     * @return itinerario encontrada
     * @throws ItinerarioException cuando la ciudad no existe
     */
    @GET
    @Path("{id: \\d+}")
    public ItinerarioDTO getItinerario(@PathParam("id") Long id) throws ItinerarioLogicException {
       return itinerarioLogic.getItinerario(id);
   }

    /**
     * Agrega un itinerario
     * @param itinerario itinerario a agregar
     * @return datos del itinerario a agregar
     * @throws ItinerioLogicException cuando ya existe un itinerario con el id suministrado
     */
    @POST
    public ItinerarioDTO createItinerario(ItinerarioDTO itinerario) throws ItinerarioLogicException {
        return itinerarioLogic.createItinerario(itinerario);
    }

    /**
     * Actualiza los datos de un itinerario
     * @param id identificador del itinerario a modificar
     * @param itinerario itinerario a modificar
     * @return datos del itinierario modificado
     * @throws ItinerarioLogicException cuando no existe un itinerario con el id suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public ItinerarioDTO updateItinerario(@PathParam("id") Long id, ItinerarioDTO itinerario) throws ItinerarioLogicException {
        return itinerarioLogic.updateItinerario(id, itinerario);
    }

    /**
     * Elimina los datos de un itinerario
     * @param id identificador del itinerario a eliminar
     * @throws ItinerarioLogicException cuando no existe un itinerario con el id suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteItinerario(@PathParam("id") Long id) throws ItinerarioLogicException {
    	itinerarioLogic.deleteItinerario(id);
    }

}