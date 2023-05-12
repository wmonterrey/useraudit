package com.jessica.error;

public class AuditNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuditNotFoundException(Long id) {
        super("Audit id no encontrada : " + id);
    }

}