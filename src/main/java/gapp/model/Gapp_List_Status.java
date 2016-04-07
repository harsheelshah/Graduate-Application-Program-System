package gapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gapp_list_status")
public class Gapp_List_Status {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer list_status_id;
	
	private String description;

}
