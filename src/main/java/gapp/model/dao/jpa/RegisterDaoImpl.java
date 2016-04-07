package gapp.model.dao.jpa;

import gapp.model.GappUsers;
import gapp.model.dao.RegisterDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class RegisterDaoImpl implements RegisterDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public GappUsers saveUsers(GappUsers users){
		return entityManager.merge(users);
		
		
		
		 
	}
}
