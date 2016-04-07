package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.GappApplication;
import gapp.model.dao.GappAccountingDao;

@Repository
public class GappAccountingDaoImpl implements GappAccountingDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<GappApplication> getGappAccounting() {
		return entityManager.createQuery( "select application from GappApplication application join application.prgmid program join program.deptid did where did.departmentname='Accounting' and application.term='Fall 2016' ", GappApplication.class )
				.getResultList();
	}
	
	
}
