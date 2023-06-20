package in.suryaumapathy.projects.collage_admission.service;

import in.suryaumapathy.projects.collage_admission.dao.StudentDao;
import in.suryaumapathy.projects.collage_admission.model.Student;

public class StudentService {

	StudentDao studentDao;

	public StudentService() throws Exception {
		this.studentDao = new StudentDao();
	}

	public Student login(String email, String password) throws Exception {
		Student studentDetails = this.studentDao.getStudentProfile(email, password);
		return studentDetails;
	}

}
