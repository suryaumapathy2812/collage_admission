package in.suryaumapthy.projects.collage_admission.service;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import in.suryaumapathy.projects.collage_admission.dto.StudentDepartmentDetailsDto;
import in.suryaumapathy.projects.collage_admission.service.StudentDepartmentService;

public class TestStudentDetails {
	
	StudentDepartmentService service = new StudentDepartmentService();
	
	// Feature 6: Display student and department details
	// Using Joins (Inner Join)
	
	@Test
	public void testStudentDepartmentDetails() throws Exception{
		
		StudentDepartmentService service = new StudentDepartmentService();
		
		List<StudentDepartmentDetailsDto> details = service.studentDeptDetails();
		
		for (StudentDepartmentDetailsDto student : details) {
			System.out.println(student.toString());
		}
		
	}


}
