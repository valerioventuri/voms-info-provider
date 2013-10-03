import java.io.File;

import model.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ldap.NameNotFoundException;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.odm.core.OdmManager;

import services.AdminService;
import services.CoreService;

import builders.AdminEndpointBuilder;
import builders.CoreEndpointBuilder;



public class VomsInfoProvider {

	private static String CORE_CONFIGURATION_PATH = "/etc/voms";
	private static String ADMIN_CONFIGURATION_PATH = "/etc/voms-admin";
	
	private static File adminConfigurationDirectory = new File(ADMIN_CONFIGURATION_PATH);
	private static File coreConfigurationDirectory = new File(CORE_CONFIGURATION_PATH);
	
	/**
	 * The spring ldap manager.
	 * 
	 */
	private static OdmManager manager;
	
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		new VomsInfoProvider();
	}

	
	public VomsInfoProvider() {

		ApplicationContext context = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		manager = (OdmManager) context.getBean("odmManager");
		
		manageCoreEndpoints();
		manageAdminEndpoints();
	}

	/**
	 * Create or update all admin endpoints.
	 * 
	 */
	private static void manageAdminEndpoints() {

		if(!adminConfigurationDirectory.isDirectory()) {
			
			System.out.println("ERROR: " + ADMIN_CONFIGURATION_PATH + " is not a directory");
			
			return;
		}
			
		String[] adminVos = adminConfigurationDirectory.list();

		for(String vo : adminVos) {

			if(vo.equals("voms-admin-server.logback") || 
				vo.equals("voms-admin-server.properties"))
				continue;

			manageAdminEndpoint(vo);
			
		}
		
	}

	/**
	 * Create or update admin endpoint entry for a vo.
	 *  
	 * @param vo
	 */
	private static void manageAdminEndpoint(String vo) {

		System.out.println("Managing admin endpoint entry for " + vo);
		
		AdminService adminService = new AdminService(vo);

		Endpoint endpoint = readAdminEndpoint(adminService.getHost(), vo);

		if (endpoint == null) {

			// TODO will use info from adminService
			endpoint = new AdminEndpointBuilder(adminService.getHost(),
				adminService.getPort(), vo).qualityLevel("production")
				.healthState("ok").servingState("production").build();

			manager.create(endpoint);

			System.out.println("Created admin endpoint entry for " + vo);

		} else {

			// TODO will use info from adminService to create this
			endpoint.getOtherInfo().add("usersCount=2000");

			manager.update(endpoint);
			
			System.out.println("Updated admin endpoint entry for " + vo);
		
		}
	
	}
	
	/**
	 * Create or update all core endpoints.
	 * 
	 */
	private static void manageCoreEndpoints() {

		if(!coreConfigurationDirectory.isDirectory()) {
			
			System.out.println("ERROR: " + CORE_CONFIGURATION_PATH + " is not a directory");

			return;
		}
			
		String[] coreVos = coreConfigurationDirectory.list();

		for(String vo : coreVos) {

			manageCoreEndpoint(vo);
		}

	}

	/**
	 * Create or update core endpoint entry for a vo.
	 *  
	 * @param vo
	 */
	private static void manageCoreEndpoint(String vo) {

		System.out.println("Managing core endpoint entry for " + vo);

		CoreService coreService = new CoreService(vo);

		Endpoint endpoint = readCoreEndpoint(coreService.getHost(), vo);

		if (endpoint == null) {

			// TODO will use info in coreService
			endpoint = new CoreEndpointBuilder(coreService.getHost(),
				coreService.getPort(), vo).qualityLevel("production")
				.healthState("ok").servingState("production").build();

			manager.create(endpoint);

			System.out.println("Created core endpoint entry for " + vo);

		} else {

			// TODO will use info in coreService
			
			manager.update(endpoint);

			System.out.println("Updated core endpoint entry for " + vo);

		}

	}
	
	/**
	 * Read core endpoint for a vo from the bdii.
	 * 
	 * @param host
	 * @param vo
	 * @return
	 */
	private static Endpoint readCoreEndpoint(String host, String vo) {

		DistinguishedName dn = new DistinguishedName("GLUE2EndpointID="
			+ CoreEndpointBuilder.buildEndpointId(host, vo));
		
		return readEndpoint(dn);
		
	}

	/**
	 * Read admin endpoint for a vo from the bdii.
	 * 
	 * @param host
	 * @param vo
	 * @return
	 */
	private static Endpoint readAdminEndpoint(String host, String vo) {
		
		DistinguishedName dn = new DistinguishedName("GLUE2EndpointID="
			+ AdminEndpointBuilder.buildAdminEndpointId(host, vo));
		
		return readEndpoint(dn);
		
	}
	
	/**
	 * Read and endpoint given the dn frmo the bdii.
	 * 
	 * @param dn
	 * @return
	 */
	private static Endpoint readEndpoint(DistinguishedName dn) {
		
		Endpoint endpoint = null;
			
		try {
		
			endpoint = manager.read(Endpoint.class, dn);
		
		} catch (NameNotFoundException exception) {
		
			return null;
		}
		
		return endpoint;
	}
	
}
