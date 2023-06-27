package in.suryaumapathy.projects.collage_admission.exception;

public class InvalidStudentException extends ValidationException {
    
    public InvalidStudentException(String errorMessage) {
      super(errorMessage);
    }
}
