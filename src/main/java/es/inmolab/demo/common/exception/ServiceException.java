package es.inmolab.demo.common.exception;

public class ServiceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;

	public ServiceException(String code) {
		super();
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

}
