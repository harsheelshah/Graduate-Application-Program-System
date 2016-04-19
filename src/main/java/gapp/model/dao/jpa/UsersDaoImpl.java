package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.GappAcademicRecords;
import gapp.model.GappDepartment;
import gapp.model.GappProgram;
import gapp.model.GappUsers;
import gapp.model.dao.UsersDao;

@Repository
public class UsersDaoImpl implements UsersDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public GappUsers getUserId(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(GappUsers.class, id);
		// return entityManager.createQuery("from GappUsers",
		// GappUsers.class).getResultList();
	}

	@Override
	public List<GappUsers> getUserType(String email, String password) {
		// TODO Auto-generated method stub
		return entityManager
				.createQuery(
						"from GappUsers where email =:email and password=:password",
						GappUsers.class).setParameter("email", email)
				.setParameter("password", password).getResultList();
	}

	@Override
	public List<GappUsers> checkuser(String email) {
		// TODO Auto-generated method stub
		return entityManager
				.createQuery("from GappUsers where email=:email",
						GappUsers.class).setParameter("email", email)
				.getResultList();
	}

	@Override
	public List<GappAcademicRecords> getGappAcademicRecords() {
		return entityManager.createQuery(
				"from GappAcademicRecords order by arid",
				GappAcademicRecords.class).getResultList();
	}

	@Override
	@Transactional
	public GappAcademicRecords saveAcademicRecords(
			GappAcademicRecords AcademicRecords) {
		return entityManager.merge(AcademicRecords);

	}

	@Override
	public GappAcademicRecords getGappAcademicRecordsId(Integer arid) {
		// TODO Auto-generated method stub
		return entityManager.find(GappAcademicRecords.class, arid);
		// return entityManager.createQuery("from GappUsers",
		// GappUsers.class).getResultList();
	}

	@Transactional
	@Override
	public GappAcademicRecords remove(GappAcademicRecords ar1) {
		// TODO Auto-generated method stub
		entityManager.remove(ar1);
		// return entityManager.createQuery("from GappUsers",
		// GappUsers.class).getResultList();
		return ar1;
	}

	@Transactional
	@Override
	public GappUsers saveUsers(GappUsers users) {
		return entityManager.merge(users);

	}

}