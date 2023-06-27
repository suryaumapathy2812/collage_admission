package in.suryaumapathy.projects.collage_admission.exception;

import java.sql.SQLException;

public class PersistanceException extends Exception {

	public PersistanceException(Throwable e) {
		super(e);
	}
	
	public PersistanceException(String errorMessage) {
		super(errorMessage);
	}

}
