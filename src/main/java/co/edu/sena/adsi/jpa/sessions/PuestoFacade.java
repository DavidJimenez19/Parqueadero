package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Puesto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@Stateless
public class PuestoFacade extends AbstractFacade<Puesto> {

    @PersistenceContext(unitName = "co.edu.sena.adsi_Parqueadero_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PuestoFacade() {
        super(Puesto.class);
    }
    
}
