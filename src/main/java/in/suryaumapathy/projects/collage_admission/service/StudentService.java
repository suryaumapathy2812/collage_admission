package in.suryaumapathy.projects.collage_admission.service;


import in.suryaumapathy.projects.collage_admission.dao.StudentDao;
import in.suryaumapathy.projects.collage_admission.exception.PersistanceException;
import in.suryaumapathy.projects.collage_admission.exception.ServiceException;
import in.suryaumapathy.projects.collage_admission.model.Student;

public class StudentService {

	StudentDao studentDao = new StudentDao();

	public Student login(String email, String password) throws ServiceException {
		try {
			Student studentDetails = this.studentDao.getStudentProfile(email, password);
			return studentDetails;
		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}

}
