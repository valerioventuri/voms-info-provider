package builders;

import static org.junit.Assert.*;

import model.Endpoint;

import org.junit.Test;

/**
 * Tests that a builder for an endpoint representing a 
 * voms-admin endpoint builds an endpoint with correct information.
 * 
 * 
 * @author valerioventuri
 *
 */
public class AdminEndpointBuilderTest {

	String HOST = "voms.example.org"; 
	int PORT = 8443;
	String VO = "vo";
	
	
	@Test
	public void testBuilder() {

		AdminEndpointBuilder builder = new AdminEndpointBuilder(HOST, PORT, VO);
		
		Endpoint endpoint = builder.build();
		
		// TODO assert endpoint.getCreationtime?
		assertEquals(3600, endpoint.getValidity());
		// TODO assert endpoint.getEntityName
		// TOTO assert endpoint.getOtherInfo
		
		assertEquals("https://" + HOST + ":" + PORT + "/voms/" + VO, endpoint.getUrl());
		assertEquals("security.attributeauthority", endpoint.getCapability());
		assertEquals("webservice", endpoint.getTechnology());
		assertEquals("org.glite.voms-admin", endpoint.getInterfaceName());
		assertEquals("1", endpoint.getInterfaceVersion());
		// TODO endpoint.getWSDL();
		assertEquals("https://github.com/italiangrid/voms/wiki", endpoint.getSemantics());
		assertEquals("gLite", endpoint.getImplementor());
		assertEquals("VOMS", endpoint.getImplementationName());

		//assertEquals("production", endpoint.getQualityLevel());
		//assertEquals("ok", endpoint.getHealtState());
		//assertEquals("production", endpoint.getServingState());
		// TODO assert wendpoint.getStartTime
		//assertEquals("/C=IT/O=INFN/CN=INFN CA", endpoint.getIssuerCA());
		//assertEquals("IGTF", endpoint.getTrustedCA());		
		
	}

	
	
}
