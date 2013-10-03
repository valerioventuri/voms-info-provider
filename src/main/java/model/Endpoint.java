package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = "GLUE2Endpoint")
public class Endpoint {

	@Id
	private Name dn;
	
	@Attribute(name = "GLUE2EntityCreationTime")
	private Date creationTime;

	@Attribute(name = "GLUE2EntityValidity")
	private int validity = 3600;
	
	@Attribute(name = "GLUE2EntityOtherInfo")
	private List<String> otherInfo;
	
	@Attribute(name = "GLUE2EntityName")
	private String name;
	
	@Attribute(name = "GLUE2EndpointID")
	private String id;

	@Attribute(name = "GLUE2EndpointURL")
	private String url;
	
	@Attribute(name = "GLUE2EndpointCapability")
	private String capability;

	@Attribute(name = "GLUE2EndpointTechnology")
	private String technology;

	@Attribute(name = "GLUE2EndpointInterfaceName")
	private String interfaceName;

	@Attribute(name = "GLUE2EndpointInterfaceVersion")
	private String interfaceVersion;
	
	@Attribute(name = "GLUE2EndpointWSDL")
	private List<String> wsdls;

	@Attribute(name = "GLUE2EndpointSemantics")
	private String semantics;
	
	@Attribute(name = "GLUE2EndpointImplementor")
	private String implementor;

	@Attribute(name = "GLUE2EndpointImplementationName")
	private String implementationName;

	@Attribute(name = "GLUE2EndpointImplementationVersion")
	private String implementationVersion;

	@Attribute(name = "GLUE2EndpointQualityLevel")
	private String qualityLevel;

	@Attribute(name = "GLUE2EndpointHealthState")
	private String healtState;

	@Attribute(name = "GLUE2EndpointHealthStateInfo")
	private String healtStateInfo;
	
	@Attribute(name = "GLUE2EndpointServingState")
	private String servingState;
	
	@Attribute(name = "GLUE2EndpointStartTime")
	private Date startTime;
	
	@Attribute(name = "GLUE2EndpointIssuerCA")
	private String issuerCA;

	@Attribute(name = "GLUE2EndpointTrustedCA")
	private String trustedCA;

	@Attribute(name = "GLUE2EndpointServiceForeignKey")	
	private String serviceId;
	
	/**
	 * @return the dn
	 */
	public Name getDn() {
	
		return dn;
	}

	/**
	 * @param dn the dn to set
	 */
	public void setDn(Name dn) {
	
		this.dn = dn;
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
	 * @return the id
	 */
	public String getId() {
	
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
	
		this.id = id;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
	
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
	
		this.url = url;
	}

	/**
	 * @return the capability
	 */
	public String getCapability() {
	
		return capability;
	}

	/**
	 * @param capability the capability to set
	 */
	public void setCapability(String capability) {
	
		this.capability = capability;
	}

	/**
	 * @return the technology
	 */
	public String getTechnology() {
	
		return technology;
	}

	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
	
		this.technology = technology;
	}

	/**
	 * @return the interfaceName
	 */
	public String getInterfaceName() {
	
		return interfaceName;
	}

	/**
	 * @param interfaceName the interfaceName to set
	 */
	public void setInterfaceName(String interfaceName) {
	
		this.interfaceName = interfaceName;
	}

	/**
	 * @return the interfaceVersion
	 */
	public String getInterfaceVersion() {
	
		return interfaceVersion;
	}

	/**
	 * @param interfaceVersion the interfaceVersion to set
	 */
	public void setInterfaceVersion(String interfaceVersion) {
	
		this.interfaceVersion = interfaceVersion;
	}

	/**
	 * @return the wsdls
	 */
	public List<String> getWsdls() {
	
		if(wsdls == null)
			wsdls = new ArrayList<String>();
		
		return wsdls;
	}

	/**
	 * @param wsdls the wsdls to set
	 */
	public void setWsdls(List<String> wsdls) {
	
		this.wsdls = wsdls;
	}

	/**
	 * @return the semantics
	 */
	public String getSemantics() {
	
		return semantics;
	}

	/**
	 * @param semantics the semantics to set
	 */
	public void setSemantics(String semantics) {
	
		this.semantics = semantics;
	}

	/**
	 * @return the implementor
	 */
	public String getImplementor() {
	
		return implementor;
	}

	/**
	 * @param implementor the implementor to set
	 */
	public void setImplementor(String implementor) {
	
		this.implementor = implementor;
	}

	/**
	 * @return the implementationName
	 */
	public String getImplementationName() {
	
		return implementationName;
	}

	/**
	 * @param implementationName the implementationName to set
	 */
	public void setImplementationName(String implementationName) {
	
		this.implementationName = implementationName;
	}

	/**
	 * @return the implementationVersion
	 */
	public String getImplementationVersion() {
	
		return implementationVersion;
	}

	/**
	 * @param implementationVersion the implementationVersion to set
	 */
	public void setImplementationVersion(String implementationVersion) {
	
		this.implementationVersion = implementationVersion;
	}

	/**
	 * @return the qualityLevel
	 */
	public String getQualityLevel() {
	
		return qualityLevel;
	}

	/**
	 * @param qualityLevel the qualityLevel to set
	 */
	public void setQualityLevel(String qualityLevel) {
	
		this.qualityLevel = qualityLevel;
	}

	/**
	 * @return the healtState
	 */
	public String getHealtState() {
	
		return healtState;
	}

	/**
	 * @param healtState the healtState to set
	 */
	public void setHealtState(String healtState) {
	
		this.healtState = healtState;
	}

	/**
	 * @return the healtStateInfo
	 */
	public String getHealtStateInfo() {
	
		return healtStateInfo;
	}

	/**
	 * @param healtStateInfo the healtStateInfo to set
	 */
	public void setHealtStateInfo(String healtStateInfo) {
	
		this.healtStateInfo = healtStateInfo;
	}

	/**
	 * @return the servingState
	 */
	public String getServingState() {
	
		return servingState;
	}

	/**
	 * @param servingState the servingState to set
	 */
	public void setServingState(String servingState) {
	
		this.servingState = servingState;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
	
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
	
		this.startTime = startTime;
	}

	/**
	 * @return the issuerCA
	 */
	public String getIssuerCA() {
	
		return issuerCA;
	}

	/**
	 * @param issuerCA the issuerCA to set
	 */
	public void setIssuerCA(String issuerCA) {
	
		this.issuerCA = issuerCA;
	}

	/**
	 * @return the trustedCA
	 */
	public String getTrustedCA() {
	
		return trustedCA;
	}

	/**
	 * @param trustedCA the trustedCA to set
	 */
	public void setTrustedCA(String trustedCA) {
	
		this.trustedCA = trustedCA;
	}

	
	/**
	 * @return the serviceId
	 */
	public String getServiceId() {
	
		return serviceId;
	}

	
	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(String serviceId) {
	
		this.serviceId = serviceId;
	}

	
	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(Date creationTime) {
	
		this.creationTime = creationTime;
	}

}
