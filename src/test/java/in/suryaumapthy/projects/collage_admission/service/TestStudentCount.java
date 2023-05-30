package in.suryaumapthy.projects.collage_admission.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import in.suryaumapathy.projects.collage_admission.service.StudentDepartmentService;

public class TestStudentCount {

	StudentDepartmentService service = new StudentDepartmentService();
	
	
	// Feature 4: Find Total no of students in each department
	@Test
	public void testStudentCount() throws Exception{
		
		try {
			
			List<Map<String, Integer>> count = service.studentCount();
			
			for (Object _row : count) {
				System.out.println(_row);
			}
			
		} catch (Exception e) {
			fail("Failed to retrieve students count");			
		}
		
	}
	
}
