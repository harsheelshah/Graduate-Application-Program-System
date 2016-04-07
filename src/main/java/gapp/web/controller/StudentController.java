package gapp.web.controller;


import gapp.model.GappAcademicRecords;
import gapp.model.GappAdditional;
import gapp.model.GappApplication;
import gapp.model.GappApplicationStatus;
import gapp.model.GappDepartment;
import gapp.model.GappFile;
import gapp.model.GappProgram;
import gapp.model.GappUsers;
import gapp.model.GappUsersType;
import gapp.model.dao.AdditionalDao;
import gapp.model.dao.GappApplicationDao;
import gapp.model.dao.GappDepartmentDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.RegisterDao;
import gapp.model.dao.UsersDao;
import gapp.web.validator.StudentValidator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Controller
@SessionAttributes("GappApplication1")
public class StudentController {

	@Autowired
    private UsersDao usersDao;
	
	@Autowired
    private GappDepartmentDao deptDao;
	
	@Autowired
    private GappApplicationDao appDao;
	
	@Autowired
    private ProgramDao prgmDao;
	
	@Autowired
    private AdditionalDao additionalDao;
	
	@Autowired
    private RegisterDao registerDao;
	
	@Autowired
    private StudentValidator studentvalidator;
	
	
	
	@RequestMapping(value = "/student/editdept.html", method = RequestMethod.GET)
    public String EditDept(@RequestParam Integer deptid,ModelMap models){
    	
		//models.put( "GappProgram", prgmDao.getProgramId(prgmid) );
		models.put( "GappDepartment", deptDao.getDepartmentId(deptid) );
    	return "student/editdept";
    	
    }
	
	
	@RequestMapping(value = "/student/editdept.html", method = RequestMethod.POST)
    public String EditDept(@ModelAttribute GappDepartment d, BindingResult result){
    	
    	d = deptDao.saveDepartment(d);
    	return "redirect:addeddept.html?id="+d.getDeptid();
    	
    }
	
	
	@RequestMapping(value = "/student/addprgmdept.html", method = RequestMethod.GET)
    public String AddPrgmDept(@RequestParam Integer deptid,ModelMap models){
    	
		models.put( "GappDepartment", deptDao.getDepartmentId(deptid) );
		models.put( "GappProgram", new GappProgram() );
    	return "student/addprgmdept";
    	
    }
    
    @RequestMapping(value = "/student/addprgmdept.html", method = RequestMethod.POST)
    public String AddPrgmDept(@ModelAttribute GappProgram p, BindingResult result,@RequestParam Integer deptid){
    	
    	
    	List<GappDepartment> d = new ArrayList<GappDepartment>();
    	GappDepartment d1 = deptDao.getDepartmentId(deptid);
    	/*System.out.println(d1);
    	System.out.println(p);*/
    	//d.add(d1);
    	p.setDeptid(d1);
    	
    	    	
    	p = prgmDao.saveProgram(p);
    	return "redirect:addedprgm.html?id="+p.getPrgmid();
    	
    }
	
    
    
    @RequestMapping(value = "/student/addadditionaldept.html", method = RequestMethod.GET)
    public String AddAdditionalDept(@RequestParam Integer deptid,ModelMap models){
    	
		models.put( "GappDepartment", deptDao.getDepartmentId(deptid) );
		models.put( "GappAdditional", new GappAdditional() );
    	return "student/addadditionaldept";
    	
    }
    
    @RequestMapping(value = "/student/addadditionaldept.html", method = RequestMethod.POST)
    public String AddAdditionalDept(@ModelAttribute GappAdditional a, BindingResult result,@RequestParam Integer deptid,@RequestParam String type){
    	
    	
    	List<GappDepartment> d = new ArrayList<GappDepartment>();
    	GappDepartment d1 = deptDao.getDepartmentId(deptid);
    	
    	a.setDeptid(d1);
    	a.setRequired(true);  
    	a.setType(type);
    	a = deptDao.saveAdditional(a);
    	return "redirect:addedadditional.html?id="+a.getAdditionalid();
    	
    }
    
    
    
