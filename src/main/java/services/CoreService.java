package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * This class loads a core configuration, and queries for its state 
 * (running, not running)and make info available.
 * 
 * @author valerioventuri
 *
 */
public class CoreService extends Service {

	private static String CORE_CONFIGURATION_PATH = "/etc/voms";
	private static File coreConfigurationDirectory = new File(CORE_CONFIGURATION_PATH);

	private String vo;

	public CoreService(String vo) {

		super(vo);

		// load configuration

		File voConfigurationDirectory = new File(coreConfigurationDirectory, vo);

		InputStream inputStream = null;

		try {

			inputStream = new FileInputStream(new File(voConfigurationDirectory,
				"service.properties"));

		} catch (FileNotFoundException e) {

			System.err.println("ERROR: service.properties not found");

			return;
		}

	}

}
