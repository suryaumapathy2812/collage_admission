package in.suryaumapthy.projects.collage_admission.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import in.suryaumapathy.projects.collage_admission.model.StudentDepartment;
import in.suryaumapathy.projects.collage_admission.service.StudentDepartmentService;

public class TestUpdateStudentDepartment {

	StudentDepartmentService service = new StudentDepartmentService();

	
	// Feature 2: Update Student Department information
	// Update student department to "MECH" department
	@Test
	public void updateStudentDepartment() {

		System.out.println("updateStudentDepartment() ============================> ");

		int student_id = 1;
		String finalDepartmentName = "EEE";

		try {

			StudentDepartmentService service = new StudentDepartmentService();
			StudentDepartment studentDepartment = service.getStudentDepartment(student_id);
			System.out.println(studentDepartment);
			System.out.println("Before  ===================================================================");

			service.updateStudentDepartment(student_id, finalDepartmentName);
			StudentDepartment studentDepartment2 = service.getStudentDepartment(student_id);


			System.out.println("After  ===================================================================");
			System.out.println(studentDepartment2);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to retrieve Student Profile");
		}

	}

}
