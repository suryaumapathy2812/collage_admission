package in.suryaumapathy.projects.collage_admission.exception;

public class ServiceException extends Exception {

	public ServiceException(Throwable e) {
		super(e);
	}
	
	public ServiceException(String message) {
		super(message);
	}

}
