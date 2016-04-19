package gapp.model.dao;

import gapp.model.GappAdditional;
import gapp.model.GappDepartment;

import java.util.List;

public interface GappDepartmentDao {

	List<GappDepartment> getGappDepartment();

	GappDepartment saveDepartment(GappDepartment department);

	GappDepartment getDepartmentId(Integer id);

	GappAdditional getAdditionalId(Integer id);

	GappAdditional saveAdditional(GappAdditional additional);
}
