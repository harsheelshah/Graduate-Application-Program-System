package gapp.model.dao;

import java.util.List;

import gapp.model.GappAcademicRecords;
import gapp.model.GappDepartment;
import gapp.model.GappProgram;
import gapp.model.GappUsers;


public interface UsersDao {
	
	
	
	List<GappUsers> getUserType (String email,String password);
	
	GappUsers getUserId(Integer id);
	
	List<GappUsers> checkuser(String email );
	
	 List<GappAcademicRecords> getGappAcademicRecords();
	 
	GappAcademicRecords saveAcademicRecords(GappAcademicRecords AcademicRecords);
	 
	 GappAcademicRecords getGappAcademicRecordsId(Integer arid);
	 
	 GappAcademicRecords remove(GappAcademicRecords ar1);
	 
	 GappUsers saveUsers(GappUsers users);

}