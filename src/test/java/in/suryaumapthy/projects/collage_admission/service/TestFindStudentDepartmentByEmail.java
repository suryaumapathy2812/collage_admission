package in.suryaumapthy.projects.collage_admission.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import in.suryaumapathy.projects.collage_admission.service.StudentDepartmentService;

public class TestFindStudentDepartmentByEmail {

	StudentDepartmentService service;

	@BeforeEach
	public void setUp() {
		service = new StudentDepartmentService();
	}

	// Feature 8: Find Department for the given student email id
	// With valid email Address
	@Test
	public void testFindStudentDepartmentByEmailId() throws Exception {

		String email = "john@example.com";

		try {
			String department = service.findStudentDepartmentByEmail(email);
			System.out.println(department);
			Assertions.assertEquals("EEE", department);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			fail("Department Name miss match");
		}

	}

	// Feature 8: Find Department for the given student email id
	// With null as email Address
	@Test
	public void testFindStudentDepartmentByEmailIdNull() throws Exception {

		String email = null;

		try {
			String department = service.findStudentDepartmentByEmail(email);
			System.out.println(department);
			fail("Failed to retrieve student department");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assertions.assertEquals("Invalid Email Address", e.getMessage());
		}

	}

	// Feature 8: Find Department for the given student email id
	// With invalid email pattern as email Address
	@Test
	public void testFindStudentDepartmentByEmailIdPattern() throws Exception {

		String email = "@example.com";

		try {
			String department = service.findStudentDepartmentByEmail(email);
			System.out.println(department);
			fail("Failed to retrieve student department");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assertions.assertEquals("Invalid Email Pattern", e.getMessage());
		}

	}

	// Feature 8: Find Department for the given student email id
	// With new Email address as email Address
	@Test
	public void testFindStudentDepartmentByEmailIdNewEmail() throws Exception {

		String email = "surya@example.com";

		try {
			String department = service.findStudentDepartmentByEmail(email);
			System.out.println(department);
			Assertions.assertEquals("EEE", department);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assertions.assertEquals("Student not found", e.getMessage());
		}

	}

}