    @RequestMapping(value = "/student/removeprgm.html")
    public String RemovePrgm(@RequestParam Integer prgmid )
    {
    	   	
    	GappProgram p1 = prgmDao.getProgramId(prgmid);
    	/*List<GappApplication> a = appDao.getApplicationProgram(p1);
    	GappApplication a1 = new GappApplication();
    	a1.setPrgmid(null);
    	a.add(a1);
    	a = appDao.saveApplicationList(a);*/
    	//prgmDao.removeProgram(p1);
		prgmDao.remove(p1);
		
		return "redirect:pd.html?prgmid="+p1.getPrgmid();
		
    }
    
 
	
    @RequestMapping(value = "/student/pd.html")
    public String pd(@RequestParam Integer prgmid, ModelMap models )
    {
    	//GappProgram p1 = prgmDao.getProgramId(prgmid);
    	models.put( "GappProgram", prgmDao.getProgramId(prgmid) );
        return "student/pd";
    }

    
    
    @RequestMapping(value = "/student/removeadditional.html")
    public String RemoveAdditional(@RequestParam Integer additionalid )
    {
		
		GappAdditional a1 = additionalDao.getAdditionalId(additionalid);
		additionalDao.remove(a1);
		
		//prgmDao.removeProgram(p1);
        return "redirect:ad.html?additionalid="+a1.getAdditionalid();
		//return "student/ad";
    }
    
    
    @RequestMapping(value = "/student/ad.html")
    public String ad(@RequestParam Integer additionalid, ModelMap models )
    {
    	//GappProgram p1 = prgmDao.getProgramId(prgmid);
    	models.put( "GappAdditional", additionalDao.getAdditionalId(additionalid) );
        return "student/ad";
    }
	
	
	@RequestMapping(value = "/student/addprgm.html", method = RequestMethod.GET)
    public String AddPrgm(ModelMap models){
    	
		models.put( "GappDepartment", deptDao.getGappDepartment() );
		models.put( "GappProgram", new GappProgram() );
    	return "student/addprgm";
    	
    }
    
    @RequestMapping(value = "/student/addprgm.html", method = RequestMethod.POST)
    public String AddPrgm(@ModelAttribute GappProgram p, BindingResult result,@RequestParam Integer deptid){
    	
    	
    	List<GappDepartment> d = new ArrayList<GappDepartment>();
    	GappDepartment d1 = deptDao.getDepartmentId(deptid);
    	/*System.out.println(d1);
    	System.out.println(p);
    	d.add(d1);*/
    	p.setDeptid(d1);
    	    	
    	p = prgmDao.saveProgram(p);
    	return "redirect:addedprgm.html?id="+p.getPrgmid();
    	
    }
    
    @RequestMapping(value = "/student/addedprgm.html")
    public String AddedPrgm(@RequestParam Integer id, ModelMap models )
    {
		models.put( "GappProgram", prgmDao.getProgramId(id));
        return "student/addedprgm";
    }
    
    @RequestMapping(value = "/student/addadditional.html", method = RequestMethod.GET)
    public String AddAdditional(ModelMap models){
    	
		models.put( "GappDepartment", deptDao.getGappDepartment() );
		models.put( "GappAdditional", new GappAdditional() );
    	return "student/addadditional";
    	
    }
    
    @RequestMapping(value = "/student/addadditional.html", method = RequestMethod.POST)
    public String AddAdditional(@ModelAttribute GappAdditional p, BindingResult result,@RequestParam Integer deptid,@RequestParam String type){
    	
    	
    	List<GappDepartment> d = new ArrayList<GappDepartment>();
    	GappDepartment d1 = deptDao.getDepartmentId(deptid);
    	
    	p.setDeptid(d1);
    	p.setRequired(true);   
    	p.setType(type);
    	
    	p = deptDao.saveAdditional(p);
    	return "redirect:addedadditional.html?id="+p.getAdditionalid();
    }
    
