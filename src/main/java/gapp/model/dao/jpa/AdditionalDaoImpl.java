package gapp.model.dao.jpa;

import gapp.model.GappAdditional;
import gapp.model.GappProgram;
import gapp.model.dao.AdditionalDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdditionalDaoImpl implements AdditionalDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<GappAdditional> getGappAdditional() {
		return entityManager.createQuery("from GappAdditional",
				GappAdditional.class).getResultList();
	}

	@Override
	public GappAdditional getAdditionalId(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(GappAdditional.class, id);
		// return entityManager.createQuery("from GappUsers",
		// GappUsers.class).getResultList();
	}

	@Transactional
	@Override
	public GappAdditional remove(GappAdditional a1) {
		// TODO Auto-generated method stub
		entityManager.remove(a1);
		// return entityManager.createQuery("from GappUsers",
		// GappUsers.class).getResultList();
		return a1;
	}

}
