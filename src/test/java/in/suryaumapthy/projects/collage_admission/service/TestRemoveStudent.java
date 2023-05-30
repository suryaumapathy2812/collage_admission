package in.suryaumapthy.projects.collage_admission.service;

import in.suryaumapathy.projects.collage_admission.service.StudentDepartmentService;

public class TestRemoveStudent {

	StudentDepartmentService service = new StudentDepartmentService();

	// Feature 3: Remove Student from a College
	public void testRemoveStudent() throws Exception {

		int studentId = 1;
		System.out.println("testRemoveStudent() ============================>: " + studentId);

		try {
			service.updateStudentStatus(1);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to Remove Student");
		}

	}

	// Feature 3: Remove Student from a College 
	public void testRemoveStudentByIdNull() throws Exception {

		int studentId = 1;
		System.out.println("testRemoveStudent() ============================>: " + studentId);

		try {
			service.updateStudentStatus(1);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to Remove Student");
		}

	}

}