    @RequestMapping(value = "/student/addedadditional.html")
    public String AddedAdditional(@RequestParam Integer id, ModelMap models )
    {
		models.put( "GappAdditional", deptDao.getAdditionalId(id));
        return "student/addedadditional";
    }
    
	
	@RequestMapping(value = "/student/adddept.html", method = RequestMethod.GET)
    public String AddDept(ModelMap models){
    	
		models.put( "GappDepartment", new GappDepartment() );
    	return "student/adddept";
    	
    }
    
    @RequestMapping(value = "/student/adddept.html", method = RequestMethod.POST)
    public String AddDept(@ModelAttribute GappDepartment d, BindingResult result){
    	
    	
    	d = deptDao.saveDepartment(d);
    	return "redirect:addeddept.html?id="+d.getDeptid();
    	
    }
	
	
    @RequestMapping(value = "/student/addeddept.html")
    public String AddedDept(@RequestParam Integer id, ModelMap models )
    {
		models.put( "GappDepartment", deptDao.getDepartmentId(id) );
        return "student/addeddept";
    }
	
	@RequestMapping(value = "/student/student.html")
    public String Student(@RequestParam Integer id, ModelMap models )
    {
		GappUsers users = usersDao.getUserId(id);
		models.put( "GappUsers", usersDao.getUserId(id) );
		models.put( "GappApplication", appDao.getGappApplicationUser(users) );
    	models.put( "GappProgram", new GappProgram() );
    	models.put( "GappDepartment", new GappDepartment() );
        return "student/student";
    }
	
	@RequestMapping(value = "/student/staff.html")
    public String Staff(@RequestParam Integer id, ModelMap models )
    {
		models.put( "GappUsers", usersDao.getUserId(id) );
        return "student/staff";
    }
	
	@RequestMapping(value = "/student/admin.html")
    public String Admin(ModelMap models )
    {
		
		//models.put( "GappUsers", usersDao.getUserId(id) );
		models.put( "GappDepartment", deptDao.getGappDepartment() );
		models.put( "GappProgram", prgmDao.getGappProgram() );
		models.put( "GappAdditional", additionalDao.getGappAdditional() );
		/*GappProgram p = (GappProgram) prgmDao.getGappProgram();
		GappDepartment d = (GappDepartment) deptDao.getGappDepartment();
		if(p.getDeptid().getDeptid()==d.getDeptid())
			models.put( "did", d.getDeptid() );	
		*/
        return "student/admin";
    }
	
	
	
	
	//Register
	
	@RequestMapping(value = "/student/registration.html", method = RequestMethod.GET)
    public String Register( ModelMap models )
    {
        models.put( "GappUsers", new GappUsers() );
        return "student/registration";
    }
	
	@RequestMapping(value = "/student/registration.html", method = RequestMethod.POST)
    public String Register(@ModelAttribute GappUsers GappUsers, BindingResult bindingResult, ModelMap model){
    	
		
		
    	studentvalidator.validate(GappUsers, bindingResult); 
		if(bindingResult.hasErrors()){ 
			model.put("GappUsers", GappUsers);
			model.put("emailerror", "Email already exists");
			return "student/registration";}
		
		
		
		List<GappUsersType> g = new ArrayList<GappUsersType>();
    	GappUsersType g1 = new GappUsersType();
    	
    	/*if(u.getEmail().equalsIgnoreCase(u.getEmail())){
    		System.out.println("Error");
    	}
    	else{
    	
    	System.out.println("u--"+u.getEmail());*/
    	
    	/*List<GappUsers> users1=usersDao.getemail(u.getEmail());
    	if(users1.size()>0)
    	{
    		System.out.println("Error");
    	}
    	else{*/
    	g1.setTypeid(3);
    	g.add(g1);
    	GappUsers.setTypeid(g);
    	
    	GappUsers = registerDao.saveUsers(GappUsers);
    	
    	//}
    	return "redirect:/";
    }
	
	
	//Login
	
	@RequestMapping(value = "/student/login.html", method = RequestMethod.GET)
    public String Login(ModelMap model){
    	
    	return "student/login";
    	
    }
    
