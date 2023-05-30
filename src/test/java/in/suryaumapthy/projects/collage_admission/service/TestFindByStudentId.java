package in.suryaumapthy.projects.collage_admission.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import in.suryaumapathy.projects.collage_admission.model.StudentDepartment;
import in.suryaumapathy.projects.collage_admission.service.StudentDepartmentService;

public class TestFindByStudentId {

	StudentDepartmentService service = new StudentDepartmentService();

	// Feature 1: Find Students who are enrolled in the given department
	// Find Students who are studying in "CSE" department.
	@Test
	public void getDepartmentStudentsById() {

		System.out.println("getDepartmentStudentsById() ============================> ");

		try {

			StudentDepartmentService service = new StudentDepartmentService();

			List<StudentDepartment> departmentStudents = service.getDepartmentStudent(1);

			System.out.println(
					"getDepartmentStudentsById.length ============================> " + departmentStudents.size());

			for (StudentDepartment studentDepartment : departmentStudents) {
				System.out.println(studentDepartment);
			}

			Assertions.assertEquals(1, departmentStudents.size());

		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to retrieve Student Profile");
		}

	}

}
