package in.suryaumapathy.projects.collage_admission.model;

public class StudentDepartment {
	
	
	private int id;
	private int studentId;
	private int departmentId;
	private Boolean active;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
	    return "StudentDepartment{" +
	            "id=" + id +
	            ", studentId=" + studentId +
	            ", departmentId=" + departmentId +
	            ", active=" + active +
	            '}';
	}
	
}
