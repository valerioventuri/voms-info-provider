package services;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * This class loads an admin configuration, and queries for its state 
 * (running, not running) and information (number of users) and make 
 * info available.
 * 
 * @author valerioventuri
 *
 */
public class AdminService extends Service {

	private static String ADMIN_CONFIGURATION_PATH = "/etc/voms-admin";
	private static File adminConfigurationDirectory = new File(ADMIN_CONFIGURATION_PATH);
	
	private String vo;
	
	public AdminService(String vo) {

		super(vo);
		
		// load configuration

		File voConfigurationDirectory = new File(adminConfigurationDirectory, vo);
		
		InputStream inputStream = null;
		
		try {
		
			inputStream = new FileInputStream(new File(voConfigurationDirectory, 
				"service.properties"));
		
		} catch (FileNotFoundException e) {
		
			System.err.println("ERROR: service.properties not found");
			
			return;
		}
		
		Properties properties = new Properties();
		
		try {
		
			properties.load(inputStream);
		
		} catch (IOException e) {
			
			System.err.println("ERROR: not able to load properties from service.properties");
			
			return;
		}

		// TODO reads host and port from the configuration
		
		setHost("localhost");
		
		setPort(8443);
		
	}

}
