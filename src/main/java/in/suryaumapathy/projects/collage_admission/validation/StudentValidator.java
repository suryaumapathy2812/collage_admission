package in.suryaumapathy.projects.collage_admission.validation;

import java.util.regex.Pattern;

import in.suryaumapathy.projects.collage_admission.dao.StudentDao;
import in.suryaumapathy.projects.collage_admission.exception.PersistanceException;
import in.suryaumapathy.projects.collage_admission.exception.ValidationException;
import in.suryaumapathy.projects.collage_admission.model.Student;

public class StudentValidator {

	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

	public static void rejectIfStudentNotFound(int studentId) throws PersistanceException, ValidationException {
			StudentDao studentDao = new StudentDao();
			Student student = studentDao.getStudentProfile(studentId);
			if (student == null) {
				throw new ValidationException("Student Not Found");
			}
	}

	public static void validate(Student student) throws ValidationException {
		if (student.getId() < 0) {
			throw new ValidationException("Invalid ID: ID cannot be less than zero");
		}

		if (student.getName() == null || student.getName().trim().isEmpty()) {
			throw new ValidationException("Invalid Name: Name cannot be null or empty");
		}

		if (student.getEmail() == null || !Pattern.matches(EMAIL_REGEX, student.getEmail())) {
			throw new ValidationException("Invalid Email: Email is not valid");
		}

		if (student.getMobileNo() <= 0) {
			throw new ValidationException("Invalid Mobile Number: Mobile Number is not valid");
		}

		if (student.getPassword() == null || student.getPassword().trim().isEmpty()) {
			throw new ValidationException("Invalid Password: Password cannot be null or empty");
		}

		if (student.getGender() != 'M' && student.getGender() != 'F') {
			throw new ValidationException("Invalid Gender: Gender can only be 'M' or 'F'");
		}

		if (student.getDob() == null) {
			throw new ValidationException("Invalid Date of Birth: Date of Birth cannot be null");
		}

		if (student.getCreatedDate() == null) {
			throw new ValidationException("Invalid Created Date: Created Date cannot be null");
		}
	}
}
