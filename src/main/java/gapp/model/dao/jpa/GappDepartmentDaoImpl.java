package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.GappAdditional;
import gapp.model.GappDepartment;
import gapp.model.GappProgram;
import gapp.model.dao.GappDepartmentDao;

@Repository
public class GappDepartmentDaoImpl implements GappDepartmentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public GappDepartment getDepartmentId(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(GappDepartment.class, id);
		// return entityManager.createQuery("from GappUsers",
		// GappUsers.class).getResultList();
	}

	@Override
	public GappAdditional getAdditionalId(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(GappAdditional.class, id);
		// return entityManager.createQuery("from GappUsers",
		// GappUsers.class).getResultList();
	}

	@Override
	public List<GappDepartment> getGappDepartment() {
		return entityManager.createQuery("from GappDepartment order by id",
				GappDepartment.class).getResultList();
	}

	@Override
	@Transactional
	public GappDepartment saveDepartment(GappDepartment department) {
		return entityManager.merge(department);

	}

	@Override
	@Transactional
	public GappAdditional saveAdditional(GappAdditional additional) {
		return entityManager.merge(additional);

	}

}