    @RequestMapping(value = "/student/login.html", method = RequestMethod.POST)
    public String Login(@RequestParam String email, @RequestParam String password, ModelMap model){
    	
    	
    	List<GappUsers> gappusers = usersDao.getUserType(email, password);
    	
    	
	    	GappUsers user1 = gappusers.get(0);
    		   	
	    	//System.out.println(user1.getId());
	    	//System.out.println(user1.getTypeid().get(0).getTypeid());
	    	//System.out.println(gappusers.get(0).getTypeid());
	    	
	    	 if (user1.getTypeid().get(0).getTypeid()==(1)){
	    		return "redirect:admin.html?id="+user1.getId();
	    	}
	    	
	    	else if (user1.getTypeid().get(0).getTypeid()==(2)){
	    		return "redirect:staff.html?id="+user1.getId();
	        }
	    	
	    	else if (user1.getTypeid().get(0).getTypeid()==(3)){
	    		return "redirect:student.html?id="+user1.getId();
	    		
	    	}	
	    	else
	    	{
	    	System.out.println("Role not defined for user");	
	    	}
    	    	
    	return "student/login";
    }
	
    @RequestMapping(value = "/student/viewapplication.html")
    public String ViewApplication(@RequestParam Integer id,@RequestParam Integer deptid,@RequestParam Integer prgmid,@RequestParam Integer appid, ModelMap models )
    {
		
		models.put( "GappUsers", usersDao.getUserId(id) );
		models.put( "GappApplication", appDao.getApplicationId(appid) );
    	models.put( "GappProgram", prgmDao.getProgramId(prgmid) );
    	models.put( "GappDepartment", deptDao.getDepartmentId(deptid) );
        return "student/viewapplication";
    }
    
    
    @RequestMapping(value = "/student/editapplication.html", method = RequestMethod.GET)
    public String EditApplication(@RequestParam Integer id,@RequestParam Integer deptid,@RequestParam Integer prgmid,@RequestParam Integer appid, ModelMap models )
    {
    	models.put( "GappUsers1", usersDao.getUserId(id) );
		models.put( "GappApplication1", appDao.getApplicationId(appid) );
    	models.put( "GappProgram", prgmDao.getProgramId(prgmid) );
    	models.put( "GappPrograms", prgmDao.getGappProgram() );
    	models.put( "GappDepartment", deptDao.getDepartmentId(deptid) );
    	models.put( "GappDepartments", deptDao.getGappDepartment());
    	
        return "student/editapplication";
    }
	
