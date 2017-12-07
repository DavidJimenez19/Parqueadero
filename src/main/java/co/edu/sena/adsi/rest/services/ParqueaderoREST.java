package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Parqueadero;
import co.edu.sena.adsi.jpa.sessions.ParqueaderoFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author david
 */

@Path("parqueaderos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ParqueaderoREST {

    @EJB
    private ParqueaderoFacade parqueaderoEJB;

    /**
     * Obtiene todos los parqueaderos
     *
     * @return lista de parqueaderos
     */
    @GET
    public List<Parqueadero> findAll() {
        return parqueaderoEJB.findAll();
    }

    /**
     * Busca parqueadero por su id
     *
     * @param id
     * @return parqueadero
     */
    @GET
    @Path("{id}")
    public Parqueadero findById(@PathParam("id") Integer id) {
        return parqueaderoEJB.find(id);
    }

    /**
     * Crear un parqueadero
     *
     * @param parqueadero
     * @return
     */
    @POST
    public Response create(Parqueadero parqueadero) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            parqueadero.setAbierto(Boolean.TRUE);
            parqueaderoEJB.create(parqueadero);
            return Response.status(Response.Status.CREATED)
                    .entity(gson.toJson("El puesto se registró correctamente"))
                    .build();
        } catch (Exception e) {
            System.out.println("Err: " + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar el puesto!."))
                    .build();
        }

    }

    /**
     * Edita un parqueadero
     *
     * @param id
     * @param parqueadero
     * @return
     */
    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Parqueadero parqueadero) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            parqueaderoEJB.edit(parqueadero);
            return Response.status(Response.Status.CREATED)
                    .entity(gson.toJson("El puesto se actualizó correctamente"))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al actualizar el puesto!."))
                    .build();
        }
    }

}
