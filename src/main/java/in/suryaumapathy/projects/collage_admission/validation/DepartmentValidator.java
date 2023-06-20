package in.suryaumapathy.projects.collage_admission.validation;

import in.suryaumapathy.projects.collage_admission.exception.DepartmentValidationException;
import in.suryaumapathy.projects.collage_admission.model.Department;

public class DepartmentValidator {

    public static void validate(Department department) throws DepartmentValidationException {
        if (department.getId() < 0) {
            throw new DepartmentValidationException("Invalid ID: ID cannot be less than zero");
        }
        
        if (department.getName() == null || department.getName().trim().isEmpty()) {
            throw new DepartmentValidationException("Invalid Name: Name cannot be null or empty");
        }
    }
}