    @RequestMapping(value = "/student/editapplication.html", method = RequestMethod.POST)
    public String EditApplication( @ModelAttribute GappApplication GappApplication1, BindingResult bindingResult,@RequestParam MultipartFile transcript, HttpServletRequest request,@RequestParam Integer appid, @RequestParam Integer user1, @RequestParam Integer dept,@RequestParam Integer prgm,@RequestParam String term,@RequestParam Integer fileid,@RequestParam String[] colname ,@RequestParam String[] timeattend,@RequestParam String[] degreeearn,@RequestParam String[] major,@RequestParam String[] gpa ) throws IllegalStateException, IOException{
    	   	
    	
    	String save = request.getParameter("Save");
    	String submit = request.getParameter("Submit");   
    	//Integer user2 = (Integer.parseInt( request.getParameter("user1")));
    	//System.out.println(colname);
    	
    	
    	if(save!=null){
    		
    		//System.out.println("Hi");
    		
    		GappUsers u1 = usersDao.getUserId(user1);
    		GappApplication1.setId(u1);
        	
    		GappProgram p = prgmDao.getProgramId(prgm);
    		
    		GappApplication1.setPrgmid(p);
    		GappApplication1.setTerm(term);
    		GappApplicationStatus s1 = new GappApplicationStatus();
         	s1.setStatusid(2);
         	GappApplication1.setStatusid(s1);
         	
         	Date d = new Date();
         	GappApplication1.setDate(d);
        	//System.out.println("date is "+d.getTime());
        	String a = d.getTime()+"_";
        	GappFile file = new GappFile();
        	if(transcript.getOriginalFilename().isEmpty())
        	{
        		if(fileid!=null){
        		GappFile f = appDao.getFileId(fileid);
             	GappApplication1.setTranscript(f);
        		}
        	}
        	else{
        		file.setFilename(a+transcript.getOriginalFilename());
             	file.setSize(transcript.getSize());
             	file.setType(transcript.getContentType());
             	GappApplication1.setTranscript(appDao.saveFile(file));
            	transcript.transferTo(new File(getFileDirectory(),a+transcript.getOriginalFilename())); 
        	}
         	
         	        	
         	
         	
         	GappApplication1 = appDao.saveApplication(GappApplication1);
    		
        	
        	
        	for(int i=0;i<colname.length;i++){
        		if(colname[i].length()>0){
        		GappAcademicRecords aca = new GappAcademicRecords();
        		aca.setCollegename(colname[i]); 
        		aca.setTimeattended(timeattend[i]);
        		aca.setDegreeearned(degreeearn[i]);
        		aca.setMajor(major[i]);
        		aca.setGPA(gpa[i]);
        		aca.setAppid(GappApplication1);
        		aca = usersDao.saveAcademicRecords(aca);
        		}
        	}        	
        	
        	return "redirect:student.html?id="+user1;
        	
    	}
    	
    
    	else
    	{
    		
    		GappUsers u1 = usersDao.getUserId(user1);
    		GappApplication1.setId(u1);
        	
    		GappProgram p = prgmDao.getProgramId(prgm);
    		
    		GappApplication1.setPrgmid(p);
    		GappApplication1.setTerm(term);
    		GappApplicationStatus s1 = new GappApplicationStatus();
         	s1.setStatusid(1);
         	GappApplication1.setStatusid(s1);
         	
         	Date d = new Date();
         	GappApplication1.setDate(d);
        	//System.out.println("date is "+d.getTime());
        	String a = d.getTime()+"_";
        	GappFile file = new GappFile();
        	if(transcript.getOriginalFilename().isEmpty())
        	{
        		if(fileid!=null){
            		GappFile f = appDao.getFileId(fileid);
                 	GappApplication1.setTranscript(f);
            		}
        	}
        	else{
        		file.setFilename(a+transcript.getOriginalFilename());
             	file.setSize(transcript.getSize());
             	file.setType(transcript.getContentType());
             	GappApplication1.setTranscript(appDao.saveFile(file));
            	transcript.transferTo(new File(getFileDirectory(),a+transcript.getOriginalFilename())); 
        	}
         	
         	GappApplication1 = appDao.saveApplication(GappApplication1);
    		
        	
        	
         	for(int i=0;i<colname.length;i++){
        		if(colname[i].length()>0){
        		GappAcademicRecords aca = new GappAcademicRecords();
        		aca.setCollegename(colname[i]); 
        		aca.setTimeattended(timeattend[i]);
        		aca.setDegreeearned(degreeearn[i]);
        		aca.setMajor(major[i]);
        		aca.setGPA(gpa[i]);
        		aca.setAppid(GappApplication1);
        		aca = usersDao.saveAcademicRecords(aca);
        		}
        	}        	
        	
        	return "redirect:student.html?id="+user1;
    	}
    	
    	//return "student/student";
    	
    }
    
    
    
    
    @Autowired
    private ServletContext context;
    
    private File getFileDirectory() {
 		String path=context.getRealPath("/WEB-INF/files");
 		return new File(path);
 	}
    
    @RequestMapping("/download.html")
    private String download( 
        HttpServletResponse response,@RequestParam String filename) throws ServletException, IOException
    {
	  
        response.setContentType( "application/octet-stream" );
        response.setHeader( "Content-Disposition",
            "attachment; filename="+filename);

        FileInputStream in = new FileInputStream(getFileDirectory()+"/"+filename);
        OutputStream out = response.getOutputStream();

        byte buffer[] = new byte[2048];
        int bytesRead;
        while( (bytesRead = in.read( buffer )) > 0 )
            out.write( buffer, 0, bytesRead );

        in.close();
        return null;
    }
    
    
    
