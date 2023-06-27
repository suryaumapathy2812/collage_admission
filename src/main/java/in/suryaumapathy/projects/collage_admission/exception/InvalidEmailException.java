package in.suryaumapathy.projects.collage_admission.exception;

public class InvalidEmailException extends ValidationException {
    public InvalidEmailException(String errorMessage) {
        super(errorMessage);
    }
}
