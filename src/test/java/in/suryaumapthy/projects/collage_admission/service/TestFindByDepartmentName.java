package in.suryaumapthy.projects.collage_admission.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import in.suryaumapathy.projects.collage_admission.model.StudentDepartment;
import in.suryaumapathy.projects.collage_admission.service.StudentDepartmentService;

public class TestFindByDepartmentName {

	StudentDepartmentService service = new StudentDepartmentService();

	// Feature 1: Find Students who are enrolled in the given department
	// Find Students who are studying in "CSE" department.
	@Test
	public void getStudentsByDeptName() {

		String departmentName = "CSE";
		System.out.println("getStudentsByDeptName() ============================>: " + departmentName);

		try {

			List<StudentDepartment> departmentStudents = service.getDepartmentStudent(departmentName);

			System.out.println(
					"getDepartmentStudentsByName.length ============================> " + departmentStudents.size());

			for (StudentDepartment studentDepartment : departmentStudents) {
				System.out.println(studentDepartment);
			}

			Assertions.assertEquals(1, departmentStudents.size());

		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to retrieve Student Profile");
		}

	}

	@Test
	public void getStudentsByDeptNameByInvalidDeptNameNull() {

		String departmentName = null;
		System.out.println("getStudentsByDeptName() ============================>: " + departmentName);

		try {

			service.getDepartmentStudent(departmentName);
			fail("Failed to retrieve Student Profile");
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assertions.assertEquals("Invalid Department Name", e.getMessage());
			
		}

	}
	
	@Test
	public void getStudentsByDeptNameByInvalidDeptNameEmpty() {

		String departmentName = "   ";
		System.out.println("getStudentsByDeptName() ============================>: " + departmentName);

		try {

			service.getDepartmentStudent(departmentName);
			fail("Failed to retrieve Student Profile");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assertions.assertEquals("Invalid Department Name", e.getMessage());
			
		}

	}

}
