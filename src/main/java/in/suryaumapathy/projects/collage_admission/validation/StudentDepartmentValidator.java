package in.suryaumapathy.projects.collage_admission.validation;

import in.suryaumapathy.projects.collage_admission.exception.ValidationException;
import in.suryaumapathy.projects.collage_admission.model.StudentDepartment;

public class StudentDepartmentValidator {

    public static void validate(StudentDepartment studentDepartment) throws ValidationException {
        if (studentDepartment.getId() < 0) {
            throw new ValidationException("Invalid ID: ID cannot be less than zero");
        }
        
        if (studentDepartment.getStudentId() < 0) {
            throw new ValidationException("Invalid Student ID: Student ID cannot be less than zero");
        }
        
        if (studentDepartment.getDepartmentId() < 0) {
            throw new ValidationException("Invalid Department ID: Department ID cannot be less than zero");
        }
        
        if (studentDepartment.getActive() == null) {
            throw new ValidationException("Invalid Active Status: Active Status cannot be null");
        }
    }
}
