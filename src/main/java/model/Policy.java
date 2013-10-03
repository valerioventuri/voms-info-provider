package model;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = "GLUE2Policy")
public class Policy {

	@Id
	private Name name;
	
	
	
}
