package builders;

import model.Endpoint;

import org.springframework.ldap.core.DistinguishedName;


/**
 * Builder for an {@link Endpoint} for a core endpoint.
 * 
 * @author valerioventuri
 *
 */
public class CoreEndpointBuilder extends EndpointBuilder {

	
	public CoreEndpointBuilder(String host, int port, String vo) {

		super(host, port, vo);

		endpoint.setName("voms endpoint for Service vomsmania.cnaf.infn.it_VOMS_2715298739");

		endpoint.setId(buildEndpointId(host, vo));

		endpoint.setDn(new DistinguishedName("GLUE2EndpointID=" + endpoint.getId()));
		
		endpoint.setInterfaceName("org.glite.voms");
		endpoint.setInterfaceVersion("1");
		
		endpoint.setUrl("https://" + host + ":" +  port + "/voms/" + vo);

		endpoint.setServiceId("boh");
	}
	
	// TODO this is fake
	public static String buildEndpointId(String host, String vo) {
		
		return host + "_VOMS_" + "1234567890" + "_voms_" + "1234567890" + "_" + vo;
		
	}
}
