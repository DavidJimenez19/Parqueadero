package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.entities.Puesto;
import co.edu.sena.adsi.jpa.sessions.CarroFacade;
import co.edu.sena.adsi.jpa.sessions.PuestoFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

@Path("carros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarroREST {

    @EJB
    private CarroFacade carroEJB;
    
    @EJB
    private PuestoFacade puestoEJB;

    /**
     * Obtiene todos los carros
     *
     * @return lista de carros
     */
    @GET
    public List<Carro> findAll() {
        return carroEJB.findAll();
    }
    
     /**
     * Busca carro por su placa
     *
     * @param placa
     * @return carro
     */
    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public Carro findByPlaca(@QueryParam("placa") String placa) {
        return carroEJB.findByPlacaCarro(placa);
    }

    /**
     * Busca carro por su id
     *
     * @param id
     * @return carros
     */
    @GET
    @Path("{id}")
    public Carro findById(@PathParam("id") Integer id) {
        return carroEJB.find(id);
    }

    /**
     * Crear un carro
     *
     * @param carro
     * @return
     */
    @POST
    public Response create(Carro carro) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            carroEJB.create(carro);
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
     * Edita un carro
     *
     * @param id
     * @param carro
     * @return
     */
    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Carro carro) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            carroEJB.edit(carro);
            return Response.status(Response.Status.CREATED)
                    .entity(gson.toJson("El puesto se actualizó correctamente"))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al actualizar el puesto!."))
                    .build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id){
        Carro carro = carroEJB.find(id);
        Puesto puesto = puestoEJB.find(carro.getPuestos().getId());
        carroEJB.remove(carro);
        puesto.setDisponible(true);
        puestoEJB.edit(puesto);
    }

}

