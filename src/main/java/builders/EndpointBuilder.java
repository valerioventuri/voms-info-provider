package builders;
import model.Endpoint;


/**
 * Builder for an {@link Endpoint} for a generic endpoint.
 * 
 * This is an abstract class meant to be subclassed to provide builders for
 * specific endpoint.
 * 
 * @author valerioventuri
 *
 */
public abstract class EndpointBuilder {

	protected Endpoint endpoint;
	
	
	public EndpointBuilder(String host, int port, String vo) {

		endpoint = new Endpoint();
		
		endpoint.getOtherInfo().add("InfoProviderName=glite-info-glue2-endpoint");
		endpoint.getOtherInfo().add("InfoProviderVersion=1.4");
		endpoint.getOtherInfo().add("ProfileName=EGI");
		endpoint.getOtherInfo().add("ProfileVersion=1.0");
		endpoint.getOtherInfo().add("MiddlewareName=EMI");
		endpoint.getOtherInfo().add("MiddlewareVersion=3.5.0-1.el5");
		
		endpoint.setCapability("security.attributeauthority");
		
		endpoint.setTechnology("webservice");
		
		endpoint.setSemantics("https://github.com/italiangrid/voms/wiki");
		
		endpoint.setImplementor("gLite");
		
		endpoint.setImplementationName("VOMS");
		
	}
	
	public EndpointBuilder qualityLevel(String qualityLevel) {
		
		endpoint.setQualityLevel(qualityLevel);
		
		return this;
	}
	
	public EndpointBuilder healthState(String healtState) {
		
		endpoint.setHealtState(healtState);
		
		return this;
	}
	
	public EndpointBuilder healthStateInfo(String healtStateInfo) {
		
		endpoint.setHealtStateInfo(healtStateInfo);
		
		return this;
	}

	public EndpointBuilder servingState(String servingState) {
		
		endpoint.setServingState(servingState);
		
		return this;
	}

	public Endpoint build() {
		
		return endpoint;
	}
	
}
