package in.suryaumapthy.projects.collage_admission.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import in.suryaumapathy.projects.collage_admission.service.StudentDepartmentService;

public class TestRemoveStudent {

	StudentDepartmentService service;

	@BeforeEach
	public void setUp() {
		service = new StudentDepartmentService();
	}

	public void testRemoveStudent() throws Exception {

		int studentId = 1;
		System.out.println("testRemoveStudent() ============================>: " + studentId);

		try {
			service.updateStudentStatus(1);

		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail("Failed to Remove Student");
		}

	}

	// Feature 3: Remove Student from a College
	public void testRemoveStudentByInvalidId() throws Exception {

		int studentId = -1;
		System.out.println("testRemoveStudent() ============================>: " + studentId);

		try {
			service.updateStudentStatus(studentId);
			Assertions.fail("Expected an exception to be thrown");
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.assertEquals("Invalid Studebt ID", e.getMessage(), "Expected error message did not match");
		}

	}

}
