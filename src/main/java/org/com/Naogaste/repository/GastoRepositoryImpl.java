package org.com.Naogaste.repository;

import org.com.Naogaste.model.Gasto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GastoRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Gasto> findOrderedBySeatDataLimitedTo(int limit) {
        return entityManager.createQuery("SELECT g FROM Gasto g ORDER BY g.data",
                Gasto.class).setMaxResults(limit).getResultList();
    }


    public Object getGasto(int id) {
        return  entityManager.createQuery("SELECT SUM(valor) AS total FROM Gasto WHERE user_id =  " + id).getResultList().get(0);
    }
}