    @RequestMapping(value = "/student/ListGappPrograms.html", method = RequestMethod.GET)
    public List<GappProgram> ListGappPrograms(@RequestParam(value="deptid", required=true) Integer deptid, ModelMap models){
    	
    
    	System.out.println("Hi");
		//models.put( "GappDepartment", deptDao.getDepartmentId(dept) );
		//models.put("GetPrograms", deptDao.getDepartmentId(dept).getPrgmid());
		models.put("prgm", prgmDao.getPrograms(deptid));
		//json = new Gson().toJson(list);
		
    	//return "jsonView";
    	return prgmDao.getPrograms(deptid);
    }
    
    @RequestMapping(value = "/student/createapplication.html", method = RequestMethod.GET)
    public String CreateApplication( @RequestParam Integer id, ModelMap models){
    	
    	//System.out.println("Hi");
    	models.put( "GappDepartment", deptDao.getGappDepartment() );
    	models.put( "GappApplication1", new GappApplication() );
    	
    	models.put( "GappUsers", usersDao.getUserId(id) );
		
		//models.put("GetPrograms", deptDao.getDepartmentId(dept).getPrgmid());
		models.put("GappProgram", prgmDao.getGappProgram());
    	return "student/createapplication";
    	
    }
    
    
    @SuppressWarnings("deprecation")
	@RequestMapping(value = "/student/createapplication.html", method = RequestMethod.POST)
    public String CreateApplication(@ModelAttribute GappApplication GappApplication1, BindingResult bindingResult,@RequestParam MultipartFile transcript, HttpServletRequest request,@RequestParam String term, @RequestParam Integer user, @RequestParam Integer dept,@RequestParam String[] colname ,@RequestParam String[] timeattend,@RequestParam String[] degreeearn,@RequestParam String[] major,@RequestParam String[] gpa ) throws IllegalStateException, IOException{
    	   	
    	
    	String save = request.getParameter("Save");
    	String submit = request.getParameter("Submit"); 
    	String prgm1 = request.getParameter("prgm");
    	//System.out.println("prgm is "+prgm1);
    	
    	Integer user1 = (Integer.parseInt(request.getParameter("user")));
    	//System.out.println(colname);
    	
    	
    	if(save!=null){
    		
    		GappProgram p1 = prgmDao.getProgramName(prgm1);
        	GappUsers u1 = usersDao.getUserId(user);
        	
        	       	
        	
         	List<GappApplicationStatus> apps1 = new ArrayList<GappApplicationStatus>();
         	GappApplicationStatus s1 = new GappApplicationStatus();
         	s1.setStatusid(2);
         	apps1.add(s1);
        	GappApplication1.setPrgmid(p1);
        	GappApplication1.setId(u1);  
        	GappApplication1.setTerm(term);
        	GappApplication1.setStatusid(s1);
        	Date d = new Date();
        	GappApplication1.setDate(d);
        	//System.out.println("date is "+d.getTime());
        	String a = d.getTime()+"_";
        	GappFile file = new GappFile();
        	if(!transcript.getOriginalFilename().isEmpty())
        	{
        		file.setFilename(a+transcript.getOriginalFilename());
             	file.setSize(transcript.getSize());
             	file.setType(transcript.getContentType());
             	GappApplication1.setTranscript(appDao.saveFile(file));
            	transcript.transferTo(new File(getFileDirectory(),a+transcript.getOriginalFilename()));
        	}
        	     	
         	
        	
        	//List<GappUsers> u = (List<GappUsers>) usersDao.getUserId(user1);
        	//u.setArid(lacademic);
        	//u = usersDao.saveAcademicRecords(lacademic);
        	GappApplication1 = appDao.saveApplication(GappApplication1);
        	

        	for(int i=0;i<colname.length;i++){
        		if(colname[i].length()>0){
        		GappAcademicRecords aca = new GappAcademicRecords();
        		aca.setCollegename(colname[i]); 
        		aca.setTimeattended(timeattend[i]);
        		aca.setDegreeearned(degreeearn[i]);
        		aca.setMajor(major[i]);
        		aca.setGPA(gpa[i]);
        		aca.setAppid(GappApplication1);
        		aca = usersDao.saveAcademicRecords(aca);
        		}
        	}
        	
        	return "redirect:student.html?id="+user;
    	}
    	
    
    	else
    	{
    		GappProgram p1 = prgmDao.getProgramName(prgm1);
        	GappUsers u1 = usersDao.getUserId(user);
        	
        	
        	
        	
         	List<GappApplicationStatus> apps1 = new ArrayList<GappApplicationStatus>();
         	GappApplicationStatus s1 = new GappApplicationStatus();
         	s1.setStatusid(1);
         	apps1.add(s1);
        	GappApplication1.setPrgmid(p1);
        	GappApplication1.setId(u1);  
        	GappApplication1.setTerm(term);
        	GappApplication1.setStatusid(s1);
        	Date d = new Date();
        	GappApplication1.setDate(d);
        	//System.out.println("date is "+d.getTime());
        	String a = d.getTime()+"_";
        	GappFile file = new GappFile();
        	if(!transcript.getOriginalFilename().isEmpty())
        	{
        		file.setFilename(a+transcript.getOriginalFilename());
             	file.setSize(transcript.getSize());
             	file.setType(transcript.getContentType());
             	GappApplication1.setTranscript(appDao.saveFile(file));
            	transcript.transferTo(new File(getFileDirectory(),a+transcript.getOriginalFilename()));
        	}
        	     	
         	
        	
        	//List<GappUsers> u = (List<GappUsers>) usersDao.getUserId(user1);
        	//u.setArid(lacademic);
        	//u = usersDao.saveAcademicRecords(lacademic);
        	GappApplication1 = appDao.saveApplication(GappApplication1);
        	

        	for(int i=0;i<colname.length;i++){
        		if(colname[i].length()>0){
        		GappAcademicRecords aca = new GappAcademicRecords();
        		aca.setCollegename(colname[i]); 
        		aca.setTimeattended(timeattend[i]);
        		aca.setDegreeearned(degreeearn[i]);
        		aca.setMajor(major[i]);
        		aca.setGPA(gpa[i]);
        		aca.setAppid(GappApplication1);
        		aca = usersDao.saveAcademicRecords(aca);
        		}
        	}
        	
        	return "redirect:student.html?id="+user;
    	}
    	
    	//return "student/student";
    	
    }
    
    
    
    
    
