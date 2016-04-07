package gapp.web.validator;

import java.util.List;

import gapp.model.GappUsers;
import gapp.model.dao.UsersDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.util.StringUtils;

@Component
public class StudentValidator implements Validator{
	
	
	@Autowired
	private UsersDao usersdao;

	@Override
	public boolean supports(Class<?> clazz) {
		return GappUsers.class.isAssignableFrom(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		GappUsers gappusers = (GappUsers) target;
		//System.out.println("test gap user"+gappusers.getFirstname());
		//System.out.println("test gap user2"+gappusers.getLastname());
		if(!StringUtils.hasText(gappusers.getFirstname())){
			//System.out.println("Inside firstname");
			errors.rejectValue("firstname", "error.field.empty");}
		if(!StringUtils.hasText(gappusers.getLastname())){
			errors.rejectValue("lastname", "error.field.empty");}
		if(!StringUtils.hasText(gappusers.getEmail())){
			errors.rejectValue("email", "error.field.empty");}
		if(StringUtils.hasText(gappusers.getEmail())){
			List<GappUsers> u1 = usersdao.checkuser(gappusers.getEmail().toLowerCase());
			if(u1.size()>0)
			{
				errors.rejectValue("email", "error.field.existing");}	
			}
		if(!StringUtils.hasText(gappusers.getPassword())){
			errors.rejectValue("password", "error.field.empty");}
	}

	}

