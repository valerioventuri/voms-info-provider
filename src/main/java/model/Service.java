package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Name;

import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = "GLUE2Service")
public class Service {

	@Id
	private Name dn;

	@Attribute(name = "GLUE2EntityCreationTime")
	private Date creationTime;

	@Attribute(name = "GLUE2EntityValidity")
	private int validity;
	
	@Attribute(name = "GLUE2EntityOtherInfo")
	private List<String> otherInfo;
	
	@Attribute(name = "GLUE2EntityName")
	private String name;
	
	@Attribute(name = "GLUE2ServiceID")
	private String id;
	
	@Attribute(name = "GLUE2ServiceCapability")
	private String capability;
	
	@Attribute(name = "GLUE2ServiceType")
	private String type;

	@Attribute(name = "GLUE2ServiceQualityLevel")
	private String qualityLevel;
	
	@Attribute(name = "GLUE2ServiceStatusInfo")
	private String statusInfo;
	
	@Attribute(name = "GLUE2ServiceComplexity")
	private String complexity;

	@Attribute(name = "GLUE2ServiceAdminDomainForeignKey")
	private String serviceAdminDomain;
	
	
	public Service() {}
	
	public Service(String site) {

		setId("0123456789");
		
		setDn(new DistinguishedName("GLUE2ServiceID=" +  id));

		setCreationTime();
		setValidity(3600);
		setName(site + "-voms");
		getOtherInfo().add("InfoProviderName=voms-glue2");
		getOtherInfo().add("InfoProviderVersion=0.0.1");
		getOtherInfo().add("InfoProviderHost=localhost");
		getOtherInfo().add("ProfileName=EGI");
		getOtherInfo().add("ProfileVersion=1.0");

		setCapability("security.attributeauthority");
		setType("org.glite.voms");
		setQualityLevel("production");
		setComplexity("endpointType=2, share=0, resource=0");
		setServiceAdminDomain(site);
		
	}
	
	public Name getDn() {
		
		return dn;
	}

	public void setDn(Name dn) {
		this.dn = dn;
	}

	/**
	 * @return the name
	 */
	public String getName() {
	
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
	
		this.name = name;
	}
	
	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
	
		return creationTime;
	}

	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime() {
	
		this.creationTime = new Date();
	}

	/**
	 * @return the validity
	 */
	public int getValidity() {
	
		return validity;
	}
	
	/**
	 * @param validity the validity to set
	 */
	public void setValidity(int validity) {
	
		this.validity = validity;
	}
	
	/**
	 * @return the otherInfo
	 */
	public List<String> getOtherInfo() {
	
		if(otherInfo == null)
			otherInfo = new ArrayList<String>();
		
		return otherInfo;
	}

	/**
	 * @param otherInfo the otherInfo to set
	 */
	public void setOtherInfo(List<String> otherInfo) {
	
		this.otherInfo = otherInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCapability() {
		return capability;
	}

	public void setCapability(String capability) {
		this.capability = capability;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQualityLevel() {
		return qualityLevel;
	}

	public void setQualityLevel(String qualityLevel) {
		this.qualityLevel = qualityLevel;
	}

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}
	
	public String getServiceAdminDomain() {
		return serviceAdminDomain;
	}
	
	public void setServiceAdminDomain(String serviceAdminDomain) {
		this.serviceAdminDomain = serviceAdminDomain;
	}
	
}
