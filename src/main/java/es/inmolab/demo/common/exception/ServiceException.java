package es.inmolab.demo.common.exception;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private final String code;

    // Constructor que acepta tanto código como mensaje
	public ServiceException(String message, String code) {
		super(message);  // Almacena el mensaje en la clase Exception interna
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

}
