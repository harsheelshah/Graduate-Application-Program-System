package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.GappApplication;
import gapp.model.GappDepartment;
import gapp.model.GappProgram;
import gapp.model.dao.ProgramDao;

@Repository
public class ProgramDaoImpl implements ProgramDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public GappProgram getProgramId(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(GappProgram.class, id);
		// return entityManager.createQuery("from GappUsers",
		// GappUsers.class).getResultList();
	}

	@Override
	public GappProgram getProgramName(String programname) {
		// TODO Auto-generated method stub
		// return entityManager.find(GappProgram.class, programname);
		return entityManager
				.createQuery(
						" from GappProgram  where programname=:programname",
						GappProgram.class)
				.setParameter("programname", programname).getSingleResult();
		// return entityManager.createQuery("from GappProgram",
		// GappProgram.class).getResultList();
	}

	@Transactional
	@Override
	public GappProgram remove(GappProgram p1) {
		// TODO Auto-generated method stub
		entityManager.remove(p1);
		// return entityManager.createQuery("from GappUsers",
		// GappUsers.class).getResultList();
		return p1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GappApplication> removeProgram(GappProgram prgmid) {

		return entityManager
				.createQuery(
						"delete  from GappApplication  where prgmid=:prgmid")
				.setParameter("prgmid", prgmid).getResultList();
	}

	@Override
	public List<GappProgram> getGappProgram() {
		return entityManager
				.createQuery(
						"select prgm from GappProgram prgm join prgm.deptid dept order by dept.deptid",
						GappProgram.class).getResultList();
	}

	@Override
	@Transactional
	public GappProgram saveProgram(GappProgram program) {
		return entityManager.merge(program);

	}

	@Override
	public List<GappProgram> getPrograms(Integer deptid) {
		return entityManager
				.createQuery(
						"select prgm from GappProgram prgm where deptid = :deptid",
						GappProgram.class).setParameter("deptid", deptid)
				.getResultList();
	}

}