    @RequestMapping(value = "/student/removedegree.html")
    public String RemoveEducation(@RequestParam Integer arid,@RequestParam Integer prgmid,@RequestParam Integer deptid,@RequestParam Integer id,@RequestParam Integer appid )
    {
    	   	
    	GappAcademicRecords ar1 = usersDao.getGappAcademicRecordsId(arid);
    	
		usersDao.remove(ar1);
		   
		
		return "redirect:editapplication.html?prgmid="+prgmid+"&&deptid="+deptid+"&&appid="+appid+"&&id="+id;
		
    }
    
    
    
    @RequestMapping(value = "/student/getProg.html", method = RequestMethod.GET)
	public @ResponseBody String getPrograms( HttpServletRequest request ,HttpServletResponse response,ModelMap models) {
		
    	String json = null;
    	List<String> addprgm = new ArrayList<String>();
    	
		Integer department = Integer.parseInt(request.getParameter("department"));	
		GappDepartment d = deptDao.getDepartmentId(department);
					
		List<GappProgram> p = d.getPrgmid();
	
		for(GappProgram p1:p){
			addprgm.add(p1.getProgramname());	
		}
		
		json = new Gson().toJson(addprgm);
		response.setContentType("application/json");
		try 
		{
			response.getWriter().write(json);
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
    

    
    
}
	
	
