package in.suryaumapthy.projects.collage_admission.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import in.suryaumapathy.projects.collage_admission.exception.InvalidStudentException;
import in.suryaumapathy.projects.collage_admission.model.StudentDepartment;
import in.suryaumapathy.projects.collage_admission.service.StudentDepartmentService;

public class TestFindByStudentId {

	StudentDepartmentService service = new StudentDepartmentService();

	// Feature 1: Find Students who are enrolled in the given department
	// Find Students who are studying in "CSE" department.
	@Test
	public void testGetDepartmentStudentsById() {
		int studentId = 1;
		System.out.println("testGetDepartmentStudentsById() ============================> ");
		assertDoesNotThrow(() -> {
			List<StudentDepartment> departmentStudents = service.getDepartmentStudent(studentId);
			System.out.println("getDepartmentStudentsById.length ============================> " + departmentStudents.size());
			for (StudentDepartment studentDepartment : departmentStudents) {
				System.out.println(studentDepartment);
			}
			Assertions.assertEquals(1, departmentStudents.size());
		});
	}

	@Test
	public void testGetDepartmentStudentsByInvalidId() {
		int studentId = -1;
		System.out.println("testGetDepartmentStudentsByInvalidId() ============================> ");
		Exception exception = assertThrows(InvalidStudentException.class, () -> {
			service.getDepartmentStudent(studentId);
		});
		String expectedMessage = "Invalid Student ID";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
