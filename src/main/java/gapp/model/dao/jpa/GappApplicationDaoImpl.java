package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.GappApplication;
import gapp.model.GappApplicationStatus;
import gapp.model.GappDepartment;
import gapp.model.GappFile;
import gapp.model.GappProgram;
import gapp.model.GappUsers;
import gapp.model.dao.GappApplicationDao;

@Repository
public class GappApplicationDaoImpl implements GappApplicationDao{
	
	  @PersistenceContext
	    private EntityManager entityManager;
	  
	 
		@Override
		public List<GappApplication> getGappApplication() {
			//return entityManager.createQuery( "from GappApplication where id.firstname='Neil' " , GappApplication.class )
			return entityManager.createQuery( "select application from GappApplication application join application.id user join user.typeid typ where user.firstname='Neil' and typ.type='Students' " , GappApplication.class )	
		            //.setParameter("x", x).setParameter("y", y).getResultList();
					.getResultList();
		}
		
		
		@Override
		public List<GappApplication> getGappApplicationUser(GappUsers users) {
			//return entityManager.createQuery( "from GappApplication where id.firstname='Neil' " , GappApplication.class )
			return entityManager.createQuery( "select application from GappApplication application  where application.id=:users " , GappApplication.class )	
		            //.setParameter("x", x).setParameter("y", y).getResultList();
					.setParameter("users", users).getResultList();
		}
		


		@Override
		public GappApplication getApplicationId(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(GappApplication.class, id);
			//return  entityManager.createQuery("from GappUsers", GappUsers.class).getResultList();
		}
		
		@Override
		@Transactional
		public GappApplication saveApplication(GappApplication application){
			return entityManager.merge(application);
			 
		}
		
		
		@Override
		@Transactional
		public GappApplicationStatus saveApplicationStatus(GappApplicationStatus application){
			return entityManager.merge(application);
			 
		}
		
		@Override
		@Transactional
		public List<GappApplication> saveApplicationList(List<GappApplication> application){
			return entityManager.merge(application);
			 
		}
		
		
		@Override
		@Transactional
		public GappFile saveFile(GappFile file) {
			// TODO Auto-generated method stub
			return entityManager.merge( file );
		}

		
		
		
		@Override
		public List<GappApplication> getApplication() {
			return entityManager.createQuery( "from GappApplication order by id", GappApplication.class )
		            .getResultList();
		}
		
		
		@Override
		public List<GappApplication> getApplicationProgram(GappProgram prgm) {
			//return entityManager.createQuery( "from GappApplication where id.firstname='Neil' " , GappApplication.class )
			return entityManager.createQuery( "select application from GappApplication application  where application.prgmid=:prgm " , GappApplication.class )	
		            //.setParameter("x", x).setParameter("y", y).getResultList();
					.setParameter("prgm", prgm).getResultList();
		}
		
		
		@Override
		public GappFile getFileId(Integer fileid) {
			// TODO Auto-generated method stub
			return entityManager.find(GappFile.class, fileid);
			//return  entityManager.createQuery("from GappUsers", GappUsers.class).getResultList();
		}
		
		
}
