package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.entities.Carro_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
    
        public Carro findByPlacaCarro(String placa) {
         CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Carro> cq = cb.createQuery(Carro.class);
        Root<Carro> carro = cq.from(Carro.class);
        Predicate restrictions = cb.conjunction();
        if(placa != null){
            restrictions = cb.and(restrictions, cb.like(carro.get(Carro_.placa), placa));
        }
        cq.where(restrictions);
        cq.orderBy(cb.asc(carro.get(Carro_.placa)));
        TypedQuery<Carro> q = em.createQuery(cq);
        try {
            return q.setMaxResults(10).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
   
    
}
