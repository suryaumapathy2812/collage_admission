package in.suryaumapathy.projects.collage_admission.validation;

import in.suryaumapathy.projects.collage_admission.exception.StudentDepartmentValidationException;
import in.suryaumapathy.projects.collage_admission.model.StudentDepartment;

public class StudentDepartmentValidator {

    public static void validate(StudentDepartment studentDepartment) throws StudentDepartmentValidationException {
        if (studentDepartment.getId() < 0) {
            throw new StudentDepartmentValidationException("Invalid ID: ID cannot be less than zero");
        }
        
        if (studentDepartment.getStudentId() < 0) {
            throw new StudentDepartmentValidationException("Invalid Student ID: Student ID cannot be less than zero");
        }
        
        if (studentDepartment.getDepartmentId() < 0) {
            throw new StudentDepartmentValidationException("Invalid Department ID: Department ID cannot be less than zero");
        }
        
        if (studentDepartment.getActive() == null) {
            throw new StudentDepartmentValidationException("Invalid Active Status: Active Status cannot be null");
        }
    }
}
