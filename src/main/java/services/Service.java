package services;


public abstract class Service {

	private String vo;

	private String host;
	
	private int port;
	
	public Service(String vo) {

		this.vo = vo;
	}
	
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
	
		this.host = host;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
	
		return host;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
	
		this.port = port;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
	
		return port;
	}
	
}
