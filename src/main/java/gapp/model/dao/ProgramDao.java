package gapp.model.dao;



import gapp.model.GappApplication;
import gapp.model.GappProgram;
import gapp.model.GappUsers;

import java.util.List;


public interface ProgramDao {

	List<GappProgram> getGappProgram();
	
	GappProgram saveProgram(GappProgram program);
	
	GappProgram remove(GappProgram p1);
	
	List<GappApplication> removeProgram (GappProgram prgmid);
	
	 GappProgram getProgramId(Integer id);
	 
	 GappProgram getProgramName(String programname);
	 
	 List<GappProgram> getPrograms(Integer deptid);
	 
}
