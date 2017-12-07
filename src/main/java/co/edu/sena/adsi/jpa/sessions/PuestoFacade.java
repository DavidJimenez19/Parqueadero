package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Puesto;
import co.edu.sena.adsi.jpa.entities.Puesto_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    
     /**
     * Search puestos by disponible
     *
     * @param disponible
     * @return news
     */
    public List<Puesto> findPuestoByDisponible(boolean disponible) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Puesto> cq = cb.createQuery(Puesto.class);
        Root<Puesto> puestos = cq.from(Puesto.class);
        cq.where(cb.equal(puestos.get(Puesto_.disponible), disponible));
        TypedQuery<Puesto> q = getEntityManager().createQuery(cq);
        try {
            return q.getResultList();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
