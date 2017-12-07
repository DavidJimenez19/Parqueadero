package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Puesto;
import co.edu.sena.adsi.jpa.sessions.PuestoFacade;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author david
 */

@Path("puestos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PuestoREST {

    @EJB
    private PuestoFacade puestoEJB;

    /**
     * Obtiene todos los puestos
     *
     * @return lista de puestos
     */
    @GET
    public List<Puesto> findAll() {
        return puestoEJB.findAll();
    }

    /**
     * Busca puesto por su id
     *
     * @param id
     * @return puestos
     */
    @GET
    @Path("{id}")
    public Puesto findById(@PathParam("id") Integer id) {
        return puestoEJB.find(id);
    }
    
    @GET
    @Path("encontrar")
    public List<Puesto> findByActivo(@QueryParam("disponible") boolean disponible) {
            return puestoEJB.findPuestoByDisponible(disponible);
    }

    /**
     * Crear un puesto
     *
     * @param puesto
     * @return
     */
    @POST
    public Response create(Puesto puesto) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            puestoEJB.create(puesto);
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
     * Edita un puesto
     *
     * @param id
     * @param puesto
     * @return
     */
    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Puesto puesto) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            puestoEJB.edit(puesto);
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
