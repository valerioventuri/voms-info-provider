package builders;

import static org.junit.Assert.*;

import model.Endpoint;

import org.junit.Test;


public class CoreEndpointBuilderTest {

	String HOST = "voms.example.org"; 
	int PORT = 15000;
	String VO = "vo";
	
	@Test
	public void test() {

		CoreEndpointBuilder builder = new CoreEndpointBuilder(HOST, PORT, VO);
		
		Endpoint endpoint = builder.build();
		
		// TODO assert endpoint.getCreationtime?
		assertEquals(3600, endpoint.getValidity());
		// TODO assert endpoint.getEntityName
		// TOTO assert endpoint.getOtherInfo
		
		// TODO assert endpoing.getId()
		
		assertEquals("https://" + HOST + ":" + PORT + "/voms/" + VO, endpoint.getUrl());
		assertEquals("security.attributeauthority", endpoint.getCapability());
		assertEquals("webservice", endpoint.getTechnology());
		assertEquals("org.glite.voms", endpoint.getInterfaceName());
		assertEquals("1", endpoint.getInterfaceVersion());
		// TODO assert endpoint.getWSDL()
		assertEquals("https://github.com/italiangrid/voms/wiki", endpoint.getSemantics());
		assertEquals("gLite", endpoint.getImplementor());
		assertEquals("VOMS", endpoint.getImplementationName());

		//assertEquals("production", endpoint.getQualityLevel());
		//assertEquals("ok", endpoint.getHealtState());
		//assertEquals("production", endpoint.getServingState());
		// TODO assert endpoint.getStartTime()?
		//assertEquals("/C=IT/O=INFN/CN=INFN CA", endpoint.getIssuerCA());
		//assertEquals("IGTF", endpoint.getTrustedCA());		
		
		
	}

}
