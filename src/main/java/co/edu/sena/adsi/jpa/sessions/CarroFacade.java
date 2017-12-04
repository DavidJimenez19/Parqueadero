package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Carro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@Stateless
public class CarroFacade extends AbstractFacade<Carro> {

    @PersistenceContext(unitName = "co.edu.sena.adsi_Parqueadero_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarroFacade() {
        super(Carro.class);
    }
    
}
