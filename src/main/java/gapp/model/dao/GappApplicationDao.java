package gapp.model.dao;

import gapp.model.GappApplication;
import gapp.model.GappApplicationStatus;
import gapp.model.GappDepartment;
import gapp.model.GappFile;
import gapp.model.GappProgram;
import gapp.model.GappUsers;

import java.util.List;

public interface GappApplicationDao {

	List<GappApplication> getGappApplication();

	GappApplication getApplicationId(Integer id);

	List<GappApplication> getGappApplicationUser(GappUsers users);

	GappApplication saveApplication(GappApplication application);

	GappApplicationStatus saveApplicationStatus(
			GappApplicationStatus application);

	List<GappApplication> saveApplicationList(List<GappApplication> application);

	GappFile saveFile(GappFile file);

	/* GappFile getFileName(GappApplication application); */

	List<GappApplication> getApplication();

	List<GappApplication> getApplicationProgram(GappProgram prgm);

	GappFile getFileId(Integer fileid);

}
