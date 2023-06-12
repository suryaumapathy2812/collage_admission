package in.suryaumapathy.projects.collage_admission.service;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import in.suryaumapathy.projects.collage_admission.dao.StudentDepartmentDao;
import in.suryaumapathy.projects.collage_admission.dto.StudentDepartmentDetailsDto;
import in.suryaumapathy.projects.collage_admission.model.StudentDepartment;

public class StudentDepartmentService {

	StudentDepartmentDao dao = null;

	public StudentDepartmentService() {
		this.dao = new StudentDepartmentDao();
	}

	public StudentDepartment getStudentDepartment(int studentId) throws Exception {

		// Validation
		if (studentId <= 0) {
			throw new Exception("Invalid Student Id");
		}

		StudentDepartment studentDept = this.dao.findByStudentId(studentId);
		return studentDept;
	}

	public List<StudentDepartment> getDepartmentStudent(int departmentId) throws Exception {

		// Validation
		if (departmentId <= 0) {
			throw new Exception("Invalid Department Id");
		}

		List<StudentDepartment> departmentStudents = this.dao.findByDepartmentId(departmentId);
		return departmentStudents;
	}

	public List<StudentDepartment> getDepartmentStudent(String departmentName) throws Exception {

		// Validation
		if (departmentName == null || departmentName.trim().equals("")) {
			throw new Exception("Invalid Department Name");
		}

		List<StudentDepartment> departmentStudents = this.dao.findByDepartmentName(departmentName);
		return departmentStudents;
	}

	public StudentDepartment updateStudentDepartment(int studentId, String departmentName) throws Exception {
		StudentDepartment updatedStudentDepartment = this.dao.update(studentId, departmentName);
		return updatedStudentDepartment;
	}

	public void updateStudentStatus(int studentId) throws Exception {

		if (studentId > 0) {
			throw new Exception("Invalid Studebt ID");
		}

		this.dao.updateStatus(studentId);
	}

	public List<Map<String, Integer>> studentCount() throws Exception {

		List<Map<String, Integer>> studentCount = this.dao.count();
		return studentCount;

	}

	public List<StudentDepartmentDetailsDto> studentDeptDetails() throws Exception {
		List<StudentDepartmentDetailsDto> studentDetails = this.dao.findStudentDetails();
		return studentDetails;
	}

	public String findStudentDepartmentByEmail(String email) throws Exception {

		System.out.println(email);

		if (email == null || email.trim().equals("")) {
			throw new Exception("Invalid Email Address");
		}

		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean isMatch = Pattern.matches(regex, email);

		if (isMatch == false) {
			throw new Exception("Invalid Email Pattern");
		}

		String departmentName = this.dao.findStudentDepartmentByEmail(email);
		return departmentName;

	}

}
