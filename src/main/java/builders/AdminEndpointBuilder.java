package builders;

import model.Endpoint;

import org.springframework.ldap.core.DistinguishedName;

/**
 * Builder for an {@link Endpoint} for an admin endpoint.
 * 
 * @author valerioventuri
 *
 */
public class AdminEndpointBuilder extends EndpointBuilder {

	public AdminEndpointBuilder(String host, int port, String vo) {

		super(host, port, vo);

		endpoint.setName("voms admin endpoint");
		
		endpoint.setId(buildAdminEndpointId(host, vo));
		
		endpoint.setDn(new DistinguishedName("GLUE2EndpointID=" + endpoint.getId()));
				
		endpoint.setInterfaceName("org.glite.voms-admin");
		endpoint.setInterfaceVersion("1");
		
		endpoint.getWsdls().add("https://" + host + ":" + port + "/voms/" + vo + "/services/VOMSAttributes?wsdl");
		endpoint.getWsdls().add("https://" + host + ":" + port + "/voms/igi.italiangrid.it/services/VOMSAdmin?wsdl");
		endpoint.getWsdls().add("https://" + host + ":" + port + "/voms/igi.italiangrid.it/services/VOMSSaml?wsdl");
		endpoint.getWsdls().add("https://" + host + ":" + port + "/voms/igi.italiangrid.it/services/VOMSACL?wsdl");
		endpoint.getWsdls().add("https://" + host + ":" + port + "/voms/igi.italiangrid.it /services/VOMSCompatibility?wsdl");
		endpoint.getWsdls().add("https://" + host + ":" + port + "/voms/igi.italiangrid.it/services/VOMSRegistration?wsdl");
		endpoint.getWsdls().add("https://" + host + ":" + port + "/voms/igi.italiangrid.it/services/VOMSCertificates?wsdl");
		endpoint.getWsdls().add("https://" + host + ":" + port + "/voms-admin-server/tree/3.x/resources/wsdls");

		endpoint.setUrl("https://" + host + ":" +  port + "/voms/" + vo);
		
		endpoint.setServiceId("boh");
	}
	
	public AdminEndpointBuilder usersCount(int usersCount) {
		
		endpoint.getOtherInfo().add("usersCount=" + usersCount);
		
		return this;
	}
	
	public AdminEndpointBuilder expiredUsersCount(int expiredUsersCount) {
		
		endpoint.getOtherInfo().add("expiredUsersCount=" + expiredUsersCount);
		
		return this;
	}

	public AdminEndpointBuilder suspendUsersCount(int suspendUsersCount) {
		
		endpoint.getOtherInfo().add("suspendUsersCount=" + suspendUsersCount);
		
		return this;
	}

	// TODO this is fake
	public static String buildAdminEndpointId(String host, String vo) {
		
		return host + "_VOMS_" + "1234567890" + "_voms-admin_" + "1234567890" + "_" + vo;
		
	}
	
}
