package in.suryaumapthy.projects.collage_admission.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import in.suryaumapathy.projects.collage_admission.exception.InvalidDepartmentException;
import in.suryaumapathy.projects.collage_admission.model.StudentDepartment;
import in.suryaumapathy.projects.collage_admission.service.StudentDepartmentService;

public class TestFindByDepartmentName {

	StudentDepartmentService service = new StudentDepartmentService();

	// Feature 1: Find Students who are enrolled in the given department
	// Find Students who are studying in "CSE" department.
	@Test
	public void testGetStudentsByDeptName() {

		String departmentName = "CSE";
		System.out.println("testGetStudentsByDeptName() ============================>: " + departmentName);

		assertDoesNotThrow(() -> {
			List<StudentDepartment> departmentStudents = service.getDepartmentStudent(departmentName);
			System.out.println(
					"getDepartmentStudentsByName.length ============================> " + departmentStudents.size());
			assertEquals(1, departmentStudents.size());
		});

	}

	@Test
	public void testGetStudentsByDeptNameByInvalidDeptNameNull() {

		String departmentName = null;
		System.out
				.println("testGetStudentsByDeptNameByInvalidDeptNameNull() ============================>: " + departmentName);

		Exception exception = assertThrows(InvalidDepartmentException.class, () -> {
			service.getDepartmentStudent(departmentName);
		});

		String expectedMessage = "Invalid Department Name";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void testGetStudentsByDeptNameByInvalidDeptNameEmpty() {

		String departmentName = "   ";
		System.out
				.println("testGetStudentsByDeptNameByInvalidDeptNameEmpty() ============================>: " + departmentName);

		Exception exception = assertThrows(InvalidDepartmentException.class, () -> {
			service.getDepartmentStudent(departmentName);
		});

		String expectedMessage = "Invalid Department Name";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

}
