package in.suryaumapathy.projects.collage_admission.validation;

import in.suryaumapathy.projects.collage_admission.dao.DepartmentDao;
import in.suryaumapathy.projects.collage_admission.exception.PersistanceException;
import in.suryaumapathy.projects.collage_admission.exception.ValidationException;
import in.suryaumapathy.projects.collage_admission.model.Department;

public class DepartmentValidator {

	public static void rejectIfDepartmentNotFound(int departmentId) throws PersistanceException, ValidationException {
		DepartmentDao deptDao = new DepartmentDao();
		Department dept = deptDao.getDepartment(departmentId);
		if (dept == null) {
			throw new ValidationException("Department Not Found");
		}
	}

	public static void rejectIfDepartmentNotFound(String departmentName) throws PersistanceException, ValidationException {
		DepartmentDao deptDao = new DepartmentDao();
		Department dept =deptDao.getDepartment(departmentName);
		if (dept == null) {
			throw new ValidationException("Department Not Found");
		}
	}

	public static void validate(Department department) throws ValidationException {
		if (department.getId() < 0) {
			throw new ValidationException("Invalid ID: ID cannot be less than zero");
		}

		if (department.getName() == null || department.getName().trim().isEmpty()) {
			throw new ValidationException("Invalid Name: Name cannot be null or empty");
		}
	}
}