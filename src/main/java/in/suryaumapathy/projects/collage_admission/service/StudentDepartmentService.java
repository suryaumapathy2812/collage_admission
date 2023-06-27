package in.suryaumapathy.projects.collage_admission.service;

import java.util.List;
import java.util.Map;

import in.suryaumapathy.projects.collage_admission.dao.DepartmentDao;
import in.suryaumapathy.projects.collage_admission.dao.StudentDao;
import in.suryaumapathy.projects.collage_admission.dao.StudentDepartmentDao;
import in.suryaumapathy.projects.collage_admission.dto.StudentDepartmentDetailsDto;
import in.suryaumapathy.projects.collage_admission.exception.InvalidDepartmentException;
import in.suryaumapathy.projects.collage_admission.exception.InvalidEmailException;
import in.suryaumapathy.projects.collage_admission.exception.InvalidStudentException;
import in.suryaumapathy.projects.collage_admission.exception.PersistanceException;
import in.suryaumapathy.projects.collage_admission.exception.ServiceException;
import in.suryaumapathy.projects.collage_admission.exception.ValidationException;
import in.suryaumapathy.projects.collage_admission.model.StudentDepartment;
import in.suryaumapathy.projects.collage_admission.utils.StringUtil;
import in.suryaumapathy.projects.collage_admission.validation.DepartmentValidator;
import in.suryaumapathy.projects.collage_admission.validation.StudentValidator;

public class StudentDepartmentService {

	private StudentDao studentDao = new StudentDao();
	private DepartmentDao deptDao = new DepartmentDao();
	private StudentDepartmentDao studentDepartmentDao = new StudentDepartmentDao();

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws Exception
	 */
	public StudentDepartment getStudentDepartment(int studentId) throws ValidationException, ServiceException {

		if (studentId <= 0) {
			throw new ValidationException("Invalid Student Id");
		}

		try {
			// Validation

			StudentValidator.rejectIfStudentNotFound(studentId);

			StudentDepartment studentDept = this.studentDepartmentDao.findByStudentId(studentId);
			if (studentDept == null) {
				throw new ValidationException("Department not found for studentId: " + studentId);
			}
			return studentDept;

		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}

	public List<StudentDepartment> getDepartmentStudent(int departmentId) throws ValidationException, ServiceException {

		// Validation
		if (departmentId <= 0) {
			throw new InvalidDepartmentException("Invalid Department Id");
		}

		List<StudentDepartment> departmentStudents;
		try {
			DepartmentValidator.rejectIfDepartmentNotFound(departmentId);
			departmentStudents = this.studentDepartmentDao.findByDepartmentId(departmentId);

			if (departmentStudents == null) {
				throw new ValidationException("Students Not Found For departmentId: " + departmentId);
			}

		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return departmentStudents;
	}

	public List<StudentDepartment> getDepartmentStudent(String departmentName)
			throws ValidationException, ServiceException {

		// Validation
		if (!StringUtil.isValidString(departmentName)) {
			throw new InvalidDepartmentException("Invalid Department Name");
		}

		List<StudentDepartment> departmentStudents;
		try {
			DepartmentValidator.rejectIfDepartmentNotFound(departmentName);

			departmentStudents = this.studentDepartmentDao.findByDepartmentName(departmentName);
			if (departmentStudents == null) {
				throw new ValidationException("Students not found for departmentName: " + departmentName);
			}

		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return departmentStudents;
	}

	public boolean updateStudentDepartment(int studentId, String departmentName)
			throws ValidationException, ServiceException {

		if (studentId <= 0) {
			throw new InvalidStudentException("Invalid Student ID");
		}

		if (!StringUtil.isValidString(departmentName)) {
			throw new InvalidDepartmentException("Invalid Department Name");
		}

		boolean status;

		try {

			StudentValidator.rejectIfStudentNotFound(studentId);
			DepartmentValidator.rejectIfDepartmentNotFound(departmentName);
			status = this.studentDepartmentDao.update(studentId, departmentName);

		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return status;
	}

	public void updateStudentStatus(int studentId) throws ValidationException, ServiceException {

		if (studentId > 0) {
			throw new InvalidStudentException("Invalid Student ID");
		}

		try {
			this.studentDepartmentDao.updateStatus(studentId);
		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}

	public List<Map<String, Integer>> studentCount() throws ValidationException, ServiceException {
		List<Map<String, Integer>> studentCount;
		try {
			studentCount = this.studentDepartmentDao.count();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return studentCount;

	}

	public List<StudentDepartmentDetailsDto> studentDeptDetails() throws ValidationException, ServiceException {
		try {
			List<StudentDepartmentDetailsDto> studentDetails = this.studentDepartmentDao.findStudentDetails();
			return studentDetails;
		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}

	public String findStudentDepartmentByEmail(String email) throws ValidationException, ServiceException {

		Boolean isMatch = StringUtil.isValidEmail(email);
		if (!isMatch) {
			throw new InvalidEmailException("Invalid Email Pattern");
		}

		try {
			String departmentName = this.studentDepartmentDao.findStudentDepartmentByEmail(email);
			return departmentName;
		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}

	}

}
